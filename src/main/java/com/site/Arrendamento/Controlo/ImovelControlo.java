package com.site.Arrendamento.Controlo;

import com.site.Arrendamento.DTO.ImovelDTOEntrada;
import com.site.Arrendamento.Service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imovel")
public class ImovelControlo {
    @Autowired
    ImovelService imovelService;

    @PostMapping
    public ResponseEntity<String> cadastrarImovel(@RequestBody @Valid ImovelDTOEntrada imovelDTOEntrada){
        return imovelService.cadastrarImovel(imovelDTOEntrada);


    }
}
