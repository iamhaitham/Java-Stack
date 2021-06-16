<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" href="css/result.css">
</head>
<body>
	<div id="borderedDiv">
		<h2>Submitted Info</h2>
		<div class="resultsInRow">
			<p>Name</p>
			<p><c:out value="${myName}"/></p>
		</div>
		<div class="resultsInRow">
			<p>Dojo Location</p>
			<p><c:out value="${myLocation}"/></p>
		</div>
		<div class="resultsInRow">
			<p>Favourite Language</p>
			<p><c:out value="${myLanguage}"/></p>
		</div>
		<div class="resultsInRow">
			<p>Comment</p>
			<p><c:out value="${myComment}"/></p>
		</div>
		<a href="/"><button type="submit">Go Back</button></a>
	</div>
</body>
</html>