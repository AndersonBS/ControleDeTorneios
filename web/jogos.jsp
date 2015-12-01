<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="tabelaJogosDAO" class="controller.TabelaJogosDAO"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Jogos</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
        <script src="JS/Chart.min.js" type="text/javascript"></script>
        
    </head>
    <body>
        
        <!-- Inclusão do Menu Superior padrão -->
        <jsp:include page="navbar.jsp" />        
        
        <!-- Lista Tabela de Jogos -->
        <div align="center">
            <h1>Jogos: ${selectedTorneio.nomeDoTorneio}</h1>
            <div class="col-sm-10 col-sm-offset-1">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <c:choose>
                    <c:when test="${empty tabelaJogosDAO.retrieve(selectedTorneio)}">
                        <div align="center">
                            <br/>
                            <h3><font color="red">Tabela de jogos indisponível!</font></h3>
                        </div>
                    </c:when>
                    <c:otherwise>
                <c:set var="rodada" value="-1" scope="page"></c:set>
                <c:forEach var="tabelaJogos" varStatus="status" items="${tabelaJogosDAO.retrieve(selectedTorneio)}">
                    <c:choose>
                        <c:when test="${rodada != tabelaJogos.numeroRodada}">
                            <c:if test="${status.index != 0}">
                                </table>
                            </c:if>
                            <c:set var="rodada" value="${tabelaJogos.numeroRodada}" scope="page"></c:set>
                            <br>
                            <h3 align="left">Rodada ${tabelaJogos.numeroRodada}</h3>
                            <table class="table table-striped table-hover myTable">
                                <tr class="myTh">
                                    <th class="text-center">Data da Partida</th>
                                    <th class="text-center">Local</th>
                                    <th class="text-right">Equipe Casa</th>
                                    <th class="text-center"></th>
                                    <th class="text-left">Equipe Visitante</th>
                                    <th class="text-right">Placar Casa</th>
                                    <th class="text-center"></th>
                                    <th class="text-left">Placar Visitante</th>
                                </tr>
                                    <c:choose>
                                        <c:when test="${status.index % 2 == 0}">
                                            <tr class="info myRow">
                                        </c:when>
                                        <c:otherwise>
                                            <tr class="active myRow">
                                        </c:otherwise>
                                    </c:choose>           
                                        <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${tabelaJogos.dataPartida}"/></td>
                                        <td align="center">${tabelaJogos.localPartida}</td>
                                        <td align="right"><img name="logo" id="logo" width="21" height="21" 
                                                src="LogoServlet?idInscricaoEquipe=${tabelaJogos.inscricaoEquipeCasa.id}">
                                                ${tabelaJogos.inscricaoEquipeCasa.nomeDaEquipe}</td>
                                        <td align="center">X</td>
                                        <td align="left">${tabelaJogos.inscricaoEquipeVisitante.nomeDaEquipe}
                                                <img name="logo" id="logo" width="21" height="21" 
                                                src="LogoServlet?idInscricaoEquipe=${tabelaJogos.inscricaoEquipeVisitante.id}"></td>
                                        <c:choose>
                                            <c:when test="${tabelaJogos.placarEquipeCasa >= 0 && tabelaJogos.placarEquipeVisitante >= 0}">
                                                <td align="right">${tabelaJogos.placarEquipeCasa}</td>
                                                <td align="center">X</td>
                                                <td align="left">${tabelaJogos.placarEquipeVisitante}</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td align="center"></td>
                                                <td align="center"></td>
                                                <td align="center"></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${status.index % 2 == 0}">
                                    <tr class="info myRow">
                                </c:when>
                                <c:otherwise>
                                    <tr class="active myRow">
                                </c:otherwise>
                            </c:choose>           
                                <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${tabelaJogos.dataPartida}"/></td>
                                <td align="center">${tabelaJogos.localPartida}</td>
                                <td align="right"><img name="logo" id="logo" width="21" height="21" 
                                        src="LogoServlet?idInscricaoEquipe=${tabelaJogos.inscricaoEquipeCasa.id}">
                                        ${tabelaJogos.inscricaoEquipeCasa.nomeDaEquipe}</td>
                                <td align="center">X</td>
                                <td align="left">${tabelaJogos.inscricaoEquipeVisitante.nomeDaEquipe}
                                        <img name="logo" id="logo" width="21" height="21" 
                                        src="LogoServlet?idInscricaoEquipe=${tabelaJogos.inscricaoEquipeVisitante.id}"></td>
                                <c:choose>
                                    <c:when test="${tabelaJogos.placarEquipeCasa >= 0 && tabelaJogos.placarEquipeVisitante >= 0}">
                                        <td align="right">${tabelaJogos.placarEquipeCasa}</td>
                                        <td align="center">X</td>
                                        <td align="left">${tabelaJogos.placarEquipeVisitante}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td align="center"></td>
                                        <td align="center"></td>
                                        <td align="center"></td>
                                    </c:otherwise>
                                </c:choose>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach >
                </table>
                <br><br>
            </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
