package com.site.Arrendamento.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoDTOSaida {
    private Long id;
    private String provincia;
    private String municipio;
    private String bairro;
    private java.util.List<String> servicosSociais;

}
