<%-- 
    Document   : cadastrarPermissao
    Created on : 23/10/2015, 15:49:17
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="permissaoDAO" class="controller.PermissaoDAO"/>

<c:if test="${param != null && param.altPermissao != null}">
    <c:set var="permissao" value="${permissaoDAO.retrieve(param.altPermissao)}" scope="page"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Permissao</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <c:choose>
            <c:when test="${param != null && param.altPermissao != null}">
                <h1 align="center">Alteração de Permissão</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Permissão</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="PermissaoServlet">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altPermissao != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="usuario" class="col-sm-2 col-sm-offset-3 control-label">Usuário:</label>
                <div class="col-sm-3 input-group"> 
                    <select name="usuario" id="usuario" class="form-control">
                        <jsp:useBean id="usuarioDAO" class="controller.UsuarioDAO"/>
                        <c:forEach var="usuario" items="${usuarioDAO.retrieve()}">
                            <option value="${usuario.id}"
                                <c:if test="${permissao != null && permissao.usuario.id == usuario.id}">
                                    selected
                                </c:if> >${usuario.nomeCompleto}</option>
                        </c:forEach> 
                    </select>
                </div>
                <button type="button" class="btn btn-primary" name="novoUsuario" id="novoUsuario" 
                    onclick="location.href='cadastrarUsuario.jsp'" style="font-weight: bold;">+</button>
            </div>
            <div class="form-group form-inline">
                <label for="inscricaoEquipe" class="col-sm-2 col-sm-offset-3 control-label">Inscrição da Equipe:</label>
                <div class="col-sm-3 input-group"> 
                    <select name="inscricaoEquipe" id="inscricaoEquipe" class="form-control">
                        <jsp:useBean id="inscricaoEquipeDAO" class="controller.InscricaoEquipeDAO"/>
                        <c:forEach var="inscricaoEquipe" items="${inscricaoEquipeDAO.retrieve()}">
                            <option value="${inscricaoEquipe.id}"
                                <c:if test="${permissao != null && permissao.incricaoEquipe.id == inscricaoEquipe.id}">
                                    selected
                                </c:if> >${inscricaoEquipe.nomeDaEquipe}</option>
                        </c:forEach> 
                    </select>
                </div>
                <button type="button" class="btn btn-primary" name="novoInscricaoEquipe" id="novoInscricaoEquipe" 
                    onclick="location.href='cadastrarInscricaoEquipe.jsp'" style="font-weight: bold;">+</button>
            </div> 
            <div class="form-group form-inline">
                <label for="combustivel" class="col-sm-2 col-sm-offset-3 control-label">Torneio:</label>
                <div class="col-sm-3 input-group"> 
                    <select name="torneio" id="torneio" class="form-control">
                        <jsp:useBean id="torneioDAO" class="controller.TorneioDAO"/>
                        <c:forEach var="torneio" items="${torneioDAO.retrieve()}">
                            <option value="${torneio.id}"
                                <c:if test="${permissao != null && permissao.torneio.id == torneio.id}">
                                    selected
                                </c:if> >${torneio.nomeDoTorneio}</option>
                        </c:forEach> 
                    </select>
                </div>
                <button type="button" class="btn btn-primary" name="novoTorneio" id="novoTorneio" 
                        onclick="location.href='cadastrarTorneio.jsp'" style="font-weight: bold;">+</button>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${permissao != null}">
                            <input type="hidden" name="idJogador" id="idJogador" value="${permissao.id}">
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Salvar Alterações</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Cadastrar</button>
                            <button type="reset" class="btn btn-primary" style="margin-left: 5px; font-weight: bold;">Limpar</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="button" class="btn btn-primary" onclick="location.href='listarJogador.jsp'" 
                        style="margin-left: 5px; font-weight: bold;">Listar</button>
                </div>
            </div>
            <c:if test="${message != null && !message.isEmpty()}">
                <h3 align="center" id="message">${message}</h3>
            </c:if>
        </form>
    </body>
</html>