package br.com.api.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BairroDTO {
    @NotBlank
    private String nome;
}