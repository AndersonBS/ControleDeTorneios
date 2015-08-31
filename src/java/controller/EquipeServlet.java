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
import model.Equipe;

/**
 *
 * @author anderson
 */
@WebServlet(name = "EquipeServlet", urlPatterns = {"/EquipeServlet"})
public class EquipeServlet extends HttpServlet {

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
            EquipeDAO equipeDAO = new EquipeDAO();
            Equipe equipe = new Equipe();
            HttpSession session = request.getSession(false);
            
            if ("salvar".equals(request.getParameter("operacao")) || "alterar".equals(request.getParameter("operacao"))) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                equipe.setNome(request.getParameter("nome"));
                equipe.setDataFundacao(new Date(dateFormat.parse(request.getParameter("dataFundacao")).getTime()));
                equipe.setEmail(request.getParameter("email"));
                equipe.setEnderecoWeb(request.getParameter("enderecoWeb"));
                equipe.setFone(request.getParameter("fone"));
            }
            
            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = null;
            String mensagem = "";
            switch (request.getParameter("operacao")) {
                case "salvar": {
                    if (equipeDAO.save(equipe)) {
                        mensagem = "<font color=\"green\">Equipe cadastrada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de realizar o cadastro!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/cadastrarEquipe.jsp");
                    break;
                }
                case "alterar": {
                    equipe.setId(Integer.parseInt(request.getParameter("idEquipe")));
                    if (equipeDAO.update(equipe)) {
                        mensagem = "<font color=\"green\">Equipe alterada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de alterar a equipe!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarEquipe.jsp");
                    break;
                }
                case "apagar": {
                    equipe.setId(Integer.parseInt(request.getParameter("excEquipe")));
                    if (equipeDAO.delete(equipe)) {
                        mensagem = "<font color=\"green\">Equipe apagada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de apagar a equipe!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarEquipe.jsp");
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
