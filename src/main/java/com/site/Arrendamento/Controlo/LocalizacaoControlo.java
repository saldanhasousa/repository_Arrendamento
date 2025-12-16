package com.site.Arrendamento.Controlo;

import com.site.Arrendamento.DTO.LocalizacaoDTOEntrada;
import com.site.Arrendamento.Service.LocalizacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoControlo {

    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping
    public ResponseEntity<String> criarLocalizacao(@RequestBody @Valid LocalizacaoDTOEntrada localizacaoDTOEntrada){
        localizacaoService.criarLocalizacao(localizacaoDTOEntrada);
        return ResponseEntity.ok("Localização criada com sucesso");
    }
}


