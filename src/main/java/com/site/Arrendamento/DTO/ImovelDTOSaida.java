package com.site.Arrendamento.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelDTOSaida {

    private Long id;
    private String titulo;
    private String descricao;
    private java.math.BigDecimal preco;
    private String tipoContrato;
    private String estadoContrato;
    private String estadoImovel;
    private UsuarioSaidaDTO proprietario;
    private LocalizacaoDTOSaida localizacao;

}
