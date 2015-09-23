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
@Table(name = "Posicao")
public class Posicao {
    
    @Id
    @GeneratedValue
    @Column(name = "idPosicao")
    private int id;
    
    @Column(name = "nome")
    private String nome;
    
    public Posicao() {
        
    }

    public Posicao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}