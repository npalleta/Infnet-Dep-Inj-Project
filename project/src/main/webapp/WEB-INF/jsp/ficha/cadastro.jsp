<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Registro Escolar</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
		<div class="container mt-3">
			<h1 align="center">Ficha dos Dados Escolares</h1>			
			<br />
			<form class="form-horizontal" action="/ficha/incluir" method="post">
				<c:set var="ativ" value="Sim"/>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Nome do Aluno:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nomeAluno" name="nomeAluno" value="${aluno.nomeAluno}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Matrícula:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="matricula" name="matricula" value="${aluno.matricula}" readonly />
					</div>
				</div>
				<c:if test="${not aluno.ativo}">
					<c:set var="ativ" value="Não"/>
				</c:if>
				<div class="form-group">
					<label class="control-label col-sm-2" for="" >Ativo</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" value="${ativ}" readonly />
						<input type="hidden" class="form-control" id="ativo" name="ativo" value="${aluno.ativo}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Nome do Responsável:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nomeResponsavel" name="nomeResponsavel" value="${responsavel.nomeResponsavel}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Nome do Professor:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nomeProfessor" name="nomeProfessor" value="${professor.nomeProfessor}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Matéria:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="materia" name="materia" value="${professor.materia}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Dia da Aula:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="diaAula" name="diaAula" value="${professor.diaAula}" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Número da Sala:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="numSala" name="numSala" value="${professor.numSala}" readonly />
					</div>
				</div>
				<div class="form-group">
					<div align="center">
						<button type="submit" class="btn btn-primary">Efetivar Cadastro</button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>