<%@page import="br.com.talles.drink.domain.Drink"%>
<%@page import="br.com.talles.drink.domain.Entity"%>
<%@page import="br.com.talles.drink.controll.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
			Result result = new Result();
			result = (Result) request.getAttribute("result");
			
			if(result != null){
				if(result.hasMsg()){
					String[] msgs = result.getMsg().split("\n");
					out.println("<p>");
					for(String msg : msgs)
						out.println("<i class='fa fa-times' aria-hidden='true' style='color: #FF0000;'></i> " + msg + "<br/>");
				}else{
					out.println("<table class='u-full-width'>");
					out.println("<thead>");
					out.println("<tr>");
					out.println("<td>Name</td>");
					out.println("<td>Price</td>");
					out.println("<td>Editar</td>");
					out.println("<td>Excluir</td>");
					out.println("</tr>");
					out.println("</thead>");
					out.println("<tbody>");

					int i = 0;

					for(Entity entity : result.getEntities()){
						Drink drink = (Drink) entity;

						out.println("<tr>");
						out.println("<td>" + drink.getName() + "</td>");
						out.println("<td>" + drink.getPrice() + "</td>");
						out.println("<td>"
										+ "<a href='findMerchant?operation=FIND&id=" + drink.getId() + "'>"
											+ "<i class='fa fa-pencil' aria-hidden='true'></i>"
										+ "</a>"
									+ "</td>");

						out.println("<td>"
										+ "<a href='deleteMerchant?operation=DELETE&id=" + drink.getId() + "'>"
											+ "<i class='fa fa-trash' aria-hidden='true'></i>"
										+ "</a>"
									+ "</td>");

						out.println("</tr>");

						i++;
					}

					out.println("</tbody>");
					out.println("<tfooter>");
					out.println("<tr>");
					out.println("<td>Name</td>");
					out.println("<td>Price</td>");
					out.println("<td>Editar</td>");
					out.println("<td>Excluir</td>");
					out.println("</tr>");
					out.println("</tfooter>");
					out.println("<tbody>");
					out.println("</table>");

					out.println("<p>" + i + " registros encontrados.</p>"); 
				}
				out.println("</p>");
			}
		%>
		
		<script src="https://use.fontawesome.com/51922b6b29.js"></script>
    </body>
</html>
