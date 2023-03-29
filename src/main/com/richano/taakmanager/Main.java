package com.richano.taakmanager;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        KleineTaak taakEen =
                new KleineTaak("Vuilnis" , LocalDate.now().plusDays(7), "Vuilnis weggooien");

        GroteTaak taakTwee =
                new GroteTaak("Afwas", LocalDate.now().plusDays(1));

        taakTwee.addOpdracht("Borden wassen");
        taakTwee.addOpdracht("Bestek wassen");
        taakTwee.addOpdracht("Glazen wassen");

        TakenManager takenManager = new TakenManager("Richano");

        takenManager.addTaak(taakEen);
        takenManager.addTaak(taakTwee);

        takenManager.takenExportService.exportNaarConsole(takenManager.getTakenLijst());
        takenManager.takenExportService.exportNaarTekstBestand(
                takenManager.getTakenLijst(),
                takenManager.getGebruiker());

    }
}
