package com.example.pasztormark_dolgozat;

public class ListViewItem {
    private String cim;
    private String szerzo;
    private int oldalszam;

    public ListViewItem(String cim, String szerzo, int oldalszam) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.oldalszam = oldalszam;
    }

    public String getCim() {
        return cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public int getOldalszam() {
        return oldalszam;
    }
    public void setCim(String cim) {
        this.cim = cim;
    }
    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }
    public void setOldalszam(int oldalszam) {
        this.oldalszam = oldalszam;
    }
}
