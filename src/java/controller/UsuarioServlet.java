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
import model.Usuario;

/**
 *
 * @author anderson
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = null;
            String mensagem = "";
            switch (request.getParameter("operation")) {
                case "login": {
                    Usuario usuario = usuarioDAO.isUsuario(request.getParameter("login_email"), request.getParameter("login_password"));
                    if (usuario != null) {
                        request.getSession().setAttribute("loggedInUser", usuario);
                        requestDispatcher = servletContext.getRequestDispatcher("/home.jsp");
                    } else {
                        mensagem = "<font color=\"red\">E-mail e/ou Senha inválidos!</font>";
                        requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
                    }
                    break;
                }
                case "register": {
                    Usuario usuario = new Usuario();
                    usuario.setNomeCompleto(request.getParameter("register_name"));
                    usuario.setLogin(request.getParameter("register_email"));
                    usuario.setSenha(request.getParameter("register_password"));
                    if (usuarioDAO.save(usuario)) {
                        mensagem = "<font color=\"green\">Usuário cadastrado com sucesso!</font>";
                    } else {
                        mensagem = "<font color=\"red\">Ocorreu um erro na tentativa de cadastrar o usuário!</font>";
                    }
                    request.getSession().setAttribute("selectedAutomovel", null);
                    requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
                    break;
                }
                case "logout": {
                    request.getSession().removeAttribute("loggedInUser");
                    request.getSession().removeAttribute("selectedTorneio");
                    requestDispatcher = servletContext.getRequestDispatcher("/index.jsp");
                    break;
                }
                case "retrieve": {
                    /*Properties props = new Properties();
                    Session session = Session.getDefaultInstance(props, null);
                    try {
                        Message email = new MimeMessage(session);
                        email.setFrom(new InternetAddress("anderson.sensolo@gmail.com", "Gmail.com Anderson"));
                        email.addRecipient(Message.RecipientType.TO, new InternetAddress(request.getParameter("retrieve_email")));
                        email.setSubject("Recuperar Senha");
                        email.setText("Teste!!");
                        Transport.send(email);
                    } catch (AddressException addressException) {
                        System.out.println(addressException.getMessage());
                    } catch (MessagingException messagingException) {
                        System.out.println(messagingException.getMessage());
                    }*/
                    break;
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
