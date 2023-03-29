package com.richano.taakmanager;

import java.time.LocalDate;

public abstract class Taak {
    private String naam;
    private LocalDate deadline;
    private boolean voltooid;

    public Taak(String naam, LocalDate deadline) {
        this.naam = naam;
        this.deadline = deadline;
    }

    abstract public String getTaakInfo();

    public String getNaam() {
        return naam;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean getVoltooid() {
        return voltooid;
    }

    public void setVoltooid() {
        voltooid = true;
    }
}
