package br.com.api.model;

import br.com.api.dtos.BairroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bairros")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bairro_id")
    private Integer Id;
    @Column(nullable = false)
    private String bairro;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "fk_bairro_id")
    private List<Imovel> imoveis;

    public Bairro(BairroDTO bairroDTO) {
        this.bairro = bairroDTO.getBairro();
    }

}
