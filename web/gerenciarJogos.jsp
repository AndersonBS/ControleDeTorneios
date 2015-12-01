<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="tabelaJogosDAO" class="controller.TabelaJogosDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Classificação</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
        <script src="JS/Chart.min.js" type="text/javascript"></script>
        
    </head>
    <body>
        
        <!-- Inclusão do Menu Superior padrão -->
        <jsp:include page="navbar.jsp" />        
        
        <!-- Lista Classificação -->
        <div align="center">
            <h1>Classificação ${selectedTorneio.nomeDoTorneio}</h1><h1></h1>
            <h1></h1>   
            <div class="col-sm-10 col-sm-offset-1">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Data da Partida</th>
                        <th class="text-center">Local</th>
                        <th class="text-right">Equipe Casa</th>
                        <th class="text-center"></th>
                        <th class="text-left">Equipe Visitante</th>
                        <th class="text-center">Placar Casa</th>
                        <th class="text-center"></th>
                        <th class="text-center">Placar Visitante</th>
                        <th class="text-center">Confirmar</th>
                    </tr>
                    <c:forEach var="tabelaJogos" varStatus="status" items="${tabelaJogosDAO.retrieve(selectedTorneio)}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose>
                            <form method="post" action="TabelaJogosServlet">
                                <input type="hidden" id="idTabelaJogos" name="idTabelaJogos" value="${tabelaJogos.id}">
                                <td align="center"><input type="date" id="dataPartida" name="dataPartida" value="${tabelaJogos.dataPartida}"></td>
                                <td align="center"><input type="text" id="localPartida" name="localPartida" value="${tabelaJogos.localPartida}"></td>
                                <td align="right"><img name="logo" id="logo" width="30" height="30" 
                                        src="LogoServlet?idInscricaoEquipe=${tabelaJogos.inscricaoEquipeCasa.id}">
                                        ${tabelaJogos.inscricaoEquipeCasa.nomeDaEquipe}</td>
                                <td align="center">X</td>
                                <td align="left"><img name="logo" id="logo" width="30" height="30" 
                                        src="LogoServlet?idInscricaoEquipe=${tabelaJogos.inscricaoEquipeVisitante.id}">
                                        ${tabelaJogos.inscricaoEquipeVisitante.nomeDaEquipe}</td>
                                <input type="hidden" id="operacao" name="operacao" value="alterar">
                                <td align="center"><input type="number" id="placarEquipeCasa" name="placarEquipeCasa" value="${tabelaJogos.placarEquipeCasa}"></td>
                                <td align="center">X</td>
                                <td align="center"><input type="number" id="placarEquipeVisitante" name="placarEquipeVisitante" value="${tabelaJogos.placarEquipeVisitante}"></td>
                                <td align="center"><button type="submit" class="btn btn-sm btn-primary"><span class="glyphicon glyphicon-ok"></span></button></td>
                            </form>
                        </tr>
                    </c:forEach >
                </table>
                <br><br>
            </div>
        </div>
    </body>
</html>
