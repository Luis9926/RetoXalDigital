package com.xaldigital.retotecnico.model.responses;

import java.sql.Date;

public class VuelosDiaResponse {
    private Date dia;
    private Long vuelos;

    public VuelosDiaResponse(Date dia, Long vuelos) {
        this.dia = dia;
        this.vuelos = vuelos;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Long getVuelos() {
        return vuelos;
    }

    public void setVuelos(Long vuelos) {
        this.vuelos = vuelos;
    }
}
