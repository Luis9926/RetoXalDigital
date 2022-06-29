package com.xaldigital.retotecnico.web;
import com.xaldigital.retotecnico.model.stackitems.Item;
import com.xaldigital.retotecnico.model.stackitems.Preguntas;
import com.xaldigital.retotecnico.model.stackresponses.ContestadasYNoResponse;
import com.xaldigital.retotecnico.model.stackresponses.MasViejaMasNueva;
import com.xaldigital.retotecnico.service.PreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@CrossOrigin
@RestController
@RequestMapping("/preguntas")
public class PreguntasController {


    private PreguntasService preguntasService;

    @Autowired
    public PreguntasController(PreguntasService preguntasService) {
        this.preguntasService = preguntasService;
    }

    @GetMapping
    public ResponseEntity<Preguntas> getAllPreguntas() throws IOException {
        return new ResponseEntity<>(preguntasService.ObtenerPreguntas(), HttpStatus.OK);
    }

    @GetMapping("/contestadas-y-nocontestadas")
    public ResponseEntity<ContestadasYNoResponse> getPreguntasContestadasYNoContestadas() throws IOException {
        return new ResponseEntity<>(preguntasService.getPreguntasContestadasYNoContestadas(), HttpStatus.OK);
    }

    @GetMapping("/mayor-rep")
    public ResponseEntity<Item> getPreguntaMayorRep() throws IOException {
        return new ResponseEntity<>(preguntasService.getPreguntaMayorRep(), HttpStatus.OK);
    }

    @GetMapping("/menor-num-vistas")
    public ResponseEntity<Item> getPreguntaMenorCantVistas() throws IOException {
        return new ResponseEntity<>(preguntasService.getPreguntaMenorVistas(), HttpStatus.OK);
    }

    @GetMapping("/vieja-actual")
    public ResponseEntity<MasViejaMasNueva> getMasViejaMasActual() throws IOException {
        return new ResponseEntity<>(preguntasService.getMasViejaMasActual(), HttpStatus.OK);
    }
}

