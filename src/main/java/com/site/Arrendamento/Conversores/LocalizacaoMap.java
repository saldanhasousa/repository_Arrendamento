package com.site.Arrendamento.Conversores;

import com.site.Arrendamento.DTO.LocalizacaoDTOEntrada;
import com.site.Arrendamento.DTO.LocalizacaoDTOSaida;
import com.site.Arrendamento.entidades.Localizacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UsuarioMap.class, LocalizacaoMap.class})
public interface LocalizacaoMap {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "provincia", ignore = true)

    Localizacao paraLocalizacao(LocalizacaoDTOEntrada entradaDto);
    @Mapping(target = "id", ignore = true)
    LocalizacaoDTOSaida paraLocalizacaoDTOSaida(Localizacao localizacao);
    List<LocalizacaoDTOSaida> paraListaDTOSaida(List<Localizacao> localizacoes);


}
