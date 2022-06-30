package com.xaldigital.retotecnico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xaldigital.retotecnico.model.stackitems.Item;
import com.xaldigital.retotecnico.model.stackitems.Preguntas;
import com.xaldigital.retotecnico.model.stackresponses.ContestadasYNoResponse;
import com.xaldigital.retotecnico.model.stackresponses.MasViejaMasNueva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

@Service
public class PreguntasService {

    URL url = new URL("https://api.stackexchange.com/2.2/search?order=desc&sort=activity&intitle=perl&site=stackoverflow");
    HttpURLConnection conn;
    final Preguntas preguntas;

    @Autowired
    public PreguntasService() throws IOException {
        preguntas = ObtenerPreguntas();
    }

    public ContestadasYNoResponse getPreguntasContestadasYNoContestadas() throws IOException {

        List<Item> contestadas = new ArrayList<>();
        List<Item> noContestadas = new ArrayList<>();
        Preguntas preguntas = this.preguntas;
        preguntas.items.forEach(item -> {
            if(item.answer_count > 0){
                contestadas.add(item);
            }else{
                noContestadas.add(item);
            }
        });
        return new ContestadasYNoResponse((float) contestadas.size(), (float) noContestadas.size());
    }

    public Item getPreguntaMayorRep() throws IOException {
        Preguntas preguntas = this.preguntas;
        return preguntas.items.stream().max((o1, o2) -> o1.owner.reputation > o2.owner.reputation ? 1:-1).get();
    }

    public List<Item> getPreguntasMayorRep() throws IOException {
        Preguntas preguntas = this.preguntas;
        return preguntas.items.stream().sorted((o1, o2) -> o1.owner.reputation > o2.owner.reputation ? -1:1).collect(Collectors.toList()).subList(0,4);
    }

    public Item getPreguntaMenorVistas() throws IOException {
        Preguntas preguntas = this.preguntas;
        return preguntas.items.stream().max((o1, o2) -> o1.view_count > o2.view_count ? -1:1).get();
    }

    public MasViejaMasNueva getMasViejaMasActual() throws IOException{
        Preguntas preguntas = ObtenerPreguntas();
        Item vieja = preguntas.items.stream().max((o1, o2) -> o1.creation_date > o2.creation_date ? -1:1).get();
        Item nueva = preguntas.items.stream().max((o1, o2) -> o1.creation_date > o2.creation_date ? 1:-1).get();
        return new MasViejaMasNueva(nueva,vieja);
    }

    public Preguntas ObtenerPreguntas() throws IOException {
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        InputStream stream = new GZIPInputStream(conn.getInputStream());

        String text = new BufferedReader(
                new InputStreamReader(stream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        return new ObjectMapper().readValue(text, Preguntas.class);
    }


}
