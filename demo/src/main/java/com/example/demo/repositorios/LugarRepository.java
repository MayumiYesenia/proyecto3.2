package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Lugar;

public interface LugarRepository extends JpaRepository<Lugar, Long> {
}