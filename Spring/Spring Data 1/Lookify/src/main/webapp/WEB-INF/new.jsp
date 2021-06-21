<%@ page isErrorPage="true" %>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
</head>
<body>
	<form:form action="/songs/new" method="post" modelAttribute="song">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title" name="title"/>
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:textarea path="artist" name="artist"/>
    </p>
    <p>
        <form:label path="rating">Rating(1-10)</form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating" name="rating"/>
    </p>
    <input type="submit" value="Add Song"/>
</form:form>
</body>
</html>