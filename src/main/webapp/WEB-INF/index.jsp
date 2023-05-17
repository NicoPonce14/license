<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Licencia</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body class="container">
	<h1>Crea una persona o una nueva Licencia</h1>
	<a href="/persons/new">Create Person</a>
	<a href="/license/new">Create License</a>
	<div class="row">
			<div class="col-ms-12">
			<h2>Lista de lenguajes</h2>
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">Licencia</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="todos" items="${todos}">
							<tr>

								<td><a href='/${todos.id }'><c:out value="${todos.firstName } ${todos.lastName }"></c:out></td>
								<td><c:out value="${todos.getLicense().getNumber() }"></c:out></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>