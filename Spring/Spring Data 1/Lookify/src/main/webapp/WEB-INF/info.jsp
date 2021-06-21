<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<table>
			<tr>
				<td>Title</td>
				<td><c:out value="${song.title}"/></td>
			</tr>
			<tr>
				<td>Artist</td>
				<td><c:out value="${song.artist}"/></td>
			</tr>
			<tr>
				<td>Rating(1-10)</td>
				<td><c:out value="${song.rating}"/></td>
			</tr>
	</table>
	<a href="">Delete</a>
</body>
</html>