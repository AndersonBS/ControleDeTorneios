/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.type.EnumType;

/**
 *
 * @author anderson
 */

@Entity
@Table(name = "InscricaoEquipe")
public class InscricaoEquipe {
   
    @Id
    @GeneratedValue
    @Column(name = "idInscricaoEquipe")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    @Cascade(CascadeType.ALL)
    private Torneio torneio;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "statusInscricao")
    private String statusInscricao;
    
    @Column(name = "fechamentoInscricao")
    private boolean fechamentoInscricao;
    
    @Column(name = "precoTotalInscricao")
    private float precoTotalInscricao;
    
    @Column(name = "dataFundacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFundacao;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "enderecoWeb")
    private String enderecoWeb;
    
    @Column(name = "fone")
    private String fone;
    
    @Column(name = "endereco")
    private String logradouro;
    
    @Column(name = "cep")
    private String cep;
    
    @Column(name = "cidade")
    private String cidade;

    public InscricaoEquipe() {
        
    }

    public InscricaoEquipe(int id, Torneio torneio, String nome, String statusInscricao, boolean fechamentoInscricao, float precoTotalInscricao, Date dataFundacao, String email, String enderecoWeb, String fone, String logradouro, String cep, String cidade) {
        this.id = id;
        this.torneio = torneio;
        this.nome = nome;
        this.statusInscricao = statusInscricao;
        this.fechamentoInscricao = fechamentoInscricao;
        this.precoTotalInscricao = precoTotalInscricao;
        this.dataFundacao = dataFundacao;
        this.email = email;
        this.enderecoWeb = enderecoWeb;
        this.fone = fone;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public String getNome() {
        return nome;
    }

    public String getStatusInscricao() {
        return statusInscricao;
    }

    public boolean isFechamentoInscricao() {
        return fechamentoInscricao;
    }

    public float getPrecoTotalInscricao() {
        return precoTotalInscricao;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public String getEmail() {
        return email;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public String getFone() {
        return fone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatusInscricao(String statusInscricao) {
        this.statusInscricao = statusInscricao;
    }

    public void setFechamentoInscricao(boolean fechamentoInscricao) {
        this.fechamentoInscricao = fechamentoInscricao;
    }

    public void setPrecoTotalInscricao(float precoTotalInscricao) {
        this.precoTotalInscricao = precoTotalInscricao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}
