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
@Table(name = "jogador")
public class Jogador {
    
    @Id
    @GeneratedValue
    @Column(name = "idJogador")
    private int id;
    
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
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "equipe")
    private String equipe;
    
    @Column(name = "posicao")
    private String posicao;
    
    public Jogador() {
        
    }

    public Jogador(String nome, long cpf, Date dataNascimento, Date dataCadastro, String email, String telefone, String equipe, String posicao) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.email = email;
        this.telefone = telefone;
        this.equipe = equipe;
        this.posicao = posicao;
    }
    
    public int getId() {
        return id;
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

    public String getTelefone() {
        return telefone;
    }

    public String getEquipe() {
        return equipe;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    
}
