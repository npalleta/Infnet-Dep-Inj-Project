<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/">Registro Escolar</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active">
				<a href="/">Home</a>
			</li>
			<c:if test="${not empty user}">
				<li><a href="/usuario/lista">Usuários</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="/">Aluno
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/aluno/cadastro">Cadastro</a></li>
						<li><a href="/aluno/lista">Lista de Alunos</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="/">Responsável
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<c:if test="${not empty aluno}">
							<li><a href="/responsavel/cadastro">Cadastro</a></li>
						</c:if>	
						<li><a href="/responsavel/lista">Lista de Responsáveis</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="/">Professor
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<c:if test="${not empty responsavel}">
							<li><a href="/professor/cadastro">Cadastro</a></li>
						</c:if>
						<li><a href="/professor/lista">Lista de Professores</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="/">Ficha de Dados - Registro Escolar
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<c:if test="${not empty professor}">
							<li><a href="/ficha/cadastro">Cadastro</a></li>
						</c:if>
						<li><a href="/ficha/lista">Lista de Dados - Registro Escolar</a></li>
					</ul>
				</li>
			</c:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty user}">
					<li><a href="/usuario/cadastro"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Sign&nbsp;Up</a></li>
					<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;Login</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;Logout:&nbsp;${user.nome}</a></li>
				</c:otherwise>
			</c:choose>
        </ul>
	</div>
</nav>