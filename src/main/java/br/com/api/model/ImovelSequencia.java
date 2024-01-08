package br.com.api.model;

import jakarta.validation.Valid;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "imovel_sequencia")
public class ImovelSequencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imovel_sequencia_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.sequencia.obrigatorio}")
    private String sequencia;

    @ManyToOne
    @JoinColumn(name = "fk_imovel_id")
    private Imovel imovel;
}
