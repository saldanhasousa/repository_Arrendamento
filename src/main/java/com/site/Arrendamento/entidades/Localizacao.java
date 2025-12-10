package com.site.Arrendamento.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Localizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;


    private String provincia="Luanda";

    @Column(nullable = false)
    @NotBlank(message = "O municipio é obrigatório")
    private String municipio;


    @Column(nullable = false)
    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;

    @ElementCollection
    @CollectionTable(
            name = "localizacao_servicos_sociais",
            joinColumns = @JoinColumn(name = "localizacao_id")
    )
    @Column(name = "servicos")

    @NotEmpty(message = "A lista de serviços sociais não pode estar vazia")
    private List<@NotBlank(message = "O serviço social é obrigatório")String> servicosSociais;



}

