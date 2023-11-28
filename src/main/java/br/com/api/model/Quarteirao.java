package br.com.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "quarteirao")
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
    @JoinColumn(name = "fk_localidade_id")
    private Localidade localidade;

    @OneToMany(mappedBy = "quarteirao")
    private Set<RotasAgentes> rotasAgentes = new HashSet<>();

}
