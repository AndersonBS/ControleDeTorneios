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
 * @author anderson
 */

@Entity
@Table(name = "Jogador")
public class Jogador {
    
    @Id
    @GeneratedValue
    @Column(name = "idJogador")
    private int id;
    
    // many -1
    @Column(name = "inscricaoEquipe")
    private InscricaoEquipe inscricaoEquipe;
    
    // many -1
    @Column(name = "posicao")
    private Posicao posicao;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "cpf")
    private long cpf;
    
    @Column(name = "dataNascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "dataCadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "altura")
    private float altura;
    
    @Column(name = "peso")
    private float peso;
    
    @Column(name = "pais")
    private String pais;
    
    public Jogador() {
        
    }

    public Jogador(int id, InscricaoEquipe inscricaoEquipe, Posicao posicao, String nome, long cpf, Date dataNascimento, Date dataCadastro, String email, float altura, float peso, String pais) {
        this.id = id;
        this.inscricaoEquipe = inscricaoEquipe;
        this.posicao = posicao;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.email = email;
        this.altura = altura;
        this.peso = peso;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public InscricaoEquipe getInscricaoEquipe() {
        return inscricaoEquipe;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getEmail() {
        return email;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public String getPais() {
        return pais;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInscricaoEquipe(InscricaoEquipe inscricaoEquipe) {
        this.inscricaoEquipe = inscricaoEquipe;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
