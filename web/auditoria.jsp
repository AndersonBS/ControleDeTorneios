<%-- 
    Document   : auditoria
    Created on : 27/10/2015, 00:17:09
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="jogadorDAO" class="controller.JogadorDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Auditoria</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        <!-- Lista Jogadores -->
        <div align="center">
            <h1>Auditoria</h1><h1></h1>
            <button type="button" class="btn btn-primary" onclick="location.href='index.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Home</button>
            <h1></h1>
            <div class="col-sm-10 col-sm-offset-1">
                <ul class="nav nav-pills nav-justified">
                    <li role="presentation" class="btn-default active"><a href="#torneio" aria-controls="home" role="tab" data-toggle="tab" style="font-size:18px">Torneio</a></li>
                    <li role="presentation" class="btn-default"><a href="#inscricaoEquipe" aria-controls="profile" role="tab" data-toggle="tab" style="font-size:18px">Inscrição de Equipe</a></li>
                    <li role="presentation" class="btn-default"><a href="#posicao" aria-controls="messages" role="tab" data-toggle="tab" style="font-size:18px">Posição</a></li>
                    <li role="presentation" class="btn-default"><a href="#jogador" aria-controls="settings" role="tab" data-toggle="tab" style="font-size:18px">Jogador</a></li>
                </ul>
            </div>
            
            <h1></h1>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="torneio">
                    <div class="col-sm-10 col-sm-offset-1">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">REV</th>
                                <th class="text-center">REVTYPE</th>
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
                            </tr>
                            <c:forEach var="torneio" varStatus="status" items="${torneioDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose>
                                    <td align="center">${torneio.REV}</td>
                                    <td align="center">${torneio.REVTYPE}</td>
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
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                        
                <div role="tabpanel" class="tab-pane fade" id="inscricaoEquipe">
                    <div class="col-sm-10 col-sm-offset-1">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">REV</th>
                                <th class="text-center">REVTYPE</th>
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
                            </tr>
                            <c:forEach var="inscricaoEquipe" varStatus="status" items="${inscricaoEquipeDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose>
                                    <td align="center">${inscricaoEquipe.REV}</td>
                                    <td align="center">${inscricaoEquipe.REVTYPE}</td>
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
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                        
                <div role="tabpanel" class="tab-pane fade" id="posicao">
                    <div class="col-sm-10 col-sm-offset-1">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">REV</th>
                                <th class="text-center">REVTYPE</th>
                                <th class="text-center">Nome da Posição</th>
                            </tr>
                            <c:forEach var="posicao" varStatus="status" items="${posicaoDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose>
                                    <td align="center">${posicao.REV}</td>
                                    <td align="center">${posicao.REVTYPE}</td>
                                    <td align="center">${posicao.nome}</td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                        
                <div role="tabpanel" class="tab-pane fade" id="jogador">
                    <div class="col-sm-10 col-sm-offset-1">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">REV</th>
                                <th class="text-center">REVTYPE</th>
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
                            </tr>
                            <c:forEach var="jogador" varStatus="status" items="${jogadorDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose> 
                                    <td align="center">${jogador.REV}</td>
                                    <td align="center">${jogador.REVTYPE}</td>
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
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
            </div>
            
            
        </div>
    </body>
</html>
