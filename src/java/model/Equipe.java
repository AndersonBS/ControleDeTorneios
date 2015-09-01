/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author anderson
 */
public class Equipe {
   
    private int id;
    private String nome;
    private Date dataFundacao;
    private String email;
    private String enderecoWeb;
    private String fone;

    public Equipe() {
        
    }
    
    public Equipe(String nome, Date dataFundacao, String email, String enderecoWeb, String fone) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.email = email;
        this.enderecoWeb = enderecoWeb;
        this.fone = fone;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public String getEmail() {
        return email;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public String getFone() {
        return fone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
}
