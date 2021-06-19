<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/timeStyle.css">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/timeJS.js"></script>
<meta charset="ISO-8859-1">
<title>Time Page</title>
</head>
<body>
	<h1><c:out value="${myTime}" /></h1>
</body>
</html>