package br.com.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String bairro;
    @OneToMany(mappedBy = "bairro")
    private List<Imovel> imoveis;

}
