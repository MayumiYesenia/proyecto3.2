package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Lugar;
import com.example.demo.repositorios.LugarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LugarService {

    private final LugarRepository lugarRepository;

    @Autowired
    public LugarService(LugarRepository lugarRepository) {
        this.lugarRepository = lugarRepository;
    }

    // Método para crear un nuevo lugar
    public Lugar crearLugar(Lugar lugar) {
        return lugarRepository.save(lugar);
    }

    // Método para obtener todos los lugares
    public List<Lugar> obtenerTodosLugares() {
        return (List<Lugar>) lugarRepository.findAll();
    }

    // Método para obtener un lugar por su ID
    public Optional<Lugar> obtenerLugarPorId(Long id) {
        return lugarRepository.findById(id);
    }

    // Método para actualizar un lugar
    public Lugar actualizarLugar(Lugar lugar) {
        return lugarRepository.save(lugar);
    }


    public void eliminarLugar(Long id) {
        lugarRepository.deleteById(id);
    }
}
