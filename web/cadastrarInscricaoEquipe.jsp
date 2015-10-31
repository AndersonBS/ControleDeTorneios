<%-- 
    Document   : cadastrarEquipe
    Created on : 31/08/2015, 00:35:44
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="inscricaoEquipeDAO" class="controller.InscricaoEquipeDAO"/>

<c:if test="${param != null && param.altInscricaoEquipe != null}">
    <c:set var="inscricaoEquipe" value="${inscricaoEquipeDAO.retrieve(param.altInscricaoEquipe)}" scope="page"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Inscrição de Equipe</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <c:choose>
            <c:when test="${param != null && param.altInscricaoEquipe != null}">
                <h1 align="center">Alteração de Inscrição de Equipe</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Inscrição de Equipes</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="InscricaoEquipeServlet">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altInscricaoEquipe != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="combustivel" class="col-sm-2 col-sm-offset-3 control-label">Torneio:</label>
                <div class="col-sm-3 input-group"> 
                    <select name="torneio" id="torneio" class="form-control">
                        <jsp:useBean id="torneioDAO" class="controller.TorneioDAO"/>
                        <c:forEach var="torneio" items="${torneioDAO.retrieve()}">
                            <option value="${torneio.id}"
                                <c:if test="${inscricaoEquipe != null && inscricaoEquipe.torneio.id == torneio.id}">
                                    selected
                                </c:if> >${torneio.nomeDoTorneio}</option>
                        </c:forEach> 
                    </select>
                </div>
                <button type="button" class="btn btn-primary" name="novoTorneio" id="novoTorneio" 
                        onclick="location.href='cadastrarTorneio.jsp'" style="font-weight: bold;">+</button>
            </div>
            <div class="form-group form-inline">
                <label for="nomeDaEquipe" class="col-sm-2 col-sm-offset-3 control-label">Nome da Equipe:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="nomeDaEquipe" id="nomeDaEquipe" 
                            placeholder="Digite o nome da equipe"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.nomeDaEquipe}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="dataFundacao" class="col-sm-2 col-sm-offset-3 control-label">Data da Fundação:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="dataFundacao" id="dataFundacao"
                           <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.dataFundacao}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="email" class="col-sm-2 col-sm-offset-3 control-label">E-mail:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="email" required="true" class="form-control" name="email" id="email" 
                            placeholder="Digite o e-mail da equipe"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.email}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="enderecoWeb" class="col-sm-2 col-sm-offset-3 control-label">Endereço WEB:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="enderecoWeb" id="enderecoWeb" 
                            placeholder="Digite o endereço WEB da equipe"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.enderecoWeb}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="telefone" class="col-sm-2 col-sm-offset-3 control-label">Telefone:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="telefone" id="telefone" 
                            placeholder="Digite o telefone da equipe"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.telefone}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="logradouro" class="col-sm-2 col-sm-offset-3 control-label">Logradouro:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="logradouro" id="logradouro" 
                            placeholder="Digite o logradouro (endereço) da equipe"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.logradouro}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="numeroDaResidencia" class="col-sm-2 col-sm-offset-3 control-label">Número da Residência:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="number" required="true" step="1.0" min="0" class="form-control" name="numeroDaResidencia" id="numeroDaResidencia" 
                            placeholder="Digite o número da residência"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.numeroDaResidencia}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="complemento" class="col-sm-2 col-sm-offset-3 control-label">Complemento:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" class="form-control" name="complemento" id="complemento" 
                            placeholder="Digite o complemento da residência"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.complemento}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="cidade" class="col-sm-2 col-sm-offset-3 control-label">Cidade:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="cidade" id="cidade" 
                            placeholder="Digite a cidade da residência"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.cidade}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="cep" class="col-sm-2 col-sm-offset-3 control-label">CEP:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="number" required="true" class="form-control" maxlength="8" name="cep" id="cep" 
                            placeholder="Digite o cep do local da residência"
                            <c:if test="${inscricaoEquipe != null}">
                                value="${inscricaoEquipe.cep}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${inscricaoEquipe != null}">
                            <input type="hidden" name="idInscricaoEquipe" id="idInscricaoEquipe" value="${inscricaoEquipe.id}">
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Salvar Alterações</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Cadastrar</button>
                            <button type="reset" class="btn btn-primary" style="margin-left: 5px; font-weight: bold;">Limpar</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="button" class="btn btn-primary" onclick="location.href='listarInscricaoEquipe.jsp'" 
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



