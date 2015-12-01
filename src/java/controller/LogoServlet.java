package controller;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoServlet", urlPatterns = {"/LogoServlet"})
public class LogoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        InscricaoEquipeDAO inscricaoEquipeDAO = new InscricaoEquipeDAO();
        byte[] logo = inscricaoEquipeDAO.retrieve(Integer.parseInt(request.getParameter("idInscricaoEquipe"))).getLogo();
        OutputStream out = response.getOutputStream();
        if (logo != null) {
            out.write(logo);
        }
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
