package br.com.gerenciadorhoteis.gerenciador.quarto.controller;

import br.com.gerenciadorhoteis.gerenciador.hotel.model.HotelEntity;
import br.com.gerenciadorhoteis.gerenciador.hotel.service.HotelService;
import br.com.gerenciadorhoteis.gerenciador.quarto.model.QuartoEntity;
import br.com.gerenciadorhoteis.gerenciador.quarto.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quarto")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;
    @Autowired
    private HotelService hotelService;

    @PostMapping("/salvar")
    public QuartoEntity salvarQuarto(@RequestBody QuartoEntity quartoEntity) {
        return this.quartoService.salvarQuarto(quartoEntity);
    }

    @GetMapping("/listar")
    public List listar(@RequestBody QuartoEntity quartoEntity) {
        return this.quartoService.listarQuartos(quartoEntity);
    }

    @PostMapping("/salvar-quarto")
    public String cadastrarQuartoEmHotel(@RequestBody QuartoEntity quartoEntity,
                                       @RequestParam("hotel") Integer hotelId) {
        HotelEntity hotel = hotelService.buscarPorId(hotelId);
        quartoEntity.setHotelEntity(hotel);
        this.quartoService.salvarQuarto(quartoEntity);
        return "Quarto salvo do hotel!";
    }

}
