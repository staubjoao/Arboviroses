package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="bairros")
public class BairroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bairro_id")
    private Integer id;
    @Column(nullable = false)
    private String bairro;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name="fk_bairro_id")
    private List<Imovel> imoveis;

}
