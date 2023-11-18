package com.example.demo.entidades;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlugar")
    private Long idLugar;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "rating")
    private double rating;

    @Column(name = "estado")
    private String estado;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Lugar() {
    }

    public Lugar(String nombre, double rating, String estado, String telefono) {
        this.nombre = nombre;
        this.rating = rating;
        this.estado = estado;
        this.telefono = telefono;
    }

    // Getters y setters

    public Long getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
