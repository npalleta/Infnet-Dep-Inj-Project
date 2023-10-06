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
			<h2 align="center">${projeto.nome} - ${projeto.descricao}</h2><br />
			<c:forEach var="c" items="${projeto.classes}">
				<h4 align="left">${c.nome}</h4>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Campo</th>
							<th>Tipo</th>
							<th>Observação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${c.atributos}">
							<tr>
								<td>${a.nome}</td>
								<td>${a.tipo}</td>
								<td>${a.descricao}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
			</c:forEach>
		</div>
	</body>
</html>