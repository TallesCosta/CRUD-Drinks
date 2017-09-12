
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateDrinkVh implements IViewHelper {

	@Override
	public Entity getEntity(HttpServletRequest request) {
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
		Calendar manufactureDate = Calendar.getInstance();
		Calendar expirationDate = Calendar.getInstance();
		try {			
			manufactureDate.setTime(dateFormat.parse(manufactureString));
			Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.INFO, manufactureDate.toString());
			expirationDate.setTime(dateFormat.parse(expirationString));
			Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.INFO, expirationDate.toString());
			
			return new Drink(name, ingredients, new Double(price), manufactureDate, expirationDate, 
				new Category(new Long (id_category)), new Manufacturer(new Long (manufacturer_id)), new Supplier(new Long (supplier_id)));
		} catch (ParseException | NumberFormatException ex) {
			Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
			return new Drink();
		}
	}

	@Override
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
		if(result.hasMsg()){
			request.setAttribute("result", result);
			
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/new.jsp");
			
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException ex) {
				Logger.getLogger(ListDrinkVh.class.getName()).log(Level.SEVERE, null, ex);
			}
		}else{
			try {
				response.sendRedirect("/crud-drinks/drinks?operation=SELECT");
			} catch (IOException ex) {
				Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
