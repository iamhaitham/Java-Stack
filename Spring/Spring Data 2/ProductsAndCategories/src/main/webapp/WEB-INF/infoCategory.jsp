<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${myCategory.name}</title>
</head>
<body>
	<h1><c:out value="${myCategory.name}"/></h1>
	<div id="wrapperDiv">
		<div>
			<h2>Products</h2>
			<ul>
				<c:forEach items="${myCategory.products}" var="product">
					<li><c:out value="${product.name}"/></li>
				</c:forEach>
			</ul>
		</div>
		
		<div>
			<form action="/categories/${myCategory.id}/addProducts" method="post" modelAttribute="addProducts">
				<label>Add Product</label>
				<select name="options">
					<c:forEach items="${distinctProducts}" var="product">
						<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add">
			</form>
		</div>
	</div>
</body>
</html>