package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Ltpd01;
import java.util.List;

public interface Ltpd01Dao {

    public List<Ltpd01> obtenerMaximoValor();

    public void saveLtp01(Ltpd01 ltpd01);

}
