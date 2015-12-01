<%-- 
    Document   : auditoria
    Created on : 27/10/2015, 00:17:09
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="jogadorDAO" class="controller.JogadorDAO"/>
<jsp:useBean id="inscricaoEquipeDAO" class="controller.InscricaoEquipeDAO"/>
<jsp:useBean id="torneioDAO" class="controller.TorneioDAO"/>
<jsp:useBean id="posicaoDAO" class="controller.PosicaoDAO"/>
<jsp:useBean id="permissaoDAO" class="controller.PermissaoDAO"/>
<jsp:useBean id="usuarioDAO" class="controller.UsuarioDAO"/>
<jsp:useBean id="tabelaClassificacaoDAO" class="controller.TabelaClassificacaoDAO"/>
<jsp:useBean id="tabelaJogosDAO" class="controller.TabelaJogosDAO"/>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Auditoria</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Inclusão do Menu Superior padrão -->
        <jsp:include page="navbar.jsp" />      
        
        <div align="center">
            <h1>Auditoria</h1><h1></h1>
            <h1></h1>
            <div class="col-sm-12">
                <ul class="nav nav-pills nav-justified">
                    <li role="presentation" class="btn-default active"><a href="#torneio-tab" aria-controls="home" role="tab" data-toggle="tab" style="font-size:18px">Torneio</a></li>
                    <li role="presentation" class="btn-default"><a href="#inscricaoEquipe-tab" aria-controls="profile" role="tab" data-toggle="tab" style="font-size:18px">Equipe</a></li>
                    <li role="presentation" class="btn-default"><a href="#posicao-tab" aria-controls="messages" role="tab" data-toggle="tab" style="font-size:18px">Posição</a></li>
                    <li role="presentation" class="btn-default"><a href="#jogador-tab" aria-controls="settings" role="tab" data-toggle="tab" style="font-size:18px">Jogador</a></li>
                    <li role="presentation" class="btn-default"><a href="#permissao-tab" aria-controls="settings" role="tab" data-toggle="tab" style="font-size:18px">Permissão</a></li>
                    <li role="presentation" class="btn-default"><a href="#usuario-tab" aria-controls="settings" role="tab" data-toggle="tab" style="font-size:18px">Usuário</a></li>
                    <li role="presentation" class="btn-default"><a href="#tabelaClassificacao-tab" aria-controls="settings" role="tab" data-toggle="tab" style="font-size:18px">Classificação</a></li>
                    <li role="presentation" class="btn-default"><a href="#tabelaJogos-tab" aria-controls="settings" role="tab" data-toggle="tab" style="font-size:18px">Jogos</a></li>
                </ul>
            </div>
            
            <!-- AUDITORIA: Torneio -->
            <h1></h1>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="torneio-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
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
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${torneio.data}"/></td>
                                    <td align="center">${torneio.revisao}</td>
                                    <td align="center">${torneio.operacao}</td>
                                    <td align="center">${torneio.classe.id}</td>
                                    <td align="center">${torneio.classe.nomeDoTorneio}</td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.classe.inicioRealizacao}"/></td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.classe.finalRealizacao}"/></td>
                                    <td align="center">${torneio.classe.frequenciaPartidas}</td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.classe.inicioInscricoes}"/></td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${torneio.classe.finalInscricoes}"/></td>
                                    <td align="center">${torneio.classe.nomeDoResponsavel}</td>
                                    <td align="center">${torneio.classe.enderecoWeb}</td>
                                    <td align="center">${torneio.classe.email}</td>
                                    <td align="center">R$ ${torneio.classe.custoPorJogador}</td>
                                    <td align="center">${torneio.classe.numeroMinimoJogadores}</td>
                                    <td align="center">${torneio.classe.numeroMaximoJogadores}</td>
                                    <td align="center">${torneio.classe.numeroEquipes}</td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                <!-- AUDITORIA: Inscrição Equipe -->    
                <div role="tabpanel" class="tab-pane fade" id="inscricaoEquipe-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
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
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${inscricaoEquipe.data}"/></td>
                                    <td align="center">${inscricaoEquipe.revisao}</td>
                                    <td align="center">${inscricaoEquipe.operacao}</td>
                                    <td align="center">${inscricaoEquipe.classe.id}</td>
                                    <td align="center">FK</td>
                                    <td align="center">${inscricaoEquipe.classe.statusInscricao}</td>
                                    <td align="center">${inscricaoEquipe.classe.precoTotalInscricao}</td>
                                    <td align="center">${inscricaoEquipe.classe.nomeDaEquipe}</td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${inscricaoEquipe.classe.dataFundacao}"/></td>
                                    <td align="center">${inscricaoEquipe.classe.email}</td>
                                    <td align="center">${inscricaoEquipe.classe.enderecoWeb}</td>
                                    <td align="center">${inscricaoEquipe.classe.telefone}</td>
                                    <td align="center">${inscricaoEquipe.classe.logradouro}</td>
                                    <td align="center">${inscricaoEquipe.classe.numeroDaResidencia}</td>
                                    <td align="center">${inscricaoEquipe.classe.complemento}</td>
                                    <td align="center">${inscricaoEquipe.classe.cidade}</td>
                                    <td align="center">${inscricaoEquipe.classe.cep}</td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                <!-- AUDITORIA: Posição -->     
                <div role="tabpanel" class="tab-pane fade" id="posicao-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
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
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${posicao.data}"/></td>
                                    <td align="center">${posicao.revisao}</td>
                                    <td align="center">${posicao.operacao}</td>
                                    <td align="center">${posicao.classe.id}</td>
                                    <td align="center">${posicao.classe.nome}</td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                <!-- AUDITORIA: Jogador -->        
                <div role="tabpanel" class="tab-pane fade" id="jogador-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
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
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${jogador.data}"/></td>
                                    <td align="center">${jogador.revisao}</td>
                                    <td align="center">${jogador.operacao}</td>
                                    <td align="center">${jogador.classe.id}</td>
                                    <td align="center">FK</td>
                                    <td align="center">FK</td>
                                    <td align="center">${jogador.classe.nomeCompleto}</td>
                                    <td align="center">${jogador.classe.cpf}</td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${jogador.classe.dataNascimento}"/></td>
                                    <td align="center">${jogador.classe.email}</td>
                                    <td align="center">${jogador.classe.altura} M</td>
                                    <td align="center">${jogador.classe.peso} Kg</td>
                                    <td align="center">${jogador.classe.pais}</td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${jogador.classe.dataCadastro}"/></td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
            
            
                        
                <!-- AUDITORIA: Permissão -->        
                <div role="tabpanel" class="tab-pane fade" id="permissao-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
                                <th class="text-center">Usuário</th>
                                <th class="text-center">Inscrição Equipe</th>
                                <th class="text-center">Torneio</th>
                            </tr>
                            <c:forEach var="permissao" varStatus="status" items="${permissaoDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose> 
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${permissao.data}"/></td>
                                    <td align="center">${permissao.revisao}</td>
                                    <td align="center">${permissao.operacao}</td>
                                    <td align="center">${permissao.classe.id}</td>
                                    <td align="center">FK</td>
                                    <td align="center">FK</td>
                                    <td align="center">FK</td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                
                <!-- AUDITORIA: Usuário -->        
                <div role="tabpanel" class="tab-pane fade" id="usuario-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
                                <th class="text-center">Nome Completo</th>
                                <th class="text-center">Login</th>
                                <th class="text-center">Senha</th>
                                <th class="text-center">Data de Cadastro</th>
                            </tr>
                            <c:forEach var="usuario" varStatus="status" items="${usuarioDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose> 
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${usuario.data}"/></td>
                                    <td align="center">${usuario.revisao}</td>
                                    <td align="center">${usuario.operacao}</td>
                                    <td align="center">${usuario.classe.id}</td>
                                    <td align="center">${usuario.classe.nomeCompleto}</td>
                                    <td align="center">${usuario.classe.login}</td>
                                    <td align="center">${usuario.classe.senha}</td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${usuario.classe.dataCadastro}"/></td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                        
               <!-- AUDITORIA: Tabela Classificação -->        
                <div role="tabpanel" class="tab-pane fade" id="tabelaClassificacao-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
                                <th class="text-center">Torneio</th>
                                <th class="text-center">Inscrição Equipe</th>
                                <th class="text-center">Nº Vitórias</th>
                                <th class="text-center">Nº Empates</th>
                                <th class="text-center">Nº Derrotas</th>
                                <th class="text-center">Gols Marcados</th>
                                <th class="text-center">Gols Sofridos</th>
                            </tr>
                            <c:forEach var="tabelaClassificacao" varStatus="status" items="${tabelaClassificacaoDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose> 
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${tabelaClassificacao.data}"/></td>
                                    <td align="center">${tabelaClassificacao.revisao}</td>
                                    <td align="center">${tabelaClassificacao.operacao}</td>
                                    <td align="center">${tabelaClassificacao.classe.id}</td>
                                    <td align="center">FK</td>
                                    <td align="center">FK</td>
                                    <td align="center">${tabelaClassificacao.classe.numeroVitorias}</td>
                                    <td align="center">${tabelaClassificacao.classe.numeroEmpates}</td>
                                    <td align="center">${tabelaClassificacao.classe.numeroDerrotas}</td>
                                    <td align="center">${tabelaClassificacao.classe.numeroGolsMarcados}</td>
                                    <td align="center">${tabelaClassificacao.classe.numeroGolsSofridos}</td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                        
                <!-- AUDITORIA: Tabela Jogos -->        
                <div role="tabpanel" class="tab-pane fade" id="tabelaJogos-tab">
                    <div class="col-sm-12">
                        <br>
                        <c:if test="${message != null && !message.isEmpty()}">
                            <h3 align="center" id="message">${message}</h3>
                        </c:if>
                        <table class="table table-striped table-hover myTable">
                            <tr class="myTh">
                                <th class="text-center">Data e Hora</th>
                                <th class="text-center">Revisão</th>
                                <th class="text-center">Operação</th>
                                <th class="text-center">ID</th>
                                <th class="text-center">Torneio</th>
                                <th class="text-center">Nº Rodada</th>
                                <th class="text-center">Data Partida</th>
                                <th class="text-center">Local Partida</th>
                                <th class="text-center">Equipe Casa</th>
                                <th class="text-center">Equipe Visitante</th>
                                <th class="text-center">Placar Equipe Casa</th>
                                <th class="text-center">Placar Equipe Visitante</th>
                            </tr>
                            <c:forEach var="tabelaJogos" varStatus="status" items="${tabelaJogosDAO.auditoria()}">
                                <c:choose>
                                    <c:when test="${status.index % 2 == 0}">
                                        <tr class="info myRow">
                                    </c:when>
                                    <c:otherwise>
                                        <tr class="active myRow">
                                    </c:otherwise>
                                </c:choose> 
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${tabelaJogos.data}"/></td>
                                    <td align="center">${tabelaJogos.revisao}</td>
                                    <td align="center">${tabelaJogos.operacao}</td>
                                    <td align="center">${tabelaJogos.classe.id}</td>
                                    <td align="center">FK</td>
                                    <td align="center">${tabelaJogos.classe.numeroRodada}</td>
                                    <td align="center"><fmt:formatDate pattern="dd/MM/yyyy" value="${tabelaJogos.classe.dataPartida}"/></td>
                                    <td align="center">${tabelaJogos.classe.localPartida}</td>
                                    <td align="center">FK</td>
                                    <td align="center">FK</td>
                                    <td align="center">${tabelaJogos.classe.placarEquipeCasa}</td>
                                    <td align="center">${tabelaJogos.classe.placarEquipeVisitante}</td>
                                </tr>
                            </c:forEach >
                        </table>
                    </div>
                </div>
                        
                        
            </div>
            
        </div>
    </body>
</html>
