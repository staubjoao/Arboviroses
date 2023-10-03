package br.com.api.model;



import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;


import javax.persistence.*;

@Entity
@Data
@Table(name="localidades")
public class Localidade {


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
    private Bairro bairro;

}
