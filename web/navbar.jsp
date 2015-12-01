<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="torneioDAO" class="controller.TorneioDAO"/>
<jsp:useBean id="usuarioDAO" class="controller.UsuarioDAO"/>
        <nav class="navbar navbar-inverse" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
                            data-target="#navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img alt="Brand" src="IMG/icone.png" height="50" width="65" style="padding-right: 15px;">
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="home.jsp">CLASSIFICAÇÃO</a></li>
                        <li><a href="jogos.jsp">JOGOS</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">CADASTRAR<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="cadastrarTorneio.jsp">TORNEIO</a></li>
                                <li><a href="cadastrarInscricaoEquipe.jsp">EQUIPE</a></li>
                                <li><a href="cadastrarJogador.jsp">JOGADOR</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">GERENCIAR<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="gerenciarTorneio.jsp">TORNEIO</a></li>
                                <li><a href="gerenciarInscricaoEquipe.jsp">EQUIPE</a></li>
                                <li><a href="gerenciarJogador.jsp">JOGADORES</a></li>
                            </ul>
                        </li>
                    </ul>
                    <div class="collapse navbar-collapse" id="navbar-collapse">
                        <ul class="nav navbar-nav navbar-brand">
                            <li><a style="padding-right: 0px; margin-right: 0px;"><font style="color: #337ab7; font-weight: bold;">TORNEIO:</font></a></li>
                            <li>
                                <form class="input-group" method="post" action="TorneioServlet" name="torneio_form" id="torneio_form">
                                    <input type="hidden" id="operacao" name="operacao" value="selecionar">
                                    <input type="hidden" id="jsp_request_uri" name="jsp_request_uri" value="${pageContext.request.servletPath}">
                                    <select name="torneio" id="torneio" class="navbar-form btn btn-primary" 
                                            style="font-size: 20px; font-weight: bold; padding-top: 4px; padding-bottom: 4px; margin-left: 15px;">
                                        <c:forEach var="torneio" items="${torneioDAO.retrieve(loggedInUser)}">
                                            <option align="center" value="${torneio.getId()}"
                                                <c:if test="${selectedTorneio != null && selectedTorneio.id == torneio.id}">
                                                    selected
                                                </c:if> > 
                                                <c:if test="${usuarioDAO.hasPermission(loggedInUser, torneio)}">[ADM] </c:if>${torneio.nomeDoTorneio}</option>
                                                <c:if test="${selectedTorneio == null}">
                                                    <c:set var="selectedTorneio" value="${torneio}" scope="session"></c:set>
                                                </c:if>
                                        </c:forEach>   
                                    </select>
                                </form>
                            </li>
                        </ul>
                    <form class="navbar-form navbar-right" name="search" id="search" role="search" hidden="true">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="O que você procura?" style="font-weight: normal;">
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                        </div>
                    </form>
                    <ul class="nav navbar-nav navbar-right"><span class="">
                            <button type="button" name="search_toggle" id="search_toggle" class="navbar-btn btn btn-primary">
                        <span class="glyphicon glyphicon-search"></span></button></span>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a name="b_user" id="b_user" class="dropdown-toggle" data-toggle="dropdown">
                                ${loggedInUser.nomeCompleto}<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Perfil</a></li>
                                <li><a href="auditoria.jsp">Auditoria</a></li>
                                <li><a href="#">Configurações</a></li>
                                <li><a id="quit">Logout</a></li>
                                <li><form name="quit_form" id="quit_form" method="post" class="navbar-form" action="UsuarioServlet" hidden="true">
                                    <input type="hidden" id="operation" name="operation" value="logout">
                                </form></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
