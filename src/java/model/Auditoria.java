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
public class Auditoria {
    
    private Date data;
    private int revisao;
    private String operacao;
    private Object classe;
    
    public Auditoria() {
        
    }

    public Auditoria(Date data, int revisao, String operacao, Object classe) {
        this.data = data;
        this.revisao = revisao;
        this.operacao = operacao;
        this.classe = classe;
    }

    public Date getData() {
        return data;
    }

    public int getRevisao() {
        return revisao;
    }

    public String getOperacao() {
        return operacao;
    }

    public Object getClasse() {
        return classe;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setRevisao(int revisao) {
        this.revisao = revisao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public void setClasse(Object classe) {
        this.classe = classe;
    }

}
