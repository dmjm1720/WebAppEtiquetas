package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.EnlaceLtpd01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EnlaceLtpd01DaoImp implements EnlaceLtpd01Dao {

    @Override
    public List<EnlaceLtpd01> obtenerMaximoValor() {
        List<EnlaceLtpd01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("SELECT MAX(eLtpd) +1 FROM EnlaceLtpd01").list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void saveEnlaceLtpd01(EnlaceLtpd01 enlace) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(enlace);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            session.getTransaction().rollback();
        }
    }

}
