/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

/**
 *
 * @author anderson
 */

@Entity
@Table(name = "InscricaoEquipe")
public class InscricaoEquipe implements Serializable {
   
    @Id
    @GeneratedValue
    @Column(name = "idInscricaoEquipe")
    @Audited
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    @Audited
    private Torneio torneio;
    
    @Column(name = "nomeDaEquipe")
    @Audited
    private String nomeDaEquipe;
    
    @Column(name = "statusInscricao")
    @Audited
    private String statusInscricao; //(em preenchimento, finalizada e paga)
    
    @Column(name = "fechamentoInscricao")
    @Audited
    private boolean fechamentoInscricao;
    
    @Column(name = "precoTotalInscricao") //calculado quando confirmada
    @Audited
    private float precoTotalInscricao;
    
    @Column(name = "dataFundacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Audited
    private Date dataFundacao;
    
    @Column(name = "email")
    @Audited
    private String email;
    
    @Column(name = "enderecoWeb")
    @Audited
    private String enderecoWeb;
    
    @Column(name = "telefone")
    @Audited
    private String telefone;
    
    @Column(name = "logradouro")
    @Audited
    private String logradouro;
    
    @Column(name = "numeroDaResidencia")
    @Audited
    private int numeroDaResidencia;
    
    @Column(name = "complemento")
    @Audited
    private String complemento;
    
    @Column(name = "cidade")
    @Audited
    private String cidade;
    
    @Column(name = "cep")
    @Audited
    private long cep;
    
    @Column(name = "logo")
    @Lob
    private byte[] logo;

    public InscricaoEquipe() {
        
    }

    public InscricaoEquipe(Torneio torneio, String nomeDaEquipe, String statusInscricao, boolean fechamentoInscricao, float precoTotalInscricao, Date dataFundacao, String email, String enderecoWeb, String telefone, String logradouro, int numeroDaResidencia, String complemento, String cidade, long cep, byte[] logo) {
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
        this.cidade = cidade;
        this.cep = cep;
        this.logo = logo;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
}
