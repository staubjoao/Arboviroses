package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="tipo_imoveis")
public class TipoImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_imovel_id")
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
