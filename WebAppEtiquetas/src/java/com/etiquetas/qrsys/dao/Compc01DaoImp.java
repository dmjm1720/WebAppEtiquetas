package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Compc01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Compc01DaoImp implements Compc01Dao {

    @Override
    public List<Compc01> obtenerMaximoValor() {
        List<Compc01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("SELECT MAX(folio) +1 FROM Compc01").list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void saveComc01(Compc01 compc01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(compc01);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }

    }

}
