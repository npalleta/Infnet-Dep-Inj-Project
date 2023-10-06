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
            <h1 align="center">Listagem De Responsável</h1><br />
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do Responsável</th>
                        <th>Nome do Aluno</th>
                        <th>Parentesco</th>
                        <th>Clique para excluir</th>
                    </tr>
                </thead>
                <tbody>
					<c:forEach var="r" items="${listaResponsavel}">
						<tr>
							<td>${r.idResponsavel}</td>
							<td>${r.nomeResponsavel}</td>
							<td>${r.aluno.nomeAluno}</td>
							<c:choose>
								<c:when test="${r.parentesco eq 'M'.charAt(0)}">
									<td><c:out value="Mãe" /></td>
								</c:when>
								<c:when test="${r.parentesco eq 'P'.charAt(0)}">
									<td><c:out value="Pai" /></td>
								</c:when>
								<c:otherwise>
									<td><c:out value="Outro" /></td>
								</c:otherwise>
							</c:choose>
							<td><a href="/responsavel/${r.idResponsavel}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>