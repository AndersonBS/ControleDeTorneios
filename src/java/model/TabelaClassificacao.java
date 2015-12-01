/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author anderson
 */

@Entity
@Table(name = "TabelaClassificacao")
@Audited
public class TabelaClassificacao implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idTabelaClassificacao")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    private Torneio torneio;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipe")
    private InscricaoEquipe inscricaoEquipe;
    
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
    
    public TabelaClassificacao() {
        
    }

    public TabelaClassificacao(Torneio torneio, InscricaoEquipe inscricaoEquipe, int numeroVitorias, int numeroEmpates, int numeroDerrotas, int numeroGolsMarcados, int numeroGolsSofridos) {
        this.torneio = torneio;
        this.inscricaoEquipe = inscricaoEquipe;
        this.numeroVitorias = numeroVitorias;
        this.numeroEmpates = numeroEmpates;
        this.numeroDerrotas = numeroDerrotas;
        this.numeroGolsMarcados = numeroGolsMarcados;
        this.numeroGolsSofridos = numeroGolsSofridos;
    }
    
    public int getPontos() {
        return numeroVitorias * 3 + numeroEmpates;
    }
    
    public int getNumeroJogos() {
        return numeroVitorias + numeroEmpates + numeroDerrotas;
    }
    
    public int getSaldoGols() {
        return numeroGolsMarcados - numeroGolsSofridos;
    }
    
    public int getPercentualAproveitamento() {
        return (int) (33.333333334 / getNumeroJogos() * getPontos());
    }

    public int getId() {
        return id;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public InscricaoEquipe getInscricaoEquipe() {
        return inscricaoEquipe;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public void setInscricaoEquipe(InscricaoEquipe inscricaoEquipe) {
        this.inscricaoEquipe = inscricaoEquipe;
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

    
}
