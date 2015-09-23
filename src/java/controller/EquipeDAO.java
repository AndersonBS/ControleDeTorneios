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
public class EquipeDAO {
    
    public boolean save(InscricaoEquipe equipe) {
        Session sessao = null;
        Transaction transacao = null;
        boolean sucesso = false;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            sessao.save(equipe);
            transacao.commit();
            sucesso = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível inserir a equipe. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return sucesso;
    }

    public boolean update(InscricaoEquipe equipe) {
        Session sessao = null;
        Transaction transacao = null;
        boolean sucesso = false;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            sessao.update(equipe);
            transacao.commit();
            sucesso = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível alterar a equipe. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return sucesso;
    }

    public boolean delete(InscricaoEquipe equipe) {
        Session sessao = null;
        Transaction transacao = null;
        boolean sucesso = false;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            sessao.delete(equipe);
            transacao.commit();
            sucesso = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar a equipe. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return sucesso;
    }

    public List<InscricaoEquipe> retrieve() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<InscricaoEquipe> resultado = null;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Equipe");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar as equipes. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return null;
    }

    public InscricaoEquipe findEquipe(int id) {
        InscricaoEquipe equipe = null;
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Equipe where id = :parametro");
            consulta.setInteger("parametro", id);
            equipe = (InscricaoEquipe) consulta.uniqueResult();
            transacao.commit();
            return equipe;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a equipe. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                if (sessao.isOpen()) {
                    sessao.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return null;
    }

}
