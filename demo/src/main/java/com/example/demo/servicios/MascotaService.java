package com.example.demo.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Mascota;
import com.example.demo.repositorios.MascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    @Autowired
    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    // Método para crear una nueva mascota
    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Método para obtener todas las mascotas
    public List<Mascota> obtenerTodasMascotas() {
        return (List<Mascota>) mascotaRepository.findAll();
    }

    // Método para obtener una mascota por su ID
    public Optional<Mascota> obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    // Método para actualizar una mascota
    public Mascota actualizarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // Método para eliminar una mascota por su ID
    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}
