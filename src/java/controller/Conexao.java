/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author anderson
 */
public class Conexao {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            configureSessionFactory();
        }
        if (sessionFactory.getCurrentSession() == null) {
            return sessionFactory.openSession();
        }
        return sessionFactory.getCurrentSession();
    }
}
