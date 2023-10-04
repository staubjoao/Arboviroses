package br.com.api.dtos;

import br.com.api.model.Bairro;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LocalidadeDTO {

    private String descricao;

    private String estrato;

    private String categoria;

    private Integer idBairro;


}
