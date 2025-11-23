package com.site.Arrendamento.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    private String senha;
}
