package com.xaldigital.retotecnico.repository;

import com.xaldigital.retotecnico.model.Aerolinea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AeropuertoRepository extends CrudRepository<Aerolinea,Long> {
    @Query(value = "SELECT ar.nombre_aeropuerto, COUNT(*) as conteo FROM vuelo as v " +
            "JOIN aeropuerto as ar ON v.id_aeropuerto = ar.id " +
            "GROUP BY v.id_aeropuerto " +
            "ORDER BY conteo DESC LIMIT 1" ,nativeQuery = true)
    List<Object[]> findAeropuertoMasOcupado();

    @Query(value = "SELECT ar.nombre_aeropuerto, COUNT(*) as conteo FROM vuelo as v " +
            "JOIN aeropuerto as ar ON v.id_aeropuerto = ar.id " +
            "GROUP BY v.id_aeropuerto " +
            "ORDER BY conteo DESC" ,nativeQuery = true)
    List<Object[]> MovimientosPorAeropuerto();
}
