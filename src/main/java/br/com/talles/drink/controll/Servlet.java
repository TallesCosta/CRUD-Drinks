package br.com.talles.drink.controll;

import br.com.talles.drink.controll.command.DeleteCmd;
import br.com.talles.drink.controll.command.FindCmd;
import br.com.talles.drink.controll.command.ICommand;
import br.com.talles.drink.controll.command.SaveCmd;
import br.com.talles.drink.controll.command.SelectCmd;
import br.com.talles.drink.controll.command.UpdateCmd;
import br.com.talles.drink.controll.viewHelper.DrinkVh;
import br.com.talles.drink.controll.viewHelper.IViewHelper;
import br.com.talles.drink.domain.Drink;
import br.com.talles.drink.domain.Entity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EntryPoint", urlPatterns = {"/start", "/create"})
public class Servlet extends HttpServlet {

	private Map<String, IViewHelper> viewHelpers;
	private Map<String, ICommand> commands;

	public Servlet() {
		viewHelpers = new HashMap();
		viewHelpers.put("/crud-drinks/create", new DrinkVh());

		commands = new HashMap();
		commands.put("SAVE", new SaveCmd());
		commands.put("UPDATE", new UpdateCmd());
		commands.put("DELETE", new DeleteCmd());
		commands.put("SELECT", new SelectCmd());
		commands.put("FIND", new FindCmd());
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
        
        IViewHelper viewHelper = viewHelpers.get(uri);

        Entity entity = viewHelper.getEntity(request);

		/*String cmd = request.getParameter("operation");
        ICommand command = commands.get(cmd);

        Result result = command.execute(entity);

        viewHelper.setView(result, request, response);*/	
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("FOI!");
		out.println("FOI! " + ((Drink) entity).getName());
		out.println("</body>");
		out.println("</html>");
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
