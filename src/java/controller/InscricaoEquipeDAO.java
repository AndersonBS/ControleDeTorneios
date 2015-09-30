/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.InscricaoEquipe;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anderson
 */
public class InscricaoEquipeDAO {
    
    public boolean save(InscricaoEquipe inscricaoEquipe) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.save(inscricaoEquipe);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel inserir a inscri��o da equipe. Erro: " + hibernateException.getMessage());
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

    public boolean update(InscricaoEquipe inscricaoEquipe) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.update(inscricaoEquipe);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel alterar a inscri��o da equipe. Erro: " + hibernateException.getMessage());
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

    public boolean delete(InscricaoEquipe inscricaoEquipe) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.delete(inscricaoEquipe);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel apagar a inscri��o da equipe. Erro: " + hibernateException.getMessage());
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

    public List<InscricaoEquipe> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query = null;
        List<InscricaoEquipe> result = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from InscricaoEquipe");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar as inscri��es das equipes. Erro: " + hibernateException.getMessage());
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

    public InscricaoEquipe retrieve(int idInscricaoEquipe) {
        InscricaoEquipe inscricaoEquipe = null;
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from InscricaoEquipe where id = :parametro");
            query.setInteger("parametro", idInscricaoEquipe);
            inscricaoEquipe = (InscricaoEquipe) query.uniqueResult();
            transaction.commit();
            return inscricaoEquipe;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar a inscri��o da equipe. Erro: " + hibernateException.getMessage());
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
