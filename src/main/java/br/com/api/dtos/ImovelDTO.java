package br.com.api.dtos;


import lombok.Data;

@Data
public class ImovelDTO {

    private Integer id;
    private String localidade;
    private String numero;
    private String complemento;
    private Integer bairro_id;
    private Integer logradouro_id;
    private Integer quarteirao_id;
    private Integer tipo_imovel_id;
    private Integer registro_antivetorial_id;
}
