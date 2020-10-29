package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Minve01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Minve01DaoImp implements Minve01Dao {

    @Override
    public List<Minve01> obtenerMaximoValor() {
        List<Minve01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("SELECT MAX(numMov) +1 FROM Minve01").list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void saveMinve01(Minve01 minve) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(minve);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

}
