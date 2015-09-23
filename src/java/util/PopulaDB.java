/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.Conexao;
import controller.EquipeDAO;
import controller.JogadorDAO;
import java.util.Date;
import model.InscricaoEquipe;
import model.Jogador;

/**
 *
 * @author anderson
 */
public class PopulaDB {
    
    public static void main(String[] args) {
        
        EquipeDAO equipeDAO = new EquipeDAO();
        JogadorDAO jogadorDAO = new JogadorDAO();
        
        //equipeDAO.save(new InscricaoEquipe("Equipe 1", new Date("01/01/2015"), "equipe1@gmail.com", "www.equipe1.com.br", "(49)1234-5678"));
        //equipeDAO.save(new InscricaoEquipe("Equipe 2", new Date("02/02/2015"), "equipe2@gmail.com", "www.equipe2.com.br", "(49)2345-6789"));
        //equipeDAO.save(new InscricaoEquipe("Equipe 3", new Date("03/03/2015"), "equipe3@gmail.com", "www.equipe3.com.br", "(49)3456-7890"));
        //equipeDAO.save(new InscricaoEquipe("Equipe 4", new Date("04/04/2015"), "equipe4@gmail.com", "www.equipe4.com.br", "(49)0123-4567"));
        //equipeDAO.save(new InscricaoEquipe("Equipe 5", new Date("05/05/2015"), "equipe5@gmail.com", "www.equipe5.com.br", "(49)9012-3456"));
        
        //jogadorDAO.save(new Jogador("Jogador 1", 1234567890, new Date("01/01/2001"), new Date("01/01/2015"), "jogador1@gmail.com", "(49)1234-5678", "Equipe 1", "Posição 1"));
        //jogadorDAO.save(new Jogador("Jogador 2", 1020351512, new Date("02/02/2002"), new Date("02/02/2015"), "jogador2@gmail.com", "(49)2345-6789", "Equipe 2", "Posição 2"));
        //jogadorDAO.save(new Jogador("Jogador 3", 1511505615, new Date("03/03/2003"), new Date("03/03/2015"), "jogador3@gmail.com", "(49)3456-7890", "Equipe 3", "Posição 3"));
        //jogadorDAO.save(new Jogador("Jogador 4", 1651518981, new Date("04/04/2004"), new Date("04/04/2015"), "jogador4@gmail.com", "(49)0123-4567", "Equipe 4", "Posição 4"));
        //jogadorDAO.save(new Jogador("Jogador 5", 1166811535, new Date("05/05/2005"), new Date("05/05/2015"), "jogador5@gmail.com", "(49)9012-3456", "Equipe 5", "Posição 5"));
        
        Conexao.stopConnectionProvider();
        
    }
    
}
