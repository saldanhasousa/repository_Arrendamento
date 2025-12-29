package com.site.Arrendamento.Conversores;

import com.site.Arrendamento.DTO.UsuarioEntradaDTO;
import com.site.Arrendamento.DTO.UsuarioSaidaDTO;
import com.site.Arrendamento.entidades.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMap {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
   // @Mapping(target = "dataCadastro", ignore = true)
    Usuario paraUsuario(UsuarioEntradaDTO entradaDto);

    @Mapping(target = "id", ignore = true)
    UsuarioSaidaDTO paraUsuarioSaidaDTO(Usuario usuario);

    List<UsuarioSaidaDTO> paraListaDTOSaida(List<Usuario> usuarios);
}
