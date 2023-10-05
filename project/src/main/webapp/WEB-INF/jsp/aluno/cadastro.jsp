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
			<h1 align="center">Cadastramento De Aluno</h1><br />
			<form class="form-horizontal" action="/aluno/incluir" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Nome:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nomeAluno" name="nomeAluno" placeholder="Nome e sobrenome" required />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Matrícula:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="matricula" name="matricula" value="${matricula}" placeholder="" readonly />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="">Número da Sala:</label>
					<div class="col-sm-10">
						<input inputmode="numeric" class="form-control" oninput="this.value = this.value.replace(/\D+/g, '')" maxlength="3" id="numSala" name="numSala" placeholder="Número da Sala" required />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label><input type="checkbox" id="ativo" name="ativo" value="true" checked>&nbsp;Ativo</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>