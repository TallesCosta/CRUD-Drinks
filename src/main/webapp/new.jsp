<%@page import="br.com.talles.drink.controll.Result"%>
<%@page import="java.util.List"%>
<%@page import="br.com.talles.drink.domain.Entity"%>
<%@page import="br.com.talles.drink.persistence.dao.CategoryDao"%>
<%@page import="br.com.talles.drink.domain.Category"%>
<%@page import="br.com.talles.drink.persistence.dao.ManufacturerDao"%>
<%@page import="br.com.talles.drink.domain.Manufacturer"%>
<%@page import="br.com.talles.drink.persistence.dao.SupplierDao"%>
<%@page import="br.com.talles.drink.domain.Supplier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
		<form action="drinks/create" method="POST">
			<%
				Result result = new Result();
				result = (Result) request.getAttribute("result");
				
				if(result != null){
					if(result.hasMsg()){
						String[] msgs = result.getMsg().split("\n");
						out.println("<p>");
						for(String msg : msgs)
							out.println("<i class='fa fa-times' aria-hidden='true' style='color: #FF0000;'></i> " + msg + "<br/>");
						out.println("</p>");
					}
				}
			%>
			<label for="name">Name: </label>
			<input type="text" name="name" id="name" />
			<br/>
			<label for="ingredients">Ingredients </label>
			<textarea name="ingredients" id="ingredients"></textarea>
			<br/>
			<label for="price">Price: </label>
			<input type="number" name="price" id="price" value="1" />
			<br/>
			<label for="manufactureDate">Manufacture Date: </label>
			<input type="date" name="manufactureDate" id="manufactureDate" />
			<br/>
			<label for="expirationDate">Expiration Date: </label>
			<input type="date" name="expirationDate" id="expirationDate" />
			<br/>
			<label for="category">Category: </label>
			<select id="category" name="id_category">
			<%
				CategoryDao daoC = new CategoryDao();
				List<Entity> entitiesC = daoC.select();
				for(Entity entity : entitiesC){
					Category category = (Category) entity;
					out.println("<option value='" + category.getId() + "'>" + category.getName() + "</option>");
				}
			%>
			</select>
			<br/>
			<label for="manufacturer">Manufacturer </label>
			<select id="manufacturer" name="manufacturer_id">
			<%
				ManufacturerDao daoM = new ManufacturerDao();
				List<Entity> entitiesM = daoM.select();
				for(Entity entity : entitiesM){
					Manufacturer manufacturer = (Manufacturer) entity;
					out.println("<option value='" + manufacturer.getId() + "'>" + manufacturer.getName() + "</option>");
				}
			%>
			</select>
			<br/>
			<label for="supplier">Supplier </label>
			<select id="supplier" name="supplier_id">
			<%
				SupplierDao daoS = new SupplierDao();
				List<Entity> entitiesS = daoS.select();
				for(Entity entity : entitiesS){
					Supplier supplier = (Supplier) entity;
					out.println("<option value='" + supplier.getId() + "'>" + supplier.getName() + "</option>");
				}
			%>
			</select>
			<br/>
			<button type="submit" name="operation" value="SAVE">Save here! c:</button>
		</form>
    </body>
</html>
