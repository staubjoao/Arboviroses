package br.com.api.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "rotasAgentes")
public class RotasAgentes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "fk_usuario_id")
    private Usuario usuario;
	
	@ManyToOne
    @JoinColumn(name = "fk_quarteirao_id")
    private Quarteirao quarteirao;
	
}
