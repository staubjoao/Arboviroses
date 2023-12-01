package br.com.api.dtos;


import lombok.Data;

@Data
public class ImovelDTO {

    private Integer id;
    private String localidade;
    private String numero;
    private String complemento;
    private Integer bairroId;
    private Integer logradouroId;
    private Integer quarteiraoId;
    private Integer tipoImovelId;
//    private Integer registroAntivetorialId;
}
