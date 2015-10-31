<%-- 
    Document   : listarTorneio
    Created on : 26/10/2015, 15:48:20
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="torneioDAO" class="controller.TorneioDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Lista de Torneios</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Lista Torneios -->
        <div align="center">
            <h1>Torneios Cadastrados</h1><h1></h1>
            <h1></h1>   
            <div class="col-sm-10 col-sm-offset-1">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Nome do Torneio</th>
                        <th class="text-center">Início Realização</th>
                        <th class="text-center">Final Realização</th>
                        <th class="text-center">Frequência das Partidas</th>
                        <th class="text-center">Início Inscrições</th>
                        <th class="text-center">Final Inscrições</th>
                        <th class="text-center">Nome do Responsável</th>
                        <th class="text-center">Endereço WEB</th>
                        <th class="text-center">E-Mail</th>
                        <th class="text-center">Custo por Jogador</th>
                        <th class="text-center">Nº Mínimo de Jogadores</th>
                        <th class="text-center">Nº Máximo de Jogadores</th>
                        <th class="text-center">Nº de Equipes</th>
                        <th class="text-center" colspan="2" style="width: 1%">Ações</th>
                    </tr>
                    <c:forEach var="torneio" varStatus="status" items="${torneioDAO.retrieve()}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose> 
                            <td align="center">${torneio.nomeDoTorneio}</td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.inicioRealizacao}"/></td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.finalRealizacao}"/></td>
                            <td align="center">${torneio.frequenciaPartidas}</td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.inicioInscricoes}"/></td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.finalInscricoes}"/></td>
                            <td align="center">${torneio.nomeDoResponsavel}</td>
                            <td align="center">${torneio.enderecoWeb}</td>
                            <td align="center">${torneio.email}</td>
                            <td align="center">${torneio.custoPorJogador} M</td>
                            <td align="center">${torneio.numeroMinimoJogadores} Kg</td>
                            <td align="center">${torneio.numeroMaximoJogadores}</td>
                            <td align="center">${torneio.numeroEquipes}</td>
                            <form method="post" action="cadastrarTorneio.jsp">
                                <td align="center">
                                    <input type="hidden" name="altTorneio" id="altTorneio" value="${torneio.id}">
                                    <button type="submit" class="btn btn-sm btn-warning">
                                        <span class="glyphicon glyphicon-cog"></span></button>
                                </td>
                            </form>
                            <form method="post" action="TorneioServlet">
                                <td align="center">
                                    <input type="hidden" name="excTorneio" id="excTorneio" value="${torneio.id}">
                                    <input type="hidden" id="operacao" name="operacao" value="apagar">
                                    <button type="submit" class="btn btn-sm btn-danger" 
                                            onclick="return confirm('Tem certeza que deseja excluir este torneio?')">
                                            <span class="glyphicon glyphicon-trash"></span></button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach >
                </table>
                <button type="button" class="btn btn-primary" onclick="location.href='cadastrarTorneio.jsp'"
                        style="font-weight: bold;">Cadastrar Torneio</button>
                <button type="button" class="btn btn-primary" onclick="location.href='cadastrarInscricaoEquipe.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Inscrever Equipe</button>
                <button type="button" class="btn btn-primary" onclick="location.href='index.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Home</button>
                <br><br>
            </div>
        </div>
    </body>
</html>

