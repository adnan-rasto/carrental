package com.zbw.carrental.entities;

public class Kunde {

    private int kundenID;
    private String vorname;
    private String nachname;
    private String adresse;
    private int postleitzahl;
    private String wohnort;

    public Kunde(){
        super();
    }

    public Kunde(int kundenID, String vorname, String nachname, String adresse, int postleitzahl, String wohnort) {
        this.kundenID = kundenID;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.postleitzahl = postleitzahl;
        this.wohnort = wohnort;
    }

    public int getKundenID() {
        return kundenID;
    }

    public void setKundenID(int kundenID) {
        this.kundenID = kundenID;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }
}
