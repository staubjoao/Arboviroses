package br.com.api.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	public Role(String name) {
		this.name = name;
	}
	
	public Role() {
		
	}
		
}

