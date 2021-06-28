<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
	<div class="container">
  <section id="content">
  <p>
  	<c:out value="${error}"/>
  </p>  
  <form:form method="POST" action="/loginProcess" modelAttribute="user">
  <h1>Login Form</h1>
 
  	<p>
		<form:input type="email" path="email" id="username" placeholder="Email" required=""/>
    </p>
	<p>
    	<form:password path="password" id="password" placeholder="Password" required=""/>
    </p>
    <input type="submit" value="Log in"/>
	</form:form>
	<a href="/register"><button class="registerBtn">Register</button></a>
	
	    
  </section><!-- content -->
</div><!-- container -->
</body>
</html>