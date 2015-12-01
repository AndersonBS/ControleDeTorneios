<%-- 
    Document   : listarJogador
    Created on : 31/08/2015, 00:36:42
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="jogadorDAO" class="controller.JogadorDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Lista de Jogadores</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Inclusão do Menu Superior padrão -->
        <jsp:include page="navbar.jsp" />        
        
        <c:choose>
            <c:when test="${empty jogadorDAO.retrieve(loggedInUser, selectedTorneio)}">
                <div align="center">
                    <br/>
                    <h3><font color="red">Você não possui nenhum jogador cadastrado em: ${selectedTorneio.nomeDoTorneio}!</font></h3>
                </div>
            </c:when>
            <c:otherwise>
        <!-- Lista Jogadores -->
        <div align="center">
            <h1>Jogadores Cadastrados</h1><h1></h1>
            <h1></h1>   
            <div class="col-sm-10 col-sm-offset-1">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Foto</th>
                        <th class="text-center">Inscrição Equipe</th>
                        <th class="text-center">Posição</th>
                        <th class="text-center">Nome Completo</th>
                        <th class="text-center">CPF</th>
                        <th class="text-center">Data de Nascimento</th>
                        <th class="text-center">E-mail</th>
                        <th class="text-center">Altura</th>
                        <th class="text-center">Peso</th>
                        <th class="text-center">País</th>
                        <th class="text-center">Data de Cadastro</th>
                        <th class="text-center" colspan="2" style="width: 1%">Ações</th>
                    </tr>
                    <c:forEach var="jogador" varStatus="status" items="${jogadorDAO.retrieve(loggedInUser, selectedTorneio)}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose>
                            <td align="center"><img name="foto" id="foto" width="30" height="30" src="FotoServlet?idJogador=${jogador.id}"></td>
                            <td align="center">${jogador.inscricaoEquipe.nomeDaEquipe}</td>
                            <td align="center">${jogador.posicao.nome}</td>
                            <td align="center">${jogador.nomeCompleto}</td>
                            <td align="center">${jogador.cpf}</td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${jogador.dataNascimento}"/></td>
                            <td align="center">${jogador.email}</td>
                            <td align="center">${jogador.altura} M</td>
                            <td align="center">${jogador.peso} Kg</td>
                            <td align="center">${jogador.pais}</td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${jogador.dataCadastro}"/></td>
                            <form method="post" action="cadastrarJogador.jsp">
                                <td align="center">
                                    <input type="hidden" name="altJogador" id="altJogador" value="${jogador.id}">
                                    <button type="submit" class="btn btn-sm btn-warning">
                                        <span class="glyphicon glyphicon-cog"></span></button>
                                </td>
                            </form>
                            <form method="post" action="JogadorServlet">
                                <td align="center">
                                    <input type="hidden" name="excJogador" id="excJogador" value="${jogador.id}">
                                    <input type="hidden" id="operacao" name="operacao" value="apagar">
                                    <button type="submit" class="btn btn-sm btn-danger" 
                                            onclick="return confirm('Tem certeza que deseja excluir este jogador?')">
                                            <span class="glyphicon glyphicon-trash"></span></button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach >
                </table>
                <button type="button" class="btn btn-primary" onclick="location.href='cadastrarInscricaoEquipe.jsp'"
                        style="font-weight: bold;">Inscrever Equipes</button>
                <button type="button" class="btn btn-primary" onclick="location.href='cadastrarJogador.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Cadastrar Jogadores</button>
                <button type="button" class="btn btn-primary" onclick="location.href='index.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Home</button>
                <br><br>
            </div>
        </div>
        </c:otherwise>
        </c:choose>
    </body>
</html>
