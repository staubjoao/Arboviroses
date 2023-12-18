package br.com.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.geo.Polygon;

import javax.persistence.*;

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

    @Column(columnDefinition = "GEOMETRY(POLYGON, 4326)")
    private Polygon poligono;

    @ManyToOne
    @JoinColumn(name = "fk_localidade_id")
    private Localidade localidade;

}
