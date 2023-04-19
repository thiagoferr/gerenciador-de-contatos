package br.com.gerenciador.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.BancoDeUsuarios;
import br.com.gerenciador.modelo.UsuarioContato;

public class EditarContato implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("access/editarcontato");
		String id = request.getParameter("id");
		
        BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
        UsuarioContato usuarioContato = bancoDeUsuarios.findById(Integer.parseInt(id));
        
        PrintWriter out = response.getWriter();
        //RequestDispatcher rd = request.getRequestDispatcher("/editarform.jsp");
        
        if(!usuarioContato.equals(null)) {
        	request.setAttribute("contatoId", Integer.parseInt(id));
        	request.setAttribute("usuarioContatoEditado", usuarioContato);
        	return "forward:editarform.jsp";
            //rd.forward(request, response);
        } else {
        	out.append("null");
        }
        return null;
	}
}
