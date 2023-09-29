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
            <h1 align="center">Listagem De Alunos</h1><br />
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do Aluno</th>
                        <th>Matrícula</th>
                        <th>Número da Sala</th>
                        <th>Em Atividade Escolar?</th>
                        <th>Clique para excluir</th>
                    </tr>
                </thead>
                <tbody>
					<c:forEach var="a" items="${listaAluno}">
						<tr>
							<td>${a.idAluno}</td>
							<td>${a.nomeAluno}</td>
							<td>${a.matricula}</td>
							<td>${a.numSala}</td>
							<c:choose>
								<c:when test="${a.ativo}">
									<td style="color: #006400"><c:out value="Sim" /></td>
								</c:when>
								<c:otherwise>
									<td style="color: #FF0000"><c:out value="Não" /></td>
								</c:otherwise>
							</c:choose>
							<td><a href="/aluno/${a.idAluno}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>