/*
 * Copyright (C) 2015 anderson
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package model;

import java.util.Date;


/**
 *
 * @author anderson
 */

public class Jogador_AUD {
    
    private Jogador jogador;
    private int REV;
    private int REVTYPE;
    private InscricaoEquipe inscricaoEquipe;
    private Posicao posicao;
    private String nomeCompleto;
    private long cpf;
    private Date dataNascimento;
    private Date dataCadastro;
    private String email;
    private float altura;
    private float peso;
    private String pais;

    public Jogador_AUD() {
        
    }

    public Jogador_AUD(Jogador jogador, int REV, int REVTYPE, InscricaoEquipe inscricaoEquipe, Posicao posicao, String nomeCompleto, long cpf, Date dataNascimento, Date dataCadastro, String email, float altura, float peso, String pais) {
        this.jogador = jogador;
        this.REV = REV;
        this.REVTYPE = REVTYPE;
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
    }

    public Jogador getJogador() {
        return jogador;
    }

    public int getREV() {
        return REV;
    }

    public int getREVTYPE() {
        return REVTYPE;
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

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setREV(int REV) {
        this.REV = REV;
    }

    public void setREVTYPE(int REVTYPE) {
        this.REVTYPE = REVTYPE;
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

}
