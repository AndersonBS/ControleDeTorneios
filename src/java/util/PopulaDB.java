/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.Conexao;
import controller.InscricaoEquipeDAO;
import controller.JogadorDAO;
import controller.PermissaoDAO;
import controller.PosicaoDAO;
import controller.TorneioDAO;
import controller.UsuarioDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import model.InscricaoEquipe;
import model.Jogador;
import model.Permissao;
import model.Posicao;
import model.Torneio;
import model.Usuario;

/**
 *
 * @author anderson
 */
public class PopulaDB {
    
    public static void main(String[] args) throws IOException {
        
        /*POSIÇÃO*/
        PosicaoDAO posicaoDAO = new PosicaoDAO();
        posicaoDAO.save(new Posicao("Goleiro"));
        posicaoDAO.save(new Posicao("Zagueiro"));
        posicaoDAO.save(new Posicao("Lateral"));
        posicaoDAO.save(new Posicao("Lateral Direito"));
        posicaoDAO.save(new Posicao("Lateral Esquerdo"));
        posicaoDAO.save(new Posicao("Líbero"));
        posicaoDAO.save(new Posicao("Volante"));
        posicaoDAO.save(new Posicao("Ala Esquerdo"));
        posicaoDAO.save(new Posicao("Ala Direito"));
        posicaoDAO.save(new Posicao("Meio-Campo"));
        posicaoDAO.save(new Posicao("Meia-Armador"));
        posicaoDAO.save(new Posicao("Médio Centro"));
        posicaoDAO.save(new Posicao("Meio-Campista Lateral Direito"));
        posicaoDAO.save(new Posicao("Meio-Campista Lateral Esquerdo"));
        posicaoDAO.save(new Posicao("Meia Ofensivo"));
        posicaoDAO.save(new Posicao("Atacante"));
        posicaoDAO.save(new Posicao("Ponta"));
        posicaoDAO.save(new Posicao("Segundo Atacante"));
        posicaoDAO.save(new Posicao("Centrovante"));
        
        /*TORNEIO*/
        TorneioDAO torneioDAO = new TorneioDAO(); 
        torneioDAO.save(new Torneio("Brasileirão 2015 - Série A", new Date("09/05/2015"), 
                new Date("06/12/2015"), (byte) 2, new Date("01/01/2015"), new Date("31/05/2015"), "João Havelange", 
                "www.brasileirao2015.com.br", "brasileiraoA@2015.com", 299.90f, (byte) 18, (byte) 25, (byte) 20));
        torneioDAO.save(new Torneio("Brasileirão 2015 - Série B", new Date("10/05/2015"), 
                new Date("07/12/2015"), (byte) 2, new Date("02/01/2015"), new Date("30/05/2015"), "João Havelange", 
                "www.brasileirao2015.com.br", "brasileiraoB@2015.com", 259.90f, (byte) 18, (byte) 25, (byte) 20));
        torneioDAO.save(new Torneio("Brasileirão 2015 - Série C", new Date("11/05/2015"), 
                new Date("08/12/2015"), (byte) 2, new Date("03/01/2015"), new Date("29/05/2015"), "João Havelange", 
                "www.brasileirao2015.com.br", "brasileiraoC@2015.com", 209.90f, (byte) 18, (byte) 25, (byte) 20));
        torneioDAO.save(new Torneio("Brasileirão 2015 - Série D", new Date("12/05/2015"), 
                new Date("09/12/2015"), (byte) 2, new Date("04/01/2015"), new Date("28/05/2015"), "João Havelange", 
                "www.brasileirao2015.com.br", "brasileiraoD@2015.com", 159.90f, (byte) 18, (byte) 25, (byte) 20));
        
        /*INSCRIÇÃO EQUIPE*/
        InscricaoEquipeDAO inscricaoEquipeDAO = new InscricaoEquipeDAO();
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Atlético Mineiro", 
                "Em Preenchimento", false, 0f, new Date("25/03/1908"), "atleticoMineiro@2015.com", 
                "www.atleticoMineiro.com.br", "3513-3235", "Rua Atlético Mineiro", 42, "Independência", 
                "Belo Horizonte", 51849321, Files.readAllBytes(Paths.get("web/IMG/atleticoMineiro.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Atlético Paranaense", 
                "Em Preenchimento", false, 0f, new Date("26/03/1924"), "atleticoParanaense@2015.com", 
                "www.atleticoParanaense.com.br", "3518-1598", "Rua Atlético Paranaense", 727, "Arena da Baixada", 
                "Curitiba", 61325984, Files.readAllBytes(Paths.get("web/IMG/atleticoParanaense.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Avaí", 
                "Em Preenchimento", false, 0f, new Date("01/09/1923"), "avai@2015.com", 
                "www.avai.com.br", "2452-4524", "Rua Avaí", 7527, "Ressacada", 
                "Florianópolis", 78278273, Files.readAllBytes(Paths.get("web/IMG/avai.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Chapecoense", 
                "Em Preenchimento", false, 0f, new Date("10/05/1973"), "chapecoense@2015.com", 
                "www.chapecoense.com.br", "4535-4533", "Rua Chapecoense", 242, "Arena Condá", 
                "Chapecó", 27878332, Files.readAllBytes(Paths.get("web/IMG/chapecoense.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Corinthians", 
                "Em Preenchimento", false, 0f, new Date("01/09/1910"), "corinthians@2015.com", 
                "www.corinthians.com.br", "1237-5785", "Rua Corinthians", 452, "Arena Corinthians", 
                "São Paulo", 37872323, Files.readAllBytes(Paths.get("web/IMG/corinthians.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Coritiba", 
                "Em Preenchimento", false, 0f, new Date("12/10/1909"), "coritiba@2015.com", 
                "www.coritiba.com.br", "3248-3572", "Rua Coritiba", 782, "Couto Pereira", 
                "Curitiba", 72873237, Files.readAllBytes(Paths.get("web/IMG/coritiba.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Cruzeiro", 
                "Em Preenchimento", false, 0f, new Date("02/01/1921"), "cruzeiro@2015.com", 
                "www.cruzeiro.com.br", "7589-5579", "Rua Cruzeiro", 3237, "Mineirão", 
                "Belo Horizonte", 43545378, Files.readAllBytes(Paths.get("web/IMG/cruzeiro.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Figueirense", 
                "Em Preenchimento", false, 0f, new Date("12/06/1921"), "figueirense@2015.com", 
                "www.figueirense.com.br", "5227-8722", "Rua Figueirense", 32, "Orlando Scarpelli", 
                "Florianópolis", 37822378, Files.readAllBytes(Paths.get("web/IMG/figueirense.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Flamengo", 
                "Em Preenchimento", false, 0f, new Date("17/11/1895"), "flamengo@2015.com", 
                "www.flamengo.com.br", "4578-3247", "Rua Flamengo", 7, "Maracanã", 
                "Rio de Janeiro", 78232378, Files.readAllBytes(Paths.get("web/IMG/flamengo.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Fluminense", 
                "Em Preenchimento", false, 0f, new Date("21/06/1902"), "fluminense@2015.com", 
                "www.fluminense.com.br", "3845-2879", "Rua Fluminense", 327, "Maracanã", 
                "Rio de Janeiro", 32378782, Files.readAllBytes(Paths.get("web/IMG/fluminense.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Goiás", 
                "Em Preenchimento", false, 0f, new Date("06/04/1943"), "goias@2015.com", 
                "www.goias.com.br", "9875-5524", "Rua Goiás", 278, "Serra Dourada", 
                "Goiânia", 27823378, Files.readAllBytes(Paths.get("web/IMG/goias.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Grêmio", 
                "Em Preenchimento", false, 0f, new Date("15/09/1903"), "gremio@2015.com", 
                "www.gremio.com.br", "8727-9154", "Rua Grêmio", 28, "Arena do Grêmio", 
                "Porto Alegre", 73872237, Files.readAllBytes(Paths.get("web/IMG/gremio.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Internacional", 
                "Em Preenchimento", false, 0f, new Date("04/04/1909"), "internacional@2015.com", 
                "www.internacional.com.br", "2478-2284", "Rua Internacional", 38, "Beira Rio", 
                "Porto Alegre", 35327839, Files.readAllBytes(Paths.get("web/IMG/internacional.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Joinville", 
                "Em Preenchimento", false, 0f, new Date("29/01/1976"), "joinville@2015.com", 
                "www.joinville.com.br", "3875-2378", "Rua Joinville", 75275, "Arena Joinville", 
                "Joinville", 78223786, Files.readAllBytes(Paths.get("web/IMG/joinville.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Palmeiras", 
                "Em Preenchimento", false, 0f, new Date("26/08/1914"), "palmeiras@2015.com", 
                "www.palmeiras.com.br", "2782-9327", "Rua Palmeiras", 752, "Allianz Parque", 
                "São Paulo", 13237837, Files.readAllBytes(Paths.get("web/IMG/palmeiras.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Ponte Preta", 
                "Em Preenchimento", false, 0f, new Date("11/08/1900"), "pontePreta@2015.com", 
                "www.pontePreta.com.br", "8272-3227", "Rua Ponte Preta", 357, "Moisés Lucarelli", 
                "Campinas", 78223782, Files.readAllBytes(Paths.get("web/IMG/pontePreta.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Santos", 
                "Em Preenchimento", false, 0f, new Date("14/04/1912"), "santos@2015.com", 
                "www.santos.com.br", "2457-1237", "Rua Santos", 22, "Vila Belmiro", 
                "Santos", 21378322, Files.readAllBytes(Paths.get("web/IMG/santos.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "São Paulo", 
                "Em Preenchimento", false, 0f, new Date("25/01/1930"), "saoPaulo@2015.com", 
                "www.saoPaulo.com.br", "8723-7522", "Rua São Paulo", 72, "Morumbi", 
                "São Paulo", 78227237, Files.readAllBytes(Paths.get("web/IMG/saoPaulo.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Sport", 
                "Em Preenchimento", false, 0f, new Date("13/05/1905"), "sport@2015.com", 
                "www.sport.com.br", "7287-3424", "Rua Sport", 78, "Ilha do Retiro", 
                "Recife", 78233783, Files.readAllBytes(Paths.get("web/IMG/sport.png"))));
        inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(1), "Vasco", 
                "Em Preenchimento", false, 0f, new Date("21/08/1898"), "vasco@2015.com", 
                "www.vasco.com.br", "1787-2872", "Rua Vasco", 287, "São Januário", 
                "Rio de Janeiro", 56389327, Files.readAllBytes(Paths.get("web/IMG/vasco.png"))));
        for (int x = 2; x <= 4; x++) {
            for (int y = 1; y <= 20; y++) {
                 inscricaoEquipeDAO.save(new InscricaoEquipe(torneioDAO.retrieve(x), "Equipe" + y, 
                    "Em Preenchimento", false, 0f, new Date("21/08/1898"), "equipe" + y + "@2015.com", 
                    "www.equipe" + y + ".com.br", "1234-5678", "Rua Equipe " + y, y, "Complemento Equipe " + y, 
                    "Cidade Equipe " + y, 12345678, Files.readAllBytes(Paths.get("web/IMG/sem_logo.jpg"))));
            }
        }
        
        /*JOGADOR*/
        JogadorDAO jogadorDAO = new JogadorDAO();
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(1), 
                "Charles", new Long("58726987547"), new Date("04/02/1994"), new Date("23/11/2015"), 
                "charles@gmail.com", 1.85f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Charles.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(1), 
                "Jordi", new Long("78569524585"), new Date("09/09/1993"), new Date("23/11/2015"), 
                "jordi@gmail.com", 1.92f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/MartinSilva.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(1), 
                "Martín Silva", new Long("67835498524"), new Date("25/03/1983"), new Date("23/11/2015"), 
                "martinSilva@gmail.com", 1.87f, 70, "Uruguai", Files.readAllBytes(Paths.get("web/IMG/Jordi.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(2), 
                "Anderson Salles", new Long("65785632145"), new Date("16/02/1988"), new Date("23/11/2015"), 
                "andersonSalles@gmail.com", 1.81f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/AndersonSalles.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(2), 
                "Jomar", new Long("65785632145"), new Date("28/09/1992"), new Date("23/11/2015"), 
                "jomar@gmail.com", 1.85f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Jomar.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(2), 
                "Luan", new Long("65785632145"), new Date("10/05/1993"), new Date("23/11/2015"), 
                "luan@gmail.com", 1.88f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Luan.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(2), 
                "Rodrigo", new Long("65785632145"), new Date("27/08/1980"), new Date("23/11/2015"), 
                "rodrigo@gmail.com", 1.82f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Rodrigo.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(2), 
                "Aislan", new Long("65785632145"), new Date("11/01/1988"), new Date("23/11/2015"), 
                "aislan@gmail.com", 1.93f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Aislan.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(2), 
                "João Carlos", new Long("65785632145"), new Date("01/01/1982"), new Date("23/11/2015"), 
                "joaoCarlos@gmail.com", 1.89f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/JoaoCarlos.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(2), 
                "Rafael Vaz", new Long("65785632145"), new Date("17/09/1988"), new Date("23/11/2015"), 
                "rafaelVaz@gmail.com", 1.88f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/RafaelVaz.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(3), 
                "Henrique Silva", new Long("65785632145"), new Date("25/04/1994"), new Date("23/11/2015"), 
                "henriqueSilva@gmail.com", 1.73f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/HenriqueSilva.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(3), 
                "Christianno", new Long("65785632145"), new Date("29/10/1991"), new Date("23/11/2015"), 
                "christianno@gmail.com", 1.85f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Christianno.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(3), 
                "Nei", new Long("65785632145"), new Date("06/12/1985"), new Date("23/11/2015"), 
                "nei@gmail.com", 1.75f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Nei.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(3), 
                "Madson", new Long("65785632145"), new Date("13/01/1992"), new Date("23/11/2015"), 
                "madson@gmail.com", 1.82f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Madson.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(3), 
                "Júlio César", new Long("65785632145"), new Date("15/06/1982"), new Date("23/11/2015"), 
                "julioCesar@gmail.com", 1.73f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/JulioCesar.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(3), 
                "Bruno Teles", new Long("65785632145"), new Date("01/05/1986"), new Date("23/11/2015"), 
                "brunoTeles@gmail.com", 1.83f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/BrunoTeles.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(3), 
                "Bruno Ferreira", new Long("65785632145"), new Date("14/09/1994"), new Date("23/11/2015"), 
                "brunoFerreira@gmail.com", 1.80f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/BrunoFerreira.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Guiñazu", new Long("65785632145"), new Date("26/08/1978"), new Date("23/11/2015"), 
                "guinazu@gmail.com", 1.72f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Guinazu.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Jean Patrick", new Long("65785632145"), new Date("25/06/1992"), new Date("23/11/2015"), 
                "jeanPatrick@gmail.com", 1.72f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/JeanPatrick.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Julio Dos Santos", new Long("65785632145"), new Date("07/05/1983"), new Date("23/11/2015"), 
                "julioDosSantos@gmail.com", 1.88f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/JulioDosSantos.png")))); 
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Lucas", new Long("65785632145"), new Date("23/09/1988"), new Date("23/11/2015"), 
                "lucas@gmail.com", 1.81f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Lucas.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Emanuel Biancucchi", new Long("65785632145"), new Date("28/07/1988"), new Date("23/11/2015"), 
                "emanuelBiancucchi@gmail.com", 1.77f, 70, "Argentina", Files.readAllBytes(Paths.get("web/IMG/EmanuelBiancucchi.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Andrezinho", new Long("65785632145"), new Date("30/07/1984"), new Date("23/11/2015"), 
                "andrezinho@gmail.com", 1.78f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Andrezinho.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Jéferson", new Long("65785632145"), new Date("15/07/1984"), new Date("23/11/2015"), 
                "jeferson@gmail.com", 1.80f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Jeferson.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(10), 
                "Mateus Vital", new Long("65785632145"), new Date("12/02/1998"), new Date("23/11/2015"), 
                "mateusVital@gmail.com", 1.75f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/MateusVital.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(7), 
                "Diguinho", new Long("65785632145"), new Date("20/03/1983"), new Date("23/11/2015"), 
                "diguinho@gmail.com", 1.71f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Diguinho.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(7), 
                "Serginho", new Long("65785632145"), new Date("04/08/1986"), new Date("23/11/2015"), 
                "serginho@gmail.com", 1.77f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Serginho.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(7), 
                "Felipe Seymour", new Long("65785632145"), new Date("23/07/1987"), new Date("23/11/2015"), 
                "felipeSeymour@gmail.com", 1.74f, 70, "Chile", Files.readAllBytes(Paths.get("web/IMG/FelipeSeymour.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(7), 
                "Bruno Gallo", new Long("65785632145"), new Date("07/05/1988"), new Date("23/11/2015"), 
                "brunoGallo@gmail.com", 1.82f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/BrunoGallo.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Thalles", new Long("65785632145"), new Date("18/05/1995"), new Date("23/11/2015"), 
                "thalles@gmail.com", 1.85f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Thalles.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Rafael Silva", new Long("65785632145"), new Date("08/10/1990"), new Date("23/11/2015"), 
                "rafaelSilva@gmail.com", 1.86f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/RafaelSilva.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Romarinho", new Long("65785632145"), new Date("20/09/1993"), new Date("23/11/2015"), 
                "romarinho@gmail.com", 1.76f, 70, "Espanha", Files.readAllBytes(Paths.get("web/IMG/Romarinho.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Dagoberto", new Long("65785632145"), new Date("22/03/1983"), new Date("23/11/2015"), 
                "dagoberto@gmail.com", 1.75f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Dagoberto.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Riascos", new Long("65785632145"), new Date("26/06/1986"), new Date("23/11/2015"), 
                "riascos@gmail.com", 1.80f, 70, "Colombia", Files.readAllBytes(Paths.get("web/IMG/Riascos.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Herrera", new Long("65785632145"), new Date("19/07/1983"), new Date("23/11/2015"), 
                "herrera@gmail.com", 1.81f, 70, "Argentina", Files.readAllBytes(Paths.get("web/IMG/Herrera.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Eder Luis", new Long("65785632145"), new Date("19/04/1985"), new Date("23/11/2015"), 
                "ederLuis@gmail.com", 1.69f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/EderLuis.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Nenê", new Long("65785632145"), new Date("19/07/1981"), new Date("23/11/2015"), 
                "nene@gmail.com", 1.81f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Nene.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Jorge Henrique", new Long("65785632145"), new Date("23/04/1982"), new Date("23/11/2015"), 
                "jorgeHenrique@gmail.com", 1.69f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/JorgeHenrique.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Leandrão", new Long("65785632145"), new Date("18/07/1983"), new Date("23/11/2015"), 
                "leandrao@gmail.com", 1.89f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/Leandrao.png"))));
        jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(20), posicaoDAO.retrieve(16), 
                "Renato Kayzer", new Long("65785632145"), new Date("17/02/1996"), new Date("23/11/2015"), 
                "renatoKayzer@gmail.com", 1.78f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/RenatoKayzer.png"))));
        for (int x = 1; x <= 19; x++) {
            for (int y = 1; y <= 19; y++) {
                jogadorDAO.save(new Jogador(inscricaoEquipeDAO.retrieve(x), posicaoDAO.retrieve(y), 
                    "Jogador" + y, new Long("012345678900"), new Date("01/01/1990"), new Date("23/11/2015"), 
                    "jogador" + y + "@gmail.com", 1.93f, 70, "Brasil", Files.readAllBytes(Paths.get("web/IMG/sem_foto.png")))); 
            }
        }

        /*USUÁRIO*/
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.save(new Usuario("atleticoMineiro@2015.com", "atleticoMineiro", new Date("23/11/2015"), "Atlético Mineiro"));
        usuarioDAO.save(new Usuario("atleticoParanaense@2015.com", "atleticoParanaense", new Date("23/11/2015"), "Atlético Paranaense"));
        usuarioDAO.save(new Usuario("avai@2015.com", "avai", new Date("23/11/2015"), "Avaí"));
        usuarioDAO.save(new Usuario("chapecoense@2015.com", "chapecoense", new Date("23/11/2015"), "Chapecoense"));
        usuarioDAO.save(new Usuario("corinthians@2015.com", "corinthians", new Date("23/11/2015"), "Corinthians"));
        usuarioDAO.save(new Usuario("coritiba@2015.com", "coritiba", new Date("23/11/2015"), "Coritiba"));
        usuarioDAO.save(new Usuario("cruzeiro@2015.com", "cruzeiro", new Date("23/11/2015"), "Cruzeiro"));
        usuarioDAO.save(new Usuario("figueirense@2015.com", "figueirense", new Date("23/11/2015"), "Figueirense"));
        usuarioDAO.save(new Usuario("flamengo@2015.com", "flamengo", new Date("23/11/2015"), "Flamengo"));
        usuarioDAO.save(new Usuario("fluminense@2015.com", "fluminense", new Date("23/11/2015"), "Fluminense"));
        usuarioDAO.save(new Usuario("goias@2015.com", "goias", new Date("23/11/2015"), "Goias"));
        usuarioDAO.save(new Usuario("gremio@2015.com", "gremio", new Date("23/11/2015"), "Grêmio"));
        usuarioDAO.save(new Usuario("internacional@2015.com", "internacional", new Date("23/11/2015"), "Internacional"));
        usuarioDAO.save(new Usuario("joinville@2015.com", "joinville", new Date("23/11/2015"), "Joinville"));
        usuarioDAO.save(new Usuario("palmeiras@2015.com", "palmeiras", new Date("23/11/2015"), "Palmeiras"));
        usuarioDAO.save(new Usuario("pontePreta@2015.com", "pontePreta", new Date("23/11/2015"), "Ponte Preta"));
        usuarioDAO.save(new Usuario("santos@2015.com", "santos", new Date("23/11/2015"), "Santos"));
        usuarioDAO.save(new Usuario("saoPaulo@2015.com", "saoPaulo", new Date("23/11/2015"), "São Paulo"));
        usuarioDAO.save(new Usuario("sport@2015.com", "sport", new Date("23/11/2015"), "Sport"));
        usuarioDAO.save(new Usuario("vasco@2015.com", "vasco", new Date("23/11/2015"), "Vasco"));
        for(int x = 1; x <= 20; x++) {
            usuarioDAO.save(new Usuario("usuario" + x , "usuario" + x, new Date("23/11/2015"), "Usuário " + x));
        }
        usuarioDAO.save(new Usuario("anderson.sensolo@gmail.com", "anderson123", new Date("23/11/2015"), "Anderson Sensolo"));
        
        /*PERMISSÃO*/
        PermissaoDAO permissaoDAO = new PermissaoDAO();
        permissaoDAO.save(new Permissao(usuarioDAO.retrieve(41), null, torneioDAO.retrieve(1)));
        for (int x = 1; x <= 20; x++) {
            permissaoDAO.save(new Permissao(usuarioDAO.retrieve(x), inscricaoEquipeDAO.retrieve(x), null));
        }
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 20; y++) {
                permissaoDAO.save(new Permissao(usuarioDAO.retrieve(10 + y), inscricaoEquipeDAO.retrieve((x * 20) + y), null));
            }
        }
        Conexao.stopConnectionProvider();
        
    }
    
}
