
package br.com.talles.drink.controll.viewHelper.drink;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.controll.viewHelper.IViewHelper;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;

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
		
		return new Drink(name, ingredients, new Double(price), manufactureDate, expirationDate);
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
