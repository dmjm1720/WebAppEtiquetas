package com.etiquetas.qrsys.dao;

import com.etiquetas.qrsys.s.model.ObsDocc01;
import com.etiquetas.qrsys.util.HibernateUtilSae;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Obsdocc01DaoImp implements Obsdocc01Dao {

    @Override
    public List<ObsDocc01> obtenerMaximoValor() {
        List<ObsDocc01> lista = null;
        Session session = HibernateUtilSae.getSessionfactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.createQuery("SELECT MAX(cveObs) +1 FROM ObsDocc01").list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void saveObservacion(ObsDocc01 obsdocc01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionfactory().openSession();
            session.beginTransaction();
            session.save(obsdocc01);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE ETIQUETAS", "Registro guardado y registrado en sistema SAE"));
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

}
