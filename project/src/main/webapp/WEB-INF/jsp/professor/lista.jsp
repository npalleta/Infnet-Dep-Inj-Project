<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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
        <div class="container-fluid mt-3">
            <h1 align="center">Listagem De Professores</h1><br />
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do Professor</th>
                        <th>Número da Sala</th>
                        <th>ID do Aluno</th>
                        <th>Matéria</th>
                        <th>Dia da Aula</th>
                        <th>Clique para excluir</th>
                    </tr>
                </thead>
                <tbody>
					<c:forEach var="p" items="${listaProfessor}">
						<tr>
							<td>${p.idProfessor}</td>
							<td>${p.nomeProfessor}</td>
							<td>${p.numSala}</td>
							<td>${p.aluno.idAluno}</td>
							<td>${p.materia}</td>
							<td>${p.diaAula}</td>
							<td><a href="/professor/${p.idProfessor}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>