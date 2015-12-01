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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

/**
 *
 * @author 272273
 */

@Entity
@Table(name = "Usuario")
@Audited
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "idUsuario")
    private int id;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "senha")
    private String senha;
    
    @Column(name = "dataCadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @Column(name = "nomeCompleto")
    private String nomeCompleto;
    
    public Usuario() {
        
    }

    public Usuario(String login, String senha, Date dataCadastro, String nomeCompleto) {
        this.login = login;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.nomeCompleto = nomeCompleto;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

}
