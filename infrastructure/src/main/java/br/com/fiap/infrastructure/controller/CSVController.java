package br.com.fiap.infrastructure.controller;

import br.com.fiap.infrastructure.service.CSVService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/csv")
public class CSVController {

    private final CSVService service;

    @PostMapping("upload")
    public String importarCSV(@RequestParam("file") MultipartFile file) throws Exception {
        service.processarCSV(file);
        return "Processamento iniciado";
    }
}
