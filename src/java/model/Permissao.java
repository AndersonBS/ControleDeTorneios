/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 272273
 */

@Entity
@Table(name = "Permissao")
public class Permissao {
    
    @Id
    @GeneratedValue
    @Column(name = "idPosicao")
    private int id;
    
    // many -1
    @Column(name = "usuario")
    private Usuario usuario;
    
    // many -1
    @Column(name = "inscricaoEquipe")
    private InscricaoEquipe inscricaoEquipe;
    
    // many -1
    @Column(name = "torneio")
    private Torneio torneio;
    
    public Permissao() {
        
    }

    public Permissao(int id, Usuario usuario, InscricaoEquipe inscricaoEquipe, Torneio torneio) {
        this.id = id;
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
