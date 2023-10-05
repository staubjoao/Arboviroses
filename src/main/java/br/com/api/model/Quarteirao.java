package br.com.api.model;

import jakarta.validation.Valid;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "db_quarteirao")
public class Quarteirao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quarteirao_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.numero.obrigatorio}")
    private Integer numero;

    @Column
    @Valid
    @NotEmpty(message = "{campo.localidade.obrigatorio}")
    private String localidade;

}
