package br.com.api.model;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

import jakarta.validation.Valid;
import lombok.Data;

@Data
@Entity
@Table(name = "db_imovel")
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imovel_id")
    private Integer id;

    @Column
    @Valid
    @NotEmpty(message = "{campo.localidade.obrigatorio}")
    private String localidade;

    @Column
    @Valid
    @NotEmpty(message = "{campo.numero.obrigatorio}")
    private String numero;

    @Column
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "fk_bairro_id")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "fk_logradouro_id")
    private Logradouro logradouro;

    @ManyToOne
    @JoinColumn(name = "fk_quarteirao_id")
    private Quarteirao quarteirao;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_imovel_id")
    private TipoImovel tipoImovel;

}
