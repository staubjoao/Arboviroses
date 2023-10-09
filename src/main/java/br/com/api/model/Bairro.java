package br.com.api.model;


import javax.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "bairro")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bairro_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

}
