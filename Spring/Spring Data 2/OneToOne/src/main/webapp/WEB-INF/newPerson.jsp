<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
<style>
	form{
		display:flex;
		flex-direction:column;
	}
</style>
</head>
<body>
	<h1>New Person</h1>
	<form method="post" action="/persons/newPersonProcessing">
		<div>
			<label for="firstname">First Name</label>
			<input id="firstname" name="firstname" type="text">
		</div>
		<div>
			<label for="lastname">Last Name</label>
			<input id="lastname" name="lastname" type="text">
		</div>
		<input type="submit" value="Create">
	</form>
</body>
</html>