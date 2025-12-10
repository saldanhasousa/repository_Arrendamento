package com.site.Arrendamento.Controlo;

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

    @PostMapping
    public ResponseEntity<UsuarioSaidaDTO> CadastrarUsuario(@RequestBody @Valid UsuarioEntradaDTO entrada){
        UsuarioSaidaDTO usuarioSaidaDTO = usuarioService.CriarUsuario(entrada);

        return new ResponseEntity<>(usuarioSaidaDTO, HttpStatus.CREATED);
    }


    //Para apresentar os usuario no frontend
    @GetMapping
    public ResponseEntity<List<UsuarioSaidaDTO>> listarUsuarios() {
        List<UsuarioSaidaDTO> lista = usuarioService.listarUsuarios();
        return ResponseEntity.ok(lista);
    }
}


