<%-- 
    Document   : cadastrarTorneio
    Created on : 23/10/2015, 15:51:44
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="torneioDAO" class="controller.TorneioDAO"/>
<jsp:useBean id="now" class="java.util.Date" />

<c:if test="${param != null && param.altTorneio != null}">
    <c:set var="torneio" value="${torneioDAO.retrieve(param.altTorneio)}" scope="page"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Torneio</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <c:choose>
            <c:when test="${param != null && param.altTorneio != null}">
                <h1 align="center">Alteração de Torneio</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Torneio</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="TorneioServlet">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altTorneio != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="nomeDoTorneio" class="col-sm-2 col-sm-offset-3 control-label">Nome do Torneio:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="nomeDoTorneio" id="nomeDoTorneio" 
                            placeholder="Digite o nome do torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.nomeDoTorneio}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="inicioRealizacao" class="col-sm-2 col-sm-offset-3 control-label">Início da Realização:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="inicioRealizacao" id="inicioRealizacao"
                           <c:if test="${torneio != null}">
                                value="${torneio.inicioRealizacao}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="finalRealizacao" class="col-sm-2 col-sm-offset-3 control-label">Final da Realização:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="finalRealizacao" id="finalRealizacao"
                           <c:if test="${torneio != null}">
                                value="${torneio.finalRealizacao}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="frequenciaPartidas" class="col-sm-2 col-sm-offset-3 control-label">Frequência das Partidas</label>
                <div class="col-sm-3 input-group">
                    <input type="number" required="true" step="1.0" min="1" max="2" class="form-control" name="frequenciaPartidas" id="frequenciaPartidas" 
                            placeholder="Digite a frequência semanal das partidas"
                            <c:if test="${torneio != null}">
                                value="${torneio.frequenciaPartidas}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="inicioInscricoes" class="col-sm-2 col-sm-offset-3 control-label">Início das Inscrições:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="inicioInscricoes" id="inicioInscricoes"
                           <c:if test="${torneio != null}">
                                value="${torneio.inicioInscricoes}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="finalInscricoes" class="col-sm-2 col-sm-offset-3 control-label">Final das Inscrições:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="finalInscricoes" id="finalInscricoes"
                           <c:if test="${torneio != null}">
                                value="${torneio.finalInscricoes}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="nomeDoResponsavel" class="col-sm-2 col-sm-offset-3 control-label">Nome do Responsável:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="nomeDoResponsavel" id="nomeDoResponsavel" 
                            placeholder="Digite o nome do responsável pelo torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.nomeDoResponsavel}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="enderecoWeb" class="col-sm-2 col-sm-offset-3 control-label">Endereço WEB:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="enderecoWeb" id="enderecoWeb" 
                            placeholder="Digite o endereço web do torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.enderecoWeb}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="email" class="col-sm-2 col-sm-offset-3 control-label">E-mail:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="email" required="true" class="form-control" name="email" id="email" 
                            placeholder="Digite o e-mail do responsável pelo torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.email}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="custoPorJogador" class="col-sm-2 col-sm-offset-3 control-label">Custo de Inscrição por Jogador</label>
                <div class="col-sm-3 input-group">
                    <div class="input-group-addon">R$</div>
                    <input type="number" required="true" step="0.01" min="0" class="form-control" name="custoPorJogador" id="custoPorJogador" 
                            placeholder="Digite o custo (por jogador) de inscrição no torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.custoPorJogador}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="numeroMinimoJogadores" class="col-sm-2 col-sm-offset-3 control-label">Número Mínimo de Jogadores</label>
                <div class="col-sm-3 input-group">
                    <input type="number" required="true" step="1.0" min="0" class="form-control" name="numeroMinimoJogadores" id="numeroMinimoJogadores" 
                            placeholder="Digite o número mínimo de jogadores por enquipe do torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.numeroMinimoJogadores}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="numeroMaximoJogadores" class="col-sm-2 col-sm-offset-3 control-label">Número Máximo de Jogadores</label>
                <div class="col-sm-3 input-group">
                    <input type="number" required="true" step="1.0" min="0" class="form-control" name="numeroMaximoJogadores" id="numeroMaximoJogadores" 
                            placeholder="Digite o número máximo de jogadores por enquipe do torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.numeroMaximoJogadores}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="numeroEquipes" class="col-sm-2 col-sm-offset-3 control-label">Número de Equipes</label>
                <div class="col-sm-3 input-group">
                    <input type="number" required="true" step="1.0" min="0" class="form-control" name="numeroEquipes" id="numeroEquipes" 
                            placeholder="Digite o número de equipes do torneio"
                            <c:if test="${torneio != null}">
                                value="${torneio.numeroEquipes}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${torneio != null}">
                            <input type="hidden" name="idTorneio" id="idTorneio" value="${torneio.id}">
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Salvar Alterações</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Cadastrar</button>
                            <button type="reset" class="btn btn-primary" style="margin-left: 5px; font-weight: bold;">Limpar</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="button" class="btn btn-primary" onclick="location.href='listarTorneio.jsp'" 
                        style="margin-left: 5px; font-weight: bold;">Listar</button>
                    <button type="button" class="btn btn-primary" onclick="location.href='index.jsp'" 
                        style="margin-left: 3px; font-weight: bold;">Home</button>
                </div>
            </div>
            <c:if test="${message != null && !message.isEmpty()}">
                <h3 align="center" id="message">${message}</h3>
            </c:if>
        </form>
    </body>
</html>

