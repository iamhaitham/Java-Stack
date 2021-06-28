<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit <c:out value="${myEvent.eventName}"/></title>
</head>
<body>
	<h1><c:out value="${myEvent.eventName}"/></h1>
	<h3>Edit Event</h3>
	<form:form action="/events/${myEvent.id}/editProcess" method="post" modelAttribute="event">
	 <p>
        <form:label path="eventName">Name</form:label>
        <form:errors path="eventName"/>
        <form:input type="text" path="eventName"/>
    </p>
     <p>
        <form:label path="eventDate">Date</form:label>
        <form:errors path="eventDate"/>
        <form:input type="date" path="eventDate"/>
    </p>
    <p>
        <form:label path="location">Location</form:label>
        <form:errors path="location"/>
        <form:input type="text" path="location"/>
    </p>
    <input type="submit" value="Edit"/>
    </form:form> 
</body>
</html>