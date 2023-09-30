package br.com.api.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuarteiraoDTO {
    @NotNull
    private Integer numero;
    @NotBlank
    private String localidade;
}
