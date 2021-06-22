<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="/css/dojoNew.css">
</head>
<body>
	<h1>New Dojo</h1>
	<form action="/dojos/newProcessing" method="post" modelAttribute="dojo">
		<div>
			<label for="dojoName">Name:</label>
			<input type="text" id="dojoName" name="dojoName">
		</div>
		<input type="submit" value="Create" id="createButton" class="btn btn-info">
	</form>
</body>
</html>