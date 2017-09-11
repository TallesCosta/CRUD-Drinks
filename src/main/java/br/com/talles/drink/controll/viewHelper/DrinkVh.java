
package br.com.talles.drink.controll.viewHelper;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DrinkVh implements IViewHelper {

	@Override
	public Entity getEntity(HttpServletRequest request) {
		String name = request.getParameter("name");
		String ingredients = request.getParameter("ingredients");
		String price = request.getParameter("price");
		String manufactureString = request.getParameter("manufactureDate");
		String expirationString = request.getParameter("expirationDate");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date manufactureDate = new Date();
		Date expirationDate = new Date();
		try {
			manufactureDate = dateFormat.parse(manufactureString);
			expirationDate = dateFormat.parse(expirationString);
		} catch (ParseException | NullPointerException ex) {
			Logger.getLogger(DrinkVh.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return new Drink(name, ingredients, new Double(price));
	}

	@Override
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
