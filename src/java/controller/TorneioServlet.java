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
import model.Torneio;

/**
 *
 * @author anderson
 */
@WebServlet(name = "TorneioServlet", urlPatterns = {"/TorneioServlet"})
public class TorneioServlet extends HttpServlet {

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
            TorneioDAO torneioDAO = new TorneioDAO();
            HttpSession session = request.getSession(false);
            Torneio torneio = new Torneio();
            
            if ("salvar".equals(request.getParameter("operacao")) || "alterar".equals(request.getParameter("operacao"))) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                torneio.setInicioRealizacao(new Date(dateFormat.parse(request.getParameter("inicioRealizacao")).getTime()));
                torneio.setFinalRealizacao(new Date(dateFormat.parse(request.getParameter("finalRealizacao")).getTime()));
                torneio.setFrequenciaPartidas(Byte.parseByte(request.getParameter("frequenciaPartidas")));
                torneio.setInicioInscricoes(new Date(dateFormat.parse(request.getParameter("inicioInscricoes")).getTime()));
                torneio.setFinalInscricoes(new Date(dateFormat.parse(request.getParameter("finalInscricoes")).getTime()));
                torneio.setNomeDoTorneio(request.getParameter("nomeDoTorneio"));
                torneio.setNomeDoResponsavel(request.getParameter("nomeDoResponsavel"));
                torneio.setEnderecoWeb(request.getParameter("enderecoWeb"));
                torneio.setEmail(request.getParameter("email"));
                torneio.setCustoPorJogador(Float.parseFloat(request.getParameter("custoPorJogador")));
                torneio.setNumeroMinimoJogadores(Byte.parseByte(request.getParameter("numeroMinimoJogadores")));
                torneio.setNumeroMaximoJogadores(Byte.parseByte(request.getParameter("numeroMaximoJogadores")));
                torneio.setNumeroEquipes(Byte.parseByte(request.getParameter("numeroEquipes")));
            }
            
            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = null;
            String mensagem = "";
            switch (request.getParameter("operacao")) {
                case "salvar": {
                    if (torneioDAO.save(torneio)) {
                        mensagem = "<font color=\"green\">Torneio cadastrado com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de realizar o cadastro!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/cadastrarTorneio.jsp");
                    break;
                }
                case "alterar": {
                    torneio.setId(Integer.parseInt(request.getParameter("idTorneio")));
                    if (torneioDAO.update(torneio)) {
                        mensagem = "<font color=\"green\">Torneio alterado com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de alterar o torneio!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarTorneio.jsp");
                    break;
                }
                case "apagar": {
                    torneio.setId(Integer.parseInt(request.getParameter("excTorneio")));
                    if (torneioDAO.delete(torneio)) {
                        mensagem = "<font color=\"green\">Torneio apagado com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de apagar o torneio!</font>";
                    }
                    requestDispatcher = servletContext.getRequestDispatcher("/listarTorneio.jsp");
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
