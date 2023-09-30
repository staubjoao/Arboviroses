package br.com.api.model;

import javax.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LocalidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 400)
    @Valid
    private String descricao;

    @Column(nullable = false, length = 100)
    @Valid
    private String estrato;

    @Column(nullable = false, length = 100)
    @Valid
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "bairro_id")
    @Valid
    @NotNull(message = "{campo.bairro.obrigatorio}")
    private BairroModel bairro;

}
