package com.site.Arrendamento.Controlo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.site.Arrendamento.DTO.UsuarioEntradaDTO;
import com.site.Arrendamento.DTO.UsuarioSaidaDTO;
import com.site.Arrendamento.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlo {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/user")
    public ResponseEntity<String> CadastrarUsuario(@RequestBody @Valid UsuarioEntradaDTO entrada){
      usuarioService.CriarUsuario(entrada);

        return  ResponseEntity.ok("Usuário criado com sucesso");
    }
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/admin")
public ResponseEntity<String>CadastrarAdmim(@RequestBody @Valid UsuarioEntradaDTO entrada){
        usuarioService.criarAdmin(entrada);
        return ResponseEntity.ok("Administrador criado com sucesso");
}


    //Para apresentar os usuario no frontend
    @GetMapping
    public ResponseEntity<List<UsuarioSaidaDTO>> listarUsuarios() {
        List<UsuarioSaidaDTO> lista = usuarioService.listarUsuarios();
        return ResponseEntity.ok(lista);
    }

    // DELETE /usuario/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok("Usuário deletado com sucesso");
    }
}


