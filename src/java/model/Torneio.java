/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author 272273
 */

@Entity
@Table(name = "Torneio")
public class Torneio {
    
    @Id
    @GeneratedValue
    @Column(name = "idTorneio")
    private int id;
    
    @Column(name = "inicioRealizacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioRealizacao;
    
    @Column(name = "finalRealizacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date finalRealizacao;
    
    @Column(name = "frequenciaPartidas")
    private int frequenciaPartidas; //(1 ou 2 por semana)
    
    @Column(name = "inicioInscricoes")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioInscricoes;
    
    @Column(name = "finalInscricoes")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date finalInscricoes;
    
    @Column(name = "nomeDoTorneio")
    private String nomeDoTorneio; //nome do torneio
    
    @Column(name = "nomeDoResponsavel")
    private String nomeDoResponsavel;
    
    @Column(name = "enderecoWeb")
    private String enderecoWeb;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "custoPorJogador")
    private float custoPorJogador;
    
    @Column(name = "numeroMinimoJogadores")
    private int numeroMinimoJogadores;
    
    @Column(name = "numeroMaximoJogadores")
    private int numeroMaximoJogadores;
    
    @Column(name = "numeroEquipes")
    private int numeroEquipes;
    
    public Torneio() {
        
    }

    public Torneio(int id, Date inicioRealizacao, Date finalRealizacao, int frequenciaPartidas, Date inicioInscricoes, Date finalInscricoes, String nomeDoTorneio, String nomeDoResponsavel, String enderecoWeb, String email, float custoPorJogador, int numeroMinimoJogadores, int numeroMaximoJogadores, int numeroEquipes) {
        this.id = id;
        this.inicioRealizacao = inicioRealizacao;
        this.finalRealizacao = finalRealizacao;
        this.frequenciaPartidas = frequenciaPartidas;
        this.inicioInscricoes = inicioInscricoes;
        this.finalInscricoes = finalInscricoes;
        this.nomeDoTorneio = nomeDoTorneio;
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

    public int getFrequenciaPartidas() {
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

    public int getNumeroMinimoJogadores() {
        return numeroMinimoJogadores;
    }

    public int getNumeroMaximoJogadores() {
        return numeroMaximoJogadores;
    }

    public int getNumeroEquipes() {
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

    public void setFrequenciaPartidas(int frequenciaPartidas) {
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

    public void setNumeroMinimoJogadores(int numeroMinimoJogadores) {
        this.numeroMinimoJogadores = numeroMinimoJogadores;
    }

    public void setNumeroMaximoJogadores(int numeroMaximoJogadores) {
        this.numeroMaximoJogadores = numeroMaximoJogadores;
    }

    public void setNumeroEquipes(int numeroEquipes) {
        this.numeroEquipes = numeroEquipes;
    }

    
    
}
