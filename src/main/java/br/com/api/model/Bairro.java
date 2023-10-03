package br.com.api.model;
<<<<<<<< HEAD:src/main/java/br/com/api/model/BairroModel.java
import javax.persistence.*;
========


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
>>>>>>>> origin/master:src/main/java/br/com/api/model/Bairro.java
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
<<<<<<<< HEAD:src/main/java/br/com/api/model/BairroModel.java
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bairros")
public class BairroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bairro_id")
========
@Table(name = "bairros")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

>>>>>>>> origin/master:src/main/java/br/com/api/model/Bairro.java
    private Integer id;

    @Column(nullable = false, length = 100)
    @Valid
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

}
