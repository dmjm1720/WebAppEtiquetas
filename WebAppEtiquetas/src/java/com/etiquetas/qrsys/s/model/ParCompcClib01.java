package com.etiquetas.qrsys.s.model;

public class ParCompcClib01 implements java.io.Serializable {

    private String claveDoc;
    private int numPart;

    public ParCompcClib01() {
    }

    public ParCompcClib01(String claveDoc, int numPart) {
        this.claveDoc = claveDoc;
        this.numPart = numPart;
    }

    public String getClaveDoc() {
        return this.claveDoc;
    }

    public void setClaveDoc(String claveDoc) {
        this.claveDoc = claveDoc;
    }

    public int getNumPart() {
        return this.numPart;
    }

    public void setNumPart(int numPart) {
        this.numPart = numPart;
    }

}
