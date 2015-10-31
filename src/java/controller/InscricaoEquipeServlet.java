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
import model.InscricaoEquipe;

/**
 *
 * @author anderson
 */
@WebServlet(name = "InscricaoEquipeServlet", urlPatterns = {"/InscricaoEquipeServlet"})
public class InscricaoEquipeServlet extends HttpServlet {

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
            InscricaoEquipeDAO inscricaoEquipeDAO = new InscricaoEquipeDAO();
            TorneioDAO torneioDAO = new TorneioDAO();
            InscricaoEquipe inscricaoEquipe = new InscricaoEquipe();
            HttpSession session = request.getSession(false);
            
            if ("salvar".equals(request.getParameter("operacao")) || "alterar".equals(request.getParameter("operacao"))) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                inscricaoEquipe.setTorneio(torneioDAO.retrieve(Integer.parseInt(request.getParameter("torneio"))));
                inscricaoEquipe.setNomeDaEquipe(request.getParameter("nomeDaEquipe"));
                inscricaoEquipe.setStatusInscricao("Em Preenchimento");
                inscricaoEquipe.setFechamentoInscricao(false);
                inscricaoEquipe.setPrecoTotalInscricao(0);
                inscricaoEquipe.setDataFundacao(new Date(dateFormat.parse(request.getParameter("dataFundacao")).getTime()));
                inscricaoEquipe.setEmail(request.getParameter("email"));
                inscricaoEquipe.setEnderecoWeb(request.getParameter("enderecoWeb"));
                inscricaoEquipe.setTelefone(request.getParameter("telefone"));
                inscricaoEquipe.setLogradouro(request.getParameter("logradouro"));
                inscricaoEquipe.setNumeroDaResidencia(Integer.parseInt(request.getParameter("numeroDaResidencia")));
                inscricaoEquipe.setComplemento(request.getParameter("complemento"));
                inscricaoEquipe.setCidade(request.getParameter("cidade"));
                inscricaoEquipe.setCep(Long.parseLong(request.getParameter("cep")));
            }
            
            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = null;
            String mensagem = "";
            switch (request.getParameter("operacao")) {
                case "salvar": {
                    if (inscricaoEquipeDAO.save(inscricaoEquipe)) {
                        mensagem = "<font color=\"green\">Inscrição da Equipe cadastrada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de realizar o cadastro!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/cadastrarInscricaoEquipe.jsp");
                    break;
                }
                case "alterar": {
                    inscricaoEquipe.setId(Integer.parseInt(request.getParameter("idInscricaoEquipe")));
                    if (inscricaoEquipeDAO.update(inscricaoEquipe)) {
                        mensagem = "<font color=\"green\">Inscrição da Equipe alterada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de alterar a equipe!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarInscricaoEquipe.jsp");
                    break;
                }
                case "apagar": {
                    inscricaoEquipe.setId(Integer.parseInt(request.getParameter("excInscricaoEquipe")));
                    if (inscricaoEquipeDAO.delete(inscricaoEquipe)) {
                        mensagem = "<font color=\"green\">Inscrição da Equipe apagada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de apagar a equipe!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarInscricaoEquipe.jsp");
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
