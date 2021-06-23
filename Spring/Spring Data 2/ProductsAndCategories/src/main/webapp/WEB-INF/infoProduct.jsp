<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${myProduct.name}"/></title>
<link rel="stylesheet" href="/css/infoProduct.css">
</head>
<body>
	<h1><c:out value="${myProduct.name}"/></h1>
	<div id="wrapperDiv">
		<div id="leftDiv">
			<h2>Categories</h2>
			<ul>
				<c:forEach items="${myProduct.categories}" var="category">
					<li><c:out value="${category.name}"/></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="rightDiv">
			<form action="/products/${myProduct.id}/addCategory" method="post" modelAttribute="addCategories">
				<label>Add Category</label>
				<select name="options">
					<c:forEach items="${remainingCategories}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add">
			</form>
		</div>
	</div>
</body>
</html>