package com.site.Arrendamento.DTO;

import com.site.Arrendamento.entidades.Localizacao;
import com.site.Arrendamento.entidades.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelDTOEntrada {


    @NotBlank(message = "O titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "A descrição  é obrigatório")
    private String descricao;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser um valor positivo")
    private java.math.BigDecimal preco;

    @NotBlank(message = "O tipo de contrato  é obrigatório")
    private String tipoContrato;

    @NotBlank(message = "O estado do contrato é obrigatório")
    private String estadoContrato;

    @NotBlank(message = "O estado do imovel é obrigatório")
    private String estadoImovel;

    @NotBlank(message = "O proprietario do imovel é obrigatório")
    private  long proprietario_id;

    @NotBlank(message = "A localização do imovel é obrigatório")
    private LocalizacaoDTOEntrada localizacao;



}
