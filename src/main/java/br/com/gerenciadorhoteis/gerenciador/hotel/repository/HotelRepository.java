package br.com.gerenciadorhoteis.gerenciador.hotel.repository;

import br.com.gerenciadorhoteis.gerenciador.hotel.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
}
