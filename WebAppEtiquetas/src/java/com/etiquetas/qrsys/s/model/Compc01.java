package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Compc01 implements java.io.Serializable {

    private String cveDoc;
    private String tipDoc;
    private String cveClpv;
    private String status;
    private String suRefer;
    private Date fechaDoc;
    private Date fechaRec;
    private Date fechaPag;
    private Date fechaCancela;
    private Double canTot;
    private Double impTot1;
    private Double impTot2;
    private Double impTot3;
    private Double impTot4;
    private Double desTot;
    private Double desFin;
    private Double totInd;
    private String obsCond;
    private Integer cveObs;
    private Integer numAlma;
    private String actCxp;
    private String actCoi;
    private String enlazado;
    private String tipDocE;
    private Integer numMoned;
    private Double tipcamb;
    private Integer numPagos;
    private Date fechaelab;
    private String serie;
    private Integer folio;
    private Integer ctlpol;
    private String escfd;
    private String contado;
    private String bloq;
    private Double desFinPorc;
    private Double desTotPorc;
    private Double importe;
    private String tipDocAnt;
    private String docAnt;
    private String tipDocSig;
    private String docSig;
    private String formaenvio;

    public Compc01() {
    }

    public Compc01(String cveDoc, String cveClpv, String status, Date fechaDoc) {
        this.cveDoc = cveDoc;
        this.cveClpv = cveClpv;
        this.status = status;
        this.fechaDoc = fechaDoc;
    }

    public Compc01(String cveDoc, String tipDoc, String cveClpv, String status, String suRefer, Date fechaDoc, Date fechaRec, Date fechaPag, Date fechaCancela, Double canTot, Double impTot1, Double impTot2, Double impTot3, Double impTot4, Double desTot, Double desFin, Double totInd, String obsCond, Integer cveObs, Integer numAlma, String actCxp, String actCoi, String enlazado, String tipDocE, Integer numMoned, Double tipcamb, Integer numPagos, Date fechaelab, String serie, Integer folio, Integer ctlpol, String escfd, String contado, String bloq, Double desFinPorc, Double desTotPorc, Double importe, String tipDocAnt, String docAnt, String tipDocSig, String docSig, String formaenvio) {
        this.cveDoc = cveDoc;
        this.tipDoc = tipDoc;
        this.cveClpv = cveClpv;
        this.status = status;
        this.suRefer = suRefer;
        this.fechaDoc = fechaDoc;
        this.fechaRec = fechaRec;
        this.fechaPag = fechaPag;
        this.fechaCancela = fechaCancela;
        this.canTot = canTot;
        this.impTot1 = impTot1;
        this.impTot2 = impTot2;
        this.impTot3 = impTot3;
        this.impTot4 = impTot4;
        this.desTot = desTot;
        this.desFin = desFin;
        this.totInd = totInd;
        this.obsCond = obsCond;
        this.cveObs = cveObs;
        this.numAlma = numAlma;
        this.actCxp = actCxp;
        this.actCoi = actCoi;
        this.enlazado = enlazado;
        this.tipDocE = tipDocE;
        this.numMoned = numMoned;
        this.tipcamb = tipcamb;
        this.numPagos = numPagos;
        this.fechaelab = fechaelab;
        this.serie = serie;
        this.folio = folio;
        this.ctlpol = ctlpol;
        this.escfd = escfd;
        this.contado = contado;
        this.bloq = bloq;
        this.desFinPorc = desFinPorc;
        this.desTotPorc = desTotPorc;
        this.importe = importe;
        this.tipDocAnt = tipDocAnt;
        this.docAnt = docAnt;
        this.tipDocSig = tipDocSig;
        this.docSig = docSig;
        this.formaenvio = formaenvio;
    }

    public String getCveDoc() {
        return this.cveDoc;
    }

    public void setCveDoc(String cveDoc) {
        this.cveDoc = cveDoc;
    }

    public String getTipDoc() {
        return this.tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getCveClpv() {
        return this.cveClpv;
    }

    public void setCveClpv(String cveClpv) {
        this.cveClpv = cveClpv;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSuRefer() {
        return this.suRefer;
    }

    public void setSuRefer(String suRefer) {
        this.suRefer = suRefer;
    }

    public Date getFechaDoc() {
        return this.fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public Date getFechaRec() {
        return this.fechaRec;
    }

    public void setFechaRec(Date fechaRec) {
        this.fechaRec = fechaRec;
    }

    public Date getFechaPag() {
        return this.fechaPag;
    }

    public void setFechaPag(Date fechaPag) {
        this.fechaPag = fechaPag;
    }

    public Date getFechaCancela() {
        return this.fechaCancela;
    }

    public void setFechaCancela(Date fechaCancela) {
        this.fechaCancela = fechaCancela;
    }

    public Double getCanTot() {
        return this.canTot;
    }

    public void setCanTot(Double canTot) {
        this.canTot = canTot;
    }

    public Double getImpTot1() {
        return this.impTot1;
    }

    public void setImpTot1(Double impTot1) {
        this.impTot1 = impTot1;
    }

    public Double getImpTot2() {
        return this.impTot2;
    }

    public void setImpTot2(Double impTot2) {
        this.impTot2 = impTot2;
    }

    public Double getImpTot3() {
        return this.impTot3;
    }

    public void setImpTot3(Double impTot3) {
        this.impTot3 = impTot3;
    }

    public Double getImpTot4() {
        return this.impTot4;
    }

    public void setImpTot4(Double impTot4) {
        this.impTot4 = impTot4;
    }

    public Double getDesTot() {
        return this.desTot;
    }

    public void setDesTot(Double desTot) {
        this.desTot = desTot;
    }

    public Double getDesFin() {
        return this.desFin;
    }

    public void setDesFin(Double desFin) {
        this.desFin = desFin;
    }

    public Double getTotInd() {
        return this.totInd;
    }

    public void setTotInd(Double totInd) {
        this.totInd = totInd;
    }

    public String getObsCond() {
        return this.obsCond;
    }

    public void setObsCond(String obsCond) {
        this.obsCond = obsCond;
    }

    public Integer getCveObs() {
        return this.cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }

    public Integer getNumAlma() {
        return this.numAlma;
    }

    public void setNumAlma(Integer numAlma) {
        this.numAlma = numAlma;
    }

    public String getActCxp() {
        return this.actCxp;
    }

    public void setActCxp(String actCxp) {
        this.actCxp = actCxp;
    }

    public String getActCoi() {
        return this.actCoi;
    }

    public void setActCoi(String actCoi) {
        this.actCoi = actCoi;
    }

    public String getEnlazado() {
        return this.enlazado;
    }

    public void setEnlazado(String enlazado) {
        this.enlazado = enlazado;
    }

    public String getTipDocE() {
        return this.tipDocE;
    }

    public void setTipDocE(String tipDocE) {
        this.tipDocE = tipDocE;
    }

    public Integer getNumMoned() {
        return this.numMoned;
    }

    public void setNumMoned(Integer numMoned) {
        this.numMoned = numMoned;
    }

    public Double getTipcamb() {
        return this.tipcamb;
    }

    public void setTipcamb(Double tipcamb) {
        this.tipcamb = tipcamb;
    }

    public Integer getNumPagos() {
        return this.numPagos;
    }

    public void setNumPagos(Integer numPagos) {
        this.numPagos = numPagos;
    }

    public Date getFechaelab() {
        return this.fechaelab;
    }

    public void setFechaelab(Date fechaelab) {
        this.fechaelab = fechaelab;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getFolio() {
        return this.folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getCtlpol() {
        return this.ctlpol;
    }

    public void setCtlpol(Integer ctlpol) {
        this.ctlpol = ctlpol;
    }

    public String getEscfd() {
        return this.escfd;
    }

    public void setEscfd(String escfd) {
        this.escfd = escfd;
    }

    public String getContado() {
        return this.contado;
    }

    public void setContado(String contado) {
        this.contado = contado;
    }

    public String getBloq() {
        return this.bloq;
    }

    public void setBloq(String bloq) {
        this.bloq = bloq;
    }

    public Double getDesFinPorc() {
        return this.desFinPorc;
    }

    public void setDesFinPorc(Double desFinPorc) {
        this.desFinPorc = desFinPorc;
    }

    public Double getDesTotPorc() {
        return this.desTotPorc;
    }

    public void setDesTotPorc(Double desTotPorc) {
        this.desTotPorc = desTotPorc;
    }

    public Double getImporte() {
        return this.importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getTipDocAnt() {
        return this.tipDocAnt;
    }

    public void setTipDocAnt(String tipDocAnt) {
        this.tipDocAnt = tipDocAnt;
    }

    public String getDocAnt() {
        return this.docAnt;
    }

    public void setDocAnt(String docAnt) {
        this.docAnt = docAnt;
    }

    public String getTipDocSig() {
        return this.tipDocSig;
    }

    public void setTipDocSig(String tipDocSig) {
        this.tipDocSig = tipDocSig;
    }

    public String getDocSig() {
        return this.docSig;
    }

    public void setDocSig(String docSig) {
        this.docSig = docSig;
    }

    public String getFormaenvio() {
        return this.formaenvio;
    }

    public void setFormaenvio(String formaenvio) {
        this.formaenvio = formaenvio;
    }

}
