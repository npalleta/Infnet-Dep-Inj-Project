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
		<div class="container">
			<h2>Cadastramento de Usuário</h2>
			<form action="/usuario/incluir" method="post">
				<div class="form-group">
					<label for="nome">Nome:</label>
					<input type="text" class="form-control" value="Niky Lima" id="nome" placeholder="Entre com o seu nome" name="nome">
				</div>
				<div class="form-group">
					<label for="pwd">Senha:</label>
					<input type="password" class="form-control" value="niky.lima@al.infnet.edu.br" id="senha" placeholder="Entre com a sua senha" name="senha">
				</div>
				<div class="form-group">
					<label for="email">E-mail:</label>
					<input type="email" class="form-control" value="niky.lima@al.infnet.edu.br" id="email" placeholder="Entre com o seu e-mail" name="email">
				</div>
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
		</div>
	</body>
</html>