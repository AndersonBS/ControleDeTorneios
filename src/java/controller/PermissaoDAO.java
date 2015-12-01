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
import model.InscricaoEquipe;
import model.Permissao;
import model.Torneio;
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
            System.out.println("Não foi possível inserir a permissão. Erro: " + hibernateException.getMessage());
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
            System.out.println("Não foi possível alterar a permissão. Erro: " + hibernateException.getMessage());
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
            System.out.println("Não foi possível apagar a permissão. Erro: " + hibernateException.getMessage());
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
    
    public boolean delete(List<Permissao> permissoes) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            for (Permissao permissao: permissoes) {
                session.delete(permissao);
            }
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar a permissão. Erro: " + hibernateException.getMessage());
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

    public List<Permissao> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query;
        List<Permissao> result;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Permissao");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar as permissões. Erro: " + hibernateException.getMessage());
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

    public Permissao retrieve(int idPermissao) {
        Permissao permissao;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Permissao.class);
            criteria.add(Restrictions.eq("id", idPermissao));
            permissao = (Permissao) criteria.uniqueResult();
            transaction.commit();
            return permissao;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a permissão. Erro: " + hibernateException.getMessage());
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
    
    public Permissao retrieve(InscricaoEquipe inscricaoEquipe) {
        Permissao permissao;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Permissao where codInscricaoEquipe = :parametro");
            query.setInteger("parametro", inscricaoEquipe.getId());
            permissao = (Permissao) query.uniqueResult();
            transaction.commit();
            return permissao;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a permissão. Erro: " + hibernateException.getMessage());
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
    
    public Permissao retrieve(Torneio torneio) {
        Permissao permissao;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Permissao where codTorneio = :parametro");
            query.setInteger("parametro", torneio.getId());
            permissao = (Permissao) query.uniqueResult();
            transaction.commit();
            return permissao;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a permissão. Erro: " + hibernateException.getMessage());
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
                .forRevisionsOfEntity(Permissao.class, false, true);
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
