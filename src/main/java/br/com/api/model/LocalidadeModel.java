package br.com.api.model;

import br.com.api.dtos.LocalidadeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalidadeModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @Column
    private String estrato;

    @Column
    private String categoria;

    @Column
    private String zona;

    public LocalidadeModel(LocalidadeDTO localidadeDTO) {
        this.descricao = localidadeDTO.getDescricao();
        this.categoria = localidadeDTO.getCategoria();
        this.estrato = localidadeDTO.getEstrato();
        this.zona = localidadeDTO.getZona();
    }

    @Override
    public String toString() {
        return "Localidade [categoria=" + categoria + ", descricao=" + descricao + ", estrato=" + estrato + ", id=" + id
                + "]";
    }
}
