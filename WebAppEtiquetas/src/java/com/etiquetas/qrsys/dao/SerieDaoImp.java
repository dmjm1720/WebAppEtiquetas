package com.etiquetas.qrsys.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.etiquetas.qrsys.e.model.Serie;
import com.etiquetas.qrsys.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class SerieDaoImp implements SerieDao {

    @Override
    @SuppressWarnings("null")
    public List<Serie> listaSeries() {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        //String hql = "FROM Serie";
        //String hql = "FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.proveedor IS NULL";
        try {
            lista = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.proveedor IS NULL").list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public List<Serie> listaSeriesPorFactura(String nofactura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura=:factura");
            q.setParameter("", nofactura);
            lista = (List<Serie>) q.list();
            t.commit();
            session.close();

        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void saveSerie(Serie serie) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(serie);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro guardado"));
            session.close();
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR"));
            session.getTransaction().rollback();
        }

    }

    @Override
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void updateSerie(Serie serie) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionfactory().openSession();
            session.beginTransaction();
            session.merge(serie);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro actualizado"));
            session.close();
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR"));
            session.getTransaction().rollback();
        }

    }

    @Override
    @SuppressWarnings("null")
    public void deleteSerie(Serie serie) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionfactory().openSession();
            session.beginTransaction();
            session.delete(serie);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro borrado"));
            session.close();
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR"));
            session.getTransaction().rollback();
        }

    }

    @Override
    public List<Serie> listaSeriesConInformacion(String nofactura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura=:factura AND serie.pedimento IS NULL");
            q.setParameter("factura", nofactura);
            lista = (List<Serie>) q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public Serie obtenerSerieExistente(Serie serie) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Query q = session.createQuery("FROM Serie WHERE serie=:serie");
        q.setParameter("serie", serie.getSerie());
        return (Serie) q.uniqueResult();
    }

    @Override
    public Serie returnSerieExistente(Serie serie) {
        Serie serieId = this.obtenerSerieExistente(serie);
        return serieId;
    }

    @Override
    @SuppressWarnings("null")
    public List<Serie> listaDeSeries(String nofactura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura=:factura");
            q.setParameter("factura", nofactura);
            lista = (List<Serie>) q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public List<Serie> listaSeriesImprimir(String nofactura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura=:factura AND factura.tipo='Compra' AND factura.subtipo='Entrada' AND serie.aduana IS NOT NULL AND serie.impreso <=1");
            q.setParameter("factura", nofactura);
            lista = (List<Serie>) q.list();
            t.commit();
            // session.close();
        } catch (HibernateException e) {
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public void updateNoImpresion(String serie, int orden) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Serie SET impreso=impreso+1, seleccionar=1, orden=:orden WHERE serie=:serie");
        q.setParameter("serie", serie);
        q.setParameter("orden", orden);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR" + e.getMessage()));
            t.rollback();
        }
    }

    @Override
    public List<Serie> listarSeriesSae(int user, String pedimento, String art) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT COUNT(sae) FROM Serie WHERE idusuario=:user AND pedimento=:pedimento AND articulo=:art AND sae=0");
            //Query<?> q = session.createQuery("SELECT COUNT(sae) FROM Serie WHERE idusuario=:user AND pedimento=:pedimento AND articulo=:art AND sae=0");
            q.setParameter("user", user);
            q.setParameter("pedimento", pedimento);
            q.setParameter("art", art);
            lista = (List<Serie>) q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<String> listarSeriesSaeRegistro(int id, String pedimento) {
        List<String> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            //Query q = session.createQuery("SELECT DISTINCT articulo FROM Serie WHERE idusuario=:user AND pedimento=:pedimento AND sae=0");
            Query q = session.createSQLQuery("SELECT DISTINCT articulo FROM Serie WHERE  idfactura='" + id + "' AND pedimento='" + pedimento + "' AND sae=0");
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void updateSerieSae1(String serie) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Serie SET sae=1 WHERE serie=:serie");
        q.setParameter("serie", serie);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
    }

    @Override
    public List<String> listarSeriesSaeEstado1(int user, String pedimento) {
        List<String> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie WHERE idusuario=:user AND pedimento=:pedimento AND sae=0");
            q.setParameter("user", user);
            q.setParameter("pedimento", pedimento);
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public List<Serie> listaSeriesImprTrasEntrada(String nofactura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura=:factura AND factura.tipo='Traspaso' AND factura.subtipo='Entrada' AND serie.aduana IS NOT NULL AND serie.impreso <=1");
            q.setParameter("factura", nofactura);
            lista = (List<Serie>) q.list();
            t.commit();
            //session.close();
        } catch (HibernateException e) {
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public List<Serie> listaSeriesImprTrasSalida(String nofactura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura=:factura AND factura.tipo='Traspaso' AND factura.subtipo='Salida' AND serie.aduana IS NOT NULL AND serie.impreso <=1");
            q.setParameter("factura", nofactura);
            lista = (List<Serie>) q.list();
            t.commit();
            //session.close();
        } catch (HibernateException e) {
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public List<Serie> listarSeriesImprVentas(String nofactura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura=:factura AND factura.tipo='Venta' AND factura.subtipo='Salida' AND serie.aduana IS NOT NULL AND serie.impreso <=1");
            q.setParameter("factura", nofactura);
            lista = (List<Serie>) q.list();
            t.commit();
            //session.close();
        } catch (HibernateException e) {
            t.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public void updateSerieEstadoCero(String serie) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("UPDATE Serie SET seleccionar=0, orden=0 WHERE serie=:serie");
        q.setParameter("serie", serie);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR" + e.getMessage()));
            t.rollback();
        }
    }

    @Override
    public List<String> listaPedimentoSerie(int user, int id) {
        List<String> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createSQLQuery("SELECT DISTINCT pedimento FROM Serie WHERE idusuario='" + user + "' AND idfactura='" + id + "' AND sae=0");
            //Query q = session.createNativeQuery("SELECT DISTINCT pedimento FROM Serie as pedimento INNER JOIN pedimento.factura as factura WHERE factura.idfactura='" + id + "'");
            //q.setParameter("user", user);
            //q.setParameter("idfactura", id);
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<String> listaLote(int noFactura, String pedimento, int id, String art) {
        List<String> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createSQLQuery("SELECT TOP(1) LOTE FROM SERIE WHERE IDFACTURA='" + noFactura +"' AND PEDIMENTO='" + pedimento +"' AND IDUSUARIO='" + id +"' AND ARTICULO='" + art + "'");
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<String> listaFecha(int noFactura, String pedimento, int id, String art) {
         List<String> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createSQLQuery("SELECT TOP(1) FECHAPEDIMENTO FROM SERIE WHERE IDFACTURA='" + noFactura +"' AND PEDIMENTO='" + pedimento +"' AND IDUSUARIO='" + id +"' AND ARTICULO='" + art + "'");
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<String> listaAduana(int noFactura, String pedimento, int id, String art) {
         List<String> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            Query q = session.createSQLQuery("SELECT TOP(1) ADUANA FROM SERIE WHERE IDFACTURA='" + noFactura +"' AND PEDIMENTO='" + pedimento +"' AND IDUSUARIO='" + id +"' AND ARTICULO='" + art + "'");
            lista = q.list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            t.rollback();
        }
        return lista;
    }

}
