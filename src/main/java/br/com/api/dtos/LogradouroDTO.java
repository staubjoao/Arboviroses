package br.com.api.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LogradouroDTO {
    @NotBlank
    private String logradouro;
}
