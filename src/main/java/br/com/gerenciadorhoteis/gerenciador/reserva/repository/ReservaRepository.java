package br.com.gerenciadorhoteis.gerenciador.reserva.repository;

import br.com.gerenciadorhoteis.gerenciador.reserva.model.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {
}
