/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.envers.Audited;

/**
 *
 * @author anderson
 */

@Entity
@Table(name = "InscricaoEquipe")
@Audited
public class InscricaoEquipe {
   
    @Id
    @GeneratedValue
    @Column(name = "idInscricaoEquipe")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    @Cascade(CascadeType.ALL)
    private Torneio torneio;
    
    @Column(name = "nomeDaEquipe")
    private String nomeDaEquipe;
    
    @Column(name = "statusInscricao")
    private String statusInscricao; //(em preenchimento, confirmada e paga)
    
    @Column(name = "fechamentoInscricao")
    private boolean fechamentoInscricao;
    
    @Column(name = "precoTotalInscricao") //calculado quando confirmada
    private float precoTotalInscricao;
    
    @Column(name = "dataFundacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFundacao;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "enderecoWeb")
    private String enderecoWeb;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "logradouro")
    private String logradouro;
    
    @Column(name = "numeroDaResidencia")
    private int numeroDaResidencia;
    
    @Column(name = "complemento")
    private String complemento;
    
    @Column(name = "cidade")
    private String cidade;
    
    @Column(name = "cep")
    private long cep;

    public InscricaoEquipe() {
        
    }

    public InscricaoEquipe(int id, Torneio torneio, String nomeDaEquipe, String statusInscricao, boolean fechamentoInscricao, float precoTotalInscricao, Date dataFundacao, String email, String enderecoWeb, String telefone, String logradouro, int numeroDaResidencia, String complemento, long cep, String cidade) {
        this.id = id;
        this.torneio = torneio;
        this.nomeDaEquipe = nomeDaEquipe;
        this.statusInscricao = statusInscricao;
        this.fechamentoInscricao = fechamentoInscricao;
        this.precoTotalInscricao = precoTotalInscricao;
        this.dataFundacao = dataFundacao;
        this.email = email;
        this.enderecoWeb = enderecoWeb;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numeroDaResidencia = numeroDaResidencia;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public String getNomeDaEquipe() {
        return nomeDaEquipe;
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

    public String getTelefone() {
        return telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumeroDaResidencia() {
        return numeroDaResidencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public long getCep() {
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

    public void setNomeDaEquipe(String nomeDaEquipe) {
        this.nomeDaEquipe = nomeDaEquipe;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumeroDaResidencia(int numeroDaResidencia) {
        this.numeroDaResidencia = numeroDaResidencia;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
