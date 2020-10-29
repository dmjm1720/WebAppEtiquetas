package com.etiquetas.qrsys.e.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Factura implements java.io.Serializable {

    private int idfactura;
    private String nofactura;
    private Date fecha;
    private int idusuario;
    private String proveedor;
    private String tipo;
    private String subtipo;
    private String esquema;
    private Double tipocambio;
    private String moneda;
    private String almacen;
    private String observacion;
    private String idproveedor;
    private Integer idalmacen;
    private Integer cveobs;
    private String cvedoc;
    private boolean estado;
    private Set series = new HashSet(0);

    public Factura() {
    }

    public Factura(int idfactura, String nofactura, Date fecha, int idusuario) {
        this.idfactura = idfactura;
        this.nofactura = nofactura;
        this.fecha = fecha;
        this.idusuario = idusuario;
    }

    public Factura(int idfactura, String nofactura, Date fecha, int idusuario, String proveedor, String tipo, String subtipo, String esquema, Double tipocambio, String moneda, String almacen, String observacion, String idproveedor, Integer idalmacen, Integer cveobs, String cvedoc, boolean estado) {
        this.idfactura = idfactura;
        this.nofactura = nofactura;
        this.fecha = fecha;
        this.idusuario = idusuario;
        this.proveedor = proveedor;
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.esquema = esquema;
        this.tipocambio = tipocambio;
        this.moneda = moneda;
        this.almacen = almacen;
        this.observacion = observacion;
        this.idproveedor = idproveedor;
        this.idalmacen = idalmacen;
        this.cveobs = cveobs;
        this.cvedoc = cvedoc;
        this.estado = estado;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public String getNofactura() {
        return nofactura;
    }

    public void setNofactura(String nofactura) {
        this.nofactura = nofactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public Double getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(Double tipocambio) {
        this.tipocambio = tipocambio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Integer getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(Integer idalmacen) {
        this.idalmacen = idalmacen;
    }

    public Integer getCveobs() {
        return cveobs;
    }

    public void setCveobs(Integer cveobs) {
        this.cveobs = cveobs;
    }

    public String getCvedoc() {
        return cvedoc;
    }

    public void setCvedoc(String cvedoc) {
        this.cvedoc = cvedoc;
    }

    public Set getSeries() {
        return series;
    }

    public void setSeries(Set series) {
        this.series = series;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
