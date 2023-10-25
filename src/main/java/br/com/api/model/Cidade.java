package br.com.api.model;

import jakarta.validation.Valid;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cidade_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    private String cidade;
}
