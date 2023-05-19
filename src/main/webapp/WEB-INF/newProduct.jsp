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
    <section class="vh-100" style="background-color: #2779e2;">
        <div class="container h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-xl-9">
      
              <h1 class="text-white mb-4">New Product</h1>
      
              <form:form action="/products/new" method="POST" modelAttribute="producto">


                  <div class="card" style="border-radius: 15px;">
                    <div class="card-body">
          
                      <div class="row align-items-center pt-4 pb-3">
                        <div class="col-md-3 ps-5">
          
                          <h6 path="name" class="mb-0">Name</h6>
          
                        </div>
                        <div class="col-md-9 pe-5">
          
                          <form:input path="name" type="text" class="form-control form-control-lg" />
                          <form:errors path="name" />
          
                        </div>
                      </div>
          
                      <hr class="mx-n3">
          
                      <div class="row align-items-center py-3">
                        <div class="col-md-3 ps-5">
          
                          <h6 path="description" class="mb-0">Description</h6>
          
                        </div>
                        <div class="col-md-9 pe-5">
          
                          <form:input path="description"  class="form-control form-control-lg"  />
                          <form:errors path="description" />
          
                        </div>
                      </div>
          
                      <hr class="mx-n3">
          
                      <div class="row align-items-center py-3">
                        <div class="col-md-3 ps-5">
          
                          <h6 path="price" class="mb-0">Price</h6>
          
                        </div>
                        <div class="col-md-9 pe-5">
          
                          <form:input path="price" class="form-control form-control-lg"  />
                          <form:errors path="price" />
          
                        </div>
                      </div>
                    
          
                      <hr class="mx-n3">
          
                      <div class="px-5 py-4">
                        <button type="submit" class="btn btn-primary btn-lg">Add</button>
                      </div>
          
                    </div>
                  </div>
              </form:form>
      
            </div>
          </div>
        </div>
      </section>
</body>
</html>