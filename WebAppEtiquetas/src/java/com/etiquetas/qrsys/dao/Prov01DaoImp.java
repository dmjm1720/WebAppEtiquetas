package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Prov01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Prov01DaoImp implements Prov01Dao {

    @Override
    public List<Prov01> listaProveedores() {
        List<Prov01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Prov01 WHERE status='A' AND clasific='SE'";
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
