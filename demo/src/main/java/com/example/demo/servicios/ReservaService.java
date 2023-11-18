package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Reserva;
import com.example.demo.repositorios.ReservaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

 
    public List<Reserva> obtenerTodasReservas() {
        return (List<Reserva>) reservaRepository.findAll();
    }


    public Optional<Reserva> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }


    public Reserva actualizarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

  
    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
