<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="/css/ninjaNew.css">
</head>
<body>
	<h1>New Ninja</h1>
	<form action="/ninjas/newProcessing" method="post" modelAttribute="ninja">
		<div>
		<label for="dojo">Dojo:</label>
		<select name="dojo" id="dojo">
	        <c:forEach items="${dojos}" var="dojo">
				<option value=${dojo.id}><c:out value="${dojo.name}"/></option>
			</c:forEach>
		</select>
		</div>
		<div>
			<label for="firstName">First Name:</label>
			<input type="text" id ="firstName" name="firstName">
		</div>
		<div>
			<label for="lastName">Last Name:</label>
			<input type="text" id ="lastName" name="lastName">
		</div>
		<div>
			<label for="age">Age:</label>
			<input type="text" id ="age" name="age">
		</div>
		
		<input type="submit" value="Create" class="btn btn-success" id="createButton">
	</form>
</body>
</html>