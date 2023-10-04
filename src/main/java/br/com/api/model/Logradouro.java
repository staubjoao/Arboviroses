package br.com.api.model;

import br.com.api.dtos.LogradouroDTO;

import javax.persistence.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "db_logradouro")
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logradouro_id")
    private Integer id;
    @Column
    @Valid
    @NotBlank(message = "{campo.nome.obrigatorio}")
    private String logradouro;

}
