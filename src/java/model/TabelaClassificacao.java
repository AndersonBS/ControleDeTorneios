/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author anderson
 */

@Entity
@Table(name = "TabelaClassificacao")
public class TabelaClassificacao {
    
    @Id
    @GeneratedValue
    @Column(name = "idTabelaClassificacao")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    @Cascade(CascadeType.ALL)
    private Torneio torneio;
    
    @Column(name = "classificacao")
    private int classificacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipe")
    @Cascade(CascadeType.ALL)
    private InscricaoEquipe inscricaoEquipe;
    
    @Column(name = "numeroJogos")
    private int numeroJogos;
    
    @Column(name = "numeroVitorias")
    private int numeroVitorias;
    
    @Column(name = "numeroEmpates")
    private int numeroEmpates;
    
    @Column(name = "numeroDerrotas")
    private int numeroDerrotas;
    
    @Column(name = "numeroGolsMarcados")
    private int numeroGolsMarcados;
    
    @Column(name = "numeroGolsSofridos")
    private int numeroGolsSofridos;
    
    @Column(name = "saldoGols")
    private int saldoGols;
    
    @Column(name = "percentualAproveitamento")
    private int percentualAproveitamento;

    public TabelaClassificacao() {
        
    }
    
    public TabelaClassificacao(int id, Torneio torneio, int classificacao, InscricaoEquipe inscricaoEquipe, int numeroJogos, int numeroVitorias, int numeroEmpates, int numeroDerrotas, int numeroGolsMarcados, int numeroGolsSofridos, int saldoGols, int percentualAproveitamento) {
        this.id = id;
        this.torneio = torneio;
        this.classificacao = classificacao;
        this.inscricaoEquipe = inscricaoEquipe;
        this.numeroJogos = numeroJogos;
        this.numeroVitorias = numeroVitorias;
        this.numeroEmpates = numeroEmpates;
        this.numeroDerrotas = numeroDerrotas;
        this.numeroGolsMarcados = numeroGolsMarcados;
        this.numeroGolsSofridos = numeroGolsSofridos;
        this.saldoGols = saldoGols;
        this.percentualAproveitamento = percentualAproveitamento;
    }

    public int getId() {
        return id;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public InscricaoEquipe getInscricaoEquipe() {
        return inscricaoEquipe;
    }

    public int getNumeroJogos() {
        return numeroJogos;
    }

    public int getNumeroVitorias() {
        return numeroVitorias;
    }

    public int getNumeroEmpates() {
        return numeroEmpates;
    }

    public int getNumeroDerrotas() {
        return numeroDerrotas;
    }

    public int getNumeroGolsMarcados() {
        return numeroGolsMarcados;
    }

    public int getNumeroGolsSofridos() {
        return numeroGolsSofridos;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public int getPercentualAproveitamento() {
        return percentualAproveitamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void setInscricaoEquipe(InscricaoEquipe inscricaoEquipe) {
        this.inscricaoEquipe = inscricaoEquipe;
    }

    public void setNumeroJogos(int numeroJogos) {
        this.numeroJogos = numeroJogos;
    }

    public void setNumeroVitorias(int numeroVitorias) {
        this.numeroVitorias = numeroVitorias;
    }

    public void setNumeroEmpates(int numeroEmpates) {
        this.numeroEmpates = numeroEmpates;
    }

    public void setNumeroDerrotas(int numeroDerrotas) {
        this.numeroDerrotas = numeroDerrotas;
    }

    public void setNumeroGolsMarcados(int numeroGolsMarcados) {
        this.numeroGolsMarcados = numeroGolsMarcados;
    }

    public void setNumeroGolsSofridos(int numeroGolsSofridos) {
        this.numeroGolsSofridos = numeroGolsSofridos;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

    public void setPercentualAproveitamento(int percentualAproveitamento) {
        this.percentualAproveitamento = percentualAproveitamento;
    }
    
}
