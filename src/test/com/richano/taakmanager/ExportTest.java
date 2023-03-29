package com.richano.taakmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class ExportTest {
    @Test
    public void TestExportNaarBestand() throws IOException {
        KleineTaak taakEen =
                new KleineTaak("Opdrukken" , LocalDate.now().plusDays(1), " 50x opdrukken");
        GroteTaak taakTwee =
                new GroteTaak("Gym schema", LocalDate.now().plusDays(1));
        TakenManager takenManager = new TakenManager("Richano");

        taakTwee.addOpdracht("25x dumbells");
        taakTwee.addOpdracht("10x bench-press");
        taakTwee.addOpdracht("25x chin-ups");

        takenManager.addTaak(taakEen);
        takenManager.addTaak(taakTwee);

        takenManager.takenExportService.exportNaarTekstBestand(
                takenManager.getTakenLijst(),
                takenManager.getGebruiker());

        // Verwachte output
        String output = "";
        output += "-------" + "\n";
        output += "Gebruiker: Richano\n";
        output += "-------\n";
        output += "---------\n";
        output += "Taak: Opdrukken\n";
        output += "Opdracht:  50x opdrukken\n";
        output += "Datum tot wanneer dit voltooid kan worden: " +
                LocalDate.now().plusDays(1).toString() + "\n";
        output += "---------\n";
        output += "Taak: Gym schema\n\n";
        output += "Opdrachten:" + "\n";
        output += "1. 25x dumbells\n";
        output += "2. 10x bench-press\n";
        output += "3. 25x chin-ups\n";
        output += "Datum tot wanneer dit voltooid kan worden: " +
                LocalDate.now().plusDays(1).toString() + "\n";
        System.out.println("---Verwachte output:\n" + output);

        // Daadwerkelijke output
        Path filePath = Path.of("src/main/resources/export.txt");
        String realOutput = Files.readString(filePath);
        System.out.println("---Real output:\n" + realOutput);

        // Vergelijk
        Assertions.assertEquals(output, realOutput);
    }
}
