package com.etiquetas.qrsys.dao;

import java.util.List;

import com.etiquetas.qrsys.e.model.Serie;

public interface SerieDao {

    public List<Serie> listaSeries();

    public void saveSerie(Serie serie);

    public void updateSerie(Serie serie);

    public void deleteSerie(Serie serie);

    public List<Serie> listaSeriesPorFactura(String nofactura);

    public List<Serie> listaSeriesConInformacion(String nofactura);

    public Serie obtenerSerieExistente(Serie serie);

    public Serie returnSerieExistente(Serie serie);

    public List<Serie> listaDeSeries(String nofactura);

    public List<Serie> listaSeriesImprimir(String nofactura);

    public void updateNoImpresion(String serie, int orden);

    public List<Serie> listarSeriesSae(int user, String pedimento, String art);

    public List<String> listarSeriesSaeRegistro(int id, String pedimento);

    public void updateSerieSae1(String serie);

    public List<String> listarSeriesSaeEstado1(int user, String pedimento);

    public List<Serie> listaSeriesImprTrasEntrada(String nofactura);

    public List<Serie> listaSeriesImprTrasSalida(String nofactura);

    public List<Serie> listarSeriesImprVentas(String nofactura);

    public void updateSerieEstadoCero(String serie);

    public List<String> listaPedimentoSerie(int user, int id);

    /////////
    public List<String> listaLote(int noFactura, String pedimento, int id, String art);

    public List<String> listaFecha(int noFactura, String pedimento, int id, String art);

    public List<String> listaAduana(int noFactura, String pedimento, int id, String art);
    /////////

}
