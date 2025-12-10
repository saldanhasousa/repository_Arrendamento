package com.site.Arrendamento.DTO;

import com.site.Arrendamento.entidades.Localizacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoDTOEntrada {

    @NotBlank(message = "O municipio é obrigatório")
    private String municipio;

    @NotBlank(message = "O bairro é obrigatório")
    private String bairro;


    @NotEmpty(message = "A lista de serviços sociais não pode estar vazia")
    private List<@NotBlank(message = "O serviço social é obrigatório")String> servicosSociais;

}
