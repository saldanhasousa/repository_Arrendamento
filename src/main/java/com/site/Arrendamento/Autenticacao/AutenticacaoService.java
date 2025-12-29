package com.site.Arrendamento.Autenticacao;

import com.site.Arrendamento.Repository.UsuarioRepository;
import com.site.Arrendamento.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {
   @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    public AuthResponseDTO login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            throw new BadCredentialsException("Senha incorreta");
        }

        String token = jwtService.gerarToken(usuario);

        return new AuthResponseDTO(token, usuario.getEmail(), usuario.getTipoUsuario().toString());
    }


}
