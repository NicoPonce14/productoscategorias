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
<h1>productos y categorias</h1>
<a href="/products/new">Agrega un producto</a>
<a href="/categories/new">Agrega una categoria</a>
<div class="container">
    <div class="row">
        <div class="col-6">
            <h2>Tus productos son</h2>
            <c:forEach items="${productos}" var="prod">
                <li><a href="/products/${prod.id}">${prod.name}</a></li>
            </c:forEach>
        </div>

        <div class="col-6">
            <h2>Tus categorias son</h2>
            <c:forEach items="${categorias}" var="cat">
                <li><a href="/categories/${cat.id}">${cat.name}</a></li>
            </c:forEach>
        </div>

    </div>

</div>

</body>
</html>