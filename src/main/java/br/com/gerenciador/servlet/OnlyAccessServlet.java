package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.action.Action;

@WebServlet("/access")
public class OnlyAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramsAction = request.getParameter("action");
		String name = null;
		PrintWriter out = response.getWriter();
		String className = "br.com.gerenciador.action." + paramsAction;
		HttpSession ss = request.getSession();
		boolean logged = ss.getAttribute("cadAuth") == null;
		boolean protectedAction = !(paramsAction.equals("Login") || paramsAction.equals("AutenticarUsuario"));
		
		if(logged && protectedAction) {
			response.sendRedirect("access?action=Login");
			return;
		}
		
		try {
			Class classController = Class.forName(className); //carrega a classe em mémoria com o nome especificado
			Object classObj = classController.newInstance();
			Action action = (Action) classObj;
			name = action.execute(request, response);
			System.out.println("ClassName: " + className);
			System.out.println("Name: " + name);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException();
		}
		
		
		/*if(paramsAction.equals("listadecontatos")) {
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
		else if(paramsAction.equals("formulario")) {
			Formulario action = new Formulario();
			name = action.execute(request, response);
		}
		else {
			throw new ServletException();
		}*/
		
		String[] type = name.split(":");
		System.out.println(type[0] + "\n" + type[1]);
		
		if( type[0].equals("forward") ) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + type[1]);
			rd.forward(request, response);
		} 
		else if( type[0].equals("redirect") ){
			response.sendRedirect(type[1]);
		} 
		else {
			out.append("null");
		}
		
	}
}
