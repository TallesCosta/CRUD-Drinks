<%@ page import="br.com.talles.drink.domain.Drink" %>
<%@ page import="br.com.talles.drink.controll.Result" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="drink" class="br.com.talles.drink.domain.Drink" />

<%
  Result result = (Result) request.getAttribute("result");
  drink = (Drink) result.getEntity(0);

  SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
  String dateMnf = fmt.format(drink.getManufactureDate().getTime());
  String dateExp = fmt.format(drink.getExpirationDate().getTime());

%>

<html>
<head>
    <title>Edit Drink</title>
</head>
<body>
    <div class="container">
        <h1>Edit Drink</h1>
        <c:if test="${not empty result.msg}">
            <div class="alert alert-error">
                <% for(String error : result.getMsg().split("\n")) { %>
                    <p><% out.print(error); %></p>
                <% } // end forEach %>
            </div>
        </c:if>
        <form action="drinks/update" method="POST">
            <div>
                <label for="name">Name:</label>
                <input type="text" name="name" id="name" value="<% out.print(drink.getName()); %>"/>
            </div>

            <div>
                <label for="ingredients">Ingredients:</label>
                <textarea name="ingredients" id="ingredients"><% out.print(drink.getIngredients()); %></textarea>
            </div>

            <div>
                <label for="price">Price: </label>
                <input type="number" name="price" id="price" value="<% out.print(drink.getPrice()); %>" />
            </div>

            <div>
                <label for="manufactureDate">Manufacture Date:</label>
                <input type="date" name="manufactureDate" id="manufactureDate" value="<%  out.print(dateMnf); %>" />
            </div>

            <div>
                <label for="expirationDate">Expiration Date:</label>
                <input type="date" name="expirationDate" id="expirationDate" value="<% out.print(dateExp); %>" />
            </div>

            <div>
                <label for="category"></label>
                <select id="category" name="id_category">
                    <option value="1">Cerveja</option>
                    <option value="2">Refrigerante</option>
                    <option value="3">Vinho</option>
                </select>
            </div>

            <div>
                <label for="manufacturer">Manufacturer </label>
                <select id="manufacturer" name="manufacturer_id">
                    <option value="1">Coca-cola</option>
                    <option value="2">Pepsi</option>
                    <option value="3">Dolly</option>
                    <option value="4">Ambev</option>
                    <option value="5">Brasil Kirin</option>
                    <option value="6">Vinhos Randon</option>
                    <option value="7">Vinícula Campestre</option>
                </select>
            </div>

            <div>
                <label for="supplier">Supplier </label>
                <select id="supplier" name="supplier_id">
                    <option value="1">Makro</option>
                    <option value="2">Veran</option>
                    <option value="3">Pão de Açúcar</option>
                </select>
            </div>

            <button type="submit" name="operation" value="UPDATE">Update</button>
        </form>
    </div>
</body>
</html>
