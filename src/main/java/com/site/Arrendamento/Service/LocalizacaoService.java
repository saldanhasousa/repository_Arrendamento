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

   public void criarLocalizacao(LocalizacaoDTOEntrada localizacaoDTOEntrada){

           Localizacao localizacao= localizacaoMap.paraLocalizacao(localizacaoDTOEntrada);
           localizacaoRepository.save(localizacao);







}}
