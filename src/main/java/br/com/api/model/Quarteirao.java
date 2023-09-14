package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="quarteiroes")
public class Quarteirao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="quarteirao_id")
    private Integer id;
    @Column
    private Integer numero;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name="fk_quarteirao_id")
    private List<Imovel> imoveis;

}
