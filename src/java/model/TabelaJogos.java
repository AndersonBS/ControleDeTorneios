/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@Table(name = "TabelaJogos")
@Audited
public class TabelaJogos implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idTabelaJogos")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    private Torneio torneio;
    
    @Column(name = "numeroRodada")
    private int numeroRodada;
    
    @Column(name = "dataPartida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPartida;
    
    @Column(name = "localPartida")
    private String localPartida;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipeCasa")
    private InscricaoEquipe inscricaoEquipeCasa;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipeVisitante")
    private InscricaoEquipe inscricaoEquipeVisitante;
    
    @Column(name = "placarEquipeCasa")
    private int placarEquipeCasa;
    
    @Column(name = "placarEquipeVisitante")
    private int placarEquipeVisitante;

    public TabelaJogos() {
        
    }

    public TabelaJogos(Torneio torneio, int numeroRodada, Date dataPartida, String localPartida, InscricaoEquipe inscricaoEquipeCasa, InscricaoEquipe inscricaoEquipeVisitante, int placarEquipeCasa, int placarEquipeVisitante) {
        this.torneio = torneio;
        this.numeroRodada = numeroRodada;
        this.dataPartida = dataPartida;
        this.localPartida = localPartida;
        this.inscricaoEquipeCasa = inscricaoEquipeCasa;
        this.inscricaoEquipeVisitante = inscricaoEquipeVisitante;
        this.placarEquipeCasa = placarEquipeCasa;
        this.placarEquipeVisitante = placarEquipeVisitante;
    }

    public int getId() {
        return id;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public int getNumeroRodada() {
        return numeroRodada;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public InscricaoEquipe getInscricaoEquipeCasa() {
        return inscricaoEquipeCasa;
    }

    public InscricaoEquipe getInscricaoEquipeVisitante() {
        return inscricaoEquipeVisitante;
    }

    public int getPlacarEquipeCasa() {
        return placarEquipeCasa;
    }

    public int getPlacarEquipeVisitante() {
        return placarEquipeVisitante;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }

    public void setNumeroRodada(int numeroRodada) {
        this.numeroRodada = numeroRodada;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public void setInscricaoEquipeCasa(InscricaoEquipe inscricaoEquipeCasa) {
        this.inscricaoEquipeCasa = inscricaoEquipeCasa;
    }

    public void setInscricaoEquipeVisitante(InscricaoEquipe inscricaoEquipeVisitante) {
        this.inscricaoEquipeVisitante = inscricaoEquipeVisitante;
    }

    public void setPlacarEquipeCasa(int placarEquipeCasa) {
        this.placarEquipeCasa = placarEquipeCasa;
    }

    public void setPlacarEquipeVisitante(int placarEquipeVisitante) {
        this.placarEquipeVisitante = placarEquipeVisitante;
    }
        
}
