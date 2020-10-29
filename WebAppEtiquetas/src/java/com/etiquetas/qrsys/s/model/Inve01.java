package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Inve01 implements java.io.Serializable {

    private String cveArt;
    private String descr;
    private String linProd;
    private String conSerie;
    private String uniMed;
    private Double uniEmp;
    private String ctrlAlm;
    private Integer tiemSurt;
    private Double stockMin;
    private Double stockMax;
    private String tipCosteo;
    private Integer numMon;
    private Date fchUltcom;
    private Double compXRec;
    private Date fchUltvta;
    private Double pendSurt;
    private Double exist;
    private Double costoProm;
    private Double ultCosto;
    private Integer cveObs;
    private String tipoEle;
    private String uniAlt;
    private Double facConv;
    private Double apart;
    private String conLote;
    private String conPedimento;
    private Double peso;
    private Double volumen;
    private Integer cveEsqimpu;
    private Integer cveBita;
    private Double vtasAnlC;
    private Double vtasAnlM;
    private Double compAnlC;
    private Double compAnlM;
    private String prefijo;
    private String talla;
    private String color;
    private String cuentCont;
    private String cveImagen;
    private String blkCstExt;
    private String status;
    private String manIeps;
    private Integer aplManImp;
    private Double cuotaIeps;
    private String aplManIeps;
    private String uuid;
    private Date versionSinc;
    private Date versionSincFechaImg;
    private String cveProdserv;
    private String cveUnidad;

    public Inve01() {
    }

    public Inve01(String cveArt) {
        this.cveArt = cveArt;
    }

    public Inve01(String cveArt, String descr, String linProd, String conSerie, String uniMed, Double uniEmp, String ctrlAlm, Integer tiemSurt, Double stockMin, Double stockMax, String tipCosteo, Integer numMon, Date fchUltcom, Double compXRec, Date fchUltvta, Double pendSurt, Double exist, Double costoProm, Double ultCosto, Integer cveObs, String tipoEle, String uniAlt, Double facConv, Double apart, String conLote, String conPedimento, Double peso, Double volumen, Integer cveEsqimpu, Integer cveBita, Double vtasAnlC, Double vtasAnlM, Double compAnlC, Double compAnlM, String prefijo, String talla, String color, String cuentCont, String cveImagen, String blkCstExt, String status, String manIeps, Integer aplManImp, Double cuotaIeps, String aplManIeps, String uuid, Date versionSinc, Date versionSincFechaImg, String cveProdserv, String cveUnidad) {
        this.cveArt = cveArt;
        this.descr = descr;
        this.linProd = linProd;
        this.conSerie = conSerie;
        this.uniMed = uniMed;
        this.uniEmp = uniEmp;
        this.ctrlAlm = ctrlAlm;
        this.tiemSurt = tiemSurt;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.tipCosteo = tipCosteo;
        this.numMon = numMon;
        this.fchUltcom = fchUltcom;
        this.compXRec = compXRec;
        this.fchUltvta = fchUltvta;
        this.pendSurt = pendSurt;
        this.exist = exist;
        this.costoProm = costoProm;
        this.ultCosto = ultCosto;
        this.cveObs = cveObs;
        this.tipoEle = tipoEle;
        this.uniAlt = uniAlt;
        this.facConv = facConv;
        this.apart = apart;
        this.conLote = conLote;
        this.conPedimento = conPedimento;
        this.peso = peso;
        this.volumen = volumen;
        this.cveEsqimpu = cveEsqimpu;
        this.cveBita = cveBita;
        this.vtasAnlC = vtasAnlC;
        this.vtasAnlM = vtasAnlM;
        this.compAnlC = compAnlC;
        this.compAnlM = compAnlM;
        this.prefijo = prefijo;
        this.talla = talla;
        this.color = color;
        this.cuentCont = cuentCont;
        this.cveImagen = cveImagen;
        this.blkCstExt = blkCstExt;
        this.status = status;
        this.manIeps = manIeps;
        this.aplManImp = aplManImp;
        this.cuotaIeps = cuotaIeps;
        this.aplManIeps = aplManIeps;
        this.uuid = uuid;
        this.versionSinc = versionSinc;
        this.versionSincFechaImg = versionSincFechaImg;
        this.cveProdserv = cveProdserv;
        this.cveUnidad = cveUnidad;
    }

    public String getCveArt() {
        return this.cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getLinProd() {
        return this.linProd;
    }

    public void setLinProd(String linProd) {
        this.linProd = linProd;
    }

    public String getConSerie() {
        return this.conSerie;
    }

    public void setConSerie(String conSerie) {
        this.conSerie = conSerie;
    }

    public String getUniMed() {
        return this.uniMed;
    }

    public void setUniMed(String uniMed) {
        this.uniMed = uniMed;
    }

    public Double getUniEmp() {
        return this.uniEmp;
    }

    public void setUniEmp(Double uniEmp) {
        this.uniEmp = uniEmp;
    }

    public String getCtrlAlm() {
        return this.ctrlAlm;
    }

    public void setCtrlAlm(String ctrlAlm) {
        this.ctrlAlm = ctrlAlm;
    }

    public Integer getTiemSurt() {
        return this.tiemSurt;
    }

    public void setTiemSurt(Integer tiemSurt) {
        this.tiemSurt = tiemSurt;
    }

    public Double getStockMin() {
        return this.stockMin;
    }

    public void setStockMin(Double stockMin) {
        this.stockMin = stockMin;
    }

    public Double getStockMax() {
        return this.stockMax;
    }

    public void setStockMax(Double stockMax) {
        this.stockMax = stockMax;
    }

    public String getTipCosteo() {
        return this.tipCosteo;
    }

    public void setTipCosteo(String tipCosteo) {
        this.tipCosteo = tipCosteo;
    }

    public Integer getNumMon() {
        return this.numMon;
    }

    public void setNumMon(Integer numMon) {
        this.numMon = numMon;
    }

    public Date getFchUltcom() {
        return this.fchUltcom;
    }

    public void setFchUltcom(Date fchUltcom) {
        this.fchUltcom = fchUltcom;
    }

    public Double getCompXRec() {
        return this.compXRec;
    }

    public void setCompXRec(Double compXRec) {
        this.compXRec = compXRec;
    }

    public Date getFchUltvta() {
        return this.fchUltvta;
    }

    public void setFchUltvta(Date fchUltvta) {
        this.fchUltvta = fchUltvta;
    }

    public Double getPendSurt() {
        return this.pendSurt;
    }

    public void setPendSurt(Double pendSurt) {
        this.pendSurt = pendSurt;
    }

    public Double getExist() {
        return this.exist;
    }

    public void setExist(Double exist) {
        this.exist = exist;
    }

    public Double getCostoProm() {
        return this.costoProm;
    }

    public void setCostoProm(Double costoProm) {
        this.costoProm = costoProm;
    }

    public Double getUltCosto() {
        return this.ultCosto;
    }

    public void setUltCosto(Double ultCosto) {
        this.ultCosto = ultCosto;
    }

    public Integer getCveObs() {
        return this.cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }

    public String getTipoEle() {
        return this.tipoEle;
    }

    public void setTipoEle(String tipoEle) {
        this.tipoEle = tipoEle;
    }

    public String getUniAlt() {
        return this.uniAlt;
    }

    public void setUniAlt(String uniAlt) {
        this.uniAlt = uniAlt;
    }

    public Double getFacConv() {
        return this.facConv;
    }

    public void setFacConv(Double facConv) {
        this.facConv = facConv;
    }

    public Double getApart() {
        return this.apart;
    }

    public void setApart(Double apart) {
        this.apart = apart;
    }

    public String getConLote() {
        return this.conLote;
    }

    public void setConLote(String conLote) {
        this.conLote = conLote;
    }

    public String getConPedimento() {
        return this.conPedimento;
    }

    public void setConPedimento(String conPedimento) {
        this.conPedimento = conPedimento;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getVolumen() {
        return this.volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public Integer getCveEsqimpu() {
        return this.cveEsqimpu;
    }

    public void setCveEsqimpu(Integer cveEsqimpu) {
        this.cveEsqimpu = cveEsqimpu;
    }

    public Integer getCveBita() {
        return this.cveBita;
    }

    public void setCveBita(Integer cveBita) {
        this.cveBita = cveBita;
    }

    public Double getVtasAnlC() {
        return this.vtasAnlC;
    }

    public void setVtasAnlC(Double vtasAnlC) {
        this.vtasAnlC = vtasAnlC;
    }

    public Double getVtasAnlM() {
        return this.vtasAnlM;
    }

    public void setVtasAnlM(Double vtasAnlM) {
        this.vtasAnlM = vtasAnlM;
    }

    public Double getCompAnlC() {
        return this.compAnlC;
    }

    public void setCompAnlC(Double compAnlC) {
        this.compAnlC = compAnlC;
    }

    public Double getCompAnlM() {
        return this.compAnlM;
    }

    public void setCompAnlM(Double compAnlM) {
        this.compAnlM = compAnlM;
    }

    public String getPrefijo() {
        return this.prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getTalla() {
        return this.talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCuentCont() {
        return this.cuentCont;
    }

    public void setCuentCont(String cuentCont) {
        this.cuentCont = cuentCont;
    }

    public String getCveImagen() {
        return this.cveImagen;
    }

    public void setCveImagen(String cveImagen) {
        this.cveImagen = cveImagen;
    }

    public String getBlkCstExt() {
        return this.blkCstExt;
    }

    public void setBlkCstExt(String blkCstExt) {
        this.blkCstExt = blkCstExt;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManIeps() {
        return this.manIeps;
    }

    public void setManIeps(String manIeps) {
        this.manIeps = manIeps;
    }

    public Integer getAplManImp() {
        return this.aplManImp;
    }

    public void setAplManImp(Integer aplManImp) {
        this.aplManImp = aplManImp;
    }

    public Double getCuotaIeps() {
        return this.cuotaIeps;
    }

    public void setCuotaIeps(Double cuotaIeps) {
        this.cuotaIeps = cuotaIeps;
    }

    public String getAplManIeps() {
        return this.aplManIeps;
    }

    public void setAplManIeps(String aplManIeps) {
        this.aplManIeps = aplManIeps;
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

    public Date getVersionSincFechaImg() {
        return this.versionSincFechaImg;
    }

    public void setVersionSincFechaImg(Date versionSincFechaImg) {
        this.versionSincFechaImg = versionSincFechaImg;
    }

    public String getCveProdserv() {
        return this.cveProdserv;
    }

    public void setCveProdserv(String cveProdserv) {
        this.cveProdserv = cveProdserv;
    }

    public String getCveUnidad() {
        return this.cveUnidad;
    }

    public void setCveUnidad(String cveUnidad) {
        this.cveUnidad = cveUnidad;
    }

}
