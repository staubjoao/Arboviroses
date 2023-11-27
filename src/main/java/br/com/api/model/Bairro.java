package br.com.api.model;


import javax.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
@Entity
@Table(name = "bairro")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bairro_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.nome.obrigatorio}")
   
    private String nome;

    @ManyToOne
    @JoinColumn(name = "fk_cidade_id")
    private Cidade cidade;

    // public void setNome(String nome) {
    //     // Garantir que o nome seja sempre salvo em maiúsculas
    //     this.nome = nome != null ? nome.toUpperCase() : null;
    // }

}
