package com.site.Arrendamento.DTO;

import com.site.Arrendamento.Enum.TipoUsuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntradaDTO {



    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "telefone é obrigatório")
    private String telefone;

    @Email(message ="imail inválido" )
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario; // Tipo



}
