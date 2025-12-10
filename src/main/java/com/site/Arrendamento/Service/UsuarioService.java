package com.site.Arrendamento.Service;

import com.site.Arrendamento.Conversores.UsuarioMap;
import com.site.Arrendamento.DTO.UsuarioEntradaDTO;
import com.site.Arrendamento.DTO.UsuarioSaidaDTO;
import com.site.Arrendamento.Repository.UsuarioRepository;
import com.site.Arrendamento.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private  UsuarioRepository usuarioRepository ;
    @Autowired
    private UsuarioMap usuarioMap ;


    public  UsuarioSaidaDTO CriarUsuario(UsuarioEntradaDTO entrada){
        Usuario usuario = usuarioMap.paraUsuario(entrada);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMap.paraUsuarioSaidaDTO(usuarioSalvo);

    }


    public List<UsuarioSaidaDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioSaidaDTO(usuario))
                .toList();
    }


}
