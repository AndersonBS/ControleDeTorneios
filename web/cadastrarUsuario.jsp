<%-- 
    Document   : cadastrarUsuario
    Created on : 23/10/2015, 15:52:09
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="usuarioDAO" class="controller.UsuarioDAO"/>
<jsp:useBean id="now" class="java.util.Date" />

<c:if test="${param != null && param.altUsuario != null}">
    <c:set var="usuario" value="${usuarioDAO.retrieve(param.altUsuario)}" scope="page"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Usuário</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <c:choose>
            <c:when test="${param != null && param.altUsuario != null}">
                <h1 align="center">Alteração de Usuário</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Usuário</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="UsuarioServlet">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altUsuario != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="nomeCompleto" class="col-sm-2 col-sm-offset-3 control-label">Nome Completo:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="nomeCompleto" id="nomeCompleto" 
                            placeholder="Digite o nome completo do usuário"
                            <c:if test="${usuario != null}">
                                value=${usuario.nomeCompleto}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="login" class="col-sm-2 col-sm-offset-3 control-label">Login:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="login" id="login" 
                            placeholder="Digite o login do usuário"
                            <c:if test="${usuario != null}">
                                value=${usuario.login}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="senha" class="col-sm-2 col-sm-offset-3 control-label">Senha:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="password" required="true" class="form-control" name="senha" id="senha" 
                            placeholder="Digite a senha do usuário">
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="confirmacaoSenha" class="col-sm-2 col-sm-offset-3 control-label">Confirmação da Senha:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="password" required="true" class="form-control" name="confirmacaoSenha" id="confirmacaoSenha" 
                            placeholder="Digite a senha novamente">
                </div>
            </div>
            <div class="form-group">
                <label for="dataCadastro" class="col-sm-2 col-sm-offset-3 control-label">Data de Cadastro:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="dataCadastro" id="dataCadastro"
                           <c:choose>
                            <c:when test="${usuario != null}">
                                value="${usuario.dataCadastro}"
                            </c:when>
                            <c:otherwise>
                                value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />"
                            </c:otherwise>
                        </c:choose> >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${usuario != null}">
                            <input type="hidden" name="idJogador" id="idJogador" value="${usuario.id}">
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
