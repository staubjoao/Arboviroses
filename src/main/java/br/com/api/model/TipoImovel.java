package br.com.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="tipo_imoveis")
public class TipoImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_imovel_id")
    private Integer id;
    @Column
    private String sigla;
    @Column
    private String descricao;
//    @OneToMany(mappedBy = "tipo_imoveis")
//    private List<Imovel> imoveis;

}
