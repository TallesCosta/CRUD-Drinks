<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.talles.drink.domain.Drink"%>
<%@page import="br.com.talles.drink.domain.Entity"%>
<%@page import="java.util.List"%>
<%@page import="br.com.talles.drink.persistence.dao.DrinkDao"%>
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
			<button type="submit">Save here! c:</button>
		</form>
		
        <h1>Hello World!</h1>
		
		<%
			DrinkDao dao = new DrinkDao();
			List<Entity> list = dao.select();
			if(list != null){
				for(Entity listItem : list){
					Drink item = (Drink) listItem;
					out.println("<p>");
					out.println(item.getId() + " - " + item.getCreateDate() + " - " + item.getUpdateDate());
					out.println("<br/>");
					out.println(item.getName() + " - " + item.getIngredients() + " - " + item.getPrice());
					out.println("<br/>");
					out.println(item.getManufactureDate().getTime() + " - " + item.getExpirationDate().getTime());
					out.println("</p>");
				}
			}else{
				out.println("<p>Sem dados...</p>");
			}
		%>
    </body>
</html>
