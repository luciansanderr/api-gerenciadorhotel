package br.com.gerenciadorhoteis.gerenciador.quarto.repositoty;

import br.com.gerenciadorhoteis.gerenciador.quarto.model.QuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<QuartoEntity, Integer> {
}
