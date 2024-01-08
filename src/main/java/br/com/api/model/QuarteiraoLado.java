package br.com.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "quarteirao_lado")
public class QuarteiraoLado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quarteirao_lado_id")
    private Integer id;

    @Column
    private Integer lado;

    @ManyToOne
    @JoinColumn(name = "fk_quarteirao_id")
    private Quarteirao quarteirao;
}
