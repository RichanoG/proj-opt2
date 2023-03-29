package com.richano.taakmanager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TakenExport {
    private boolean showIndexNummers;

    public TakenExport(boolean showIndexNummers) {
        this.showIndexNummers = showIndexNummers;
    }

    public void exportNaarConsole(ArrayList<Taak> taken) {
        int index = 0;

        for(Taak taak : taken) {
            index++;

            // laat de index van elke taak zien als erom gevraagd wordt.
            if(showIndexNummers) {
                System.out.println("--------- [taaknr = " + index + "]");
            } else {
                System.out.println("---------");
            }

            // print standaard taak info.
            System.out.println(taak.getTaakInfo());
        }
    }

    public void exportNaarTekstBestand(ArrayList<Taak> taken, Gebruiker gebruiker) throws IOException {
        int index = 0;

        // Open een connectie naar het export tekstbestand
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/export.txt"));

        writer.flush();

        for(Taak taak : taken) {
            index++;

            // laat de index van elke taak zien als erom gevraagd wordt.
            if(showIndexNummers) {

                writer.append("--------- [taaknr = " + index + "]");
            } else {
                writer.append("---------");
            }

            // append standaard taak info.
            writer.append(taak.getTaakInfo());
        }

        // Sluit connectie naar tekstbestand
        writer.close();
    }

    public void setShowIndexNummers(boolean status) {
        this.showIndexNummers = showIndexNummers;
    }

}
