package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.e.model.Factura;
import com.etiquetas.qrsys.e.model.Serie;
import java.util.Date;
import java.util.List;

public interface FacturaDao {

    public List<Factura> listaFactura();

    public List<Factura> listaFacturaPorAlmacen();

    public List<Factura> listaBuscarFactura(String nofactura);

    public Factura obtenerIdFactura(Factura factura);

    public Factura returnIdFactura(Factura factura);

    public void saveFactura(Factura factura);

    public void updateFactura(Factura factura);

    public void deleteFactura(Factura factura);

    public List<Factura> listaFacturaVenta(String f1, String f2, int almacen);

    public List<Factura> listaTraspasoEntrada(String f1, String f2, int almacen);

    public List<Factura> listaTraspasoSalida(String f1, String f2, int almacen);

    public void borrarFactura(String factura);

    public List<Serie> buscarSeriesPendientes(String factura);

    public List<Serie> buscarSeriesEstado2(String factura);

    public void updateEstadoFactura(String factura);
    
    public List<Serie>buscarSeriesInformacionCompleta(String factura);

}
