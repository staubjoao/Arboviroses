package br.com.api.model;

import br.com.api.dtos.LogradouroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
    @Valid
    @NotBlank(message = "{campo.nome.obrigatorio}")
    private String logradouro;
    @JsonIgnore
    @OneToMany
    @JoinColumn(name="fk_logradouro_id")
    private List<ImovelModel> imoveis;

    public Logradouro(LogradouroDTO logradouroDTO) {
        this.logradouro = logradouroDTO.getLogradouro();
    }
}
