package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.ParCompcClib01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ParCompcClib01DaoImp implements ParCompcClib01Dao {

    @Override
    @SuppressWarnings("null")
    public void saveParCompcClib(ParCompcClib01 clib01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(clib01);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

}
