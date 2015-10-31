<%-- 
    Document   : cadastrarPosicao
    Created on : 23/10/2015, 15:50:50
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="posicaoDAO" class="controller.PosicaoDAO"/>

<c:if test="${param != null && param.altPosicao != null}">
    <c:set var="posicao" value="${posicaoDAO.retrieve(param.altPosicao)}" scope="page"></c:set>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        
        <title>Cadastro de Posição</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <c:choose>
            <c:when test="${param != null && param.altPosicao != null}">
                <h1 align="center">Alteração de Posição</h1><h1></h1>
            </c:when>
            <c:otherwise>
                <h1 align="center">Cadastro de Posição</h1><h1></h1>
            </c:otherwise>
        </c:choose>
        <form method="post" class="form-horizontal" action="PosicaoServlet">
            <input type="hidden" id="operacao" name="operacao"
                   <c:choose>
                       <c:when test="${param != null && param.altPosicao != null}">
                           value="alterar"
                       </c:when>
                       <c:otherwise>
                           value="salvar"
                       </c:otherwise>
                   </c:choose> >
            <div class="form-group form-inline">
                <label for="nome" class="col-sm-2 col-sm-offset-3 control-label">Nome da Posição:</label>
                <div class="col-sm-3 input-group"> 
                    <input type="text" required="true" class="form-control" name="nome" id="nome" 
                            placeholder="Digite o nome da posição"
                            <c:if test="${posicao != null}">
                                value=${posicao.nome}
                            </c:if> >
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 col-sm-offset-3 control-label"></label>
                <div class="col-sm-3 input-group">
                    <c:choose>
                        <c:when test="${posicao != null}">
                            <input type="hidden" name="idPosicao" id="idPosicao" value="${posicao.id}">
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Salvar Alterações</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn btn-primary" style="font-weight: bold;">Cadastrar</button>
                            <button type="reset" class="btn btn-primary" style="margin-left: 5px; font-weight: bold;">Limpar</button>
                        </c:otherwise>
                    </c:choose>
                    <button type="button" class="btn btn-primary" onclick="location.href='listarPosicao.jsp'" 
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