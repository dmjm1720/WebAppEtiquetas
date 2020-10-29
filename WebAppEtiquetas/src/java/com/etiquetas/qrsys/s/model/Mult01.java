package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Mult01 implements java.io.Serializable {

    private String cveArt;
    private int cveAlm;
    private String status;
    private String ctrlAlm;
    private Double exist;
    private Double stockMin;
    private Double stockMax;
    private Double compXRec;
    private String uuid;
    private Date versionSinc;

    public Mult01() {
    }

    public Mult01(String cveArt) {
        this.cveArt = cveArt;
    }

    public Mult01(String cveArt, int cveAlm, String status, String ctrlAlm, Double exist, Double stockMin, Double stockMax, Double compXRec, String uuid, Date versionSinc) {
        this.cveArt = cveArt;
        this.cveAlm = cveAlm;
        this.status = status;
        this.ctrlAlm = ctrlAlm;
        this.exist = exist;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.compXRec = compXRec;
        this.uuid = uuid;
        this.versionSinc = versionSinc;
    }

    public String getCveArt() {
        return cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public int getCveAlm() {
        return cveAlm;
    }

    public void setCveAlm(int cveAlm) {
        this.cveAlm = cveAlm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCtrlAlm() {
        return ctrlAlm;
    }

    public void setCtrlAlm(String ctrlAlm) {
        this.ctrlAlm = ctrlAlm;
    }

    public Double getExist() {
        return exist;
    }

    public void setExist(Double exist) {
        this.exist = exist;
    }

    public Double getStockMin() {
        return stockMin;
    }

    public void setStockMin(Double stockMin) {
        this.stockMin = stockMin;
    }

    public Double getStockMax() {
        return stockMax;
    }

    public void setStockMax(Double stockMax) {
        this.stockMax = stockMax;
    }

    public Double getCompXRec() {
        return compXRec;
    }

    public void setCompXRec(Double compXRec) {
        this.compXRec = compXRec;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getVersionSinc() {
        return versionSinc;
    }

    public void setVersionSinc(Date versionSinc) {
        this.versionSinc = versionSinc;
    }

}
