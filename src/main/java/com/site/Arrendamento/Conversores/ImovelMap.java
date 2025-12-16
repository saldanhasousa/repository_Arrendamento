package com.site.Arrendamento.Conversores;

import com.site.Arrendamento.DTO.ImovelDTOEntrada;
import com.site.Arrendamento.DTO.ImovelDTOSaida;
import com.site.Arrendamento.entidades.Imovel;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ImovelMap {


    @Mapping(target = "id", ignore = true)
   @Mapping(target = "proprietario", ignore = true)
    @Mapping(target = "imagem1", ignore = true)
    @Mapping(target = "imagem2", ignore = true)
    @Mapping(target = "imagem3", ignore = true)
    Imovel paraImovel(ImovelDTOEntrada imovelDTOEntrada);

    ImovelDTOSaida paraSaidaDTO(Imovel imovel);
    List<ImovelDTOSaida>ParaListaImovelDTOSaida(List<Imovel> imovelList);

}
