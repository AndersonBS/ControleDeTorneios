<%-- 
    Document   : index
    Created on : 30/08/2015, 17:45:28
    Author     : anderson
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt">
    <head>
        
        <title>Controle Futebol</title>
        
        <!-- Inclusão de CSS e JavaScript padrão -->
        <jsp:include page="include.jsp" />
        
    </head>
    <body>
        
        <!-- Capa -->
        <h1></h1><br>
        <div align="center">
            <img src="IMG/UNOESC.png" width="225" height="175">
            <h1>UNIVERSIDADE DO OESTE DE SANTA CATARINA</h1>
            <h3>CURSO: ENGENHARIA DA COMPUTAÇÃO</h3>
            <h3>DISCIPLINA: PROGRAMAÇÃO DE APLICATIVOS II</h3>
            <h3>PROFESSOR: EDUARDO COMIN</h3>
            <h3>ACADÊMICO: ANDERSON B. SENSOLO</h3>
            <h1></h1><br>
            <a href="cadastrarEquipe.jsp" class="btn btn-primary">Cadastrar Equipes</a>
            <a href="listarEquipe.jsp" class="btn btn-primary">Listar Equipes</a>
            <a href="cadastrarJogador.jsp" class="btn btn-primary">Cadastrar Jogadores</a>
            <a href="listarJogador.jsp" class="btn btn-primary">Listar Jogadores</a>
        </div>
        
    </body>
</html>

