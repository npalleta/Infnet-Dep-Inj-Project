<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Registro Escolar</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/aluno/lista">Aluno</a></li>
            <li class="nav-item dropdown">
			  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Dropdown</a>
			  <ul class="dropdown-menu">
			    <li><a class="dropdown-item" href="#">Link</a></li>
			    <li><a class="dropdown-item" href="#">Another link</a></li>
			    <li><a class="dropdown-item" href="#">A third link</a></li>
			  </ul>
			</li>
            <li class="nav-item"><a class="nav-link" href="#">Professor</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Responsável</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Sign&nbsp;Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;Login</a></li>
            <!--
                <li>
                    <a href="/logout">
                        <span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;Logout:&nbsp;${user.nome}
                    </a>
                </li>
            -->
        </ul>
    </div>
</nav>