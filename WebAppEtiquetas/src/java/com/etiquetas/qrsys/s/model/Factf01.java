package com.etiquetas.qrsys.s.model;

import java.util.Date;

public class Factf01 implements java.io.Serializable {

    private String cveDoc;
    private String tipDoc;
    private String cveClpv;
    private String status;
    private Integer datMostr;
    private String cveVend;
    private String cvePedi;
    private Date fechaDoc;
    private Date fechaEnt;
    private Date fechaVen;
    private Date fechaCancela;
    private Double canTot;
    private Double impTot1;
    private Double impTot2;
    private Double impTot3;
    private Double impTot4;
    private Double desTot;
    private Double desFin;
    private Double comTot;
    private String condicion;
    private Integer cveObs;
    private Integer numAlma;
    private String actCxc;
    private String actCoi;
    private String enlazado;
    private String tipDocE;
    private Integer numMoned;
    private Double tipcamb;
    private Integer numPagos;
    private Date fechaelab;
    private Double primerpago;
    private String rfc;
    private Integer ctlpol;
    private String escfd;
    private Integer autoriza;
    private String serie;
    private Integer folio;
    private String autoanio;
    private Integer datEnvio;
    private String contado;
    private Integer cveBita;
    private String bloq;
    private String formaenvio;
    private Double desFinPorc;
    private Double desTotPorc;
    private Double importe;
    private Double comTotPorc;
    private String metododepago;
    private String numctapago;
    private String tipDocAnt;
    private String docAnt;
    private String tipDocSig;
    private String docSig;
    private String uuid;
    private Date versionSinc;
    private String formadepagosat;
    private String usoCfdi;
    private String nombre;

    public Factf01() {
    }

    public Factf01(String cveDoc, String cveClpv, Date fechaDoc) {
        this.cveDoc = cveDoc;
        this.cveClpv = cveClpv;
        this.fechaDoc = fechaDoc;
    }

    public Factf01(String cveDoc, String tipDoc, String cveClpv, String status, Integer datMostr, String cveVend, String cvePedi, Date fechaDoc, Date fechaEnt, Date fechaVen, Date fechaCancela, Double canTot, Double impTot1, Double impTot2, Double impTot3, Double impTot4, Double desTot, Double desFin, Double comTot, String condicion, Integer cveObs, Integer numAlma, String actCxc, String actCoi, String enlazado, String tipDocE, Integer numMoned, Double tipcamb, Integer numPagos, Date fechaelab, Double primerpago, String rfc, Integer ctlpol, String escfd, Integer autoriza, String serie, Integer folio, String autoanio, Integer datEnvio, String contado, Integer cveBita, String bloq, String formaenvio, Double desFinPorc, Double desTotPorc, Double importe, Double comTotPorc, String metododepago, String numctapago, String tipDocAnt, String docAnt, String tipDocSig, String docSig, String uuid, Date versionSinc, String formadepagosat, String usoCfdi, String nombre) {
        this.cveDoc = cveDoc;
        this.tipDoc = tipDoc;
        this.cveClpv = cveClpv;
        this.status = status;
        this.datMostr = datMostr;
        this.cveVend = cveVend;
        this.cvePedi = cvePedi;
        this.fechaDoc = fechaDoc;
        this.fechaEnt = fechaEnt;
        this.fechaVen = fechaVen;
        this.fechaCancela = fechaCancela;
        this.canTot = canTot;
        this.impTot1 = impTot1;
        this.impTot2 = impTot2;
        this.impTot3 = impTot3;
        this.impTot4 = impTot4;
        this.desTot = desTot;
        this.desFin = desFin;
        this.comTot = comTot;
        this.condicion = condicion;
        this.cveObs = cveObs;
        this.numAlma = numAlma;
        this.actCxc = actCxc;
        this.actCoi = actCoi;
        this.enlazado = enlazado;
        this.tipDocE = tipDocE;
        this.numMoned = numMoned;
        this.tipcamb = tipcamb;
        this.numPagos = numPagos;
        this.fechaelab = fechaelab;
        this.primerpago = primerpago;
        this.rfc = rfc;
        this.ctlpol = ctlpol;
        this.escfd = escfd;
        this.autoriza = autoriza;
        this.serie = serie;
        this.folio = folio;
        this.autoanio = autoanio;
        this.datEnvio = datEnvio;
        this.contado = contado;
        this.cveBita = cveBita;
        this.bloq = bloq;
        this.formaenvio = formaenvio;
        this.desFinPorc = desFinPorc;
        this.desTotPorc = desTotPorc;
        this.importe = importe;
        this.comTotPorc = comTotPorc;
        this.metododepago = metododepago;
        this.numctapago = numctapago;
        this.tipDocAnt = tipDocAnt;
        this.docAnt = docAnt;
        this.tipDocSig = tipDocSig;
        this.docSig = docSig;
        this.uuid = uuid;
        this.versionSinc = versionSinc;
        this.formadepagosat = formadepagosat;
        this.usoCfdi = usoCfdi;
        this.nombre = nombre;
    }

