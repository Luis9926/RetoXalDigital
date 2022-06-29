package com.xaldigital.retotecnico.model;

import javax.persistence.*;

@Entity
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String descripcion;

    public Movimiento(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Movimiento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
