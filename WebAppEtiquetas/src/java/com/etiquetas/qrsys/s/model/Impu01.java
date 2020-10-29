package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Impu01 implements java.io.Serializable {

    private int cveEsqimpu;
    private String descripesq;
    private Double impuesto1;
    private Integer imp1aplica;
    private Double impuesto2;
    private Integer imp2aplica;
    private Double impuesto3;
    private Integer imp3aplica;
    private Double impuesto4;
    private Integer imp4aplica;
    private String status;
    private String uuid;
    private Date versionSinc;

    public Impu01() {
    }

    public Impu01(int cveEsqimpu) {
        this.cveEsqimpu = cveEsqimpu;
    }

    public Impu01(int cveEsqimpu, String descripesq, Double impuesto1, Integer imp1aplica, Double impuesto2, Integer imp2aplica, Double impuesto3, Integer imp3aplica, Double impuesto4, Integer imp4aplica, String status, String uuid, Date versionSinc) {
        this.cveEsqimpu = cveEsqimpu;
        this.descripesq = descripesq;
        this.impuesto1 = impuesto1;
        this.imp1aplica = imp1aplica;
        this.impuesto2 = impuesto2;
        this.imp2aplica = imp2aplica;
        this.impuesto3 = impuesto3;
        this.imp3aplica = imp3aplica;
        this.impuesto4 = impuesto4;
        this.imp4aplica = imp4aplica;
        this.status = status;
        this.uuid = uuid;
        this.versionSinc = versionSinc;
    }

    public int getCveEsqimpu() {
        return this.cveEsqimpu;
    }

    public void setCveEsqimpu(int cveEsqimpu) {
        this.cveEsqimpu = cveEsqimpu;
    }

    public String getDescripesq() {
        return this.descripesq;
    }

    public void setDescripesq(String descripesq) {
        this.descripesq = descripesq;
    }

    public Double getImpuesto1() {
        return this.impuesto1;
    }

    public void setImpuesto1(Double impuesto1) {
        this.impuesto1 = impuesto1;
    }

    public Integer getImp1aplica() {
        return this.imp1aplica;
    }

    public void setImp1aplica(Integer imp1aplica) {
        this.imp1aplica = imp1aplica;
    }

    public Double getImpuesto2() {
        return this.impuesto2;
    }

    public void setImpuesto2(Double impuesto2) {
        this.impuesto2 = impuesto2;
    }

    public Integer getImp2aplica() {
        return this.imp2aplica;
    }

    public void setImp2aplica(Integer imp2aplica) {
        this.imp2aplica = imp2aplica;
    }

    public Double getImpuesto3() {
        return this.impuesto3;
    }

    public void setImpuesto3(Double impuesto3) {
        this.impuesto3 = impuesto3;
    }

    public Integer getImp3aplica() {
        return this.imp3aplica;
    }

    public void setImp3aplica(Integer imp3aplica) {
        this.imp3aplica = imp3aplica;
    }

    public Double getImpuesto4() {
        return this.impuesto4;
    }

    public void setImpuesto4(Double impuesto4) {
        this.impuesto4 = impuesto4;
    }

    public Integer getImp4aplica() {
        return this.imp4aplica;
    }

    public void setImp4aplica(Integer imp4aplica) {
        this.imp4aplica = imp4aplica;
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

}
