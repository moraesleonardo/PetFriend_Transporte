package org.example.controller;

import org.example.entity.Transporte;
import org.example.repository.TransporteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportes")
public class TransporteController {

    private final TransporteRepository transporteRepository;

    public TransporteController(TransporteRepository transporteRepository) {
        this.transporteRepository = transporteRepository;
    }

    @GetMapping
    public List<Transporte> getTransportes() {
        return transporteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Transporte getTransporteById(@PathVariable Long id) {
        return transporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Transporte não encontrado"));
    }

    @PostMapping
    public Transporte criarTransporte(@RequestBody Transporte transporte) {
        return transporteRepository.save(transporte);
    }
}
