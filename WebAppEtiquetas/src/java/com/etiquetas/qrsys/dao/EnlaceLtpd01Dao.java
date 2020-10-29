package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.EnlaceLtpd01;
import java.util.List;

public interface EnlaceLtpd01Dao {

    public List<EnlaceLtpd01> obtenerMaximoValor();

    public void saveEnlaceLtpd01(EnlaceLtpd01 enlace);
    
}
