/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jogador;

/**
 *
 * @author anderson
 */
@WebServlet(name = "JogadorServlet", urlPatterns = {"/JogadorServlet"})
public class JogadorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JogadorDAO jogadorDAO = new JogadorDAO();
            InscricaoEquipeDAO inscricaoEquipeDAO = new InscricaoEquipeDAO();
            PosicaoDAO posicaoDAO = new PosicaoDAO();
            Jogador jogador = new Jogador();
            HttpSession session = request.getSession(false);
            
            if ("salvar".equals(request.getParameter("operacao")) || "alterar".equals(request.getParameter("operacao"))) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                jogador.setInscricaoEquipe(inscricaoEquipeDAO.retrieve(Integer.parseInt(request.getParameter("inscricaoEquipe"))));
                jogador.setPosicao(posicaoDAO.retrieve(Integer.parseInt(request.getParameter("posicao"))));
                jogador.setNomeCompleto(request.getParameter("nomeCompleto"));
                jogador.setCpf(Long.parseLong(request.getParameter("cpf")));
                jogador.setDataNascimento(new Date(dateFormat.parse(request.getParameter("dataNascimento")).getTime()));
                jogador.setEmail(request.getParameter("email"));
                jogador.setAltura(Float.parseFloat(request.getParameter("altura")));
                jogador.setPeso(Float.parseFloat(request.getParameter("peso")));
                jogador.setPais(request.getParameter("pais"));
                jogador.setDataCadastro(new Date(dateFormat.parse(request.getParameter("dataCadastro")).getTime()));
            }
            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = null;
            String mensagem = "";
            switch (request.getParameter("operacao")) {
                case "salvar": {
                    if (jogadorDAO.save(jogador)) {
                        mensagem = "<font color=\"green\">Jogador cadastrado com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de realizar o cadastro!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/cadastrarJogador.jsp");
                    break;
                }
                case "alterar": {
                    jogador.setId(Integer.parseInt(request.getParameter("idJogador")));
                    if (jogadorDAO.update(jogador)) {
                        mensagem = "<font color=\"green\">Jogador alterado com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de alterar o jogador!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarJogador.jsp");
                    break;
                }
                case "apagar": {
                    jogador.setId(Integer.parseInt(request.getParameter("excJogador")));
                    if (jogadorDAO.delete(jogador)) {
                        mensagem = "<font color=\"green\">Jogador apagado com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de apagar o jogador!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarJogador.jsp");
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
