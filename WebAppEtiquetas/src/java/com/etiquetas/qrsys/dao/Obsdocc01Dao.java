package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.ObsDocc01;
import java.util.List;

public interface Obsdocc01Dao {

    public List<ObsDocc01> obtenerMaximoValor();

    public void saveObservacion(ObsDocc01 obsdocc01);
}
