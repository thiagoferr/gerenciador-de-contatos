package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.action.Action;

@WebFilter("/access")
public class ControllerFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("ControllerFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
   		HttpServletResponse response= (HttpServletResponse) servletResponse;
		
		String paramsAction = request.getParameter("action");
		String name = null;
		PrintWriter out = response.getWriter();
		String className = "br.com.gerenciador.action." + paramsAction;
		
		try {
			Class classController = Class.forName(className); //carrega a classe em mémoria com o nome especificado
			Object classObj = classController.newInstance();
			Action action = (Action) classObj;
			name = action.execute(request, response);
			//System.out.println("ClassName: " + className);
			//System.out.println("Name: " + name);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException();
		}
		
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
