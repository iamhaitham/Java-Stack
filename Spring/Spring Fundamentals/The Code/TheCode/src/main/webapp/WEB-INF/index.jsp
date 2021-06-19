<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="index.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/errors.js"></script>
</head>
<body>
	<div>
		<p id="errors"><c:out value="${error}"/></p>
		<p>What is the code?</p>
		<form action="/code" method="POST">
			<label for="codeHere"></label>
			<input id="codeHere" type="text" name="codeHere">
			<button type="submit">Try Code</button>
		</form>
	</div>
</body>
</html>