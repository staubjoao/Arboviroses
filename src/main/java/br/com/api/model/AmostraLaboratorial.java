package br.com.api.model;


import javax.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "amostra_laboratorial")
public class AmostraLaboratorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amostra_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    @Valid
    @NotEmpty(message = "{campo.amostrainicial.obrigatorio}")
    private String numeroAmostraInicial;

    @Column(nullable = false, length = 100)
    @Valid
    @NotEmpty(message = "{campo.amostrafinal.obrigatorio}")
    private String numeroAmostraFinal;

    @Column(nullable = false, length = 400)
    @Valid
    @NotEmpty(message = "{campo.quantidade.obrigatorio}")
    
    private Integer quantidadeTubitos;

    // @ManyToOne
    // @JoinColumn(name = "fk_registro_id")
    // private RegistroDiario registrodiario;

    // @OneToOne
    // @JoinColumn(name = "fk_dados_laboratorias_id")
    // private DadosLaboratoriais dadoslaboratorias
}
