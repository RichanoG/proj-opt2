package com.richano.taakmanager;

public class Gebruiker {
    private String naam;

    public Gebruiker(String naam) {
        this.naam = naam;
    }

    public String getGebruikerInformatie() {
        String output = "";
        output += "-------" + "\n";
        output += "Gebruiker: " + naam + "\n";
        output += "-------\n";

        return output;
    }
}
