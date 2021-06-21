<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<div>
		<p>Songs by artist: <c:out value="${searchword}"/></p>
		<a href="/dashboard">Dashboard</a>
	</div>
	
	<table>
		<thead>
			<th>name</th>
			<th>rating</th>
			<th>actions</th>
		</thead>
		<tbody>
	        <c:forEach items="${songs}" var="song">
			<tr>
				<td><c:out value="${song.title}"/></td>
				<td><c:out value="${song.rating}"/></td>
				<td><a href="">delete</a></td>
			</tr>
        </c:forEach>			
		</tbody>
	</table>
</body>
</html>