package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class Mult01DaoImp implements Mult01Dao {

    @Override
    public List<Integer> obtenerMaximoValor(String art, int idAlmacen) {
        List<Integer> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT SUM(exist) FROM Mult01 WHERE cveArt=:art AND cveAlm=:idAlmacen");
            q.setParameter("art", art);
            q.setParameter("idAlmacen", idAlmacen);
            lista = q.list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void updateMult01(String art, int idAlmacen, double cantidad) {
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Mult01 SET exist=:cantidad WHERE cveArt=:art AND cveAlm=:idAlmacen");
        q.setParameter("art", art);
        q.setParameter("idAlmacen", idAlmacen);
        q.setParameter("cantidad", cantidad);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
    }
}
