package br.com.gerenciadorhoteis.gerenciador.reserva.model;

import br.com.gerenciadorhoteis.gerenciador.hotel.model.HotelEntity;
import br.com.gerenciadorhoteis.gerenciador.quarto.model.QuartoEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class ReservaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Integer id;
    @Column(name = "nome_da_reserva")
    private String nome_da_reserva;
    @Column(name = "situacao")
    private Boolean situacao;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    private QuartoEntity quartoEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_da_reserva() {
        return nome_da_reserva;
    }

    public void setNome_da_reserva(String nome_da_reserva) {
        this.nome_da_reserva = nome_da_reserva;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public QuartoEntity getQuartoEntity() {
        return quartoEntity;
    }

    public void setQuartoEntity(QuartoEntity quartoEntity) {
        this.quartoEntity = quartoEntity;
    }

}
