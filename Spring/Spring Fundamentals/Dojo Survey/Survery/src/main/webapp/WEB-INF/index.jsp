<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<div id="borderedDiv">
		<form method="POST" action="resultProcess">
			<div class="inputsInRow">
				<label for="Name">Your Name:</label>
				<input type="text" id="Name" name="Name" required>
			</div>
			<div class="inputsInRow">
				<label for="Location">Dojo Location:</label>
				<select id="Location" name="Location" required>
					<option value="usa">USA</option>
					<option selected value="online">Online</option>
					<option value="palestine">Palestine</option>
				</select>
			</div>
			<div class="inputsInRow">
				<label for="Language">Favourite Language:</label>
				<select id="Language" name="Language" required>
					<option value="Ruby">Ruby</option>
					<option value="Python">Python</option>
					<option value="Java">Java</option>
					<option selected value="Javascript">Javascript</option>
				</select>
			</div>
			<div class="inputsInColumn">
				<label for="Comment">Comment (Optional):</label>
				<textarea id="Comment" name="Comment"></textarea>
			</div>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>