<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>
		<c:import url="/WEB-INF/jsp/menu.jsp"/>
		<div class="container-fluid mt-3">
		  <h3>Listagem de Usuários:</h3>
			<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>Nome</th>
		        <th>E-mail</th>
		        <th>Senha</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
				<c:forEach var="u" items="${listaUsuario}">
					<tr>
						<td>${u.nome}</td>
						<td>${u.email}</td>
						<td>${u.senha}</td>
						<td><a href="/usuario/${u.id}/excluir">excluir</a></td>
					</tr>
				</c:forEach>
		    </tbody>
		  </table>
		</div>
	</body>
</html>