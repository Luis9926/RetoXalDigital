package com.xaldigital.retotecnico.web;

import com.xaldigital.retotecnico.model.Vuelo;
import com.xaldigital.retotecnico.model.responses.*;
import com.xaldigital.retotecnico.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/vuelos")
public class VueloController {
    private VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> getAllVuelos(){
        return new ResponseEntity<>(vueloService.getAllVuelos(),HttpStatus.OK);
    }

    @GetMapping(path = "/aerolinea-con-mas-de-2-vuelos")
    public ResponseEntity<List<CountAerolineasResponse>> getDia2Vuelos(){
        return new ResponseEntity<>(vueloService.getAerolineasCon2Vuelos(),HttpStatus.OK);
    }

    @GetMapping(path = "/dia-mas-ocupado")
    public ResponseEntity<CountDiaResponse> getDiaConMasVuelos(){
        CountDiaResponse response = vueloService.getDiaConMasVuelos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/vuelos-por-dia")
    public ResponseEntity<List<VuelosDiaResponse>> getVuelosPorDia(){
        return new ResponseEntity<>(vueloService.getVuelosPorDia(),HttpStatus.OK);
    }

    @GetMapping(path = "/aeropuerto-mas-ocupado")
    public ResponseEntity<AeropuertoResponse> getAeropuertoMasVuelos(){
        return new ResponseEntity<>(vueloService.getAeropuertoConMasVuelos().get(0),HttpStatus.OK);
    }

    @GetMapping(path = "/movimientos-por-aeropuerto")
    public ResponseEntity<List<AeropuertoResponse>> movimientosPorAeropuerto(){
        return new ResponseEntity<>(vueloService.getMovimientosPorAeropuerto(),HttpStatus.OK);
    }

    @GetMapping(path = "/aerolinea-mas-ocupada")
    public ResponseEntity<AerolineaResponse> getAerolineaMasOcupada(){
        return new ResponseEntity<>(vueloService.getAerolineaMasOcupada().get(0),HttpStatus.OK);
    }

    @GetMapping(path = "/vuelos-por-aerolinea")
    public ResponseEntity<List<AerolineaResponse>> movimientosPorAerolinea(){
        return new ResponseEntity<>(vueloService.getMovimientosPorAerolinea(),HttpStatus.OK);
    }
}
