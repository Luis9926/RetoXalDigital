package com.xaldigital.retotecnico.model;

import javax.persistence.*;

@Entity
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nombre_aerolinea;

    public Aerolinea(Long id, String nombre_aerolinea) {
        this.id = id;
        this.nombre_aerolinea = nombre_aerolinea;
    }

    public Aerolinea() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_aerolinea() {
        return nombre_aerolinea;
    }

    public void setNombre_aerolinea(String nombre_aerolinea) {
        this.nombre_aerolinea = nombre_aerolinea;
    }
}
