<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="tabelaClassificacaoDAO" class="controller.TabelaClassificacaoDAO"/>

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
                <c:choose>
                    <c:when test="${empty tabelaClassificacaoDAO.retrieve(selectedTorneio)}">
                        <div align="center">
                            <br/>
                            <h3><font color="red">Tabela de jogos indisponível!</font></h3>
                        </div>
                    </c:when>
                <c:otherwise>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Classificação</th>
                        <th class="text-center">Nome da Equipe</th>
                        <th class="text-center">Pontos</th>
                        <th class="text-center">Jogos</th>
                        <th class="text-center">Vitorias</th>
                        <th class="text-center">Empates</th>
                        <th class="text-center">Derrotas</th>
                        <th class="text-center">Gols Marcados</th>
                        <th class="text-center">Gols Sofridos</th>
                        <th class="text-center">Saldo Gols</th>
                        <th class="text-center">Aproveitamento</th>
                    </tr>
                    <c:forEach var="tabelaClassificacao" varStatus="status" items="${tabelaClassificacaoDAO.retrieve(selectedTorneio)}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose>           
                            <td align="center">${status.index + 1}º</td>
                            <td align="center"><img name="logo" id="logo" width="21" height="21" 
                                src="LogoServlet?idInscricaoEquipe=${tabelaClassificacao.inscricaoEquipe.id}">
                                ${tabelaClassificacao.inscricaoEquipe.nomeDaEquipe}</td>
                            <td align="center">${tabelaClassificacao.getPontos()}</td>
                            <td align="center">${tabelaClassificacao.getNumeroJogos()}</td>
                            <td align="center">${tabelaClassificacao.numeroVitorias}</td>
                            <td align="center">${tabelaClassificacao.numeroEmpates}</td>
                            <td align="center">${tabelaClassificacao.numeroDerrotas}</td>
                            <td align="center">${tabelaClassificacao.numeroGolsMarcados}</td>
                            <td align="center">${tabelaClassificacao.numeroGolsSofridos}</td>
                            <td align="center">${tabelaClassificacao.getSaldoGols()}</td>
                            <td align="center">${tabelaClassificacao.getPercentualAproveitamento()}%</td>
                        </tr>
                    </c:forEach >
                </table>
                <br><br>
            </div>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
