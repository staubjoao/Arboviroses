package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="tipo_imoveis")
public class TipoImovelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_imovel_id")
    private Integer id;
    @Column
    private String sigla;
    @Column
    private String descricao;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name="fk_tipo_imovel_id")
    private List<ImovelModel> imoveis;

}
