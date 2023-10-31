package br.com.api.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "rotas_agentes")
public class RotasAgentes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rotas_agentes_id")
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "fk_usuario_id")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "fk_quarteirao_id")
    private Quarteirao quarteirao;
	
}
