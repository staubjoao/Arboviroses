package br.com.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String localidade;
    @Column
    private String numero;
    @Column
    private String complemento;
    @ManyToOne
    @JoinColumn(name="bairro_id")
    private Bairro bairro;
    @ManyToOne
    @JoinColumn(name="logradouro_id")
    private Logradouro logradouro;
    @ManyToOne
    @JoinColumn(name="tipo_imovel_id")
    private TipoImovel tipoImovel;
}
