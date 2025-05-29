package br.com.gerenciadorhoteis.gerenciador.reserva.controller;

import br.com.gerenciadorhoteis.gerenciador.quarto.model.QuartoEntity;
import br.com.gerenciadorhoteis.gerenciador.quarto.service.QuartoService;
import br.com.gerenciadorhoteis.gerenciador.reserva.model.ReservaEntity;
import br.com.gerenciadorhoteis.gerenciador.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private QuartoService quartoService;

    @PostMapping("/salvar-reserva")
    public String salvarReserva(@RequestBody ReservaEntity reservaEntity, @RequestParam("quarto") Integer quartoId) {
        QuartoEntity quarto = quartoService.buscarPorId(quartoId);
        if (quarto.getSituacao() == false) {
            return "Esse quarto já está ocupado!";
        } else {
            quartoService.alterarSituacao(quarto);
            reservaEntity.setQuartoEntity(quarto);
            this.reservaService.salvarReserva(reservaEntity);
            return "Reserva Feita Com Sucesso!";
        }
    }

    @GetMapping("/listar-reserva")
    public List listarReserva(@RequestBody ReservaEntity reservaEntity) {
        return this.reservaService.listarReserva(reservaEntity);
    }

    @PutMapping("/cancelar-reserva/{id}")
    public String cancelarReserva(@PathVariable("id") Integer id, @RequestBody ReservaEntity reservaEntity, @RequestParam("quarto") Integer quartoId) {
        reservaEntity.setId(id);
        QuartoEntity quarto = quartoService.buscarPorId(quartoId);
        this.quartoService.alterarSituacao(quarto);
        this.reservaService.cancelarReserva(reservaEntity);
        return "Reserva Cancelada!";
    }
}
