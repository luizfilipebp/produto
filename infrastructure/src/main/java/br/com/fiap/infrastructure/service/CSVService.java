package br.com.fiap.infrastructure.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class CSVService {
    private final Path fileStorageLocation;
    private final JobLauncher jobLauncher;
    private final Job job;

    public CSVService(@Qualifier("jobLauncherAsync") JobLauncher jobLauncher, Job job) {
        this.fileStorageLocation = Paths.get(System.getProperty("java.io.tmpdir")).toAbsolutePath().normalize();
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public void processarCSV(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path targetLocation = fileStorageLocation.resolve(fileName);
        file.transferTo(targetLocation);


        var jobParameter = new JobParametersBuilder()
                .addJobParameter("csv", file.getOriginalFilename(), String.class, true)
                .addJobParameter("csvFile", "file:" + targetLocation.toString(), String.class)
                .toJobParameters();

        jobLauncher.run(job, jobParameter);
    }
}
