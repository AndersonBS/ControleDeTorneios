<%-- 
    Document   : listarPosicao
    Created on : 26/10/2015, 15:47:48
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="posicaoDAO" class="controller.PosicaoDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Lista de Posições</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Lista Abastecimentos -->
        <div align="center">
            <h1>Posições Cadastradas</h1><h1></h1>
            <h1></h1>   
            <div class="col-sm-10 col-sm-offset-1">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Nome da Posição</th>
                        <th class="text-center" colspan="2" style="width: 1%">Ações</th>
                    </tr>
                    <c:forEach var="posicao" varStatus="status" items="${posicaoDAO.retrieve()}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose>           
                            <td align="center">${posicao.nome}</td>
                            <form method="post" action="cadastrarPosicao.jsp">
                                <td align="center">
                                    <input type="hidden" name="altPosicao" id="altPosicao" value="${posicao.id}">
                                    <button type="submit" class="btn btn-sm btn-warning">
                                        <span class="glyphicon glyphicon-cog"></span></button>
                                </td>
                            </form>
                            <form method="post" action="PosicaoServlet">
                                <td align="center">
                                    <input type="hidden" name="excPosicao" id="excPosicao" value="${posicao.id}">
                                    <input type="hidden" id="operacao" name="operacao" value="apagar">
                                    <button type="submit" class="btn btn-sm btn-danger" 
                                            onclick="return confirm('Tem certeza que deseja excluir esta Inscrição de Equipe?')">
                                            <span class="glyphicon glyphicon-trash"></span></button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach >
                </table>
                <button type="button" class="btn btn-primary" onclick="location.href='cadastrarPosicao.jsp'"
                        style="font-weight: bold;">Cadastrar Posição</button>
                <button type="button" class="btn btn-primary" onclick="location.href='index.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Home</button>
                <br><br>
            </div>
        </div>
    </body>
</html>

