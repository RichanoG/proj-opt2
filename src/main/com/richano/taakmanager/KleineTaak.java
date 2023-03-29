package com.richano.taakmanager;

import java.time.LocalDate;

public class KleineTaak extends Taak {
    private String opdracht;

    public KleineTaak(String naam, LocalDate deadline, String opdracht) {
        super(naam, deadline);
        this.opdracht = opdracht;
    }

    @Override
    public String getTaakInfo() {
        String output = "";
        output += "Taak: " + super.getNaam() + "\n";

        // de opdracht van deze taak
        output += "Opdracht: " + opdracht + "\n";

        // de deadline
        output += "Datum tot wanneer dit voltooid kan worden: " + super.getDeadline().toString() + "\n";

        return output;
    }
}
