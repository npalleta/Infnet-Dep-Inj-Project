<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <h1 align="center">Lista Geral - Dados Escolares</h1><br />
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID Ficha</th>
                        <th>Nome do Aluno</th>
                        <th>Matrícula</th>
                        <th>Ativo</th>
                        <th>Nome do Responsável</th>
                        <th>Parentesco</th>
                        <th>Nome do Professor</th>
                        <th>Matéria</th>
                        <th>Dia da Aula</th>
                        <th>Número da Sala</th>
                    </tr>
                </thead>
                <tbody>
					<c:forEach var="d" items="${listaDados}">
						<tr>
							<td><c:out value="${d.idFicha}" escapeXml="false" /></td>
							<td><c:out value="${d.nomeAluno}" escapeXml="false" /></td>
							<td><c:out value="${d.matricula}" escapeXml="false" /></td>
							<c:choose>
								<c:when test="${d.ativo}">
									<td style="color: #006400"><c:out value="Sim" /></td>
								</c:when>
								<c:otherwise>
									<td style="color: #FF0000"><c:out value="Não" /></td>
								</c:otherwise>
							</c:choose>
							<td><c:out value="${d.nomeResponsavel}" escapeXml="false" /></td>
							<c:choose>
								<c:when test="${fn:containsIgnoreCase(d.parentesco, 'M')}">
									<td><c:out value="Mãe" escapeXml="false" /></td>
								</c:when>
								<c:when test="${fn:containsIgnoreCase(d.parentesco, 'P')}">
									<td><c:out value="Pai" escapeXml="false" /></td>
								</c:when>
								<c:otherwise>
									<td><c:out value="Outro" escapeXml="false" /></td>
								</c:otherwise>
							</c:choose>
							<td><c:out value="${d.nomeProfessor}" escapeXml="false" /></td>
							<td><c:out value="${d.materia}" escapeXml="false" /></td>
							<td><c:out value="${d.diaAula}" escapeXml="false" /></td>
							<td><c:out value="${d.numSala}" escapeXml="false" /></td>
							<td><a href="/ficha/${d.idFicha}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
            </table>
        </div>
    </body>
</html>