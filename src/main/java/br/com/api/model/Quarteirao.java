package br.com.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

import javax.persistence.*;
import java.util.List;

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

    public String polygonToWkt() {
        StringBuilder wktBuilder = new StringBuilder("POLYGON((");

        List<Point> points = this.poligono.getPoints();

        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            wktBuilder.append(point.getY()).append(" ").append(point.getX());

            if (i < points.size() - 1) {
                wktBuilder.append(", ");
            }
        }

        // Repetir o primeiro ponto para fechar o polígono
        Point firstPoint = points.get(0);
        wktBuilder.append(", ").append(firstPoint.getY()).append(" ").append(firstPoint.getX());

        wktBuilder.append("))");

        return wktBuilder.toString();
    }

}
