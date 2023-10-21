package br.com.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "dados_laboratoriais")
public class DadosLaboratoriais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dados_laboratoriais_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    @Valid
    @NotEmpty(message = "{campo.resultado.obrigatorio}")
    private String resultadoDaAnalise;

    @OneToOne
    @JoinColumn(name = "fk_amostra_id")
    private AmostraLaboratorial amostraLaboratorial;
}
