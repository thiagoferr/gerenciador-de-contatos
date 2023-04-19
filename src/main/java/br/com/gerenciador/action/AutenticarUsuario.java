package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.modelo.BancoDeUsuarios;
import br.com.gerenciador.modelo.Cadastro;

public class AutenticarUsuario implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");
	    
		BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
		int size = bancoDeUsuarios.exibirListaDeCadastrados().size();
		Cadastro cadastro = new Cadastro();
		
		cadastro.setEmail(email);
		cadastro.setSenha(senha);
		String[] userNames = new String[size];
				
		for(int i = 0; i < size; i++) {
			userNames[i] = bancoDeUsuarios.exibirListaDeCadastrados().get(i).getEmail().split("@")[0];
		}
		
		for (Cadastro item : bancoDeUsuarios.exibirListaDeCadastrados()) {
			if(item.equals(cadastro)) {
				HttpSession ss = request.getSession();
				ss.setAttribute("userNames", userNames);
				ss.setAttribute("cadAuth", item);
				ss.setAttribute("listaDeCadastros", bancoDeUsuarios.exibirListaDeCadastrados());
				return "forward:exibircadastros.jsp"; 
			}
		}
		
		return "forward:login.jsp";
	}

}
