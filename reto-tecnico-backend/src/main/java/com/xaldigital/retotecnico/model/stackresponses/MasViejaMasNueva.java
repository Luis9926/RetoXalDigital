package com.xaldigital.retotecnico.model.stackresponses;

import com.xaldigital.retotecnico.model.stackitems.Item;

public class MasViejaMasNueva {
    private Item preguntaNueva;
    private Item preguntaVieja;

    public MasViejaMasNueva(Item preguntaNueva, Item preguntaVieja) {
        this.preguntaNueva = preguntaNueva;
        this.preguntaVieja = preguntaVieja;
    }

    public Item getPreguntaNueva() {
        return preguntaNueva;
    }

    public void setPreguntaNueva(Item preguntaNueva) {
        this.preguntaNueva = preguntaNueva;
    }

    public Item getPreguntaVieja() {
        return preguntaVieja;
    }

    public void setPreguntaVieja(Item preguntaVieja) {
        this.preguntaVieja = preguntaVieja;
    }
}
