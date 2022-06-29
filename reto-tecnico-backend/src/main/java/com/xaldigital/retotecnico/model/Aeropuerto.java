package com.xaldigital.retotecnico.model;

import javax.persistence.*;

@Entity
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nombre_aeropuerto;

    public Aeropuerto(Long id, String nombre_aeropuerto) {
        this.id = id;
        this.nombre_aeropuerto = nombre_aeropuerto;
    }

    public Aeropuerto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_aeropuerto() {
        return nombre_aeropuerto;
    }

    public void setNombre_aeropuerto(String nombre_aeropuerto) {
        this.nombre_aeropuerto = nombre_aeropuerto;
    }
}
