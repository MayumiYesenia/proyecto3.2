package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}