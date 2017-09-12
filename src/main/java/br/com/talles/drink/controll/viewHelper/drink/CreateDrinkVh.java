
package br.com.talles.drink.controll.viewHelper.drink;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.controll.viewHelper.IViewHelper;
import br.com.talles.drink.domain.Category;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;
import br.com.talles.drink.domain.Supplier;
import br.com.talles.drink.domain.Manufacturer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateDrinkVh implements IViewHelper {

	@Override
	public Entity getEntity(HttpServletRequest request) {
		String name = request.getParameter("name");
		String ingredients = request.getParameter("ingredients");
		String price = request.getParameter("price");
		String manufactureString = request.getParameter("manufactureDate");
		String expirationString = request.getParameter("expirationDate");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar manufactureDate = Calendar.getInstance();
		Calendar expirationDate = Calendar.getInstance();
		try {
			manufactureDate.setTime(dateFormat.parse(manufactureString));
			expirationDate.setTime(dateFormat.parse(expirationString));
		} catch (ParseException | NullPointerException ex) {
			Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		
		String id_category = request.getParameter("id_category");
		Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.INFO, "Category: " + id_category);
		String manufacturer_id = request.getParameter("manufacturer_id");
		Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.INFO, "Manufacturer: " + manufacturer_id);
		String supplier_id = request.getParameter("supplier_id");
		Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.INFO, "Supplier: " + supplier_id);
		
		return new Drink(name, ingredients, new Double(price), manufactureDate, expirationDate, 
				new Category(new Long (id_category)), new Manufacturer(new Long (manufacturer_id)), new Supplier(new Long (supplier_id)));
	}

	@Override
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("/crud-drinks/drinks?operation=SELECT");
		} catch (IOException ex) {
			Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
