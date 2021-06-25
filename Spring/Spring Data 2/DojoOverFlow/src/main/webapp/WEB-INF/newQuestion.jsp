<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
	<h1>What is your question?</h1>
	<form:form action="/questions/newProcessing" method="post" modelAttribute="questions">
    <p>
        <form:label path="question">Question:</form:label>
        <form:errors path="question"/>
        <form:textarea path="question"/>
    </p>
    <p>
        <form:label path="tagsAsString">Tags:</form:label>
        <form:errors path="tagsAsString"/>     
        <form:input type="text" path="tagsAsString"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>