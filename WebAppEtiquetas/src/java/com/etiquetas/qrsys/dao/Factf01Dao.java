package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.e.model.Serie;
import com.etiquetas.qrsys.s.model.Factf01;

import java.util.List;

public interface Factf01Dao {

    public List<Factf01> listaFacturasVentas(String f1, String f2, int idAlmacen);

    public List<Serie> listaSeriesFacturasVentas(String factura);

}
