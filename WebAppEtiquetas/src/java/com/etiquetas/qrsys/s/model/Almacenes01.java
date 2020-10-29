package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Almacenes01 implements java.io.Serializable {

    private int cveAlm;
    private String descr;
    private String direccion;
    private String encargado;
    private String telefono;
    private Integer listaPrec;
    private String cuenCont;
    private Integer cveMent;
    private Integer cveMsal;
    private String status;
    private Double lat;
    private Double lon;
    private String uuid;
    private Date versionSinc;

    public Almacenes01() {
    }

    public Almacenes01(int cveAlm) {
        this.cveAlm = cveAlm;
    }

    public Almacenes01(int cveAlm, String descr, String direccion, String encargado, String telefono, Integer listaPrec, String cuenCont, Integer cveMent, Integer cveMsal, String status, Double lat, Double lon, String uuid, Date versionSinc) {
        this.cveAlm = cveAlm;
        this.descr = descr;
        this.direccion = direccion;
        this.encargado = encargado;
        this.telefono = telefono;
        this.listaPrec = listaPrec;
        this.cuenCont = cuenCont;
        this.cveMent = cveMent;
        this.cveMsal = cveMsal;
        this.status = status;
        this.lat = lat;
        this.lon = lon;
        this.uuid = uuid;
        this.versionSinc = versionSinc;
    }

    public int getCveAlm() {
        return this.cveAlm;
    }

    public void setCveAlm(int cveAlm) {
        this.cveAlm = cveAlm;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return this.encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getListaPrec() {
        return this.listaPrec;
    }

    public void setListaPrec(Integer listaPrec) {
        this.listaPrec = listaPrec;
    }

    public String getCuenCont() {
        return this.cuenCont;
    }

    public void setCuenCont(String cuenCont) {
        this.cuenCont = cuenCont;
    }

    public Integer getCveMent() {
        return this.cveMent;
    }

    public void setCveMent(Integer cveMent) {
        this.cveMent = cveMent;
    }

    public Integer getCveMsal() {
        return this.cveMsal;
    }

    public void setCveMsal(Integer cveMsal) {
        this.cveMsal = cveMsal;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getLat() {
        return this.lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return this.lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
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

}
