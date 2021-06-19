<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="gold.css">
<meta charset="ISO-8859-1">
<title>Ninja Gold Assignment</title>
</head>
<body>
	<div id="header">
		<p id="p1">Your Gold</p>
		<p id="p2"><c:out value="${myGold}"/></p>
	</div>
	
	<div id="main">
		<div class="boxes">
			<h1>Farm</h1>
			<p>(earns 10-20 gold)</p>
			<form method="POST" action="/Processing">
				<input type="hidden" name="myForm" value="farmForm">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		
		<div class="boxes">
			<h1>Cave</h1>
			<p>(earns 5-10 gold)</p>
			<form method="POST" action="/Processing">
				<input type="hidden" name="myForm" value="caveForm">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		
		<div class="boxes">
			<h1>House</h1>
			<p>(earns 2-5 gold)</p>
			<form method="POST" action="/Processing">
				<input type="hidden" name="myForm" value="houseForm">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		
		<div class="boxes">
			<h1>Market</h1>
			<p>(earns/take 0-50 gold)</p>
			<form method="POST" action="/Processing">
				<input type="hidden" name="myForm" value="marketForm">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
	</div>
	
	<div id="activities">
		<h1>Activites</h1>
		<p><c:out value="${myText}"/></p>
	</div>
	
	
</body>
</html>