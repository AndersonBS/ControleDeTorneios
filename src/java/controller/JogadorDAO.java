/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Arrays;
import java.util.List;
import model.Jogador;
import model.Jogador_AUD;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;

/**
 *
 * @author anderson
 */
public class JogadorDAO {
    
    public boolean save(Jogador jogador) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.save(jogador);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel inserir o jogador. Erro: " + hibernateException.getMessage());
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

    public boolean update(Jogador jogador) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.update(jogador);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel alterar o jogador. Erro: " + hibernateException.getMessage());
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

    public boolean delete(Jogador jogador) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.delete(jogador);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel apagar o jogador. Erro: " + hibernateException.getMessage());
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

    public List<Jogador> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query = null;
        List<Jogador> result = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Jogador");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar os jogadores. Erro: " + hibernateException.getMessage());
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

    public Jogador retrieve(int idJogador) {
        Jogador jogador = null;
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Jogador where id = :parametro");
            query.setInteger("parametro", idJogador);
            jogador = (Jogador) query.uniqueResult();
            transaction.commit();
            return jogador;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar o jogador. Erro: " + hibernateException.getMessage());
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
    

    public List<Jogador_AUD> auditoria() {
        
        Session session = null;
        Transaction transaction = null;
        Query query = null;
        List<Jogador_AUD> result = null;

        try {
            session = Conexao.getSession();
            AuditReader auditReader = AuditReaderFactory.get(session);
            transaction = session.beginTransaction();
            AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Jogador.class, true, true);
            
            
            
            
            transaction.commit();
            return auditQuery.getResultList();
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar os dados da auditoria. Erro: " + hibernateException.getMessage());
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
