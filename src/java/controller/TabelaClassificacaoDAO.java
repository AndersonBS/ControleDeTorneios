/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.Auditoria;
import model.InscricaoEquipe;
import model.TabelaClassificacao;
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
public class TabelaClassificacaoDAO {
    
    public boolean save(List<TabelaClassificacao> tabelaClassificacao) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            for (TabelaClassificacao objeto: tabelaClassificacao) {
                session.merge(objeto);
            }
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível inserir a tabela de classificação. Erro: " + hibernateException.getMessage());
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
            System.out.println("Não foi possível alterar a tabela de classificação. Erro: " + hibernateException.getMessage());
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
            System.out.println("Não foi possível apagar a tabela de classificação. Erro: " + hibernateException.getMessage());
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
    
    public boolean delete(List<TabelaClassificacao> tabelaClassificacoes) {
        Session session = null;
        Transaction transaction = null;
        boolean success = false;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            for (TabelaClassificacao tabelaClassificacao: tabelaClassificacoes) {
                session.delete(tabelaClassificacao);
            }
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar a tabela de classificação. Erro: " + hibernateException.getMessage());
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
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("delete from TabelaClassificacao where codTorneio = :parametro");
            query.setInteger("parametro", torneio.getId());
            query.executeUpdate();
            transaction.commit();
            success = true;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível apagar a tabela de classificação. Erro: " + hibernateException.getMessage());
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

    public List<TabelaClassificacao> retrieve() {
        Session session = null;
        Transaction transaction = null;
        Query query;
        List<TabelaClassificacao> result;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from TabelaClassificacao");
            result = query.list();
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar as tabelas de classificação. Erro: " + hibernateException.getMessage());
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

    public TabelaClassificacao retrieve(int idTabelaClassificacao) {
        TabelaClassificacao tabelaClassificacao;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(TabelaClassificacao.class);
            criteria.add(Restrictions.eq("id", idTabelaClassificacao));
            tabelaClassificacao = (TabelaClassificacao) criteria.uniqueResult();
            transaction.commit();
            return tabelaClassificacao;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a tabela de classificação. Erro: " + hibernateException.getMessage());
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
    
    public TabelaClassificacao retrieve(InscricaoEquipe inscricaoEquipe) {
        TabelaClassificacao tabelaClassificacao;
        Session session = null;
        Transaction transaction = null;
        Query query;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from TabelaClassificacao where codInscricaoEquipe = :parametro");
            query.setInteger("parametro", inscricaoEquipe.getId());
            tabelaClassificacao = (TabelaClassificacao) query.uniqueResult();
            transaction.commit();
            return tabelaClassificacao;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar a tabela de classificação. Erro: " + hibernateException.getMessage());
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
    
    public List<TabelaClassificacao> retrieve(Torneio torneio) {
        Session session = null;
        Transaction transaction = null;
        Query query;
        List<TabelaClassificacao> result;

        try {
            session = Conexao.getSession();
            transaction = session.beginTransaction();
            query = session.createQuery("from TabelaClassificacao where torneio.id = :parametro");
            query.setInteger("parametro", torneio.getId());
            result = query.list();
            Collections.sort(result, (TabelaClassificacao  tc1, TabelaClassificacao  tc2) -> {
                if (Integer.compare(tc1.getPontos(), tc2.getPontos()) != 0) {
                    return Integer.compare(tc2.getPontos(), tc1.getPontos());
                } else if (Integer.compare(tc1.getNumeroVitorias(), tc2.getNumeroVitorias()) != 0) {
                    return Integer.compare(tc2.getNumeroVitorias(), tc1.getNumeroVitorias());
                } else if (Integer.compare(tc1.getSaldoGols(), tc2.getSaldoGols()) != 0) {
                    return Integer.compare(tc2.getSaldoGols(), tc1.getSaldoGols());
                }
                return Integer.compare(tc2.getNumeroGolsMarcados(), tc1.getNumeroGolsMarcados());
            });
            transaction.commit();
            return result;
        } catch (HibernateException hibernateException) {
            System.out.println("Não foi possível recuperar as tabelas de classificação. Erro: " + hibernateException.getMessage());
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
                .forRevisionsOfEntity(TabelaClassificacao.class, false, true);
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
