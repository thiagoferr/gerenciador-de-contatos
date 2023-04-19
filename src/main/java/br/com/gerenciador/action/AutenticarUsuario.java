package br.com.gerenciador.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		//PrintWriter out = response.getWriter();
		//out.append(bancoDeusuarios.exibirListaDeCadastrados().toString());
	
	    String email = request.getParameter("email");
	    String senha = request.getParameter("senha");
	    
		BancoDeUsuarios bancoDeUsuarios = new BancoDeUsuarios();
		int size = bancoDeUsuarios.exibirListaDeCadastrados().size();
		Cadastro cadastro = new Cadastro();
		
		cadastro.setEmail(email);
		cadastro.setSenha(senha);
		String[] userNames = new String[size];
	/*	List<String> userListNames = new ArrayList<>();
		
			bancoDeUsuarios.exibirListaDeCadastrados()
			.forEach(item -> userListNames.add(item.getEmail().split("@")[0]));*/
				
		for(int i = 0; i < size; i++) {
			userNames[i] = bancoDeUsuarios.exibirListaDeCadastrados().get(i).getEmail().split("@")[0];
		}
		
		for (Cadastro item : bancoDeUsuarios.exibirListaDeCadastrados()) {
			if(item.equals(cadastro)) {
				HttpSession ss = request.getSession();
				ss.setAttribute("userNames", userNames);
				ss.setAttribute("cadAuth", item);
				ss.setAttribute("listaDeCadastros", bancoDeUsuarios.exibirListaDeCadastrados());
				//request.setAttribute("cadAuth", item);
				//request.setAttribute("listaDeCadastros", bancoDeUsuarios.exibirListaDeCadastrados());
				return "forward:exibircadastros.jsp"; 
			}
		}
		
		return "forward:login.jsp";
	}

}
