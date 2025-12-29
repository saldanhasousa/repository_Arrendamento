package com.site.Arrendamento.Service;

import com.site.Arrendamento.Enum.TipoUsuario;
import com.site.Arrendamento.Repository.UsuarioRepository;
import com.site.Arrendamento.entidades.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdmimBootstrap implements ApplicationRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Optional<Usuario> usuario=usuarioRepository.findByTipoUsuario(TipoUsuario.ADMINISTRADOR);
        if(usuario.isEmpty()){
            Usuario admin = new Usuario();
admin.setNome("Lauriana Domingos");
            admin.setTelefone("949316924");
            admin.setEmail("dnoemia273@gmail.com");
            admin.setSenha(encoder.encode("123456"));
            admin.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
            usuarioRepository.save(admin);
            System.out.println("Administrador criado com sucesso");

        }else {
            System.out.println("Administrador já existe");
        }
    }
}
