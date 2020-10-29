package com.etiquetas.qrsys.s.model;

public class Tblcontrol01 implements java.io.Serializable {

    private int idTabla;
    private Integer ultCve;

    public Tblcontrol01() {
    }

    public Tblcontrol01(int idTabla) {
        this.idTabla = idTabla;
    }

    public Tblcontrol01(int idTabla, Integer ultCve) {
        this.idTabla = idTabla;
        this.ultCve = ultCve;
    }

    public int getIdTabla() {
        return this.idTabla;
    }

    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }

    public Integer getUltCve() {
        return this.ultCve;
    }

    public void setUltCve(Integer ultCve) {
        this.ultCve = ultCve;
    }

}
