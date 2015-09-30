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

/**
 *
 * @author anderson
 */

@Entity
@Table(name = "TabelaJogos")
public class TabelaJogos {
    
    @Id
    @GeneratedValue
    @Column(name = "idTabelaJogos")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    @Cascade(CascadeType.ALL)
    private Torneio torneio;
    
    @Column(name = "numeroRodada")
    private long numeroRodada;
    
    @Column(name = "dataPartida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPartida;
    
    @Column(name = "localPartida")
    private String localPartida;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipeCasa")
    @Cascade(CascadeType.ALL)
    private InscricaoEquipe inscricaoEquipeCasa;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipeVisitante")
    @Cascade(CascadeType.ALL)
    private InscricaoEquipe inscricaoEquipeVisitante;
    
    @Column(name = "placarEquipeCasa")
    private int placarEquipeCasa;
    
    @Column(name = "placarEquipeVisitante")
    private int placarEquipeVisitante;

    public TabelaJogos() {
        
    }
    
    public TabelaJogos(int id, Torneio torneio, long numeroRodada, Date dataPartida, String localPartida, InscricaoEquipe inscricaoEquipeCasa, InscricaoEquipe inscricaoEquipeVisitante, int placarEquipeCasa, int placarEquipeVisitante) {
        this.id = id;
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

    public long getNumeroRodada() {
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

    public void setNumeroRodada(long numeroRodada) {
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
