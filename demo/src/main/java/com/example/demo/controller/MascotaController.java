package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entidades.Mascota;
import com.example.demo.servicios.MascotaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    // Endpoint para crear una nueva mascota
    @PostMapping
    public ResponseEntity<Mascota> crearMascota(@RequestBody Mascota mascota) {
        Mascota nuevaMascota = mascotaService.crearMascota(mascota);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }

    // Endpoint para obtener todas las mascotas
    @GetMapping
    public ResponseEntity<List<Mascota>> obtenerTodasMascotas() {
        List<Mascota> mascotas = mascotaService.obtenerTodasMascotas();
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    // Endpoint para obtener una mascota por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascotaPorId(@PathVariable Long id) {
        Optional<Mascota> mascota = mascotaService.obtenerMascotaPorId(id);
        return mascota.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para actualizar una mascota
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        mascota.setIdMascota(id);
        Mascota mascotaActualizada = mascotaService.actualizarMascota(mascota);
        return new ResponseEntity<>(mascotaActualizada, HttpStatus.OK);
    }

    // Endpoint para eliminar una mascota por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
