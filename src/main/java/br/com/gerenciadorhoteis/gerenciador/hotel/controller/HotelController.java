package br.com.gerenciadorhoteis.gerenciador.hotel.controller;

import br.com.gerenciadorhoteis.gerenciador.hotel.model.HotelEntity;
import br.com.gerenciadorhoteis.gerenciador.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //salvar hotel
    @PostMapping("/salvar-hotel")
    public String salvarHotel(@RequestBody HotelEntity hotelEntity) {
        this.hotelService.salvarHotel(hotelEntity);
        return "Hotel Cadastrado!";
    }
    //listar hoteis
    @GetMapping("/listar")
    public List<HotelEntity> listarHotel(@RequestBody HotelEntity hotel) {
        return this.hotelService.listarHotel(hotel);
    }
}
