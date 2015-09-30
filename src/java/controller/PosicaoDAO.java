/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Posicao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anderson
 */
public class PosicaoDAO {
    
    public boolean save(Posicao posicao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.save(posicao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel inserir a posi��o. Erro: " + hibernateException.getMessage());
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

    public boolean update(Posicao posicao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.update(posicao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel alterar a posi��o. Erro: " + hibernateException.getMessage());
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

    public boolean delete(Posicao posicao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.delete(posicao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel apagar a posi��o. Erro: " + hibernateException.getMessage());
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

    public List<Posicao> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query = null;
        List<Posicao> result = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Posicao");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar as posi��es. Erro: " + hibernateException.getMessage());
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

    public Posicao retrieve(int idPosicao) {
        Posicao posicao = null;
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Posicao where id = :parametro");
            query.setInteger("parametro", idPosicao);
            posicao = (Posicao) query.uniqueResult();
            transaction.commit();
            return posicao;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar a posi��o. Erro: " + hibernateException.getMessage());
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
