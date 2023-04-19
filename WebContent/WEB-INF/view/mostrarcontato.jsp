<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List,br.com.gerenciador.modelo.BancoDeUsuarios,
				br.com.gerenciador.modelo.UsuarioContato"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<% UsuarioContato usuario = (UsuarioContato)request.getAttribute("usuario");
List<UsuarioContato> contatos = (List<UsuarioContato>)request.getAttribute("lista");
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

@import url('https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Koulen&family=Lato&family=Nunito&family=Playfair+Display:ital@1&family=Prata&family=Raleway:ital,wght@1,100&family=Roboto&family=Roboto+Condensed&family=Teko&display=swap');

	*{
		margin:0;
		padding:0;
		box-sizing: border-box;	  
	  	font-family: arial;
	}
	
	body{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	
	.lista-completa ul li{
		padding: 10px;
		width: 40vw;
		border: 1px solid black;
		margin: 10px;
		list-style: none;
		display: flex;
		justify-content: space-between;
	}
	

	
	.main {
		width: 50vw;
		border: 2px solid black;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
	.novo-contato {
		border: 2px solid black;
		padding: 15px;
		width: 40vw;
		height: auto;
  		display: flex;
  		align-items: center;
		margin: 10px;
		flex-direction: column;
	}
	
	.lista-usuario li{
		margin: 10px;
	  	display: flex;
		flex-direction: column;
	}
	
	.novo-contato h3{
		padding: 5px;
		margin: 10px;
		border: 1px solid black;
	}
	
	.editar-item-contato a{
		 text-decoration: none;
		 padding: 6px 12px;
		 background-color: rgba(23, 26, 32, 0.8); 
		 border: none; 
		 border-radius: 6px; 
		 color: #fff; 
		 margin-left: 10px;
		 font-family: SFProText-Regular, Helvetica, Arial, sans-serif; 
		 font-size: 12px; 
		 height: 30px; 
		 line-height: 20px; 
		 text-align: center;
	}
	.editar-item-contato a:hover{
		background-color: rgba(23, 26, 32, 1); 
 		cursor: pointer; 
	}
	.header a {
		 border: 1px solid white;
		 text-align: center;
		 text-decoration: none;
		 background-color: rgba(23, 26, 32, 0.8); 
		 border: none; 
		 border-radius: 6px; 
		 color: #fff; 
		 flex-grow: 1; 
		 font-family: SFProText-Regular, Helvetica, Arial, sans-serif; 
		 font-size: 15px; 
		 height: 30px; 
		 line-height: 10px; 
		 margin-left: 8px; 
		 min-width: 140px; 
		 padding: 10px 12px; 
		 color:white; 
		 cursor: pointer; 
	}
	
	
	.header a:hover {
	 	background-color: rgba(23, 26, 32, 1); 
 		cursor: pointer; 
 	}
 	
 	.header {
 	    margin-top: 35px;
 		display: flex;
 		flex-direction: column;
 		width: 20vw;
 		align-items: center;
 		justify-content: center;
 	}
 	
 	.header h1{
 		margin-bottom: 10px;
 	}
 	
 	#logout{
 		position: absolute;
 		top: 20px;
 		right: 100px;
 	}
 		
</style>
</head>
<body>
	<a id="logout" href="/gerenciador2/access?action=Logout">Logout</a>
	<div class="main">
		<div class="header">
			<h1> Lista de Contatos</h1>
		<!--  	<a href="/gerenciador2/access?action=Formulario">-->
		<a href="access?action=AdicionarContatoForms">
				Adicionar
			</a>
		</div>
	<br> 
	
		<c:if test="${not empty lista }">
		<div class="novo-contato">
			<h3>Novo contato</h3>
			
			<ul class = "lista-usuario">
				<li>Nome: ${usuario.nome}</li>
				<li>Email: ${usuario.email}</li>
				<li>Telefone: ${usuario.telefone}</li>
				<li>Comentario: ${usuario.comentario}</li>
				<li> Data da publicação: 
				<fmt:formatDate value="${usuario.dataComentario}" pattern="dd/MM/yyyy HH:mm:ss"/>
				</li>
			</ul>
		</div>
		<%--  
		<div>
			<c:forEach var="i" begin="1" end="10" step="2">
				<h5><li> ${i} </li></h5>
			</c:forEach>
		</div>
		--%>
		<div class="lista-completa">
			<ul>
			<c:forEach items="${lista}" var="listaUsuario">
			<li>
			<div class="item-contato"> 
				${listaUsuario.nome} - 
				<fmt:formatDate value="${listaUsuario.dataComentario}" pattern="dd/MM/yyyy HH:mm:ss"/>
			</div>
			<div class="editar-item-contato"> 
				<a href="/gerenciador2/access?action=EditarContato&id=${listaUsuario.id}">
					Editar
				</a>
				<a href="/gerenciador2/access?action=RemoverContato&id=${listaUsuario.id}">
					Remover
				</a>
			</div>
			</li>
			
			</c:forEach>
		</ul>
		</div>
		
	</c:if>
	
	<c:if test="${empty lista}">
			<h1>Nenhum novo contato cadastrado</h1>
	</c:if>
	</div>

</body>
</html>