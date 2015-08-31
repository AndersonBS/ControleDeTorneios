<%-- 
    Document   : listarEquipe
    Created on : 31/08/2015, 00:36:09
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="equipeDAO" class="controller.EquipeDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Lista de Equipes</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Lista Abastecimentos -->
        <div align="center">
            <h1>Equipes Cadastradas</h1><h1></h1>
            <h1></h1>   
            <div class="col-sm-10 col-sm-offset-1">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Nome</th>
                        <th class="text-center">Data de Fundação</th>
                        <th class="text-center">E-mail</th>
                        <th class="text-center">Endereço WEB</th>
                        <th class="text-center">Fone</th>
                        <th class="text-center" colspan="2" style="width: 1%">Ações</th>
                    </tr>
                    <c:forEach var="equipe" varStatus="status" items="${equipeDAO.retrieve()}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose>           
                            <td align="center">${equipe.nome}</td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${equipe.dataFundacao}"/></td>
                            <td align="center">${equipe.email}</td>
                            <td align="center">${equipe.enderecoWeb}</td>
                            <td align="center">${equipe.fone}</td>
                            <form method="post" action="cadastrarEquipe.jsp">
                                <td align="center">
                                    <input type="hidden" name="altEquipe" id="altEquipe" value="${equipe.id}">
                                    <button type="submit" class="btn btn-sm btn-warning">
                                        <span class="glyphicon glyphicon-cog"></span></button>
                                </td>
                            </form>
                            <form method="post" action="EquipeServlet">
                                <td align="center">
                                    <input type="hidden" name="excEquipe" id="excEquipe" value="${equipe.id}">
                                    <input type="hidden" id="operacao" name="operacao" value="apagar">
                                    <button type="submit" class="btn btn-sm btn-danger" 
                                            onclick="return confirm('Tem certeza que deseja excluir esta equipe?')">
                                            <span class="glyphicon glyphicon-trash"></span></button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach >
                </table>
                <button type="button" class="btn btn-primary" onclick="location.href='cadastrarEquipe.jsp'"
                        style="font-weight: bold;">Cadastrar Equipes</button>
                <button type="button" class="btn btn-primary" onclick="location.href='cadastrarJogador.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Cadastrar Jogadores</button>
                <br><br>
            </div>
        </div>
    </body>
</html>


