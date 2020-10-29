package com.etiquetas.qrsys.dao;

import java.util.List;

public interface Mult01Dao {

    public List<Integer> obtenerMaximoValor(String art, int idAlmacen);

    public void updateMult01(String art, int idAlmacen, double cantidad);

}
