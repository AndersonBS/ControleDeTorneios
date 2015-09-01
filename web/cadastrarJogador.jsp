<%-- 
    Document   : cadastrarJogador
    Created on : 31/08/2015, 00:36:27
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="jogadorDAO" class="controller.JogadorDAO"/>

<c:if test="${param != null && param.altJogador != null}">
    <c:set var="jogador" value="${jogadorDAO.findJogador(param.altJogador)}" scope="page"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Jogador</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <c:choose>
            <c:when test="${param != null && param.altJogador != null}">
                <h1 align="center">Alteração de Jogador</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Jogadores</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="JogadorServlet">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altJogador != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="nome" class="col-sm-2 col-sm-offset-3 control-label">Nome:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="nome" id="nome" 
                            placeholder="Digite o nome do jogador"
                            <c:if test="${jogador != null}">
                                value=${jogador.nome}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="cpf" class="col-sm-2 col-sm-offset-3 control-label">CPF:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="number" required="true" class="form-control" name="cpf" id="cpf" 
                            placeholder="Digite o cpf do jogador"
                            <c:if test="${jogador != null}">
                                value=${jogador.cpf}
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="dataNascimento" class="col-sm-2 col-sm-offset-3 control-label">Data de Nascimento:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="dataNascimento" id="dataNascimento"
                           <c:if test="${jogador != null}">
                                value=${jogador.dataNascimento}
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="dataCadastro" class="col-sm-2 col-sm-offset-3 control-label">Data de Cadastro:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="dataCadastro" id="dataCadastro"
                           <c:if test="${jogador != null}">
                                value=${jogador.dataCadastro}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="email" class="col-sm-2 col-sm-offset-3 control-label">E-mail:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="email" required="true" class="form-control" name="email" id="email" 
                            placeholder="Digite o e-mail do jogador"
                            <c:if test="${jogador != null}">
                                value=${jogador.email}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="telefone" class="col-sm-2 col-sm-offset-3 control-label">Telefone:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="telefone" id="telefone" 
                            placeholder="Digite o telefone do jogador"
                            <c:if test="${jogador != null}">
                                value=${jogador.telefone}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="equipe" class="col-sm-2 col-sm-offset-3 control-label">Equipe:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="equipe" id="equipe" 
                            placeholder="Digite a equipe do jogador"
                            <c:if test="${jogador != null}">
                                value=${jogador.equipe}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="posicao" class="col-sm-2 col-sm-offset-3 control-label">Posição:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="posicao" id="posicao" 
                            placeholder="Digite a posição do jogador"
                            <c:if test="${jogador != null}">
                                value=${jogador.posicao}
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${jogador != null}">
                            <input type="hidden" name="idJogador" id="idJogador" value="${jogador.id}">
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
