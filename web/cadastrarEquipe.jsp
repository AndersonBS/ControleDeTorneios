<%-- 
    Document   : cadastrarEquipe
    Created on : 31/08/2015, 00:35:44
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="equipeDAO" class="controller.EquipeDAO"/>

<c:if test="${param != null && param.altEquipe != null}">
    <c:set var="equipe" value="${equipeDAO.findEquipe(param.altEquipe)}" scope="page"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Equipe</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <c:choose>
            <c:when test="${param != null && param.altEquipe != null}">
                <h1 align="center">Alteração de Equipe</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Equipes</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="EquipeServlet">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altEquipe != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="nome" class="col-sm-2 col-sm-offset-3 control-label">Nome:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="nome" id="nome" 
                            placeholder="Digite o nome da equipe"
                            <c:if test="${equipe != null}">
                                value=${equipe.nome}
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label for="dataFundacao" class="col-sm-2 col-sm-offset-3 control-label">Data da Fundação:</label>
                <div class="col-sm-3 input-group">
                    <input type="date" required="true" class="form-control" name="dataFundacao" id="dataFundacao"
                           <c:if test="${equipe != null}">
                                value=${equipe.dataFundacao}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="email" class="col-sm-2 col-sm-offset-3 control-label">E-mail:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="email" required="true" class="form-control" name="email" id="email" 
                            placeholder="Digite o e-mail da equipe"
                            <c:if test="${equipe != null}">
                                value=${equipe.email}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="enderecoWeb" class="col-sm-2 col-sm-offset-3 control-label">Endereço WEB:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="enderecoWeb" id="enderecoWeb" 
                            placeholder="Digite o endereço WEB da equipe"
                            <c:if test="${equipe != null}">
                                value=${equipe.enderecoWeb}
                            </c:if> >
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="fone" class="col-sm-2 col-sm-offset-3 control-label">Fone:</label>
                <div class="col-sm-3 input-group" id="selectPostoDiv"> 
                    <input type="text" required="true" class="form-control" name="fone" id="fone" 
                            placeholder="Digite o fone da equipe"
                            <c:if test="${equipe != null}">
                                value=${equipe.fone}
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${equipe != null}">
                            <input type="hidden" name="idEquipe" id="idEquipe" value="${equipe.id}">
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Salvar Alterações</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Cadastrar</button>
                            <button type="reset" class="btn btn-primary" style="margin-left: 5px; font-weight: bold;">Limpar</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="button" class="btn btn-primary" onclick="location.href='listarEquipe.jsp'" 
                        style="margin-left: 5px; font-weight: bold;">Listar</button>
                </div>
            </div>
            <c:if test="${message != null && !message.isEmpty()}">
                <h3 align="center" id="message">${message}</h3>
            </c:if>
        </form>
    </body>
</html>



