package br.com.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bloqueio")
public class Bloqueio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bloqueio_id")
    private Integer id;

    @Column
    private String Descricao;

    @ManyToOne
    @JoinColumn(name = "fk_rota_id")
    private Rota rota;

    @ManyToOne
    @JoinColumn(name = "fk_registro_antivetorial_id")
    private RegistroAntivetorial registroAntivetorial;

}
