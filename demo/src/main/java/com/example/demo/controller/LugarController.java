package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entidades.Lugar;
import com.example.demo.servicios.LugarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lugares")
public class LugarController {

    private final LugarService lugarService;

    @Autowired
    public LugarController(LugarService lugarService) {
        this.lugarService = lugarService;
    }

    // Endpoint para crear un nuevo lugar
    @PostMapping
    public ResponseEntity<Lugar> crearLugar(@RequestBody Lugar lugar) {
        Lugar nuevoLugar = lugarService.crearLugar(lugar);
        return new ResponseEntity<>(nuevoLugar, HttpStatus.CREATED);
    }

    // Endpoint para obtener todos los lugares
    @GetMapping
    public ResponseEntity<List<Lugar>> obtenerTodosLugares() {
        List<Lugar> lugares = lugarService.obtenerTodosLugares();
        return new ResponseEntity<>(lugares, HttpStatus.OK);
    }

    // Endpoint para obtener un lugar por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Lugar> obtenerLugarPorId(@PathVariable Long id) {
        Optional<Lugar> lugar = lugarService.obtenerLugarPorId(id);
        return lugar.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para actualizar un lugar
    @PutMapping("/{id}")
    public ResponseEntity<Lugar> actualizarLugar(@PathVariable Long id, @RequestBody Lugar lugar) {
        lugar.setIdLugar(id);
        Lugar lugarActualizado = lugarService.actualizarLugar(lugar);
        return new ResponseEntity<>(lugarActualizado, HttpStatus.OK);
    }

    // Endpoint para eliminar un lugar por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLugar(@PathVariable Long id) {
        lugarService.eliminarLugar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
