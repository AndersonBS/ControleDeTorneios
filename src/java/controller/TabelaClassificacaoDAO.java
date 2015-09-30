/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.TabelaClassificacao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anderson
 */
public class TabelaClassificacaoDAO {
    
    public boolean save(TabelaClassificacao tabelaClassificacao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.save(tabelaClassificacao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel inserir a tabela de classifica��o. Erro: " + hibernateException.getMessage());
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

    public boolean update(TabelaClassificacao tabelaClassificacao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.update(tabelaClassificacao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel alterar a tabela de classifica��o. Erro: " + hibernateException.getMessage());
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

    public boolean delete(TabelaClassificacao tabelaClassificacao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.delete(tabelaClassificacao);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel apagar a tabela de classifica��o. Erro: " + hibernateException.getMessage());
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

    public List<TabelaClassificacao> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query = null;
        List<TabelaClassificacao> result = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from TabelaClassificacao");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar as tabelas de classifica��o. Erro: " + hibernateException.getMessage());
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

    public TabelaClassificacao retrieve(int idTabelaClassificacao) {
        TabelaClassificacao tabelaClassificacao = null;
        Session session = null;
        Transaction transaction = null;
        Query query = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from TabelaClassificacao where id = :parametro");
            query.setInteger("parametro", idTabelaClassificacao);
            tabelaClassificacao = (TabelaClassificacao) query.uniqueResult();
            transaction.commit();
            return tabelaClassificacao;
        } catch (HibernateException hibernateException) {
            System.out.println("N�o foi poss�vel recuperar a tabela de classifica��o. Erro: " + hibernateException.getMessage());
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
