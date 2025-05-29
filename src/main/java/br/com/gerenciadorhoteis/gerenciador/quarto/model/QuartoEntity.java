package br.com.gerenciadorhoteis.gerenciador.quarto.model;

import br.com.gerenciadorhoteis.gerenciador.hotel.model.HotelEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "quartos")
public class QuartoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quarto_id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "situacao")
    private Boolean situacao;
    @Column(name = "numero")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

    @OneToMany(mappedBy = "reserva_id")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }
}
