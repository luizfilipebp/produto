package br.com.fiap.infrastructure.config;

import br.com.fiap.infrastructure.dto.produto.ProdutoCSV;
import br.com.fiap.infrastructure.entity.EstoqueEntity;
import br.com.fiap.infrastructure.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.math.BigDecimal;

@Configuration
@AllArgsConstructor
public class BatchConfig {
    private final PlatformTransactionManager transactionManager;
    private final JobRepository jobRepository;

    @Bean
    Job job(Step step, Step registrarEstoque) {
        return new JobBuilder("job", jobRepository)
                .start(step)
                .next(registrarEstoque)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    Step step(ItemReader<ProdutoCSV> reader,
              ItemProcessor<ProdutoCSV, ProdutoEntity> itemProcessor,
              ItemWriter<ProdutoEntity> itemWriter) {
        return new StepBuilder("step", jobRepository)
                .<ProdutoCSV, ProdutoEntity>chunk(32, transactionManager)
                .reader(reader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }


    @Bean
    @StepScope
    FlatFileItemReader<ProdutoCSV> reader(@Value("#{jobParameters['csvFile']}") Resource resource) {
        return new FlatFileItemReaderBuilder<ProdutoCSV>()
                .name("produtoReader")
                .resource(resource)
                .linesToSkip(1)
                .delimited()
                .names("idProduto", "nome", "categoria", "preco", "estoque", "descricao")
                .targetType(ProdutoCSV.class)
                .build();
    }

    @Bean
    ItemProcessor<ProdutoCSV, ProdutoEntity> itemProcessor() {
        return produtoCSV -> {
            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setId(Long.parseLong(produtoCSV.idProduto()));
            produtoEntity.setNome(produtoCSV.nome());
            produtoEntity.setPreco(BigDecimal.valueOf(Double.parseDouble(produtoCSV.preco())));
            produtoEntity.setDescricao(produtoCSV.descricao());
            return produtoEntity;

        };
    }

    @Bean
    JdbcBatchItemWriter<ProdutoEntity> itemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<ProdutoEntity>().dataSource(dataSource)
                .sql("""
                        INSERT INTO produto (
                             prd_id, prd_nome, prd_preco, prd_descricao
                        ) VALUES (
                             :id, :nome, :preco, :descricao
                        )
                        """)
                .beanMapped()
                .build();
    }


    @Bean
    Step registrarEstoque(ItemReader<ProdutoCSV> reader,
                          ItemProcessor<ProdutoCSV, EstoqueEntity> itemProcessorEstoque,
                          ItemWriter<EstoqueEntity> itemWriterEstoque) {
        return new StepBuilder("step", jobRepository)
                .<ProdutoCSV, EstoqueEntity>chunk(32, transactionManager)
                .reader(reader)
                .processor(itemProcessorEstoque)
                .writer(itemWriterEstoque)
                .build();
    }


    @Bean
    ItemProcessor<ProdutoCSV, EstoqueEntity> itemProcessorEstoque() {
        return produtoCSV -> {
            EstoqueEntity estoqueEntity = new EstoqueEntity();
            estoqueEntity.setProduto(new ProdutoEntity(
                    Long.parseLong(produtoCSV.idProduto()),
                    produtoCSV.nome(),
                    produtoCSV.descricao(),
                    BigDecimal.valueOf(Double.parseDouble(produtoCSV.preco()))
            ));
            estoqueEntity.setQuantidade(Integer.parseInt(produtoCSV.estoque()));
            return estoqueEntity;
        };
    }

    @Bean
    JdbcBatchItemWriter<EstoqueEntity> itemWriterEstoque(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<EstoqueEntity>().dataSource(dataSource)
                .sql("""
                        INSERT INTO estoque (
                            est_quantidade,
                            est_produto_id
                        ) VALUES (
                             :quantidade, :produto.id
                        )
                        """)
                .beanMapped()
                .build();
    }


    @Bean
    JobLauncher jobLauncherAsync(JobRepository jobRepository) throws Exception {
        var jobLauncher = new TaskExecutorJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

}
