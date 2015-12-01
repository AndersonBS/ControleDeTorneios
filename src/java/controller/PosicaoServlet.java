/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Posicao;
import model.Torneio;

/**
 *
 * @author anderson
 */
@WebServlet(name = "PosicaoServlet", urlPatterns = {"/PosicaoServlet"})
public class PosicaoServlet extends HttpServlet {

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
            PosicaoDAO posicaoDAO = new PosicaoDAO();
            HttpSession httpSession = request.getSession(false);
            Posicao posicao = new Posicao();
            
            if ("salvar".equals(request.getParameter("operacao")) || "alterar".equals(request.getParameter("operacao"))) {
                posicao.setNome(request.getParameter("nome"));
            }
            
            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = null;
            String mensagem = "";
            switch (request.getParameter("operacao")) {
                case "salvar": {
                    if (posicaoDAO.save(posicao)) {
                        mensagem = "<font color=\"green\">Posição cadastrada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de realizar o cadastro!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/cadastrarPosicao.jsp");
                    break;
                }
                case "alterar": {
                    posicao.setId(Integer.parseInt(request.getParameter("idPosicao")));
                    if (posicaoDAO.update(posicao)) {
                        mensagem = "<font color=\"green\">Posição alterada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de alterar a posição!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarPosicao.jsp");
                    break;
                }
                case "apagar": {
                    posicao.setId(Integer.parseInt(request.getParameter("excPosicao")));
                    if (posicaoDAO.delete(posicao)) {
                        mensagem = "<font color=\"green\">Posição apagada com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de apagar a posição!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarPosicao.jsp");
                }
            }
            request.setAttribute("message", mensagem);
            if (requestDispatcher != null) {
                requestDispatcher.forward(request, response);
            }
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
