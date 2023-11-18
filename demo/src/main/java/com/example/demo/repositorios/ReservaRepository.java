package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}