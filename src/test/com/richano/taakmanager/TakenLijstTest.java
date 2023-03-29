package com.richano.taakmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class TakenLijstTest {
    @Test
    public void TestRemoveTaakNummer() {
        TakenManager takenManager = new TakenManager("Richano");
        KleineTaak taakEen =
                new KleineTaak("Opdrukken" , LocalDate.now().plusDays(1), " 50x opdrukken");
        KleineTaak taakTwee =
                new KleineTaak("Rusten" , LocalDate.now().plusDays(1), " 10 minuten rusten");
        KleineTaak taakDrie =
                new KleineTaak("Rennen" , LocalDate.now().plusDays(1), " 10 minuten rennen");

        // Voeg 3 taken toe
        takenManager.addTaak(taakEen);
        takenManager.addTaak(taakTwee);
        takenManager.addTaak(taakDrie);

        //Haal 1 taak weg (taken aantal zou nu 2 moeten zijn)
        takenManager.removeTaak(1);

        Assertions.assertEquals(takenManager.getTakenLijst().size(), 2);
    }

    @Test
    public void TestRemoveTaakObject() {
        TakenManager takenManager = new TakenManager("Richano");
        KleineTaak taakEen =
                new KleineTaak("Opdrukken" , LocalDate.now().plusDays(1), " 50x opdrukken");
        KleineTaak taakTwee =
                new KleineTaak("Rusten" , LocalDate.now().plusDays(1), " 10 minuten rusten");
        KleineTaak taakDrie =
                new KleineTaak("Rennen" , LocalDate.now().plusDays(1), " 10 minuten rennen");

        // Voeg 3 taken toe
        takenManager.addTaak(taakEen);
        takenManager.addTaak(taakTwee);
        takenManager.addTaak(taakDrie);

        //Haal 2 taken weg (taken aantal zou nu 1 moeten zijn)
        takenManager.removeTaak(taakEen);
        takenManager.removeTaak(taakTwee);

        Assertions.assertEquals(takenManager.getTakenLijst().size(), 1);
    }

    @Test
    public void TestAddTaak() {
        TakenManager takenManager = new TakenManager("Richano");
        KleineTaak taakEen =
                new KleineTaak("Opdrukken" , LocalDate.now().plusDays(1), " 50x opdrukken");
        KleineTaak taakTwee =
                new KleineTaak("Rusten" , LocalDate.now().plusDays(1), " 10 minuten rusten");
        KleineTaak taakDrie =
                new KleineTaak("Rennen" , LocalDate.now().plusDays(1), " 10 minuten rennen");

        // Voeg 3 taken toe
        takenManager.addTaak(taakEen);
        takenManager.addTaak(taakTwee);
        takenManager.addTaak(taakDrie);

        Assertions.assertEquals(takenManager.getTakenLijst().size(), 3);
    }

    // Takenlijst moet alle 3 "mini" opdracht correct hebben opgeslagen
    @Test void TestGroteOpdrachtMeerdereOpdrachten() {
        GroteTaak taakEen =
                new GroteTaak("Gym schema", LocalDate.now().plusDays(1));
        TakenManager takenManager = new TakenManager("Richano");

        taakEen.addOpdracht("25x dumbells");
        taakEen.addOpdracht("10x bench-press");
        taakEen.addOpdracht("25x chin-ups");

        takenManager.addTaak(taakEen);

        // Verwachte output
        String output = "";
        output += "Taak: Gym schema\n\n";
        output += "Opdrachten:" + "\n";
        output += "1. 25x dumbells\n";
        output += "2. 10x bench-press\n";
        output += "3. 25x chin-ups\n";
        output += "Datum tot wanneer dit voltooid kan worden: " +
                LocalDate.now().plusDays(1).toString() + "\n";
        System.out.println("Verwachte output: \n" + output);

        // Daadwerkelijke output
        String realOutput = takenManager.getTakenLijst().get(0).getTaakInfo();
        System.out.println("Real output: \n" + realOutput);

        // class instance vergelijking
        Assertions.assertTrue(takenManager.getTakenLijst().get(0) instanceof GroteTaak);
        Assertions.assertEquals(output, realOutput);
    }
}
