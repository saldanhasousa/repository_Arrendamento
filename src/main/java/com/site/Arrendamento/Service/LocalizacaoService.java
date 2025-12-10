package com.site.Arrendamento.Service;

import com.site.Arrendamento.Conversores.LocalizacaoMap;
import com.site.Arrendamento.DTO.LocalizacaoDTOEntrada;
import com.site.Arrendamento.Repository.LocalizacaoRepository;
import com.site.Arrendamento.entidades.Localizacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

   @Autowired
   LocalizacaoRepository localizacaoRepository;

   @Autowired
   LocalizacaoMap localizacaoMap;

   public ResponseEntity<String> criarLocalizacao(LocalizacaoDTOEntrada localizacaoDTOEntrada){
       try {
           Localizacao localizacao= localizacaoMap.paraLocalizacao(localizacaoDTOEntrada);
           localizacaoRepository.save(localizacao);
           return ResponseEntity.status(HttpStatus.CREATED).body("Localização criada com sucesso");


       } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar localização");
       }


   }




}
