<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="/css/register.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="/js/myJquery.js"></script>
</head>
<body>
	<h1 id="myHeading">Register</h1>
    <form:form method="POST" action="/registerProcess" modelAttribute="user">
    	<p>
	        <form:errors path="firstName"/>
	        <form:input type="text" path="firstName" placeholder="First Name" required=""/>
	    </p>
	    <p>
	        <form:errors path="lastName"/>
	        <form:input type="text" path="lastName" placeholder="Last Name" required=""/>
	    </p>
	    <p>
	        <form:errors path="email"/>
	        <form:input type="email" path="email" placeholder="Email" required=""/>
	    </p>
	    <p>
	        <form:errors path="location"/>
	        <form:input type="text" path="location" placeholder="Location" required=""/>
	    </p>
	    <p>
	        <form:errors path="password"/>
	        <form:input type="password" path="password"  placeholder="Password" required=""/>
    	</p>
    	<p>
	        <form:errors path="passwordConfirmation"/>
	        <form:input type="password" path="passwordConfirmation"  placeholder="Confirm password" required=""/>
    	</p>
    	<input type="submit" value="Register" class="btn btn-primary btn-large"/>
    </form:form>
</body>
</html>