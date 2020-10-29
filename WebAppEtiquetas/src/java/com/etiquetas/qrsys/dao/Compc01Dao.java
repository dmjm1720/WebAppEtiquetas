package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Compc01;
import java.util.List;

public interface Compc01Dao {

    public List<Compc01> obtenerMaximoValor();

    public void saveComc01(Compc01 compc01);

}
