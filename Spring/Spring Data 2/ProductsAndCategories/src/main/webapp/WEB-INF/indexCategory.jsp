<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/indexCategory.css">
</head>
<body>
	<h1>New Category</h1>
	<form action="/categories/newProcessing" method="post" modelAttribute="category">
		<div>
			<label for="nameArea" class="form-label" id="nameLabel">Name</label>
			<input type="text" id="nameArea" name="name" class="form-control">
		</div>
		<input type="submit" value="Create" class="btn btn-success" id="createButton">
	</form>
</body>
</html>