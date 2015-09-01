/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.Conexao; 
import org.hibernate.Session;

/**
 *
 * @author anderson
 */
public class TesteConexao {
 
    public static void main(String[] args) {
        Session sessao = null;
        try {
            sessao = Conexao.getSession();
            System.out.println("Conectou!");
        } catch (Exception ex) {
            System.out.println("Nope!");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
