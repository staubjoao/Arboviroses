package br.com.api.model;

import javax.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Data
@Table(name = "registro_antivetorial")
public class RegistroAntivetorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_antivetorial_id")
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "{campo.data.obrigatorio}")
    private Date dataAtividade;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    @NotNull(message = "{campo.hora.obrigatorio}")
    private Date horaAtividade;

    @Column(nullable = false)
    @NotNull(message = "{campo.moradores.obrigatorio}")
    private Integer numMoradores;

    @Column(nullable = false, length = 100)
    @NotNull(message = "{campo.tipoVisita.obrigatorio}")
    private String tipoVisita;

    @Column(nullable = false)
    @NotNull(message = "{campo.larvas.obrigatorio}")
    private Boolean larvasEncontradas;

    @Column(length = 100)
    private String acoes;

    @Column(length = 100)
    private String tipoTratamentoFocal;

    @Column
    private Double qtdProdutoAplicado;

    @Column
    private Integer qtdDepositosTratados;

    @Column(length = 100)
    private String tipoTratamentoPerifocal;

    @Column
    private Integer qtdCargasAplicadas;

    @Column
    private Boolean depositosEliminados;

    @Column(length = 100)
    private String observacoes;

    @Column(length = 100, nullable = true)
    private String fotos;

    @OneToOne
    @JoinColumn(name = "fk_bloqueio_id")
    private Bloqueio bloqueio;

    // transforme a data em string
    public String getDataAtividade() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(dataAtividade);
    }

    // transforme a hora em string
    public String getHoraAtividade() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(horaAtividade);
    }

    // Faça o set agora
    public void setDataAtividade(String dataAtividade) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataAtividade = sdf.parse(dataAtividade);
    }

    // Faça o set agora
    public void setHoraAtividade(String horaAtividade) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.horaAtividade = sdf.parse(horaAtividade);
    }

}