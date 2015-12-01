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
import model.Torneio;
import model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.query.AuditQuery;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;

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
            System.out.println("Não foi possível inserir a inscrição da equipe. Erro: " + hibernateException.getMessage());
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
            System.out.println("Não foi possível alterar a inscrição da equipe. Erro: " + hibernateException.getMessage());
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

    public boolean delete(InscricaoEquipe inscricaoEquipe) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            JogadorDAO jogadorDAO = new JogadorDAO();
            jogadorDAO.delete(jogadorDAO.retrieve(inscricaoEquipe));
            
            PermissaoDAO permissaoDAO = new PermissaoDAO();
            permissaoDAO.delete(permissaoDAO.retrieve(inscricaoEquipe));
            
            TabelaClassificacaoDAO tabelaClassificacaoDAO = new TabelaClassificacaoDAO();
            tabelaClassificacaoDAO.delete(tabelaClassificacaoDAO.retrieve(inscricaoEquipe));

            TabelaJogosDAO tabelaJogosDAO = new TabelaJogosDAO();
            tabelaJogosDAO.delete(tabelaJogosDAO.retrieve(inscricaoEquipe));
            
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            session.delete(inscricaoEquipe);
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar a inscrição da equipe. Erro: " + hibernateException.getMessage());
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
    
    public boolean delete(List<InscricaoEquipe> inscricaoEquipes) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            for (InscricaoEquipe inscricaoEquipe: inscricaoEquipes) {
                JogadorDAO jogadorDAO = new JogadorDAO();
                jogadorDAO.delete(jogadorDAO.retrieve(inscricaoEquipe));

                PermissaoDAO permissaoDAO = new PermissaoDAO();
                permissaoDAO.delete(permissaoDAO.retrieve(inscricaoEquipe));
                
                TabelaClassificacaoDAO tabelaClassificacaoDAO = new TabelaClassificacaoDAO();
                tabelaClassificacaoDAO.delete(tabelaClassificacaoDAO.retrieve(inscricaoEquipe));
                
                TabelaJogosDAO tabelaJogosDAO = new TabelaJogosDAO();
                tabelaJogosDAO.delete(tabelaJogosDAO.retrieve(inscricaoEquipe));
            }
            
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            for (InscricaoEquipe inscricaoEquipe: inscricaoEquipes) {
                session.delete(inscricaoEquipe);
            }
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar a inscrição da equipe. Erro: " + hibernateException.getMessage());
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

    public List<InscricaoEquipe> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query;
        List<InscricaoEquipe> result;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from InscricaoEquipe");
            result = query.list();
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

    public InscricaoEquipe retrieve(int idInscricaoEquipe) {
        InscricaoEquipe inscricaoEquipe;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(InscricaoEquipe.class);
            criteria.add(Restrictions.eq("id", idInscricaoEquipe));
            inscricaoEquipe = (InscricaoEquipe) criteria.uniqueResult();
            transaction.commit();
            return inscricaoEquipe;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a inscrição da equipe. Erro: " + hibernateException.getMessage());
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
    
    public List<InscricaoEquipe> retrieve(Torneio torneio) {
        List<InscricaoEquipe> result;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from InscricaoEquipe where torneio.id = :parametro");
            query.setInteger("parametro", torneio.getId());
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a inscrição da equipe. Erro: " + hibernateException.getMessage());
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
    
    public List<InscricaoEquipe> retrieve(Usuario usuario, Torneio torneio) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            String sql = "select * from InscricaoEquipe " +
                "join Permissao ON InscricaoEquipe.idInscricaoEquipe = Permissao.codInscricaoEquipe " +
                "join Usuario ON Usuario.idUsuario = Permissao.codUsuario " +
                "where Usuario.idUsuario = " + usuario.getId() + 
                " AND InscricaoEquipe.codTorneio = " + torneio.getId() + " ;";
            List<InscricaoEquipe> list = session.createSQLQuery(sql).addEntity(InscricaoEquipe.class).list();
            transaction.commit();
            return list;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a inscrição da equipe. Erro: " + hibernateException.getMessage());
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
                .forRevisionsOfEntity(InscricaoEquipe.class, false, true);
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
