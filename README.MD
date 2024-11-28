
# Serviço de Upload e Processamento de CSV

Este projeto é uma aplicação Spring Boot que fornece um endpoint para upload e processamento de arquivos CSV. A aplicação utiliza PostgreSQL como banco de dados e Docker Compose para orquestração de contêineres.

## Pré-requisitos

- Java 17 ou superior
- Gradle
- Docker e Docker Compose

## Iniciando

### Clonar o Repositório

```sh
git clone https://github.com/luizfilipebp/csv-upload-service.git
cd csv-upload-service
```

### Construir o Projeto

```sh
./gradlew build
```

### Executar a Aplicação

Para iniciar a aplicação, você precisa ter Docker e Docker Compose instalados. Use o seguinte comando para iniciar os serviços:

```sh
docker-compose up
```

Isso iniciará o banco de dados PostgreSQL.

### Configuração

A configuração da aplicação é gerenciada através do arquivo `application.properties` localizado em `src/main/resources`. Certifique-se de que as seguintes propriedades estejam definidas:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/produto
spring.datasource.username=produto
spring.datasource.password=root
file.upload-dir=tmp
```

### Estrutura do Projeto

- `src/main/java/br/com/fiap/infrastructure/controller/CSVController.java`: Controlador REST para lidar com requisições de upload de CSV.
- `src/main/java/br/com/fiap/infrastructure/service/CSVService.java`: Serviço para processar os arquivos CSV enviados.
- `docker-compose.yml`: Configuração do Docker Compose para configurar o banco de dados PostgreSQL.

### Upload de um Arquivo CSV

Para fazer o upload de um arquivo CSV, envie uma requisição `POST` para o endpoint `/v1/csv/upload` com o arquivo como um parâmetro form-data chamado `file`.

Exemplo usando `curl`:

```sh
curl -F "file=@path/to/your/produtos.csv" http://localhost:8080/v1/csv/upload
```

### Tratamento de Erros

Se você encontrar um erro `java.nio.file.NoSuchFileException`, certifique-se de que o diretório `tmp` existe na raiz do projeto ou está corretamente configurado no arquivo `application.properties`.

### Exemplo de Arquivo CSV

Aqui está um exemplo do formato do arquivo `produtos.csv`:

```csv
ID do Produto,Nome do Produto,Categoria,Preço,Estoque,Descrição
001,Smartphone Galaxy S23,Eletrônicos,5999.90,150,Smartphone com tela AMOLED de 6.1" câmera de 50MP e bateria de 4000mAh
002,Notebook Dell Inspiron,Informática,3799.00,80,Notebook com processador Intel Core i7 16GB de RAM e 512GB SSD
```

## Licença

Este projeto é licenciado sob a Licença MIT.