package com.xaldigital.retotecnico.repository;

import com.xaldigital.retotecnico.model.Aerolinea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AerolineaRepository extends CrudRepository<Aerolinea,Long> {
    @Query(value = "SELECT al.id,al.nombre_aerolinea, COUNT(*) as conteo FROM vuelo as v " +
            "JOIN aerolinea as al ON v.id_aerolinea = al.id " +
            "WHERE v.id_movimiento = 1 "+
            "GROUP BY v.id_aerolinea " +
            "HAVING conteo > 2",nativeQuery = true)
    List<Object[]> findAerolineasConMas2Vuelos();


    @Query(value = "SELECT al.nombre_aerolinea, COUNT(*) as conteo FROM vuelo as v " +
            "JOIN aerolinea as al ON v.id_aerolinea = al.id " +
            "WHERE v.id_movimiento = 1 " +
            "GROUP BY v.id_aerolinea " +
            "ORDER BY conteo DESC LIMIT 1;",nativeQuery = true)
    List<Object[]> findAerolineaMasOcupada();

    @Query(value = "SELECT al.nombre_aerolinea, COUNT(*) as conteo FROM vuelo as v " +
            "JOIN aerolinea as al ON v.id_aerolinea = al.id " +
            "WHERE v.id_movimiento = 1 " +
            "GROUP BY v.id_aerolinea " +
            "ORDER BY conteo DESC;",nativeQuery = true)
    List<Object[]> MovimientosPorAerolinea();

}
