/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.InscricaoEquipe;
import model.TabelaClassificacao;
import model.TabelaJogos;
import model.Torneio;

/**
 *
 * @author anderson
 */
@WebServlet(name = "TabelaJogosServlet", urlPatterns = {"/TabelaJogosServlet"})
public class TabelaJogosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private List<TabelaJogos> roundRobin(List<InscricaoEquipe> inscricaoEquipes) {
        List<TabelaJogos> rounds = new ArrayList();
        if (inscricaoEquipes.size() > 0) {
            int teams = inscricaoEquipes.size();
            int totalRounds = (teams - 1) * 2;
            int matchesPerRound = teams / 2;
            int halfRoundMark = totalRounds / 2;
            Torneio torneio = inscricaoEquipes.get(0).getTorneio();
            Date data = torneio.getInicioRealizacao();

            for (int round = 0; round < totalRounds; round++) {
                for (int match = 0; match < matchesPerRound; match++) {
                    int home = (round + match) % (teams - 1);
                    int away = (teams - 1 - match + round) % (teams - 1);

                    if (match == 0) {
                        away = teams - 1;
                    }

                    TabelaJogos tabelaJogos;
                    if (round < halfRoundMark) {
                        tabelaJogos = new TabelaJogos(torneio, round + 1, new Date(data.getTime()), 
                                inscricaoEquipes.get(home).getCidade() + ": " + inscricaoEquipes.get(home).getComplemento(), 
                                inscricaoEquipes.get(home), inscricaoEquipes.get(away), -1, -1);
                    } else {
                        tabelaJogos = new TabelaJogos(torneio, round + 1, new Date(data.getTime()), 
                                inscricaoEquipes.get(home).getCidade() + ": " + inscricaoEquipes.get(home).getComplemento(), 
                                inscricaoEquipes.get(away), inscricaoEquipes.get(home), -1, -1);
                    }
                    rounds.add(tabelaJogos);
                }
                if (torneio.getFrequenciaPartidas() == 1) {
                    Calendar c = Calendar.getInstance(); 
                    c.setTime(data); 
                    c.add(Calendar.DATE, 7);
                    data = c.getTime();
                } else {
                    if (round % 2 == 0) {
                        Calendar c = Calendar.getInstance(); 
                        c.setTime(data); 
                        c.add(Calendar.DATE, 3);
                        data = c.getTime();
                    } else {
                        Calendar c = Calendar.getInstance(); 
                        c.setTime(data); 
                        c.add(Calendar.DATE, 4);
                        data = c.getTime();
                    }
                }
            }
        }
        return rounds;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            TabelaJogosDAO tabelaJogosDAO = new TabelaJogosDAO();
            InscricaoEquipeDAO inscricaoEquipeDAO = new InscricaoEquipeDAO();
            HttpSession session = request.getSession(false);


            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = null;
            String mensagem = "";
            switch (request.getParameter("operacao")) {
                case "criar": {
                    List<InscricaoEquipe> equipes = inscricaoEquipeDAO.retrieve((Torneio) session.getAttribute("selectedTorneio"));
                    if (tabelaJogosDAO.delete((Torneio) session.getAttribute("selectedTorneio")) && tabelaJogosDAO.save(roundRobin(equipes))) {
                        mensagem = "<font color=\"green\">Tabela de jogos criada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de salvar a tabela!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/gerenciarTorneio.jsp");
                    break;
                }
                case "alterar": {
                    TabelaJogos tabelaJogos = tabelaJogosDAO.retrieve(Integer.parseInt(request.getParameter("idTabelaJogos")));
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    tabelaJogos.setDataPartida(new Date(dateFormat.parse(request.getParameter("dataPartida")).getTime()));
                    tabelaJogos.setLocalPartida(request.getParameter("localPartida"));
                    if (tabelaJogos.getPlacarEquipeCasa() != -1 || tabelaJogos.getPlacarEquipeVisitante() != -1) {
                        TabelaClassificacaoDAO tabelaClassificacaoDAO = new TabelaClassificacaoDAO();
                        TabelaClassificacao tabelaClassificacaoCasa =  tabelaClassificacaoDAO.retrieve(tabelaJogos.getInscricaoEquipeCasa());
                        TabelaClassificacao tabelaClassificacaoVisitante =  tabelaClassificacaoDAO.retrieve(tabelaJogos.getInscricaoEquipeVisitante());
                        if (tabelaJogos.getPlacarEquipeCasa() > tabelaJogos.getPlacarEquipeVisitante()) {
                            tabelaClassificacaoCasa.setNumeroVitorias(tabelaClassificacaoCasa.getNumeroVitorias() - 1);
                            tabelaClassificacaoVisitante.setNumeroDerrotas(tabelaClassificacaoVisitante.getNumeroDerrotas() - 1);
                        } else if (tabelaJogos.getPlacarEquipeCasa() < tabelaJogos.getPlacarEquipeVisitante()) {
                            tabelaClassificacaoCasa.setNumeroDerrotas(tabelaClassificacaoCasa.getNumeroDerrotas() - 1);
                            tabelaClassificacaoVisitante.setNumeroVitorias(tabelaClassificacaoVisitante.getNumeroVitorias() - 1);
                        } else {
                            tabelaClassificacaoCasa.setNumeroEmpates(tabelaClassificacaoCasa.getNumeroEmpates() - 1);
                            tabelaClassificacaoVisitante.setNumeroEmpates(tabelaClassificacaoVisitante.getNumeroEmpates() - 1);
                        }
                        tabelaClassificacaoCasa.setNumeroGolsMarcados(0);
                        tabelaClassificacaoCasa.setNumeroGolsSofridos(0);
                        tabelaClassificacaoVisitante.setNumeroGolsMarcados(0);
                        tabelaClassificacaoVisitante.setNumeroGolsSofridos(0);
                        tabelaClassificacaoDAO.update(tabelaClassificacaoCasa);
                        tabelaClassificacaoDAO.update(tabelaClassificacaoVisitante);
                    }
                    if (Integer.parseInt(request.getParameter("placarEquipeCasa")) != -1 && 
                                Integer.parseInt(request.getParameter("placarEquipeVisitante")) != -1) {
                        tabelaJogos.setPlacarEquipeCasa(Integer.parseInt(request.getParameter("placarEquipeCasa")));
                        tabelaJogos.setPlacarEquipeVisitante(Integer.parseInt(request.getParameter("placarEquipeVisitante")));
                        if (tabelaJogosDAO.update(tabelaJogos)) {
                            TabelaClassificacaoDAO tabelaClassificacaoDAO = new TabelaClassificacaoDAO();
                            TabelaClassificacao tabelaClassificacaoCasa =  tabelaClassificacaoDAO.retrieve(tabelaJogos.getInscricaoEquipeCasa());
                            TabelaClassificacao tabelaClassificacaoVisitante =  tabelaClassificacaoDAO.retrieve(tabelaJogos.getInscricaoEquipeVisitante());
                            if (tabelaJogos.getPlacarEquipeCasa() > tabelaJogos.getPlacarEquipeVisitante()) {
                                tabelaClassificacaoCasa.setNumeroVitorias(tabelaClassificacaoCasa.getNumeroVitorias() + 1);
                                tabelaClassificacaoVisitante.setNumeroDerrotas(tabelaClassificacaoVisitante.getNumeroDerrotas() + 1);
                            } else if (tabelaJogos.getPlacarEquipeCasa() < tabelaJogos.getPlacarEquipeVisitante()) {
                                tabelaClassificacaoCasa.setNumeroDerrotas(tabelaClassificacaoCasa.getNumeroDerrotas() + 1);
                                tabelaClassificacaoVisitante.setNumeroVitorias(tabelaClassificacaoVisitante.getNumeroVitorias() + 1);
                            } else {
                                tabelaClassificacaoCasa.setNumeroEmpates(tabelaClassificacaoCasa.getNumeroEmpates() + 1);
                                tabelaClassificacaoVisitante.setNumeroEmpates(tabelaClassificacaoVisitante.getNumeroEmpates() + 1);
                            }
                            tabelaClassificacaoCasa.setNumeroGolsMarcados(tabelaJogos.getPlacarEquipeCasa());
                            tabelaClassificacaoCasa.setNumeroGolsSofridos(tabelaJogos.getPlacarEquipeVisitante());
                            tabelaClassificacaoVisitante.setNumeroGolsMarcados(tabelaJogos.getPlacarEquipeVisitante());
                            tabelaClassificacaoVisitante.setNumeroGolsSofridos(tabelaJogos.getPlacarEquipeCasa());
                            tabelaClassificacaoDAO.update(tabelaClassificacaoCasa);
                            tabelaClassificacaoDAO.update(tabelaClassificacaoVisitante);
                            mensagem = "<font color=\"green\">Partida lançada com sucesso!</font>";
                        } else {
                            mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de lançar os dados!</font>";
                        }
                        
                    } else {
                        if (tabelaJogosDAO.update(tabelaJogos)) {
                            mensagem = "<font color=\"green\">Os dados da partida foram atualizados, porém...</font><br>";
                            mensagem += "<font color=\"red\">Você tentou lançar um placar inválido!</font>";
                        } else {
                            mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de atualizar os dados!</font><br>";
                        }
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/gerenciarJogos.jsp");
                    break;
                }
            }
            request.setAttribute("message", mensagem);
            if (requestDispatcher != null) {
                requestDispatcher.forward(request, response);
            }
        } catch (ParseException parseException) {
            System.out.println("Não foi possível converter a data. Erro: " + parseException.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
