package com.etiquetas.qrsys.bean;

import com.etiquetas.qrsys.dao.SerieDao;
import com.etiquetas.qrsys.dao.SerieDaoImp;
import com.etiquetas.qrsys.e.model.Factura;
import com.etiquetas.qrsys.e.model.Serie;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "administrarEtiquetasBean")
@ViewScoped
public class AdministrarEtiquetasBean implements Serializable {

    private List<Serie> lista;
    private Serie serie;
    private Factura factura;

    public AdministrarEtiquetasBean() {
        this.lista = new ArrayList<>();
        this.serie = new Serie();
        this.factura = new Factura();
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Serie> getLista() {
        SerieDao sDao = new SerieDaoImp();
        this.lista = sDao.listaMantenimientoSeries();
        return lista;
    }

    public void actualizarSeries() {
        SerieDao sDao = new SerieDaoImp();
        sDao.updateSerie(serie);
        this.serie = new Serie();
    }

}
