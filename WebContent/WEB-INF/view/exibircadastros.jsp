<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List,
				br.com.gerenciador.modelo.BancoDeUsuarios,
				br.com.gerenciador.modelo.Cadastro" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
   List<String> lnu = (List<String>)request.getAttribute("userNames");
   List<Cadastro> lista = (List<Cadastro>)request.getAttribute("listaDeCadastros");
   Cadastro cad = (Cadastro)request.getAttribute("cadAuth");
%>

<style>
	  *{
	  	margin: 0;
	  	padding: 0;
	  	font-family: arial;
	  }
 	#logout{
 		position: absolute;
 		top: 20px;
 		right: 50px;1
 	}
 	
 	#listar{
 		position: absolute;
 		top: 20px;
 		right: 120px;
 	}
 	

</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="menu-btn">
		<a id="listar" href="/gerenciador2/access?action=ListarContatos">
			Listar Contatos
		</a>
		<a id="logout" href="/gerenciador2/access?action=Logout">
			Logout
		</a>
	</div>

	<h3>Olá, 
		<c:out value="${cadAuth.email}">
			
		</c:out>
	  </h3>
	<br><br>
	<h1>Exibir Cadastros</h1>
	<!-- 
		<ul>
		<c:forEach items="${listaDeCadastros}" var="lista">
		<li>
			${lista.email};
		</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach items="${listaDeCadastros}" var="lista">
		<li>
			${lista.senha};
		</li>
		</c:forEach>
	</ul>
	
	<c:forEach items="${listaDeCadastros}" var="ls">
		<h2>
			${ls};
		</h2>
	</c:forEach>
	-->
	<c:forEach items="${userNames}" var="name">
		<h3>
			${name};
		</h3>
	</c:forEach>
	
	
	
</body>
</html>