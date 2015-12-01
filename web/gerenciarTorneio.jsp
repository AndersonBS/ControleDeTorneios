<%-- 
    Document   : listarTorneio
    Created on : 26/10/2015, 15:48:20
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="torneioDAO" class="controller.TorneioDAO"/>
<jsp:useBean id="inscricaoEquipeDAO" class="controller.InscricaoEquipeDAO"/>
<jsp:useBean id="usuarioDAO" class="controller.UsuarioDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Lista de Torneios</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Inclusão do Menu Superior padrão -->
        <jsp:include page="navbar.jsp" />        
        
        <c:if test="${usuarioDAO.hasPermission(loggedInUser, selectedTorneio)}">
        <!-- Lista Torneios -->
        <div align="center">
            <h1>${selectedTorneio.nomeDoTorneio}</h1>
            <h1></h1>   
            <div class="col-sm-12">
                <c:if test="${message != null && !message.isEmpty()}">
                    <h3 align="center" id="message">${message}</h3>
                </c:if>
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
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
                    <tr class="info myRow">
                        <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${selectedTorneio.inicioRealizacao}"/></td>
                        <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${selectedTorneio.finalRealizacao}"/></td>
                        <td align="center">${selectedTorneio.frequenciaPartidas}</td>
                        <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${selectedTorneio.inicioInscricoes}"/></td>
                        <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${selectedTorneio.finalInscricoes}"/></td>
                        <td align="center">${selectedTorneio.nomeDoResponsavel}</td>
                        <td align="center">${selectedTorneio.enderecoWeb}</td>
                        <td align="center">${selectedTorneio.email}</td>
                        <td align="center">R$ ${selectedTorneio.custoPorJogador}</td>
                        <td align="center">${selectedTorneio.numeroMinimoJogadores}</td>
                        <td align="center">${selectedTorneio.numeroMaximoJogadores}</td>
                        <td align="center">${selectedTorneio.numeroEquipes}</td>
                        <form method="post" action="cadastrarTorneio.jsp">
                            <td align="center">
                                <input type="hidden" name="altTorneio" id="altTorneio" value="${selectedTorneio.id}">
                                <button type="submit" class="btn btn-sm btn-warning">
                                    <span class="glyphicon glyphicon-cog"></span></button>
                            </td>
                        </form>
                        <form method="post" action="TorneioServlet">
                            <td align="center">
                                <input type="hidden" name="excTorneio" id="excTorneio" value="${selectedTorneio.id}">
                                <input type="hidden" id="operacao" name="operacao" value="apagar">
                                <button type="submit" class="btn btn-sm btn-danger" 
                                        onclick="return confirm('Tem certeza que deseja excluir este torneio?')">
                                        <span class="glyphicon glyphicon-trash"></span></button>
                            </td>
                        </form>
                    </tr>
                </table>
            </div>
            <div class="row col-sm-offset-2">
                <div class="form-group col-sm-4">
                    <div class="pull-right">
                        <form method="post" action="TabelaClassificacaoServlet">
                            <input type="hidden" name="operacao" id="operacao" value="criar">
                            <button type="submit" style="font-weight: bold;" class="btn btn-primary"
                                    onclick="return confirm('Caso haja uma Tabela de Classificação criada, esta será apagada juntamente com seus dados. Uma nova tabela será gerada! Deseja continuar?')">
                                Gerar Tabela de Classificação</button>
                        </form>
                    </div>
                </div>
                <div class="form-group col-sm-2">
                    <form method="post" action="TabelaJogosServlet">
                        <input type="hidden" name="operacao" id="operacao" value="criar">
                        <button type="submit" style="font-weight: bold;" class="btn btn-primary"
                                onclick="return confirm('Caso haja uma Tabela de Jogos criada, esta será apagada juntamente com seus dados. Uma nova tabela será gerada! Deseja continuar?')">
                                Gerar Tabela de Jogos</button>
                    </form>
                </div>
                <div class="form-group col-sm-4">
                    <div class="pull-left">
                        <button type="button" class="btn btn-primary" onclick="location.href='gerenciarJogos.jsp'" 
                            style="font-weight: bold;">Lançar Dados de Partida</button>
                    </div>
                </div>
            </div>
        </div>
                                
        <!-- Lista Equipes Inscritas -->
        <div align="center">
            <h1></h1> 
            <div class="col-sm-12">
                <h1>Equipes Inscritas</h1>
            <h1></h1> 
                <table class="table table-striped table-hover myTable">
                    <tr class="myTh">
                        <th class="text-center">Logo</th>
                        <th class="text-center">Nome da Equipe</th>
                        <th class="text-center">Status da Inscrição</th>
                        <th class="text-center">Preço Total</th>
                        <th class="text-center">Data de Fundação</th>
                        <th class="text-center">E-mail</th>
                        <th class="text-center">Endereço WEB</th>
                        <th class="text-center">Telefone</th>
                        <th class="text-center">Logradouro</th>
                        <th class="text-center">Nº</th>
                        <th class="text-center">Complemento</th>
                        <th class="text-center">Cidade</th>
                        <th class="text-center">CEP</th>
                        <th class="text-center" colspan="4" style="width: 1%">Ações</th>
                    </tr>
                    <c:forEach var="inscricaoEquipe" varStatus="status" items="${inscricaoEquipeDAO.retrieve(selectedTorneio)}">
                        <c:choose>
                            <c:when test="${status.index % 2 == 0}">
                                <tr class="info myRow">
                            </c:when>
                            <c:otherwise>
                                <tr class="active myRow">
                            </c:otherwise>
                        </c:choose>
                            <td align="center"><img name="logo" id="logo" width="30" height="30" src="LogoServlet?idInscricaoEquipe=${inscricaoEquipe.id}"></td>
                            <td align="center">${inscricaoEquipe.nomeDaEquipe}</td>
                            <td align="center">${inscricaoEquipe.statusInscricao}</td>
                            <td align="center">R$ <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">${inscricaoEquipe.precoTotalInscricao}</fmt:formatNumber></td>
                            <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${inscricaoEquipe.dataFundacao}"/></td>
                            <td align="center">${inscricaoEquipe.email}</td>
                            <td align="center">${inscricaoEquipe.enderecoWeb}</td>
                            <td align="center">${inscricaoEquipe.telefone}</td>
                            <td align="center">${inscricaoEquipe.logradouro}</td>
                            <td align="center">${inscricaoEquipe.numeroDaResidencia}</td>
                            <td align="center">${inscricaoEquipe.complemento}</td>
                            <td align="center">${inscricaoEquipe.cidade}</td>
                            <td align="center">${inscricaoEquipe.cep}</td>
                            <form method="post" action="RelatorioInscricaoEquipeServlet">
                                <td align="center">
                                    <input type="hidden" name="inscricaoEquipe" id="inscricaoEquipe" value="${inscricaoEquipe.id}">
                                    <button type="submit" class="btn btn-sm btn-primary">
                                            <span class="glyphicon glyphicon-print"></span></button>
                                </td>
                            </form>
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
                            <c:if test="${inscricaoEquipe.statusInscricao == 'Finalizada'}">
                                <form method="post" action="InscricaoEquipeServlet">
                                    <td align="center">
                                        <input type="hidden" name="pagamento" id="pagamento" value="${inscricaoEquipe.id}">
                                        <input type="hidden" id="operacao" name="operacao" value="pagamento">
                                        <button type="submit" class="btn btn-sm btn-success" 
                                                onclick="return confirm('Tem certeza que Inscrição de Equipe foi paga?')">
                                                <span class="glyphicon glyphicon-usd"></span></button>
                                    </td>
                                </form>
                            </c:if>
                            <c:if test="${inscricaoEquipe.statusInscricao != 'Finalizada'}">
                                <td></td>
                            </c:if>
                        </tr>
                    </c:forEach >
                </table>
                <br><br>
            </div>
        </div>
        </c:if>
        <div align="center">
            <c:if test="${!usuarioDAO.hasPermission(loggedInUser, selectedTorneio)}">
                <br/>
                <h3><font color="red">Você não tem permissão para gerenciar: ${selectedTorneio.nomeDoTorneio}!</font></h3>
            </c:if>
        </div>
    </body>
</html>

