package br.com.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import jakarta.validation.Valid;
import lombok.Data;

@Data
@Entity
@Table(name = "db_logradouro")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logradouro_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.logradouro.obrigatorio}")
    private String logradouro;

}
