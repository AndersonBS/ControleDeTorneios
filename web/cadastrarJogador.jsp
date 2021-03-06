<%-- 
    Document   : cadastrarJogador
    Created on : 31/08/2015, 00:36:27
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="jogadorDAO" class="controller.JogadorDAO"/>
<jsp:useBean id="now" class="java.util.Date" />

<c:if test="${param != null && param.altJogador != null}">
    <c:set var="jogador" value="${jogadorDAO.retrieve(param.altJogador)}" scope="page"></c:set>
    <c:set var="idJogador" value="${jogador.id}" scope="session"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Jogador</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Inclusão do Menu Superior padrão -->
        <jsp:include page="navbar.jsp" />        
        
        <c:choose>
            <c:when test="${param != null && param.altJogador != null}">
                <h1 align="center">Alteração de Jogador</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Jogador em ${selectedTorneio.nomeDoTorneio}</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="JogadorServlet" enctype="multipart/form-data">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altJogador != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="inscricaoEquipe" class="col-sm-2 col-sm-offset-3 control-label">Equipe:</label>
                <div class="col-sm-3 input-group"> 
                    <select name="inscricaoEquipe" id="inscricaoEquipe" class="form-control">
                        <jsp:useBean id="inscricaoEquipeDAO" class="controller.InscricaoEquipeDAO"/>
                        <c:forEach var="inscricaoEquipe" items="${inscricaoEquipeDAO.retrieve(loggedInUser, selectedTorneio)}">
                            <option value="${inscricaoEquipe.id}"
                                <c:if test="${jogador != null && jogador.inscricaoEquipe.id == inscricaoEquipe.id}">
                                    selected
                                </c:if> >${inscricaoEquipe.nomeDaEquipe}</option>
                        </c:forEach> 
                    </select>
                </div>
                <button type="button" class="btn btn-primary" name="novoInscricaoEquipe" id="novoInscricaoEquipe" 
                    onclick="location.href='cadastrarInscricaoEquipe.jsp'" style="font-weight: bold;">+</button>
            </div>
            <div class="form-group form-inline">
                <label for="posicao" class="col-sm-2 col-sm-offset-3 control-label">Posição:</label>
                <div class="col-sm-3 input-group"> 
                    <select name="posicao" id="posicao" class="form-control">
                        <jsp:useBean id="posicaoDAO" class="controller.PosicaoDAO"/>
                        <c:forEach var="posicao" items="${posicaoDAO.retrieve()}">
                            <option value="${posicao.id}"
                                <c:if test="${jogador != null && jogador.posicao.id == posicao.id}">
                                    selected
                                </c:if> >${posicao.nome}</option>
                        </c:forEach> 
                    </select>
                </div>
            </div>     
            <div class="form-group form-inline">
                <label for="nomeCompleto" class="col-sm-2 col-sm-offset-3 control-label">Nome Completo:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="nomeCompleto" id="nomeCompleto" 
                            placeholder="Digite o nome completo do jogador"
                            <c:if test="${jogador != null}">
                                value="${jogador.nomeCompleto}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="cpf" class="col-sm-2 col-sm-offset-3 control-label">CPF:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="number" required="true" class="form-control" maxlength="11" name="cpf" id="cpf" 
                            placeholder="Digite o cpf do jogador"
                            <c:if test="${jogador != null}">
                                value="${jogador.cpf}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="dataNascimento" class="col-sm-2 col-sm-offset-3 control-label">Data de Nascimento:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="dataNascimento" id="dataNascimento"
                           <c:if test="${jogador != null}">
                                value="${jogador.dataNascimento}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="email" class="col-sm-2 col-sm-offset-3 control-label">E-mail:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="email" required="true" class="form-control" name="email" id="email" 
                            placeholder="Digite o e-mail do jogador"
                            <c:if test="${jogador != null}">
                                value="${jogador.email}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="altura" class="col-sm-2 col-sm-offset-3 control-label">Altura:</label>
                <div class="col-sm-3 input-group">
                    <div class="input-group-addon">Metros</div>
                    <input type="number" required="true" step="0.01" min="0" class="form-control" name="altura" id="altura" 
                            placeholder="Digite a altura do jogador"
                            <c:if test="${jogador != null}">
                                value="${jogador.altura}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="peso" class="col-sm-2 col-sm-offset-3 control-label">Peso:</label>
                <div class="col-sm-3 input-group">
                    <div class="input-group-addon">KG</div>
                    <input type="number" required="true" step="0.1" min="0" class="form-control" name="peso" id="peso" 
                            placeholder="Digite o peso do jogador"
                            <c:if test="${jogador != null}">
                                value="${jogador.peso}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="pais" class="col-sm-2 col-sm-offset-3 control-label">País:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="pais" id="pais" 
                            placeholder="Digite o país do jogador"
                            <c:if test="${jogador != null}">
                                value="${jogador.pais}"
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="dataCadastro" class="col-sm-2 col-sm-offset-3 control-label">Data de Cadastro:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="dataCadastro" id="dataCadastro"
                           <c:choose>
                            <c:when test="${jogador != null}">
                                value="${jogador.dataCadastro}"
                            </c:when>
                            <c:otherwise>
                                value="<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" />"
                            </c:otherwise>
                        </c:choose> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="foto" class="col-sm-2 col-sm-offset-3 control-label">Foto:</label>
                <div class="col-sm-3 input-group">
                    <label for="foto"><img name="show_foto" id="show_foto" width="150" height="200" 
                            <c:choose>
                                <c:when test="${jogador != null}">
                                    src="FotoServlet?idJogador=${jogador.id}"
                                </c:when>
                                <c:otherwise>
                                    src="IMG/sem_foto.png"
                                </c:otherwise>
                            </c:choose> />
                    </label>
                    <input type="file" name="foto" id="foto" accept="image/*" style="visibility: hidden;" onchange="readURL(this)"
                            <c:if test="${jogador != null}">
                                value="${jogador.foto}"
                            </c:if> >
                </div>
            </div>  
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${jogador != null}">
                            <input type="hidden" name="idJogador" id="idJogador" value="${jogador.id}">
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Salvar Alterações</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Cadastrar</button>
                            <button type="reset" class="btn btn-primary" style="margin-left: 5px; font-weight: bold;">Limpar</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="button" class="btn btn-primary" onclick="location.href='gerenciarJogador.jsp'" 
                        style="margin-left: 5px; font-weight: bold;">Gerenciar</button>
                </div>
            </div>
            <c:if test="${message != null && !message.isEmpty()}">
                <h3 align="center" id="message">${message}</h3>
            </c:if>
        </form>
    </body>
</html>
