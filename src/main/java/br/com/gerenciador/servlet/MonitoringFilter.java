package br.com.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/access")
public class MonitoringFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MonitoringFilter");
		long before = System.currentTimeMillis();

		chain.doFilter(request, response);
		
		long after = System.currentTimeMillis();
		
		System.out.println("Runtime: " + (after - before) + " ms");
	}
}
