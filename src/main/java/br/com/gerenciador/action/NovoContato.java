package br.com.gerenciador.action;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.BancoDeUsuarios;
import br.com.gerenciador.modelo.UsuarioContato;

public class NovoContato implements Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   System.out.println("access/novocontato");
		  
		   String id = request.getParameter("id");
	       String nome = request.getParameter("nome");
	       String telefone = request.getParameter("telefone"); 
	       String email = request.getParameter("email");
	       String comentario = request.getParameter("comentario");
	       
	       UsuarioContato usuarioContato = new UsuarioContato(nome, telefone, email, comentario, new Date());
	      
	       BancoDeUsuarios bancoDeUsuario = new BancoDeUsuarios();
	      
	       if(id != null) {
	    	   UsuarioContato uc = bancoDeUsuario.editarUsuario(usuarioContato, Integer.parseInt(id));
	    	   if(uc != null) {
	    		   System.out.println("Contato editado com sucesso!");	
	    		   //response.sendRedirect("access?action=listadecontatos");   
	    		   return "redirect:access?action=ListarContatos";
	    	   } else {
	    		   System.out.println("Não foi possível editar este contato");
	    	   }
		   } else {
		       bancoDeUsuario.adicionarUsuario(usuarioContato);

		       //response.sendRedirect("access?action=listadecontatos");   
		       return "redirect:access?action=ListarContatos";
		   }
	       return null;
	}
}
