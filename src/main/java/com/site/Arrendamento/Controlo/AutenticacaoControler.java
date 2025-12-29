package com.site.Arrendamento.Controlo;

import com.site.Arrendamento.Autenticacao.AutenticacaoService;
import com.site.Arrendamento.Autenticacao.AuthResponseDTO;
import com.site.Arrendamento.Autenticacao.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoControler {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        AuthResponseDTO response = autenticacaoService.login(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok(response);
    }
}

