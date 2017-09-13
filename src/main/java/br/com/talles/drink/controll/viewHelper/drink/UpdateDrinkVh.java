
package br.com.talles.drink.controll.viewHelper.drink;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.controll.viewHelper.IViewHelper;
import br.com.talles.drink.domain.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDrinkVh implements IViewHelper {

	@Override
	public Entity getEntity(HttpServletRequest request) {
        String id = request.getParameter("drinkID");
	    String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String price = request.getParameter("price");
        String manufactureString = request.getParameter("manufactureDate");
        Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.INFO, manufactureString);
        String expirationString = request.getParameter("expirationDate");
        Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.INFO, expirationString);
        String id_category = request.getParameter("id_category");
        String manufacturer_id = request.getParameter("manufacturer_id");
        String supplier_id = request.getParameter("supplier_id");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Drink drink = new Drink();

        try {
            Calendar date = Calendar.getInstance();
            date.setTime(dateFormat.parse(manufactureString));
            drink.setManufactureDate(date);

            date.setTime(dateFormat.parse(expirationString));
            drink.setExpirationDate(date);

        } catch (ParseException | NumberFormatException ex) {
            Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        drink.setId(Long.valueOf(id));
        drink.setName(name);
        drink.setIngredients(ingredients);
        drink.setPrice(Double.valueOf(price));
        drink.setCategory(new Category(Long.valueOf(id_category)));
        drink.setManufacturer(new Manufacturer(Long.valueOf(manufacturer_id)));
        drink.setSupplier(new Supplier(Long.valueOf(supplier_id)));

        return drink;
	}

	@Override
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
		if(result.hasMsg()) {
            request.setAttribute("result", result);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");

            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ListDrinkVh.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                response.sendRedirect("/crud-drinks/drinks?operation=SELECT");
            } catch (IOException ex) {
                Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
	
}
