/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Permissao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anderson
 */
public class PermissaoDAO {
    
    public boolean save(Permissao permissao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.save(permissao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel inserir a permiss�o. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("N�o foi poss�vel fechar a sess�o. Erro: " + exception.getMessage());
            }
        }
        return success;
    }

    public boolean update(Permissao permissao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.update(permissao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel alterar a permiss�o. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("N�o foi poss�vel fechar a sess�o. Erro: " + exception.getMessage());
            }
        }
        return success;
    }

    public boolean delete(Permissao permissao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.delete(permissao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel apagar a permiss�o. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("N�o foi poss�vel fechar a sess�o. Erro: " + exception.getMessage());
            }
        }
        return success;
    }

    public List<Permissao> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query = null;
        List<Permissao> result = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Permissao");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar as permiss�es. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("N�o foi poss�vel fechar a sess�o. Erro: " + exception.getMessage());
            }
        }
        return null;
    }

    public Permissao retrieve(int idPermissao) {
        Permissao permissao = null;
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Permissao where id = :parametro");
            query.setInteger("parametro", idPermissao);
            permissao = (Permissao) query.uniqueResult();
            transaction.commit();
            return permissao;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar a permiss�o. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("N�o foi poss�vel fechar a sess�o. Erro: " + exception.getMessage());
            }
        }
        return null;
    }
    
}
