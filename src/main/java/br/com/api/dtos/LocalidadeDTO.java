package br.com.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LocalidadeDTO {
    @NotBlank
    private String descricao;

    @NotBlank
    private String estrato;

    @NotBlank
    private String categoria;

    @NotBlank
    private String zona;

}
