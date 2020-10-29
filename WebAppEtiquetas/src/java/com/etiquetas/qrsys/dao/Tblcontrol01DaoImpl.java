package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.util.HibernateUtilSae;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class Tblcontrol01DaoImpl implements Tblcontrol01Dao {

    @Override
    public void updateTblControl(int clave) {
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Tblcontrol01 SET ultCve=:clave WHERE idTabla=57");
        q.setParameter("clave", clave);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
    }

    @Override
    public void updateTablaControl(int clave) {
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Tblcontrol01 SET ultCve=:clave WHERE idTabla=48");
        q.setParameter("clave", clave);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
    }

    @Override
    public void updateTbl67Control(int clave) {
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Tblcontrol01 SET ultCve=:clave WHERE idTabla=67");
        q.setParameter("clave", clave);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
    }

}
