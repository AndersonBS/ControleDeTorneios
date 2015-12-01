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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

/**
 *
 * @author 272273
 */

@Entity
@Table(name = "Torneio")
@Audited
public class Torneio implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idTorneio")
    private int id;
    
    @Column(name = "nomeDoTorneio")
    private String nomeDoTorneio;
    
    @Column(name = "inicioRealizacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioRealizacao;
    
    @Column(name = "finalRealizacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date finalRealizacao;
    
    @Column(name = "frequenciaPartidas")
    private byte frequenciaPartidas; //(1 ou 2 por semana)
    
    @Column(name = "inicioInscricoes")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioInscricoes;
    
    @Column(name = "finalInscricoes")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date finalInscricoes;
    
    @Column(name = "nomeDoResponsavel")
    private String nomeDoResponsavel;
    
    @Column(name = "enderecoWeb")
    private String enderecoWeb;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "custoPorJogador")
    private float custoPorJogador;
    
    @Column(name = "numeroMinimoJogadores")
    private byte numeroMinimoJogadores;
    
    @Column(name = "numeroMaximoJogadores")
    private byte numeroMaximoJogadores;
    
    @Column(name = "numeroEquipes")
    private byte numeroEquipes;
    
    public Torneio() {
        
    }

    public Torneio(String nomeDoTorneio, Date inicioRealizacao, Date finalRealizacao, byte frequenciaPartidas, Date inicioInscricoes, Date finalInscricoes, String nomeDoResponsavel, String enderecoWeb, String email, float custoPorJogador, byte numeroMinimoJogadores, byte numeroMaximoJogadores, byte numeroEquipes) {
        this.nomeDoTorneio = nomeDoTorneio;
        this.inicioRealizacao = inicioRealizacao;
        this.finalRealizacao = finalRealizacao;
        this.frequenciaPartidas = frequenciaPartidas;
        this.inicioInscricoes = inicioInscricoes;
        this.finalInscricoes = finalInscricoes;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.enderecoWeb = enderecoWeb;
        this.email = email;
        this.custoPorJogador = custoPorJogador;
        this.numeroMinimoJogadores = numeroMinimoJogadores;
        this.numeroMaximoJogadores = numeroMaximoJogadores;
        this.numeroEquipes = numeroEquipes;
    }

    public int getId() {
        return id;
    }

    public Date getInicioRealizacao() {
        return inicioRealizacao;
    }

    public Date getFinalRealizacao() {
        return finalRealizacao;
    }

    public byte getFrequenciaPartidas() {
        return frequenciaPartidas;
    }

    public Date getInicioInscricoes() {
        return inicioInscricoes;
    }

    public Date getFinalInscricoes() {
        return finalInscricoes;
    }

    public String getNomeDoTorneio() {
        return nomeDoTorneio;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public String getEmail() {
        return email;
    }

    public float getCustoPorJogador() {
        return custoPorJogador;
    }

    public byte getNumeroMinimoJogadores() {
        return numeroMinimoJogadores;
    }

    public byte getNumeroMaximoJogadores() {
        return numeroMaximoJogadores;
    }

    public byte getNumeroEquipes() {
        return numeroEquipes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInicioRealizacao(Date inicioRealizacao) {
        this.inicioRealizacao = inicioRealizacao;
    }

    public void setFinalRealizacao(Date finalRealizacao) {
        this.finalRealizacao = finalRealizacao;
    }

    public void setFrequenciaPartidas(byte frequenciaPartidas) {
        this.frequenciaPartidas = frequenciaPartidas;
    }

    public void setInicioInscricoes(Date inicioInscricoes) {
        this.inicioInscricoes = inicioInscricoes;
    }

    public void setFinalInscricoes(Date finalInscricoes) {
        this.finalInscricoes = finalInscricoes;
    }

    public void setNomeDoTorneio(String nomeDoTorneio) {
        this.nomeDoTorneio = nomeDoTorneio;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustoPorJogador(float custoPorJogador) {
        this.custoPorJogador = custoPorJogador;
    }

    public void setNumeroMinimoJogadores(byte numeroMinimoJogadores) {
        this.numeroMinimoJogadores = numeroMinimoJogadores;
    }

    public void setNumeroMaximoJogadores(byte numeroMaximoJogadores) {
        this.numeroMaximoJogadores = numeroMaximoJogadores;
    }

    public void setNumeroEquipes(byte numeroEquipes) {
        this.numeroEquipes = numeroEquipes;
    }

    
    
}
