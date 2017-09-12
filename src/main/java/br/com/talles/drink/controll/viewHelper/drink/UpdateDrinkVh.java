
package br.com.talles.drink.controll.viewHelper.drink;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.controll.viewHelper.IViewHelper;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateDrinkVh implements IViewHelper {

	@Override
	public Entity getEntity(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		return new Drink(new Long(id));
	}

	@Override
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("/show?operation=FIND");
		} catch (IOException ex) {
			Logger.getLogger(CreateDrinkVh.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
