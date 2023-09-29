package br.com.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelDTO {

    @NotBlank
    private String localidade;
    @NotBlank
    private String numero;
    @NotBlank
    private String complemento;
    @NotBlank
    private Integer bairro_id;
    @NotBlank
    private Integer logradouro_id;
    @NotBlank
    private Integer tipo_imovel_id;
    @NotBlank
    private Integer quarteirao_id;
}
