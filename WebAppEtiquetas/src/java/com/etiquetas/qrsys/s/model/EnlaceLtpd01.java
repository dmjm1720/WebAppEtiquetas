package com.etiquetas.qrsys.s.model;

public class EnlaceLtpd01 implements java.io.Serializable {

    private int eLtpd;
    private Integer regLtpd;
    private Double cantidad;
    private Double pxrs;

    public EnlaceLtpd01() {
    }

    public EnlaceLtpd01(int eLtpd) {
        this.eLtpd = eLtpd;
    }

    public EnlaceLtpd01(int eLtpd, Integer regLtpd, Double cantidad, Double pxrs) {
        this.eLtpd = eLtpd;
        this.regLtpd = regLtpd;
        this.cantidad = cantidad;
        this.pxrs = pxrs;
    }

    public int geteLtpd() {
        return eLtpd;
    }

    public void seteLtpd(int eLtpd) {
        this.eLtpd = eLtpd;
    }

    public Integer getRegLtpd() {
        return regLtpd;
    }

    public void setRegLtpd(Integer regLtpd) {
        this.regLtpd = regLtpd;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPxrs() {
        return pxrs;
    }

    public void setPxrs(Double pxrs) {
        this.pxrs = pxrs;
    }

}
