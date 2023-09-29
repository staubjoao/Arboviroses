package br.com.api.model;

import br.com.api.dtos.LogradouroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="logradouros")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="logradouro_id")
    private Integer id;
    @Column
    private String logradouro;

    public Logradouro(LogradouroDTO logradouroDTO) {
        this.logradouro = logradouroDTO.getLogradouro();
    }
}
