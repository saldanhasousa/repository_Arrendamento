package com.site.Arrendamento.Autenticacao;


import com.site.Arrendamento.Enum.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseDTO {

    private String token;           // JWT gerado
    private String email;           // Email do usuário
    private String tipoUsuario;     // Tipo do usuário (PROPRIETARIO, CLIENTE, etc.)
}

