package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Numser01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Numser01DaoImp implements Numser01Dao {

    @Override
    @SuppressWarnings("null")
    public void saveNumser01(Numser01 numser01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(numser01);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

}
