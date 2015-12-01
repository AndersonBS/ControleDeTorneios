/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
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
import org.hibernate.envers.Audited;

/**
 *
 * @author 272273
 */

@Entity
@Table(name = "Permissao")
@Audited
public class Permissao implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idPermissao")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codUsuario")
    private Usuario usuario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipe")
    private InscricaoEquipe inscricaoEquipe;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codTorneio")
    private Torneio torneio;
    
    public Permissao() {
        
    }

    public Permissao(Usuario usuario, InscricaoEquipe inscricaoEquipe, Torneio torneio) {
        this.usuario = usuario;
        this.inscricaoEquipe = inscricaoEquipe;
        this.torneio = torneio;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public InscricaoEquipe getInscricaoEquipe() {
        return inscricaoEquipe;
    }

    public Torneio getTorneio() {
        return torneio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setInscricaoEquipe(InscricaoEquipe inscricaoEquipe) {
        this.inscricaoEquipe = inscricaoEquipe;
    }

    public void setTorneio(Torneio torneio) {
        this.torneio = torneio;
    }
    
}
