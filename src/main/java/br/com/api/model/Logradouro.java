package br.com.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String logradouro;
    @OneToMany(mappedBy = "logradouro")
    private List<Imovel> imoveis;

}
