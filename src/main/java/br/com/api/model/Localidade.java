package br.com.api.model;

<<<<<<<< HEAD:src/main/java/br/com/api/model/LocalidadeModel.java
import javax.persistence.*;
========

import jakarta.persistence.Id;
>>>>>>>> origin/master:src/main/java/br/com/api/model/Localidade.java
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
<<<<<<<< HEAD:src/main/java/br/com/api/model/LocalidadeModel.java
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LocalidadeModel {
========

@Table(name="localidades")
public class Localidade {
    
>>>>>>>> origin/master:src/main/java/br/com/api/model/Localidade.java

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
