package com.xaldigital.retotecnico.model.responses;

public class AeropuertoResponse {
    private String nombre_aeropuerto;
    private Long movimientos;

    public AeropuertoResponse(String nombre_aeropuerto, Long movimientos) {
        this.nombre_aeropuerto = nombre_aeropuerto;
        this.movimientos = movimientos;
    }

    public String getNombre_aeropuerto() {
        return nombre_aeropuerto;
    }

    public void setNombre_aeropuerto(String nombre_aeropuerto) {
        this.nombre_aeropuerto = nombre_aeropuerto;
    }

    public Long getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Long movimientos) {
        this.movimientos = movimientos;
    }
}
