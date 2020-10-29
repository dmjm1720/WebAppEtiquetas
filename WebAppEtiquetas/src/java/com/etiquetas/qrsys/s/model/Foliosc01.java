package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Foliosc01 implements java.io.Serializable {

    private String tipDoc;
    private String serie;
    private int foliodesde;
    private Integer foliohasta;
    private Integer ultDoc;
    private Date fechUltDoc;
    private String status;

    public Foliosc01() {
    }

    public Foliosc01(String tipDoc, String serie, int foliodesde, Integer foliohasta, Integer ultDoc, Date fechUltDoc, String status) {
        this.tipDoc = tipDoc;
        this.serie = serie;
        this.foliodesde = foliodesde;
        this.foliohasta = foliohasta;
        this.ultDoc = ultDoc;
        this.fechUltDoc = fechUltDoc;
        this.status = status;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getFoliodesde() {
        return foliodesde;
    }

    public void setFoliodesde(int foliodesde) {
        this.foliodesde = foliodesde;
    }

    public Integer getFoliohasta() {
        return foliohasta;
    }

    public void setFoliohasta(Integer foliohasta) {
        this.foliohasta = foliohasta;
    }

    public Integer getUltDoc() {
        return ultDoc;
    }

    public void setUltDoc(Integer ultDoc) {
        this.ultDoc = ultDoc;
    }

    public Date getFechUltDoc() {
        return fechUltDoc;
    }

    public void setFechUltDoc(Date fechUltDoc) {
        this.fechUltDoc = fechUltDoc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
