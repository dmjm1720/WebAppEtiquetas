package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Almacenes01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Almacenes01DaoImp implements Almacenes01Dao {

    @Override
    public List<Almacenes01> listaAlmacenes() {
        List<Almacenes01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Almacenes01 WHERE cveAlm=3 OR cveAlm=14";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

}
