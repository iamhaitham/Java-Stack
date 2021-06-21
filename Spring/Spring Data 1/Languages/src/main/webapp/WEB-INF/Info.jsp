<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${language.name}"/></title>
</head>
<body>
<a href="/languages">Dashboard</a>
<h1><c:out value="${language.name}"/></h1>
<p><c:out value="${language.creator}"/></p>
<p><c:out value="${language.version}"/></p>
<a href="/languages/${language.id}/delete">Delete</a>
<a href="/languages/${language.id}/edit">edit</a>
</body>
</html>