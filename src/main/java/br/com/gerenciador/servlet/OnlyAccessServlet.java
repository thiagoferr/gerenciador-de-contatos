package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.action.EditarContato;
import br.com.gerenciador.action.ListarContatos;
import br.com.gerenciador.action.NovoContato;
import br.com.gerenciador.action.RemoverContato;

@WebServlet("/access")
public class OnlyAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramsAction = request.getParameter("action");
		String name = null;
		PrintWriter out = response.getWriter();
		
		
		if(paramsAction.equals("listadecontatos")) {
			ListarContatos action = new ListarContatos();
			name = action.execute(request, response);
		}
		else if(paramsAction.equals("removercontato")) {
			
			RemoverContato action = new RemoverContato();
			name = action.execute(request, response);
		}
		else if(paramsAction.equals("editarcontato")) {
			
			EditarContato action = new EditarContato();
			name = action.execute(request, response);
		}
		else if(paramsAction.equals("novocontato")){
			NovoContato action = new NovoContato();
			name = action.execute(request, response);
		}
		else {
			throw new ServletException();
		}
		
		String[] type = name.split(":");
		
		if( type[0].equals("forward") ) {
			System.out.println("type: " + type[0]);
			System.out.println("type: " + type[1]);
			RequestDispatcher rd = request.getRequestDispatcher(type[1]);
			rd.forward(request, response);
		} 
		else if( type[0].equals("redirect") ){
			System.out.println("type: " + type[0]);
			response.sendRedirect(type[1]);
		} 
		else {
			out.append("null");
		}
	}
}
