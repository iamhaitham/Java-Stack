<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="css/Bootstrap.css">
<style>
	body{
		width:75%;
		margin-left:10%;
	}
</style>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Creator</th>
				<th scope="col">Version</th>
				<th scope="col">action</th>
			<tr>
		</thead>
		<tbody>
	        <c:forEach items="${languages}" var="language">
			<tr>
			<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
			<td><c:out value="${language.creator}"/></td>
			<td><c:out value="${language.version}"/></td>
			<td><a href="/languages/${language.id}/delete">delete</a>
			<a href="languages/${language.id}/edit">edit</a></td>
			</tr>
	        </c:forEach>
		</tbody>
	</table>
	
	<form:form action="/languages"  method="post" modelAttribute="language">
    <p>
        <form:label path="name" class="col-form-label">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name" class="form-control"/>
    </p>
    <p>
        <form:label path="creator" class="col-form-label">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator" class="form-control"/>
    </p>
    <p>
        <form:label path="version" class="col-form-label">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version" class="form-control"/>
    </p>
    <input type="submit" value="Submit" class="btn btn-primary"/>
</form:form>
</body>
</html>