package com.site.Arrendamento.Conversores;

import com.site.Arrendamento.DTO.ImovelDTOEntrada;
import com.site.Arrendamento.DTO.ImovelDTOSaida;
import com.site.Arrendamento.entidades.Imovel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImovelMap {

    Imovel paraImovel(ImovelDTOEntrada imovelDTOEntrada);
    ImovelDTOSaida paraSaidaDTO(Imovel imovel);
    List<ImovelDTOSaida>ParaListaImovelDTOSaida(List<Imovel> imovelList);

}
