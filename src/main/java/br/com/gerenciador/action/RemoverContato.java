package br.com.gerenciador.action;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.BancoDeUsuarios;
import br.com.gerenciador.modelo.UsuarioContato;

public class RemoverContato {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("access/removercontato");
			String id = request.getParameter("id");
			BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();

			bancoDeUsuarios.removerUsuario(Integer.parseInt(id));
			//response.sendRedirect("access?action=listadecontatos");   
			return "redirect:access?action=listadecontatos";
	}
}
