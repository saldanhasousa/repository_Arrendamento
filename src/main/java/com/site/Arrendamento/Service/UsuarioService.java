package com.site.Arrendamento.Service;

import com.site.Arrendamento.Conversores.UsuarioMap;
import com.site.Arrendamento.DTO.UsuarioEntradaDTO;
import com.site.Arrendamento.DTO.UsuarioSaidaDTO;
import com.site.Arrendamento.Repository.UsuarioRepository;
import com.site.Arrendamento.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private  UsuarioRepository usuarioRepository ;
    @Autowired
    private UsuarioMap usuarioMap ;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public  UsuarioSaidaDTO CriarUsuario(UsuarioEntradaDTO entrada){
        Usuario usuario = usuarioMap.paraUsuario(entrada);
        // 🔹 Criptografar a senha antes de salvar
       usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMap.paraUsuarioSaidaDTO(usuarioSalvo);

    }


    public List<UsuarioSaidaDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioSaidaDTO(usuario))
                .toList();
    }


    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }


}
