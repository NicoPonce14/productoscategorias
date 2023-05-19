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
    <title></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <a href="/"> Volver </a>
	<h1>${categ.name }</h1>

	<hr>
	<div class="container row">
		<div class="col-6">
			<h2>Productos</h2>
			<c:forEach items="${categ.products}" var="prod">
				<li>${prod.name }</li>
			</c:forEach>
		</div>
		<div class="col-6">
			<h2>Add Product:</h2>
			<form:form action="/asos/${categ.id }" method="post"
				modelAttribute="asoci">
				<form:input type="hidden" path="category" value="${categ.id }" />
				<form:select class="form-control" path="product">
					<c:forEach items="${prod}" var="product">
						<form:option value="${product.id} "> ${product.name}  
									</form:option>
					</c:forEach>
				</form:select>
				<button>Agregar</button>
			</form:form>
</body>
</html>