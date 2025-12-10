package com.site.Arrendamento.Conversores;

import com.site.Arrendamento.DTO.LocalizacaoDTOEntrada;
import com.site.Arrendamento.DTO.LocalizacaoDTOSaida;
import com.site.Arrendamento.entidades.Localizacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocalizacaoMap {
    Localizacao paraLocalizacao(LocalizacaoDTOEntrada entradaDto);
    LocalizacaoDTOSaida paraLocalizacaoDTOSaida(Localizacao localizacao);
    List<LocalizacaoDTOSaida> paraListaDTOSaida(List<Localizacao> localizacoes);


}
