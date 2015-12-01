/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Auditoria;
import model.Posicao;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQuery;

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
            System.out.println("Não foi possível inserir a posição. Erro: " + hibernateException.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
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
            System.out.println("Não foi possível alterar a posição. Erro: " + hibernateException.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
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
            System.out.println("Não foi possível apagar a posição. Erro: " + hibernateException.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return success;
    }

    public List<Posicao> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query;
        List<Posicao> result;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Posicao");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar as posições. Erro: " + hibernateException.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return null;
    }

    public Posicao retrieve(int idPosicao) {
        Posicao posicao;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Posicao.class);
            criteria.add(Restrictions.eq("id", idPosicao));
            posicao = (Posicao) criteria.uniqueResult();
            transaction.commit();
            return posicao;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a posição. Erro: " + hibernateException.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return null;
    }
    
    public List<Auditoria> auditoria() {
        Session session = null;
        Transaction transaction = null;
        List<Auditoria> result = new ArrayList<>();

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            AuditQuery query = AuditReaderFactory.get(session).createQuery()
                .forRevisionsOfEntity(Posicao.class, false, true);
            List<Object> list = query.getResultList();
            list.stream().map((object) -> (Object[]) object).map((objectArray) -> {
                Auditoria auditoria = new Auditoria();
                auditoria.setClasse((Object) objectArray[0]);
                
                DefaultRevisionEntity defaultRevisionEntity = (DefaultRevisionEntity) objectArray[1];
                auditoria.setRevisao(defaultRevisionEntity.getId());
                auditoria.setData(new Date(defaultRevisionEntity.getTimestamp()));
                
                RevisionType revisionType = (RevisionType) objectArray[2];
                auditoria.setOperacao(revisionType.name());
                
                return auditoria;                
            }).forEach((auditoria) -> {
                result.add(auditoria);
            });
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar as inscrições das equipes. Erro: " + hibernateException.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            try {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            } catch (Exception exception) {
                System.out.println("Não foi possível fechar a sessão. Erro: " + exception.getMessage());
            }
        }
        return null;
    }
    
}
