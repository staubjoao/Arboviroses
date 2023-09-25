package br.com.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Localidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @Column
    private String estrato;

    @Column
    private String categoria;

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEstrato() {
        return estrato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Localidade() {
        super();
    }

    public Localidade(Integer id, String descricao, String estrato, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.estrato = estrato;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Localidade [categoria=" + categoria + ", descricao=" + descricao + ", estrato=" + estrato + ", id=" + id
                + "]";
    }
}
