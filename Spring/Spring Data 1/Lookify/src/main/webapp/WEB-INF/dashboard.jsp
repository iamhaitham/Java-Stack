<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div>
		<a href="/songs/new">Add New</a>
		<form action="/searchProcess">
			<input type="text" name="searchForArtist">
			<input type="submit" value="Search Artists" class="btn btn-dark">
		</form>
	</div>
		
	<table class="table">
		<thead class="table-dark">
			<th>Name</th>
			<th>Rating</th>
			<th>actions</th>
		</thead>
		<tbody>
        <c:forEach items="${songs}" var="song">
			<tr>
				<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
				<td><c:out value="${song.rating}"/></td>
				<td><a href="">delete</a></td>
			</tr>
        </c:forEach>
		</tbody>
	</table>
</body>
</html>