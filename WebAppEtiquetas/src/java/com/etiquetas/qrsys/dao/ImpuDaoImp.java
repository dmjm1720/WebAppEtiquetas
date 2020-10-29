package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Impu01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ImpuDaoImp implements Impu01Dao {

    @Override
    public List<Impu01> listarImpuestos() {
        List<Impu01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Impu01";
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
