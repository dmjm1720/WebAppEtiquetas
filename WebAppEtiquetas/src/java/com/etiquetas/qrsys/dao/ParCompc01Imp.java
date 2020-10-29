package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.ParCompc01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class ParCompc01Imp implements ParCompc01Dao {

    @Override
    @SuppressWarnings("null")
    public void saveParCompc01(ParCompc01 parcompc) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(parcompc);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Integer> obtenerMaximoValor(String factura) {
        List<Integer> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT MAX(numPar) +1 FROM ParCompc01 WHERE cveDoc=:factura");
            q.setParameter("factura", factura);
            lista = q.list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

}
