package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class Foliosc01DaoImp implements Foliosc01Dao {

    @Override
    public void updateFolio(int ultdoc, Date fechaUltDoc) {
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Foliosc01 SET ultDoc=:ultdoc, fechUltDoc=:fechaUltDoc WHERE tipDoc='c'");
        q.setParameter("ultdoc", ultdoc);
        q.setParameter("fechaUltDoc", fechaUltDoc);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
    }

}
