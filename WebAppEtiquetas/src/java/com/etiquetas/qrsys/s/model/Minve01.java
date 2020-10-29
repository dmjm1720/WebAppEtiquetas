package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Minve01 implements java.io.Serializable {

    private String cveArt;
    private int almacen;
    private int numMov;
    private int cveCpto;
    private Date fechaDocu;
    private String tipoDoc;
    private String refer;
    private String claveClpv;
    private String vend;
    private Double cant;
    private Double cantCost;
    private Double precio;
    private Double costo;
    private String afecCoi;
    private Integer cveObs;
    private Integer regSerie;
    private String uniVenta;
    private Integer ELtpd;
    private Double existG;
    private Double existencia;
    private String tipoProd;
    private Double factorCon;
    private Date fechaelab;
    private Integer ctlpol;
    private String cveFolio;
    private Integer signo;
    private String costeado;
    private Double costoPromIni;
    private Double costoPromFin;
    private Double costoPromGral;
    private String desdeInve;
    private Integer movEnlazado;

    public Minve01() {
    }

    public Minve01(String cveArt, int almacen, int numMov, int cveCpto) {
        this.cveArt = cveArt;
        this.almacen = almacen;
        this.numMov = numMov;
        this.cveCpto = cveCpto;
    }

    public Minve01(String cveArt, int almacen, int numMov, int cveCpto, Date fechaDocu, String tipoDoc, String refer, String claveClpv, String vend, Double cant, Double cantCost, Double precio, Double costo, String afecCoi, Integer cveObs, Integer regSerie, String uniVenta, Integer ELtpd, Double existG, Double existencia, String tipoProd, Double factorCon, Date fechaelab, Integer ctlpol, String cveFolio, Integer signo, String costeado, Double costoPromIni, Double costoPromFin, Double costoPromGral, String desdeInve, Integer movEnlazado) {
        this.cveArt = cveArt;
        this.almacen = almacen;
        this.numMov = numMov;
        this.cveCpto = cveCpto;
        this.fechaDocu = fechaDocu;
        this.tipoDoc = tipoDoc;
        this.refer = refer;
        this.claveClpv = claveClpv;
        this.vend = vend;
        this.cant = cant;
        this.cantCost = cantCost;
        this.precio = precio;
        this.costo = costo;
        this.afecCoi = afecCoi;
        this.cveObs = cveObs;
        this.regSerie = regSerie;
        this.uniVenta = uniVenta;
        this.ELtpd = ELtpd;
        this.existG = existG;
        this.existencia = existencia;
        this.tipoProd = tipoProd;
        this.factorCon = factorCon;
        this.fechaelab = fechaelab;
        this.ctlpol = ctlpol;
        this.cveFolio = cveFolio;
        this.signo = signo;
        this.costeado = costeado;
        this.costoPromIni = costoPromIni;
        this.costoPromFin = costoPromFin;
        this.costoPromGral = costoPromGral;
        this.desdeInve = desdeInve;
        this.movEnlazado = movEnlazado;
    }

    public String getCveArt() {
        return this.cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public int getAlmacen() {
        return this.almacen;
    }

    public void setAlmacen(int almacen) {
        this.almacen = almacen;
    }

    public int getNumMov() {
        return this.numMov;
    }

    public void setNumMov(int numMov) {
        this.numMov = numMov;
    }

    public int getCveCpto() {
        return this.cveCpto;
    }

    public void setCveCpto(int cveCpto) {
        this.cveCpto = cveCpto;
    }

    public Date getFechaDocu() {
        return this.fechaDocu;
    }

    public void setFechaDocu(Date fechaDocu) {
        this.fechaDocu = fechaDocu;
    }

    public String getTipoDoc() {
        return this.tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getRefer() {
        return this.refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public String getClaveClpv() {
        return this.claveClpv;
    }

    public void setClaveClpv(String claveClpv) {
        this.claveClpv = claveClpv;
    }

    public String getVend() {
        return this.vend;
    }

    public void setVend(String vend) {
        this.vend = vend;
    }

    public Double getCant() {
        return this.cant;
    }

    public void setCant(Double cant) {
        this.cant = cant;
    }

    public Double getCantCost() {
        return this.cantCost;
    }

    public void setCantCost(Double cantCost) {
        this.cantCost = cantCost;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCosto() {
        return this.costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getAfecCoi() {
        return this.afecCoi;
    }

    public void setAfecCoi(String afecCoi) {
        this.afecCoi = afecCoi;
    }

    public Integer getCveObs() {
        return this.cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }

    public Integer getRegSerie() {
        return this.regSerie;
    }

    public void setRegSerie(Integer regSerie) {
        this.regSerie = regSerie;
    }

    public String getUniVenta() {
        return this.uniVenta;
    }

    public void setUniVenta(String uniVenta) {
        this.uniVenta = uniVenta;
    }

    public Integer getELtpd() {
        return this.ELtpd;
    }

    public void setELtpd(Integer ELtpd) {
        this.ELtpd = ELtpd;
    }

    public Double getExistG() {
        return this.existG;
    }

    public void setExistG(Double existG) {
        this.existG = existG;
    }

    public Double getExistencia() {
        return this.existencia;
    }

    public void setExistencia(Double existencia) {
        this.existencia = existencia;
    }

    public String getTipoProd() {
        return this.tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public Double getFactorCon() {
        return this.factorCon;
    }

    public void setFactorCon(Double factorCon) {
        this.factorCon = factorCon;
    }

    public Date getFechaelab() {
        return this.fechaelab;
    }

    public void setFechaelab(Date fechaelab) {
        this.fechaelab = fechaelab;
    }

    public Integer getCtlpol() {
        return this.ctlpol;
    }

    public void setCtlpol(Integer ctlpol) {
        this.ctlpol = ctlpol;
    }

    public String getCveFolio() {
        return this.cveFolio;
    }

    public void setCveFolio(String cveFolio) {
        this.cveFolio = cveFolio;
    }

    public Integer getSigno() {
        return this.signo;
    }

    public void setSigno(Integer signo) {
        this.signo = signo;
    }

    public String getCosteado() {
        return this.costeado;
    }

    public void setCosteado(String costeado) {
        this.costeado = costeado;
    }

    public Double getCostoPromIni() {
        return this.costoPromIni;
    }

    public void setCostoPromIni(Double costoPromIni) {
        this.costoPromIni = costoPromIni;
    }

    public Double getCostoPromFin() {
        return this.costoPromFin;
    }

    public void setCostoPromFin(Double costoPromFin) {
        this.costoPromFin = costoPromFin;
    }

    public Double getCostoPromGral() {
        return this.costoPromGral;
    }

    public void setCostoPromGral(Double costoPromGral) {
        this.costoPromGral = costoPromGral;
    }

    public String getDesdeInve() {
        return this.desdeInve;
    }

    public void setDesdeInve(String desdeInve) {
        this.desdeInve = desdeInve;
    }

    public Integer getMovEnlazado() {
        return this.movEnlazado;
    }

    public void setMovEnlazado(Integer movEnlazado) {
        this.movEnlazado = movEnlazado;
    }

}
