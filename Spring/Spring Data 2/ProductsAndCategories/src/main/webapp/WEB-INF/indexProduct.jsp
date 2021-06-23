<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/indexProduct.css">
</head>
<body>
	<h1>New Product</h1>
	<form action="/products/newProcessing" method="post" modelAttribute="product">
		<div>
			<label for="nameArea" class="form-label">Name</label>
			<input type="text" id="nameArea" name="name" class="form-control inputs">
		</div>
		<div>
			<label for="descriptionArea" class="form-label">Description</label>
			<textarea id="descriptionArea" name="description" class="form-control inputs"></textarea>
		</div>
		<div>
			<label for="priceArea" class="form-label">Price</label>
			<input type="number" id="priceArea" name="price" class="form-control inputs">
		</div>
		<input type="submit" value="Create" class="btn btn-success" id="createButton">
	</form>
</body>
</html>