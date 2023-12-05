package br.com.api.model;

import jakarta.validation.Valid;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "municipio_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.municipio.obrigatorio}")
    private String municipio;

    @Column
    private Integer quantidadeImoveisUrbanos;

    @Column
    private Integer quantidadeImoveisRurais;

    @Column
    private boolean infestado;
}
