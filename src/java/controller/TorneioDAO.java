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
import model.Torneio;
import model.Usuario;
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
public class TorneioDAO {
    
    public boolean save(Torneio torneio) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.save(torneio);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível inserir o torneio. Erro: " + hibernateException.getMessage());
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

    public boolean update(Torneio torneio) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.update(torneio);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível alterar o torneio. Erro: " + hibernateException.getMessage());
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

    public boolean delete(Torneio torneio) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            InscricaoEquipeDAO inscricaoEquipeDAO = new InscricaoEquipeDAO();
            inscricaoEquipeDAO.delete(inscricaoEquipeDAO.retrieve(torneio));
            
            PermissaoDAO permissaoDAO = new PermissaoDAO();
            permissaoDAO.delete(permissaoDAO.retrieve(torneio));
            
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.delete(torneio);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar o torneio. Erro: " + hibernateException.getMessage());
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

    public List<Torneio> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query;
        List<Torneio> result;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from Torneio");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar os torneios. Erro: " + hibernateException.getMessage());
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

    public Torneio retrieve(int idTorneio) {
        Torneio torneio;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Torneio.class);
            criteria.add(Restrictions.eq("id", idTorneio));
            torneio = (Torneio) criteria.uniqueResult();
            transaction.commit();
            return torneio;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar o torneio. Erro: " + hibernateException.getMessage());
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
    
    public List<Torneio> retrieve(Usuario usuario) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            String sql = "select * from Torneio join Permissao ON Permissao.codTorneio = Torneio.idTorneio "
                    + "where Permissao.codUsuario = " + usuario.getId() + " ;";
            List<Torneio> list = session.createSQLQuery(sql).addEntity(Torneio.class).list();
            sql = "select * from Torneio join InscricaoEquipe ON InscricaoEquipe.codTorneio = Torneio.idTorneio "
                    + "join Permissao ON Permissao.codInscricaoEquipe = InscricaoEquipe.idInscricaoEquipe "
                    + "where Permissao.codUsuario = " + usuario.getId() + ";";
            list.addAll(session.createSQLQuery(sql).addEntity(Torneio.class).list());
            transaction.commit();
            return list;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar o torneio. Erro: " + hibernateException.getMessage());
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
                .forRevisionsOfEntity(Torneio.class, false, true);
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