    public String getCveDoc() {
        return cveDoc;
    }

    public void setCveDoc(String cveDoc) {
        this.cveDoc = cveDoc;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getCveClpv() {
        return cveClpv;
    }

    public void setCveClpv(String cveClpv) {
        this.cveClpv = cveClpv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDatMostr() {
        return datMostr;
    }

    public void setDatMostr(Integer datMostr) {
        this.datMostr = datMostr;
    }

    public String getCveVend() {
        return cveVend;
    }

    public void setCveVend(String cveVend) {
        this.cveVend = cveVend;
    }

    public String getCvePedi() {
        return cvePedi;
    }

    public void setCvePedi(String cvePedi) {
        this.cvePedi = cvePedi;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public Date getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(Date fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

    public Date getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(Date fechaVen) {
        this.fechaVen = fechaVen;
    }

    public Date getFechaCancela() {
        return fechaCancela;
    }

    public void setFechaCancela(Date fechaCancela) {
        this.fechaCancela = fechaCancela;
    }

    public Double getCanTot() {
        return canTot;
    }

    public void setCanTot(Double canTot) {
        this.canTot = canTot;
    }

    public Double getImpTot1() {
        return impTot1;
    }

    public void setImpTot1(Double impTot1) {
        this.impTot1 = impTot1;
    }

    public Double getImpTot2() {
        return impTot2;
    }

    public void setImpTot2(Double impTot2) {
        this.impTot2 = impTot2;
    }

    public Double getImpTot3() {
        return impTot3;
    }

    public void setImpTot3(Double impTot3) {
        this.impTot3 = impTot3;
    }

    public Double getImpTot4() {
        return impTot4;
    }

    public void setImpTot4(Double impTot4) {
        this.impTot4 = impTot4;
    }

    public Double getDesTot() {
        return desTot;
    }

    public void setDesTot(Double desTot) {
        this.desTot = desTot;
    }

    public Double getDesFin() {
        return desFin;
    }

    public void setDesFin(Double desFin) {
        this.desFin = desFin;
    }

    public Double getComTot() {
        return comTot;
    }

    public void setComTot(Double comTot) {
        this.comTot = comTot;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Integer getCveObs() {
        return cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }

    public Integer getNumAlma() {
        return numAlma;
    }

    public void setNumAlma(Integer numAlma) {
        this.numAlma = numAlma;
    }

    public String getActCxc() {
        return actCxc;
    }

    public void setActCxc(String actCxc) {
        this.actCxc = actCxc;
    }

    public String getActCoi() {
        return actCoi;
    }

    public void setActCoi(String actCoi) {
        this.actCoi = actCoi;
    }

    public String getEnlazado() {
        return enlazado;
    }

    public void setEnlazado(String enlazado) {
        this.enlazado = enlazado;
    }

    public String getTipDocE() {
        return tipDocE;
    }

    public void setTipDocE(String tipDocE) {
        this.tipDocE = tipDocE;
    }

    public Integer getNumMoned() {
        return numMoned;
    }

    public void setNumMoned(Integer numMoned) {
        this.numMoned = numMoned;
    }

    public Double getTipcamb() {
        return tipcamb;
    }

    public void setTipcamb(Double tipcamb) {
        this.tipcamb = tipcamb;
    }

    public Integer getNumPagos() {
        return numPagos;
    }

    public void setNumPagos(Integer numPagos) {
        this.numPagos = numPagos;
    }

    public Date getFechaelab() {
        return fechaelab;
    }

    public void setFechaelab(Date fechaelab) {
        this.fechaelab = fechaelab;
    }

    public Double getPrimerpago() {
        return primerpago;
    }

    public void setPrimerpago(Double primerpago) {
        this.primerpago = primerpago;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getCtlpol() {
        return ctlpol;
    }

    public void setCtlpol(Integer ctlpol) {
        this.ctlpol = ctlpol;
    }

    public String getEscfd() {
        return escfd;
    }

    public void setEscfd(String escfd) {
        this.escfd = escfd;
    }

    public Integer getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(Integer autoriza) {
        this.autoriza = autoriza;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getAutoanio() {
        return autoanio;
    }

    public void setAutoanio(String autoanio) {
        this.autoanio = autoanio;
    }

    public Integer getDatEnvio() {
        return datEnvio;
    }

    public void setDatEnvio(Integer datEnvio) {
        this.datEnvio = datEnvio;
    }

    public String getContado() {
        return contado;
    }

    public void setContado(String contado) {
        this.contado = contado;
    }

    public Integer getCveBita() {
        return cveBita;
    }

    public void setCveBita(Integer cveBita) {
        this.cveBita = cveBita;
    }

    public String getBloq() {
        return bloq;
    }

    public void setBloq(String bloq) {
        this.bloq = bloq;
    }

    public String getFormaenvio() {
        return formaenvio;
    }

    public void setFormaenvio(String formaenvio) {
        this.formaenvio = formaenvio;
    }

    public Double getDesFinPorc() {
        return desFinPorc;
    }

    public void setDesFinPorc(Double desFinPorc) {
        this.desFinPorc = desFinPorc;
    }

    public Double getDesTotPorc() {
        return desTotPorc;
    }

    public void setDesTotPorc(Double desTotPorc) {
        this.desTotPorc = desTotPorc;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getComTotPorc() {
        return comTotPorc;
    }

    public void setComTotPorc(Double comTotPorc) {
        this.comTotPorc = comTotPorc;
    }

    public String getMetododepago() {
        return metododepago;
    }

    public void setMetododepago(String metododepago) {
        this.metododepago = metododepago;
    }

    public String getNumctapago() {
        return numctapago;
    }

    public void setNumctapago(String numctapago) {
        this.numctapago = numctapago;
    }

    public String getTipDocAnt() {
        return tipDocAnt;
    }

    public void setTipDocAnt(String tipDocAnt) {
        this.tipDocAnt = tipDocAnt;
    }

    public String getDocAnt() {
        return docAnt;
    }

    public void setDocAnt(String docAnt) {
        this.docAnt = docAnt;
    }

    public String getTipDocSig() {
        return tipDocSig;
    }

    public void setTipDocSig(String tipDocSig) {
        this.tipDocSig = tipDocSig;
    }

    public String getDocSig() {
        return docSig;
    }

    public void setDocSig(String docSig) {
        this.docSig = docSig;
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

    public String getFormadepagosat() {
        return formadepagosat;
    }

    public void setFormadepagosat(String formadepagosat) {
        this.formadepagosat = formadepagosat;
    }

    public String getUsoCfdi() {
        return usoCfdi;
    }

    public void setUsoCfdi(String usoCfdi) {
        this.usoCfdi = usoCfdi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
