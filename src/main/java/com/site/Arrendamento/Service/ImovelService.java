package com.site.Arrendamento.Service;

import com.site.Arrendamento.Conversores.ImovelMap;
import com.site.Arrendamento.DTO.ImovelDTOEntrada;
import com.site.Arrendamento.Repository.ImovelRepository;
import com.site.Arrendamento.entidades.Imovel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private ImovelMap imovelMap;

    public ResponseEntity<String> cadastrarImovel(@RequestBody  @Valid ImovelDTOEntrada imovelDTOEntrada) {

        try {
            Imovel imovel=imovelMap.paraImovel(imovelDTOEntrada);
            imovelRepository.save(imovel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Imovel cadastrado com sucesso");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar imovel");
        }
    }




}
