package br.com.api.model;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "db_tipo_imovei")
public class TipoImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_imovel_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column
    @Valid
    @NotEmpty(message = "{campo.sigla.obrigatorio}")
    private String sigla;

}
