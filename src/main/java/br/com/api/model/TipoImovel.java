package br.com.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class TipoImovel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String sigla;
    @Column
    private String descricao;
    @OneToMany(mappedBy = "tipoImovel")
    private List<Imovel> imoveis;

}
