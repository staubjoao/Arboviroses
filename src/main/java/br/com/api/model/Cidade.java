package br.com.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String cidade;
}
