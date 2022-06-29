package com.xaldigital.retotecnico.model.responses;


public class CountAerolineasResponse {

    private Long id;
    private String nombre_aerolinea;
    private Long movimientos;

    public CountAerolineasResponse(Long id, String nombre_aerolinea, Long movimientos) {
        this.id = id;
        this.nombre_aerolinea = nombre_aerolinea;
        this.movimientos = movimientos;
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

    public Long getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Long movimientos) {
        this.movimientos = movimientos;
    }
}
