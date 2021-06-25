<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile</title>
</head>
<body>
	<h1>${myQuestion.question}</h1>
	<p>Tags: ${myQuestion.tags}</p>
	<div style="border:2px solid black;">
	<c:forEach items="${myQuestion.answers}" var="answer">
	<p><c:out value="${answer.answer}"/></p>
	</c:forEach>
	</div>

	<h1>Add your answer:</h1>
	<form:form action="/questions/${myQuestion.id}/createAnswer" method="post" modelAttribute="answers">
    <p>
        <form:label path="answer">Answer: </form:label>
        <form:errors path="answer"/>
        <form:input path="answer"/>
    </p>
    <input type="submit" value="Answer it!"/>
</form:form>    

</body>
</html>