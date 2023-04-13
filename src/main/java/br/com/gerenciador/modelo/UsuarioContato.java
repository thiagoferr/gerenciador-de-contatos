package br.com.gerenciador.modelo;

import java.util.Date;
import java.util.Objects;

public class UsuarioContato {
	
	
	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String comentario;
	private Date dataComentario;
	
	
	public UsuarioContato(String nome, String telefone, String email, String comentario, Date dataComentario) {
		
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.comentario = comentario;
		this.dataComentario = dataComentario;
		
	}
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Date getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioContato other = (UsuarioContato) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return 	"\n\nId: " + getId() +
				"\nNome: " + getNome() +
				"\nEmail: " + getEmail() +
				"\nTelefone: " + getTelefone() +
				"\nComentario: " + getComentario() +
				"\nPublicado em: " + getDataComentario();
	}
	
		
}
