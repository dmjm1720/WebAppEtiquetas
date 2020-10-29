package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.e.model.Serie;
import com.etiquetas.qrsys.s.model.Factf01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;

public class Factf01DaoImp implements Factf01Dao {

    @Override
    @SuppressWarnings("null")
    public List<Factf01> listaFacturasVentas(String f1, String f2, int idAlmacen) {
        List<Factf01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("FROM Factf01 WHERE fechaDoc >='" + f1 + "' AND fechaDoc <='" + f2 + "' AND  status='E' AND numAlma=:idAlmacen");
            q.setParameter("idAlmacen", idAlmacen);
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Serie> listaSeriesFacturasVentas(String factura) {
        List<Serie> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT p.cveDoc, p.cveArt, i.descr, h.numSer, l.pedimento, l.nomAduan, l.fchaduana, l.status FROM ParFactf01 as p, Inve01 as i, Hnumser01 as h, Ltpd01 as l, EnlaceLtpd01  as e WHERE p.regSerie=h.regSerie AND p.cveArt=i.cveArt AND p.ELtpd=e.eLtpd AND e.regLtpd = l.regLtpd AND h.status='V' AND p.cveDoc='" + factura + "'");
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

}
