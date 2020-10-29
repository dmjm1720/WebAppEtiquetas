package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Ltpd01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Ltpd01DaoImp implements Ltpd01Dao {

    @Override
    public List<Ltpd01> obtenerMaximoValor() {
        List<Ltpd01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT MAX(regLtpd) +1 FROM Ltpd01";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void saveLtp01(Ltpd01 ltpd01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(ltpd01);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }

    }

}
