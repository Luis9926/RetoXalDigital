package com.xaldigital.retotecnico.service;

import com.xaldigital.retotecnico.model.Vuelo;
import com.xaldigital.retotecnico.model.responses.*;
import com.xaldigital.retotecnico.repository.AerolineaRepository;
import com.xaldigital.retotecnico.repository.AeropuertoRepository;
import com.xaldigital.retotecnico.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VueloService {

    private VueloRepository vueloRepository;
    private AerolineaRepository aerolineaRepository;
    private AeropuertoRepository aeropuertoRepository;
    Iterable<Vuelo> vuelos;

    @Autowired
    public VueloService(VueloRepository vueloRepository,AerolineaRepository aerolineaRepository,
                        AeropuertoRepository aeropuertoRepository) {
        this.vueloRepository = vueloRepository;
        this.aerolineaRepository = aerolineaRepository;
        this.aeropuertoRepository = aeropuertoRepository;
        vuelos = this.vueloRepository.findAll();
    }

    public List<Vuelo> getAllVuelos(){
        List<Vuelo> vuelos = new ArrayList<>();
        this.vuelos.iterator().forEachRemaining(vuelos::add);
        return vuelos;
    }

    public List<CountAerolineasResponse> getAerolineasCon2Vuelos(){
        List<CountAerolineasResponse> responses = new ArrayList<>();
        aerolineaRepository.findAerolineasConMas2Vuelos().forEach(objects -> {
            responses.add(new CountAerolineasResponse( Long.valueOf(objects[0].toString()), (String) objects[1], Long.valueOf(objects[2].toString())));
        } );
        return responses;
    }

    public List<AerolineaResponse> getAerolineaMasOcupada(){
        List<AerolineaResponse> responses = new ArrayList<>();
        aerolineaRepository.findAerolineaMasOcupada().forEach(objects -> {
            responses.add(new AerolineaResponse((String)objects[0],Long.valueOf(objects[1].toString())));
        });
        return responses;
    }

    public List<AerolineaResponse> getMovimientosPorAerolinea(){
        List<AerolineaResponse> responses = new ArrayList<>();
        aerolineaRepository.MovimientosPorAerolinea().forEach(objects -> {
            responses.add(new AerolineaResponse((String)objects[0],Long.valueOf(objects[1].toString())));
        });
        return responses;
    }

    public List<AeropuertoResponse> getAeropuertoConMasVuelos(){
        List<AeropuertoResponse> responses = new ArrayList<>();
        aeropuertoRepository.findAeropuertoMasOcupado().forEach(objects -> {
            responses.add(new AeropuertoResponse((String) objects[0],Long.valueOf(objects[1].toString())));
        });
        return responses;
    }

    public List<AeropuertoResponse> getMovimientosPorAeropuerto(){
        List<AeropuertoResponse> responses = new ArrayList<>();
        aeropuertoRepository.MovimientosPorAeropuerto().forEach(objects -> {
            responses.add(new AeropuertoResponse((String) objects[0],Long.valueOf(objects[1].toString())));
        });
        return responses;
    }

    public CountDiaResponse getDiaConMasVuelos(){
        List<Date> vuelosDate = new ArrayList<>();
        vuelos.forEach((vuelo -> {
            vuelosDate.add(vuelo.getDia());
        }));
        Map<Date, Long> conteo =
                vuelosDate.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Date dia = conteo.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        return new CountDiaResponse(dia,conteo.get(dia),vuelosDate.stream().count());
    }

    public List<VuelosDiaResponse> getVuelosPorDia(){
        List<Date> vuelosDate = new ArrayList<>();
        vuelos.forEach((vuelo -> {
            vuelosDate.add(vuelo.getDia());
        }));
        Map<Date, Long> conteo =
                vuelosDate.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        List<VuelosDiaResponse> listaDias = new ArrayList<>();
        conteo.entrySet().forEach(dateLongEntry -> {
            listaDias.add(new VuelosDiaResponse(dateLongEntry.getKey(),dateLongEntry.getValue()));
        });

        return listaDias;

    }
}



