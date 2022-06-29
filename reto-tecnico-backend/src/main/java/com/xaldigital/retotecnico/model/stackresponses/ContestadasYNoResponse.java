package com.xaldigital.retotecnico.model.stackresponses;

public class ContestadasYNoResponse {
    private Float contestadas;
    private Float noContestadas;

    public ContestadasYNoResponse(Float contestadas, Float noContestadas) {
        this.contestadas = contestadas;
        this.noContestadas = noContestadas;
    }

    public Float getContestadas() {
        return contestadas;
    }

    public void setContestadas(Float contestadas) {
        this.contestadas = contestadas;
    }

    public Float getNoContestadas() {
        return noContestadas;
    }

    public void setNoContestadas(Float noContestadas) {
        this.noContestadas = noContestadas;
    }
}
