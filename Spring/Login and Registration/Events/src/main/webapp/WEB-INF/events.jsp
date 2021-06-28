<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<a href="/logout" class="btn btn-danger">Logout</a>
	<h1>Welcome, <c:out value="${myUser}"/></h1>
	<p>Here are some of the events in your location:</p>
	<table class="table table-striped">
		<thead>
			<th>Name</th>
			<th>Date</th>
			<th>Location</th>
			<th>Host</th>
			<th>Action/Status</th>
		</thead>
		<tbody>
			<c:forEach items="${allEventsInSameLocation}" var="eSame">
			<tr>
				<td><c:out value="${eSame.eventName}"/></td>
				<td><c:out value="${eSame.eventDate}"/></td>
				<td><c:out value="${eSame.location}"/></td>
				<td><c:out value="${eSame.hostUser.firstName}"/></td>
				<c:choose>
					<c:when test="${myUserId==eSame.hostUser.id}">
						<td><a href="/events/${eSame.id}/edit">Edit</a> | <a href="/delete/${eSame.id}">Delete</a></td>
					</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${myUserId!=eSame.hostUser.id}">
							<td><a>Join</a> | <a>Cancel</a></td>
						</c:when>
					</c:choose>
				</c:otherwise>
				</c:choose>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Here are some of the events in other locations:</p>
	<table class="table table-striped">
		<thead>
			<th>Name</th>
			<th>Date</th>
			<th>Location</th>
			<th>Host</th>
			<th>Action/Status</th>
		</thead>
		<tbody>
			<c:forEach items="${allEventsInOtherLocation}" var="eOther">
			<tr>
				<td><c:out value="${eOther.eventName}"/></td>
				<td><c:out value="${eOther.eventDate}"/></td>
				<td><c:out value="${eOther.location}"/></td>
				<td><c:out value="${eOther.hostUser.firstName}"/></td>
				<td><a href="">Join</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Create an event</h2>
	<form:form action="/createEvent" method="post" modelAttribute="event">
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
    	<input type="submit" value="Create event" class="btn btn-success"/>
	</form:form>
	<p><c:out value="${dateError}"/></p>
</body>
</html>