package br.com.api.dtos;

import lombok.Data;

@Data
public class CentroLocalidadeDTO {

    private String pontoCentral;

    public CentroLocalidadeDTO(String pontoCentral) {
        this.pontoCentral = pontoCentral;
    }

}
