package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/access")
public class AuthorizationFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
   	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
   		System.out.println("AuthorizationFilter");
   		HttpServletRequest request = (HttpServletRequest) servletRequest;
   		HttpServletResponse response= (HttpServletResponse) servletResponse;
   		
   		HttpSession ss = request.getSession();
   		String paramsAction = request.getParameter("action");
   		
   		boolean logged = ss.getAttribute("cadAuth") == null;
		boolean protectedAction = !(paramsAction.equals("Login") || paramsAction.equals("AutenticarUsuario"));
		
		if(logged && protectedAction) {
			response.sendRedirect("access?action=Login");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
