package br.com.gerenciadorhoteis.gerenciador.hotel.service;

import br.com.gerenciadorhoteis.gerenciador.hotel.model.HotelEntity;
import br.com.gerenciadorhoteis.gerenciador.hotel.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelEntity salvarHotel(HotelEntity hotelEntity) {
        return this.hotelRepository.save(hotelEntity);
    }
    public List<HotelEntity> listarHotel(HotelEntity hotelEntity) {
        return this.hotelRepository.findAll();
    }

    public HotelEntity buscarPorId(Integer hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new EntityNotFoundException("Hotel com ID " + hotelId + " não encontrado"));
    }
}
