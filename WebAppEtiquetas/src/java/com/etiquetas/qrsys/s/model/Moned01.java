package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Moned01 implements java.io.Serializable {

    private int numMoned;
    private String descr;
    private String simbolo;
    private Double tcambio;
    private Date fultcamb;
    private String status;
    private String uuid;
    private Date versionSinc;
    private String cveMoned;

    public Moned01() {
    }

    public Moned01(int numMoned) {
        this.numMoned = numMoned;
    }

    public Moned01(int numMoned, String descr, String simbolo, Double tcambio, Date fultcamb, String status, String uuid, Date versionSinc, String cveMoned) {
        this.numMoned = numMoned;
        this.descr = descr;
        this.simbolo = simbolo;
        this.tcambio = tcambio;
        this.fultcamb = fultcamb;
        this.status = status;
        this.uuid = uuid;
        this.versionSinc = versionSinc;
        this.cveMoned = cveMoned;
    }

    public int getNumMoned() {
        return this.numMoned;
    }

    public void setNumMoned(int numMoned) {
        this.numMoned = numMoned;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Double getTcambio() {
        return this.tcambio;
    }

    public void setTcambio(Double tcambio) {
        this.tcambio = tcambio;
    }

    public Date getFultcamb() {
        return this.fultcamb;
    }

    public void setFultcamb(Date fultcamb) {
        this.fultcamb = fultcamb;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getVersionSinc() {
        return this.versionSinc;
    }

    public void setVersionSinc(Date versionSinc) {
        this.versionSinc = versionSinc;
    }

    public String getCveMoned() {
        return this.cveMoned;
    }

    public void setCveMoned(String cveMoned) {
        this.cveMoned = cveMoned;
    }

}
