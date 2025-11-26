package com.site.Arrendamento.DTO;

import com.site.Arrendamento.Enum.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntradaDtO {


    @Column(unique = true, nullable = false)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "O contacto é obigatório")
    @Column( nullable = false)
    private String telefone;

    @Column(unique = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Column( nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario; // Tipo



}
