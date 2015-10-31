<%-- 
    Document   : listarEquipe
    Created on : 31/08/2015, 00:36:09
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="inscricaoEquipeDAO" class="controller.InscricaoEquipeDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Lista de Inscrições de Equipes</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Lista Abastecimentos -->
        <div align="center">
            <h1>Inscrições de Equipe Cadastradas</h1><h1></h1>
            <h1></h1>   
            <div class="col-sm-10 col-sm-offset-1">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Torneio</th>
                        <th class="text-center">Status da Inscrição</th>
                        <th class="text-center">Preço Total</th>
                        <th class="text-center">Nome da Equipe</th>
                        <th class="text-center">Data de Fundação</th>
                        <th class="text-center">E-mail</th>
                        <th class="text-center">Endereço WEB</th>
                        <th class="text-center">Telefone</th>
                        <th class="text-center">Logradouro</th>
                        <th class="text-center">Nº</th>
                        <th class="text-center">Complemento</th>
                        <th class="text-center">Cidade</th>
                        <th class="text-center">CEP</th>
                        <th class="text-center" colspan="2" style="width: 1%">Ações</th>
                    </tr>
                    <c:forEach var="inscricaoEquipe" varStatus="status" items="${inscricaoEquipeDAO.retrieve()}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose>           
                            <td align="center">${inscricaoEquipe.torneio.nomeDoTorneio}</td>
                            <td align="center">${inscricaoEquipe.statusInscricao}</td>
                            <td align="center">${inscricaoEquipe.precoTotalInscricao}</td>
                            <td align="center">${inscricaoEquipe.nomeDaEquipe}</td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${inscricaoEquipe.dataFundacao}"/></td>
                            <td align="center">${inscricaoEquipe.email}</td>
                            <td align="center">${inscricaoEquipe.enderecoWeb}</td>
                            <td align="center">${inscricaoEquipe.telefone}</td>
                            <td align="center">${inscricaoEquipe.logradouro}</td>
                            <td align="center">${inscricaoEquipe.numeroDaResidencia}</td>
                            <td align="center">${inscricaoEquipe.complemento}</td>
                            <td align="center">${inscricaoEquipe.cidade}</td>
                            <td align="center">${inscricaoEquipe.cep}</td>
                            <form method="post" action="cadastrarInscricaoEquipe.jsp">
                                <td align="center">
                                    <input type="hidden" name="altInscricaoEquipe" id="altInscricaoEquipe" value="${inscricaoEquipe.id}">
                                    <button type="submit" class="btn btn-sm btn-warning">
                                        <span class="glyphicon glyphicon-cog"></span></button>
                                </td>
                            </form>
                            <form method="post" action="InscricaoEquipeServlet">
                                <td align="center">
                                    <input type="hidden" name="excInscricaoEquipe" id="excInscricaoEquipe" value="${inscricaoEquipe.id}">
                                    <input type="hidden" id="operacao" name="operacao" value="apagar">
                                    <button type="submit" class="btn btn-sm btn-danger" 
                                            onclick="return confirm('Tem certeza que deseja excluir esta Inscrição de Equipe?')">
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
    </body>
</html>


