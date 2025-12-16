package com.site.Arrendamento.entidades;

import com.site.Arrendamento.Enum.EstadoContrato;
import com.site.Arrendamento.Enum.EstadoImovel;
import com.site.Arrendamento.Enum.TipoContrato;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false,unique = true)
    @NotBlank(message = "O titulo é obrigatório")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @Column(nullable = false, precision=10, scale=5) // <-- CORRIGIDO AQUI
    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser um valor positivo")
    private BigDecimal preco;


    @Column(nullable = false)
    private String imagem1;

    @Column(nullable = false)
    private String imagem2;

    @Column(nullable = false)
    private String imagem3;

    @Enumerated(EnumType.STRING)
    @NotNull (message = "O tipo de contrato é obrigatório")
        private TipoContrato tipoContrato;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "O estado do contrato é obrigatório")
    private EstadoContrato estadoContrato;


    @Enumerated(EnumType.STRING)

    @NotNull(message = "O estado do imovel contrato é obrigatório")
    private EstadoImovel estadoImovel;


    @ManyToOne
    @JoinColumn(name = "proprietario_id",nullable = false)
    @NotNull(message = "O imovel deve ter um proprietário ")
    private Usuario proprietario;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "localizacao_id",nullable = false)
   private Localizacao localizacao;



}
