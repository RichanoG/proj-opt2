package com.richano.taakmanager;

import java.util.ArrayList;

public class TakenManager {
    private ArrayList<Taak> takenLijst;
    public TakenExport takenExportService;
    private Gebruiker gebruiker;

    public TakenManager(String gebruiker) {
        takenLijst = new ArrayList<>();
        takenExportService = new TakenExport(false);
        this.gebruiker = new Gebruiker(gebruiker);
    }

    public void addTaak(Taak taak) {
        takenLijst.add(taak);
    }

    public void removeTaak(Taak taak) {
        takenLijst.remove(taak);
    }

    public void removeTaak(int taaknr) {
        int index = taaknr - 1;

        if (index >= 0 && index < takenLijst.size()) {
            takenLijst.remove(taaknr - 1);
        } else {
            throw new RuntimeException("Deze taak bestaat niet. (taaknr = " + taaknr + ")");
        }
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public ArrayList<Taak> getTakenLijst() {
        return takenLijst;
    }
}
