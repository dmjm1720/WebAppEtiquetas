
package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Minve01;
import java.util.List;


public interface Minve01Dao {
    
    public List<Minve01> obtenerMaximoValor();
    
    public void saveMinve01(Minve01 minve);
    
}
