package br.com.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity(name = "larvicida")
@Table(name = "larvicida")
public class Larvicida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "larvicida_id")
    private Long id;

    @Column
    @NotEmpty(message = "{campo.larvicida.descricao}")
    private String descricao;

}
