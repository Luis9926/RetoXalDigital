package com.xaldigital.retotecnico.model.responses;

public class AerolineaResponse {
    private String nombre_aerolinea;
    private Long vuelos;

    public AerolineaResponse(String nombre_aerolinea, Long vuelos) {
        this.nombre_aerolinea = nombre_aerolinea;
        this.vuelos = vuelos;
    }

    public String getNombre_aerolinea() {
        return nombre_aerolinea;
    }

    public void setNombre_aerolinea(String nombre_aerolinea) {
        this.nombre_aerolinea = nombre_aerolinea;
    }

    public Long getVuelos() {
        return vuelos;
    }

    public void setVuelos(Long vuelos) {
        this.vuelos = vuelos;
    }
}
