package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="logradouros")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="logradouro_id")
    private Integer id;
    @Column
    private String logradouro;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name="fk_logradouro_id")
    private List<Imovel> imoveis;

}
