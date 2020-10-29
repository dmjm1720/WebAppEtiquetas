package com.etiquetas.qrsys.e.model;

import java.util.Date;

public class Series implements java.io.Serializable {

    private String factura;
    private String serie;
    private String articulo;
    private String descripcion;
    private String aduana;
    private String pedimento;
    private Date fechapedimento;
    private Boolean seleccionar;

    public Series() {
    }

    public Series(String factura, String serie, String articulo, String descripcion, String aduana, String pedimento, Date fechapedimento, Boolean seleccionar) {
        this.factura = factura;
        this.serie = serie;
        this.articulo = articulo;
        this.descripcion = descripcion;
        this.aduana = aduana;
        this.pedimento = pedimento;
        this.fechapedimento = fechapedimento;
        this.seleccionar = seleccionar;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAduana() {
        return aduana;
    }

    public void setAduana(String aduana) {
        this.aduana = aduana;
    }

    public String getPedimento() {
        return pedimento;
    }

    public void setPedimento(String pedimento) {
        this.pedimento = pedimento;
    }

    public Date getFechapedimento() {
        return fechapedimento;
    }

    public void setFechapedimento(Date fechapedimento) {
        this.fechapedimento = fechapedimento;
    }

    public Boolean getSeleccionar() {
        return seleccionar;
    }

    public void setSeleccionar(Boolean seleccionar) {
        this.seleccionar = seleccionar;
    }

}
