package com.site.Arrendamento.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSaidaDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String tipoUsuario;
    private String dataCadastro;

}
