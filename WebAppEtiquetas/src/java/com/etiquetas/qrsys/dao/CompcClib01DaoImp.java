package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.CompcClib01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CompcClib01DaoImp implements CompcClib01Dao {

    @Override
    @SuppressWarnings("null")
    public void saveCompcClib(CompcClib01 compcClib) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(compcClib);
            session.getTransaction().commit();

            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }
}
