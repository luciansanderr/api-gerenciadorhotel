package br.com.gerenciadorhoteis.gerenciador.reserva.service;

import br.com.gerenciadorhoteis.gerenciador.hotel.model.HotelEntity;
import br.com.gerenciadorhoteis.gerenciador.reserva.model.ReservaEntity;
import br.com.gerenciadorhoteis.gerenciador.reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public void salvarReserva(ReservaEntity reservaEntity) {
        this.reservaRepository.save(reservaEntity);
    }

    public List listarReserva(ReservaEntity reservaEntity) {
        return this.reservaRepository.findAll();
    }

    public void cancelarReserva(ReservaEntity reservaEntity) {
        this.reservaRepository.save(reservaEntity);
    }
}
