package br.com.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String bairro;
    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;
}
