package com.richano.taakmanager;

import java.time.LocalDate;
import java.util.ArrayList;

public class GroteTaak extends Taak {
    private ArrayList<String> opdrachten;

    public GroteTaak(String naam, LocalDate deadline) {
        super(naam, deadline);
        opdrachten = new ArrayList<>();
    }

    @Override
    public String getTaakInfo() {
        String output = "";
        output += "Taak: " + super.getNaam() + "\n\n";
        output += "Opdrachten:" + "\n";

        int opdrachtnr = 0;

        // append elke "mini" opdracht van de taak
        for(String opdracht : opdrachten) {
            opdrachtnr++;
            output += opdrachtnr + ". " + opdracht + "\n";
        }

        // deadline
        output += "Datum tot wanneer dit voltooid kan worden: " +
                        super.getDeadline().toString() + "\n";

        return output;
    }

    public void addOpdracht(String opdracht) {
        opdrachten.add(opdracht);
    }
}
