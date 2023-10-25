package br.com.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "geolocalizacao")
public class Geolocalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geolocalizacao_id")
    private Integer id;

    @Column
    private Double latitude;

    @Column
    private  Double longitude;

}
