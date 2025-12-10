package com.site.Arrendamento.entidades;

import com.site.Arrendamento.Enum.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @Column( name = "data_cadastro",nullable = false,updatable = false)
    private LocalDateTime dataregisto;

    @PrePersist
    public void prePersist(){
        this.dataregisto = LocalDateTime.now();
    }
}
