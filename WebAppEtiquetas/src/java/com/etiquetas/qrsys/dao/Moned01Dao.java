package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.e.model.Factura;
import com.etiquetas.qrsys.s.model.Moned01;
import java.util.List;

public interface Moned01Dao {

    public List<Moned01> listarMonedas();

    public List<Moned01> listarTipoCambio(Factura factura);
}
