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

    @Column(name = "direccion", columnDefinition = "TEXT")
    private String direccion;

    @Column(name = "fotos", columnDefinition = "TEXT")
    private String fotos;

    @Column(name = "horario", columnDefinition = "TEXT")
    private String horario;

    @Column(name = "latitud")
    private double latitud;

    @Column(name = "longitud")
    private double longitud;


    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    public Lugar() {
    }

    public Lugar(String nombre, double rating, String estado, String telefono, String direccion, String fotos, String horario, double latitud, double longitud) {
        this.nombre = nombre;
        this.rating = rating;
        this.estado = estado;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fotos = fotos;
        this.horario = horario;
        this.latitud = latitud;
        this.longitud = longitud;
    }

   

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
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
