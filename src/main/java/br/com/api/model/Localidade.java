package br.com.api.model;

import javax.persistence.*;

import jakarta.validation.Valid;
import lombok.Data;

@Entity
@Data
@Table(name = "localidade")
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localidade_id")
    private Integer id;

    @Column(nullable = false, length = 400)
    @Valid
    private String descricao;

    @Column(nullable = false, length = 100)
    @Valid
    private String estrato;

    @Column(nullable = false, length = 100)
    @Valid
    private String categoria;

}