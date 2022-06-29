package com.xaldigital.retotecnico.model.responses;

import java.sql.Date;

public class CountDiaResponse {

        private Date dia;
        private Long cantidad;
        private Long total;


    public CountDiaResponse(Date dia, Long cantidad, Long total) {
            this.dia = dia;
            this.cantidad = cantidad;
            this.total = total;
        }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
