package br.com.talles.drink.controll;

import br.com.talles.drink.controll.command.DeleteCmd;
import br.com.talles.drink.controll.command.FindCmd;
import br.com.talles.drink.controll.command.ICommand;
import br.com.talles.drink.controll.command.SaveCmd;
import br.com.talles.drink.controll.command.SelectCmd;
import br.com.talles.drink.controll.command.UpdateCmd;
import br.com.talles.drink.controll.viewHelper.drink.CreateDrinkVh;
import br.com.talles.drink.controll.viewHelper.IViewHelper;
import br.com.talles.drink.controll.viewHelper.drink.DeleteDrinkVh;
import br.com.talles.drink.controll.viewHelper.drink.FindDrinkVh;
import br.com.talles.drink.controll.viewHelper.drink.ListDrinkVh;
import br.com.talles.drink.controll.viewHelper.drink.UpdateDrinkVh;
import br.com.talles.drink.domain.Entity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EntryPoint", urlPatterns = {"/drinks", "/drinks/find", "/drinks/create", "/drinks/update", "/drinks/delete"})
public class Servlet extends HttpServlet {

	private Map<String, IViewHelper> viewHelpers;
	private Map<String, ICommand> commands;

	public Servlet() {
		viewHelpers = new HashMap();
		viewHelpers.put("/crud-drinks/drinks", new ListDrinkVh());
		viewHelpers.put("/crud-drinks/drinks/create", new CreateDrinkVh());
		viewHelpers.put("/crud-drinks/drinks/delete", new DeleteDrinkVh());
		viewHelpers.put("/crud-drinks/drinks/find", new FindDrinkVh());
		viewHelpers.put("/crud-drinks/drinks/update", new UpdateDrinkVh());

		commands = new HashMap();
		commands.put("SELECT", new SelectCmd());
		commands.put("SAVE", new SaveCmd());
		commands.put("DELETE", new DeleteCmd());
		commands.put("FIND", new FindCmd());
		commands.put("UPDATE", new UpdateCmd());
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
        
        IViewHelper viewHelper = viewHelpers.get(uri);

        Entity entity = viewHelper.getEntity(request);

		String cmd = request.getParameter("operation");
        ICommand command = commands.get(cmd);

        Result result = command.execute(entity);

        viewHelper.setView(result, request, response);
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Servlet Genérica que trata todas as requisições da aplicação!";
	}

}
