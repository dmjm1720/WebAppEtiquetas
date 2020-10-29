package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.ParCompc01;
import java.util.List;

public interface ParCompc01Dao {

    public void saveParCompc01(ParCompc01 parcompc);
    
    public List<Integer> obtenerMaximoValor(String factura);

}
