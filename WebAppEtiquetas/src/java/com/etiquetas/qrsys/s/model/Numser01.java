package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Numser01 implements java.io.Serializable {

    private String cveArt;
    private String numSer;
    private int almacen;
    private String status;
    private Double costo;
    private String doctoEnt;
    private Date fechaEnt;

    public Numser01() {
    }

    public Numser01(String cveArt, String numSer, int almacen) {
        this.cveArt = cveArt;
        this.numSer = numSer;
        this.almacen = almacen;
    }

    public String getCveArt() {
        return cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public String getNumSer() {
        return numSer;
    }

    public void setNumSer(String numSer) {
        this.numSer = numSer;
    }

    public int getAlmacen() {
        return almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getDoctoEnt() {
        return doctoEnt;
    }

    public void setDoctoEnt(String doctoEnt) {
        this.doctoEnt = doctoEnt;
    }

    public Date getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(Date fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

}
