<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table class="table table-bordered border-primary">
		<thead>
			<th>Question</th>
			<th>Tags</th>
		</thead>
		<tbody>
		<c:forEach items="${allQuestions}" var="q">
			<tr>
				<td><a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
				<td><c:out value="${q.tags}"/></td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
	<a href="/questions/new">New Question</a>
</body>
</html>