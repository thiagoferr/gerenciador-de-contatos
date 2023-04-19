package br.com.gerenciador.modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class BancoDeUsuarios {
	
	private static List<UsuarioContato> listaDeUsuarios = new ArrayList<>();
	private static List<Cadastro> listaDeCadastrados = new ArrayList<>();
	private static int chaveSequencial = 0;
	
	static {
		Cadastro c1 = new Cadastro();
		Cadastro c2 = new Cadastro();
		Cadastro c3 = new Cadastro();
		
		c1.setEmail("user1@email.com");
		c2.setEmail("user2@othermail.com");
		c3.setEmail("newuser@hotmail.com");
		
		c1.setSenha("123456");
		c2.setSenha("654321");
		c3.setSenha("112233");
		
		BancoDeUsuarios.listaDeCadastrados.add(c1);
		BancoDeUsuarios.listaDeCadastrados.add(c2);
		BancoDeUsuarios.listaDeCadastrados.add(c3);
	}
	
	public List<Cadastro> exibirListaDeCadastrados(){
		return BancoDeUsuarios.listaDeCadastrados;
	}
	
	public void adicionarUsuario(UsuarioContato uc) {
		
		uc.setId(chaveSequencial);
		BancoDeUsuarios.listaDeUsuarios.add(uc);
		chaveSequencial++;
		
	}
	
	public void removerUsuario(int id) {
		Iterator<UsuarioContato> it = BancoDeUsuarios.listaDeUsuarios.iterator();
		while(it.hasNext()) {
			UsuarioContato uc = it.next();
			if(uc.getId() == id) {
				it.remove();
				chaveSequencial--;
			}
		}
	}
	
	public UsuarioContato editarUsuario(UsuarioContato uc, int id) {
		UsuarioContato findById = this.findById(id);
		if(this.findById(id) == null) {
			return null;
		} else {
			findById.setNome(uc.getNome());
			findById.setEmail(uc.getEmail());
			findById.setTelefone(uc.getTelefone());
			findById.setComentario(uc.getComentario());
			findById.setDataComentario(uc.getDataComentario());
			return BancoDeUsuarios.listaDeUsuarios.get(id);
		}
	}
	
	public UsuarioContato findById(int id) {
		for (UsuarioContato item : listaDeUsuarios) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	public List<UsuarioContato> exibirListaDeUsuarios() {
		return BancoDeUsuarios.listaDeUsuarios;
	}
	
	public void gravarPlanilha() {
		
		try (PrintWriter pw = new PrintWriter("C:\\Users\\user\\Desktop\\planilha.csv")){
			this.exibirListaDeUsuarios().forEach(item -> {
				String newStr = String.join(";", item.getNome(), item.getEmail(), item.getTelefone(), item.getComentario()).concat("\n");
				pw.append(newStr);
			});
			pw.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}