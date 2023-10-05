package br.com.api.model;

import br.com.api.dtos.QuarteiraoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "db_quarteiroe")
public class Quarteirao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quarteirao_id")
    private Integer id;
    @Column
    @Valid
    @NotNull(message = "{campo.numero.quarteirao.vazio}")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "localidade_id")
    private Localidade localidade;
}
