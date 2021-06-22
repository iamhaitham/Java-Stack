<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	<form method="post" action="/licenses/newLicenseProcessing" modelAttribute="license">
		<div>
			<p>Person:</p>
			<select name="myOption">
		        <c:forEach items="${persons}" var="person">
				<option value="${person.id}"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></option>
				</c:forEach>
			</select>
		</div>
		
		<div>
			<p>State:</p>
			<input type="text" name="myState">
		</div>
		
		<div>
			<p>Expiration Date:</p>
			<input type="date" name="myDate">
		</div>
		
		<input type="submit" value="Create">
	</form>
</body>
</html>