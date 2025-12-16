package com.site.Arrendamento.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Data
@Service
public class ImagemService {

    @Value("${upload.dir}")
    private String uploadDir;

    public String salvarImagem(MultipartFile arquivo) throws IOException {
        Path pasta = Paths.get(uploadDir);

        if (!Files.exists(pasta)) {
            Files.createDirectories(pasta);
        }

        String nomeArquivo = System.currentTimeMillis() + "_" + arquivo.getOriginalFilename();
        Path destino = pasta.resolve(nomeArquivo);
        Files.copy(arquivo.getInputStream(), destino);

        return nomeArquivo;
    }
}
