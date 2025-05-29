package br.com.gerenciadorhoteis.gerenciador.quarto.service;

import br.com.gerenciadorhoteis.gerenciador.quarto.model.QuartoEntity;
import br.com.gerenciadorhoteis.gerenciador.quarto.repositoty.QuartoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public QuartoEntity salvarQuarto(QuartoEntity quartoEntity) {
        return this.quartoRepository.save(quartoEntity);
    }

    public List<QuartoEntity> listarQuartos(QuartoEntity quartoEntity) {
        return this.quartoRepository.findAll();
    }

    public QuartoEntity buscarPorId(Integer quartoId) {
        return quartoRepository.findById(quartoId).orElseThrow(() -> new EntityNotFoundException("Hotel com ID " + quartoId + " não encontrado"));
    }
    
    public QuartoEntity alterarSituacao(QuartoEntity quartoEntity) {
        if (quartoEntity.getSituacao() == false) {
            quartoEntity.setSituacao(true);
        } else {
            quartoEntity.setSituacao(false);
        }
        return quartoRepository.save(quartoEntity);
    }

}
