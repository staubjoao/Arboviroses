package br.com.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import jakarta.validation.Valid;
import lombok.Data;



@Data
@Entity(name = "larvicida")
@Table(name = "larvicida")

public class larvicida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "larvicida_id")
    private Long id;

    @Column
    @NotEmpty(message = "{campo.tipo.obrigatorio}")
    private String tipo;

    @Column
    private int quantidade;

    @Column(name = "qtd_depositos_tratados")
    private int qtdDepositosTratados;

    @Column(name = "qtd_depositos_eliminados")
    private int qtdDepositosEliminados;

    private larvicida(){}

    public larvicida(String tipo, int quantidade, int qtdDepositosTratados, int qtdDepositosEliminados){
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.qtdDepositosTratados = qtdDepositosTratados;
        this.qtdDepositosEliminados = qtdDepositosEliminados;
    }
}
