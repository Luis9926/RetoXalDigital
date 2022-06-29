package com.xaldigital.retotecnico.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long id_aerolinea;
    @Column
    private Long id_aeropuerto;
    @Column
    private Long id_movimiento;
    @Column
    private Date dia;

    public Vuelo(Long id, Long id_aerolinea, Long id_aeropuerto, Long id_movimiento, Date dia) {
        this.id = id;
        this.id_aerolinea = id_aerolinea;
        this.id_aeropuerto = id_aeropuerto;
        this.id_movimiento = id_movimiento;
        this.dia = dia;
    }

    public Vuelo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_aerolinea() {
        return id_aerolinea;
    }

    public void setId_aerolinea(Long id_aerolinea) {
        this.id_aerolinea = id_aerolinea;
    }

    public Long getId_aeropuerto() {
        return id_aeropuerto;
    }

    public void setId_aeropuerto(Long id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }

    public Long getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(Long id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
}
