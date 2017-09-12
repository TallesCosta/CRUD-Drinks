
package br.com.talles.drink.controll.viewHelper.drink;

import br.com.talles.drink.controll.Result;
import br.com.talles.drink.controll.viewHelper.IViewHelper;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDrinkVh implements IViewHelper {

	@Override
	public Entity getEntity(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		return new Drink(new Long(id));
	}

	@Override
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/new.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(ListDrinkVh.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
