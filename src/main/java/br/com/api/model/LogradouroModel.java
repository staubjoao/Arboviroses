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
public class LogradouroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="logradouro_id")
    private Integer id;
    @Column
    private String logradouro;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name="fk_logradouro_id")
    private List<ImovelModel> imoveis;

    public LogradouroModel(LogradouroDTO logradouroDTO) {
        this.logradouro = logradouroDTO.getLogradouro();
    }
}
