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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quarteiroes")
public class Quarteirao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quarteirao_id")
    private Integer id;
    @Column
    @Valid
    @NotNull(message = "{campo.numero.quarteirao.vazio}")
    private Integer numero;
    @Column
    @Valid
    @NotBlank(message = "{campo.nome.obrigatorio}")
    private String localidade;
    @OneToMany
    @JoinColumn(name = "fk_quarteirao_id")
    private List<Imovel> imoveis;

    public Quarteirao(QuarteiraoDTO quarteiraoDTO) {
        this.numero=quarteiraoDTO.getNumero();
        this.localidade= quarteiraoDTO.getLocalidade();
    }
}
