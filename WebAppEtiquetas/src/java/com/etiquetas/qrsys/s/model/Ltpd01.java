package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Ltpd01 implements java.io.Serializable {

    private int regLtpd;
    private String cveArt;
    private String lote;
    private String pedimento;
    private Integer cveAlm;
    private Date fchcaduc;
    private Date fchaduana;
    private Date fchultmov;
    private String nomAduan;
    private Double cantidad;
    private Integer cveObs;
    private String ciudad;
    private String frontera;
    private Date fecProdLt;
    private String gln;
    private String status;
    private String pedimentosat;

    public Ltpd01() {
    }

    public Ltpd01(int regLtpd, String cveArt) {
        this.regLtpd = regLtpd;
        this.cveArt = cveArt;
    }

    public Ltpd01(int regLtpd, String cveArt, String lote, String pedimento, Integer cveAlm, Date fchcaduc, Date fchaduana, Date fchultmov, String nomAduan, Double cantidad, Integer cveObs, String ciudad, String frontera, Date fecProdLt, String gln, String status, String pedimentosat) {
        this.regLtpd = regLtpd;
        this.cveArt = cveArt;
        this.lote = lote;
        this.pedimento = pedimento;
        this.cveAlm = cveAlm;
        this.fchcaduc = fchcaduc;
        this.fchaduana = fchaduana;
        this.fchultmov = fchultmov;
        this.nomAduan = nomAduan;
        this.cantidad = cantidad;
        this.cveObs = cveObs;
        this.ciudad = ciudad;
        this.frontera = frontera;
        this.fecProdLt = fecProdLt;
        this.gln = gln;
        this.status = status;
        this.pedimentosat = pedimentosat;
    }

    public int getRegLtpd() {
        return this.regLtpd;
    }

    public void setRegLtpd(int regLtpd) {
        this.regLtpd = regLtpd;
    }

    public String getCveArt() {
        return this.cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public String getLote() {
        return this.lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getPedimento() {
        return this.pedimento;
    }

    public void setPedimento(String pedimento) {
        this.pedimento = pedimento;
    }

    public Integer getCveAlm() {
        return this.cveAlm;
    }

    public void setCveAlm(Integer cveAlm) {
        this.cveAlm = cveAlm;
    }

    public Date getFchcaduc() {
        return this.fchcaduc;
    }

    public void setFchcaduc(Date fchcaduc) {
        this.fchcaduc = fchcaduc;
    }

    public Date getFchaduana() {
        return this.fchaduana;
    }

    public void setFchaduana(Date fchaduana) {
        this.fchaduana = fchaduana;
    }

    public Date getFchultmov() {
        return this.fchultmov;
    }

    public void setFchultmov(Date fchultmov) {
        this.fchultmov = fchultmov;
    }

    public String getNomAduan() {
        return this.nomAduan;
    }

    public void setNomAduan(String nomAduan) {
        this.nomAduan = nomAduan;
    }

    public Double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCveObs() {
        return this.cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFrontera() {
        return this.frontera;
    }

    public void setFrontera(String frontera) {
        this.frontera = frontera;
    }

    public Date getFecProdLt() {
        return this.fecProdLt;
    }

    public void setFecProdLt(Date fecProdLt) {
        this.fecProdLt = fecProdLt;
    }

    public String getGln() {
        return this.gln;
    }

    public void setGln(String gln) {
        this.gln = gln;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPedimentosat() {
        return this.pedimentosat;
    }

    public void setPedimentosat(String pedimentosat) {
        this.pedimentosat = pedimentosat;
    }

}
