package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombre(String nombre);
}