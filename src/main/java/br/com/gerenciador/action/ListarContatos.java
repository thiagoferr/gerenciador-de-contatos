package br.com.gerenciador.action;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.BancoDeUsuarios;
import br.com.gerenciador.modelo.UsuarioContato;

public class ListarContatos {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		   //RequestDispatcher rd = request.getRequestDispatcher("/mostrarcontato.jsp");
	       BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
	       System.out.println("access/listacontato");
	       Iterator<UsuarioContato> it = bancoDeUsuarios.exibirListaDeUsuarios().iterator();
	       UsuarioContato uc = null;
	       
	       while(it.hasNext()) {
	    	   uc = it.next();
	       }
	       
	       request.setAttribute("usuario", uc);
	       request.setAttribute("lista",  bancoDeUsuarios.exibirListaDeUsuarios());
	       
	      // rd.forward(request, response);
	       return "forward:mostrarcontato.jsp";
	}
}
