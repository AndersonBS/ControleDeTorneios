/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.Jogador;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anderson
 */
public class JogadorDAO {
    
    public void save(Jogador jogador) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            sessao.save(jogador);
            transacao.commit();
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível inserir o jogador. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
    }

    public void update(Jogador jogador) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            sessao.update(jogador);
            transacao.commit();
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível alterar o jogador. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
    }

    public void delete(Jogador jogador) {
        Session sessao = null;
        Transaction transacao = null;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            sessao.delete(jogador);
            transacao.commit();
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar o jogador. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
    }

    public List<Jogador> retrieve() {
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;
        List<Jogador> resultado = null;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Jogador");
            resultado = consulta.list();
            transacao.commit();
            return resultado;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar os jogadores. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return null;
    }

    public Jogador findJogador(int id) {
        Jogador jogador = null;
        Session sessao = null;
        Transaction transacao = null;
        Query consulta = null;

        try {
            sessao = Conexao.getSession();
            transacao = sessao.beginTransaction();
            consulta = sessao.createQuery("from Jogador where id = :parametro");
            consulta.setInteger("parametro", id);
            jogador = (Jogador) consulta.uniqueResult();
            transacao.commit();
            return jogador;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar o jogador. Erro: " + hibernateException.getMessage());
        } finally {
            try {
                sessao.close();
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return null;
    }

}
