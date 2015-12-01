package controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebFilter(filterName = "LoginFilter", 
        urlPatterns = {"/auditoria.jsp", "/cadastrarInscricaoEquipe.jsp", "/cadastrarJogador.jsp", "/cadastrarPermissao.jsp", 
            "/cadastrarPosicao.jsp", "/cadastrarTorneio.jsp", "/jogos.jsp", "/gerenciarJogos.jsp", 
            "/cadastrarUsuario.jsp", "/gerenciarInscricaoEquipe.jsp", "/gerenciarJogador.jsp", "/gerenciarPosicao.jsp", 
            "/gerenciarTorneio.jsp", "/home.jsp"}, 
        servletNames = {"InscricaoEquipeServlet", "JogadorServlet", "PermissaoServlet", "PosicaoServlet", "TabelaClassificacaoServlet", 
            "TabelaJogosServlet", "TorneioServlet"}, 
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR, DispatcherType.INCLUDE})
public class LoginFilter implements Filter {   
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = (Usuario) session.getAttribute("loggedInUser");
            if (usuarioDAO.isUsuario(usuario.getLogin(), usuario.getSenha()) != null) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        
    }
    
}
