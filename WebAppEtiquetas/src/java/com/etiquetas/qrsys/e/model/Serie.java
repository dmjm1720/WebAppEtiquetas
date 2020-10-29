package com.etiquetas.qrsys.e.model;

import java.util.Date;

public class Serie implements java.io.Serializable {

    private int idserie;
    private Factura factura;
    private Usuario usuario;
    private String serie;
    private String articulo;
    private String descripcion;
    private String aduana;
    private String pedimento;
    private Date fechapedimento;
    private String lote;
    private Integer impreso;
    private Boolean seleccionar;
    private Boolean sae;
    private int orden;

    public Serie() {
    }

    public Serie(int idserie, Factura factura, String serie, String articulo, String descripcion) {
        this.idserie = idserie;
        this.factura = factura;
        this.serie = serie;
        this.articulo = articulo;
        this.descripcion = descripcion;
    }

    public Serie(int idserie, Factura factura, Usuario usuario, String serie, String articulo, String descripcion, String aduana, String pedimento, Date fechapedimento, String lote, Integer impreso, Boolean seleccionar, Boolean sae, int orden) {
        this.idserie = idserie;
        this.factura = factura;
        this.usuario = usuario;
        this.serie = serie;
        this.articulo = articulo;
        this.descripcion = descripcion;
        this.aduana = aduana;
        this.pedimento = pedimento;
        this.fechapedimento = fechapedimento;
        this.lote = lote;
        this.impreso = impreso;
        this.seleccionar = seleccionar;
        this.sae = sae;
        this.orden = orden;
    }

    public int getIdserie() {
        return this.idserie;
    }

    public void setIdserie(int idserie) {
        this.idserie = idserie;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getArticulo() {
        return this.articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAduana() {
        return this.aduana;
    }

    public void setAduana(String aduana) {
        this.aduana = aduana;
    }

    public String getPedimento() {
        return this.pedimento;
    }

    public void setPedimento(String pedimento) {
        this.pedimento = pedimento;
    }

    public Date getFechapedimento() {
        return this.fechapedimento;
    }

    public void setFechapedimento(Date fechapedimento) {
        this.fechapedimento = fechapedimento;
    }

    public String getLote() {
        return this.lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Integer getImpreso() {
        return this.impreso;
    }

    public void setImpreso(Integer impreso) {
        this.impreso = impreso;
    }

    public Boolean getSeleccionar() {
        return this.seleccionar;
    }

    public void setSeleccionar(Boolean seleccionar) {
        this.seleccionar = seleccionar;
    }

    public Boolean getSae() {
        return this.sae;
    }

    public void setSae(Boolean sae) {
        this.sae = sae;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

}
