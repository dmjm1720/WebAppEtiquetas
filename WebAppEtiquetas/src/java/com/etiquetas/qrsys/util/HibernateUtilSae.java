package com.etiquetas.qrsys.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilSae {

    public static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("/hibernateSae.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionfactory() {
        return sessionFactory;
    }

    private void shutdown() {
        getSessionfactory().close();

    }
}
