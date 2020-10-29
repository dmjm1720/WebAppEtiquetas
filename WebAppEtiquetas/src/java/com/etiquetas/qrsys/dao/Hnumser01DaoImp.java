package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.Hnumser01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class Hnumser01DaoImp implements Hnumser01Dao {

    @Override
    public List<Hnumser01> obtenerMaximoValor() {
        List<Hnumser01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            //lista = session.createSQLQuery("SELECT MAX(regSerie) +1 FROM Hnumser01").list();
            lista = session.createSQLQuery("SELECT MAX(REG_SERIE) +1 FROM HNUMSER01").list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void saveHmunser(Hnumser01 hnumser) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(hnumser);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }

    }

    @Override
    public void updateHnumserRegSerie(String factura, String articulo, int reg, String serie) {
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
            Query q = session.createSQLQuery("UPDATE HNUMSER01 SET REG_SERIE='" + reg + "' WHERE CVE_DOC='" + factura + "' AND CVE_ART='" + articulo + "' AND NUM_SER='" + serie + "'");
        //Query q = session.createSQLQuery("UPDATE TOP(" + top + ") HNUMSER01 SET REG_SERIE='" + reg + "' WHERE CVE_DOC='" + factura + "' AND CVE_ART='" + articulo + "' AND REG_SERIE=0");
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            t.rollback();
        }
    }

}
