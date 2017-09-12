<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
		<form action="create" method="POST">
			<label for="name">Name: </label>
			<input type="text" name="name" id="name" />
			<br/>
			<label for="ingredients">Ingredients </label>
			<textarea name="ingredients" id="ingredients"></textarea>
			<br/>
			<label for="price">Price: </label>
			<input type="number" name="price" id="price" />
			<br/>
			<label for="manufacturerDate">Manufacturer Date: </label>
			<input type="date" name="manufacturerDate" id="manufacturerDate" />
			<br/>
			<label for="expirationDate">Expiration Date: </label>
			<input type="date" name="expirationDate" id="expirationDate" />
			<br/>
			<button type="submit" name="operation" value="SAVE">Save here! c:</button>
		</form>
    </body>
</html>
