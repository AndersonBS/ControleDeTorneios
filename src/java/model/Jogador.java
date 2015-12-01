/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;


/**
 *
 * @author anderson
 */

@Entity
@Table(name = "Jogador")
public class Jogador implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idJogador")
    @Audited
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codInscricaoEquipe")
    @Audited
    private InscricaoEquipe inscricaoEquipe;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codPosicao")
    @Audited
    private Posicao posicao;
    
    @Column(name = "nomeCompleto")
    @Audited
    private String nomeCompleto;
    
    @Column(name = "cpf")
    @Audited
    private long cpf;
    
    @Column(name = "dataNascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Audited
    private Date dataNascimento;
    
    @Column(name = "dataCadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Audited
    private Date dataCadastro;
    
    @Column(name = "email")
    @Audited
    private String email;
    
    @Column(name = "altura")
    @Audited
    private float altura;
    
    @Column(name = "peso")
    @Audited
    private float peso;
    
    @Column(name = "pais")
    @Audited
    private String pais;
    
    @Column(name = "logo")
    @Lob
    private byte[] foto;
    
    public Jogador() {
        
    }

    public Jogador(InscricaoEquipe inscricaoEquipe, Posicao posicao, String nomeCompleto, long cpf, Date dataNascimento, Date dataCadastro, String email, float altura, float peso, String pais, byte[] foto) {
        this.inscricaoEquipe = inscricaoEquipe;
        this.posicao = posicao;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.email = email;
        this.altura = altura;
        this.peso = peso;
        this.pais = pais;
        this.foto = foto;
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

    public String getNomeCompleto() {
        return nomeCompleto;
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

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getFoto() {
        return foto;
    }

}
