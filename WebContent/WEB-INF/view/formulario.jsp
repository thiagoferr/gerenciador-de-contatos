<!DOCTYPE html>
<html>
<head>
  <title>Formulário de Contato</title>
  <style>
	  *{
	  	margin: 0;
	  	padding: 0;
	  	font-family: arial;
	  }
  	h1 {
  		text-align: center;
  		max-width: 400px;
  		padding: 20px;
		display: flex;
        flex-direction: column;
        max-width: 400px;
        margin: 0 auto;  		
  	}
    form {
      display: flex;
      flex-direction: column;
      padding-top: 30px;
      max-width: 400px;
      margin: 0 auto;
    }

    label {
      margin-bottom: 8px;
    }

    input[type="text"],
    input[type="tel"],
    input[type="email"],
    textarea {
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      margin-bottom: 16px;
      font-size: 16px;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      padding: 8px 16px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }

    input[type="submit"]:hover {
      background-color: #3e8e41;
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
  <h1>Formulário de Contato</h1>
  <form action="/gerenciador2/access?action=NovoContato" method="post">
    
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <label for="telefone">Telefone:</label>
    <input type="tel" id="telefone" name="telefone">

    <label for="email">E-mail:</label>
    <input type="email" id="email" name="email" required>

    <label for="comentario">Comentário:</label>
    <textarea id="comentario" name="comentario" rows="5" required></textarea>

    <input type="submit" value="Enviar">
  </form>
</body>
</html>
