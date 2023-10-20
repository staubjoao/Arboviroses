package br.com.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "rota")
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rota_id")
    private Integer id;

    @Column
    private String descricao;

//    @OneToMany(mappedBy = "rota")
//    @JoinColumn(name = "rota_id")
//    private List<Quarteirao> quarteiroes;

}
