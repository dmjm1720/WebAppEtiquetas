package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.e.model.Factura;
import com.etiquetas.qrsys.e.model.Serie;
import com.etiquetas.qrsys.e.model.Usuario;
import com.etiquetas.qrsys.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

public class FacturaDaoImp implements FacturaDao {

    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

    @Override
    public List<Factura> listaFactura() {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("FROM Factura WHERE tipo='Compra' AND subtipo='Entrada' AND estado=0").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Factura> listaFacturaPorAlmacen() {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("FROM Factura WHERE tipo='Compra' AND subtipo='Entrada' AND estado=0 AND almacen='" + us.getAlmacen() + "'").list();
            t.commit();
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public List<Factura> listaBuscarFactura(String nofactura) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT idfactura FROM Factura WHERE nofactura='" + nofactura + "' ";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public Factura obtenerIdFactura(Factura factura) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        String hql = "FROM Factura WHERE nofactura=:nofactura";
        Query q = session.createQuery(hql);
        q.setParameter("nofactura", factura.getNofactura());
        return (Factura) q.uniqueResult();
    }

    @Override
    public Factura returnIdFactura(Factura factura) {
        Factura factId = this.obtenerIdFactura(factura);
        return factId;
    }

    @Override
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void saveFactura(Factura factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro guardado"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR"));
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public void updateFactura(Factura factura) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionfactory().openSession();
            session.beginTransaction();
            session.merge(factura);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro actualizado"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR" + e.getMessage()));
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteFactura(Factura factura) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "DELETE  Factura  WHERE nofactura=:nofactura";
        Query q = session.createQuery(hql);
        q.setParameter("nofactura", factura.getNofactura());
        try {
            q.executeUpdate();
            t.commit();
            session.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro borrado"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR" + e.getMessage()));
            t.rollback();
        }

    }

    @Override
    public List<Factura> listaFacturaVenta(String f1, String f2, int almacen) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura WHERE tipo='Venta' AND subtipo='Salida' AND estado=0 AND fecha>='" + f1 + "' AND FECHA<='" + f2 + "' AND idalmacen='" + almacen + "'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Factura> listaTraspasoEntrada(String f1, String f2, int almacen) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura WHERE tipo='Traspaso' AND subtipo='Entrada' AND estado=0 AND fecha>='" + f1 + "' AND FECHA<='" + f2 + "' AND idalmacen='" + almacen + "'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Factura> listaTraspasoSalida(String f1, String f2, int almacen) {
        List<Factura> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Factura WHERE tipo='Traspaso' AND subtipo='Salida' AND estado=0 AND fecha>='" + f1 + "' AND FECHA<='" + f2 + "' AND idalmacen='" + almacen + "'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void borrarFactura(String factura) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "DELETE  Factura  WHERE nofactura=:nofactura";
        Query q = session.createQuery(hql);
        q.setParameter("nofactura", factura);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro borrado"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR" + e.getMessage()));
            t.rollback();
        }
    }

    @Override
    public List<Serie> buscarSeriesPendientes(String factura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura='" + factura + "'").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Serie> buscarSeriesEstado2(String factura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura='" + factura + "' AND serie.impreso =2").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void updateEstadoFactura(String factura) {
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Factura SET estado=1 WHERE nofactura=:nofactura";
        Query q = session.createQuery(hql);
        q.setParameter("nofactura", factura);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro actualizado"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE ETIQUETAS", "ERROR" + e.getMessage()));
            t.rollback();
        }

    }

    @Override
    public List<Serie> buscarSeriesInformacionCompleta(String factura) {
        List<Serie> lista = null;
        Session session = HibernateUtil.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("SELECT serie FROM Serie as serie INNER JOIN serie.factura as factura WHERE factura.nofactura='" + factura + "' AND serie.pedimento IS NOT NULL").list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

}
