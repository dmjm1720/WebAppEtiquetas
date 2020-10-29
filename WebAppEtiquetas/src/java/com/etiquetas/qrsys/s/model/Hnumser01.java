package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Hnumser01 implements java.io.Serializable {

    private String cveArt;
    private String numSer;
    private Integer tipMov;
    private String tipDoc;
    private String cveDoc;
    private int almacen;
    private Integer regSerie;
    private Date fecha;
    private String status;
    private Integer noPar;

    public Hnumser01() {
    }

    public Hnumser01(String cveArt, String numSer, int almacen) {
        this.cveArt = cveArt;
        this.numSer = numSer;
        this.almacen = almacen;
    }

    public Hnumser01(String cveArt, String numSer, Integer tipMov, String tipDoc, String cveDoc, int almacen, Integer regSerie, Date fecha, String status, Integer noPar) {
        this.cveArt = cveArt;
        this.numSer = numSer;
        this.tipMov = tipMov;
        this.tipDoc = tipDoc;
        this.cveDoc = cveDoc;
        this.almacen = almacen;
        this.regSerie = regSerie;
        this.fecha = fecha;
        this.status = status;
        this.noPar = noPar;
    }

    public String getCveArt() {
        return this.cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public String getNumSer() {
        return this.numSer;
    }

    public void setNumSer(String numSer) {
        this.numSer = numSer;
    }

    public Integer getTipMov() {
        return this.tipMov;
    }

    public void setTipMov(Integer tipMov) {
        this.tipMov = tipMov;
    }

    public String getTipDoc() {
        return this.tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getCveDoc() {
        return this.cveDoc;
    }

    public void setCveDoc(String cveDoc) {
        this.cveDoc = cveDoc;
    }

    public int getAlmacen() {
        return this.almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public Integer getRegSerie() {
        return this.regSerie;
    }

    public void setRegSerie(Integer regSerie) {
        this.regSerie = regSerie;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNoPar() {
        return this.noPar;
    }

    public void setNoPar(Integer noPar) {
        this.noPar = noPar;
    }

}
