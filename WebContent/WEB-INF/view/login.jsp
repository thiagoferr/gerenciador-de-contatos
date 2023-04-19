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
      max-width: 20vw;
      margin: 0 auto;
    }

    label {
      margin-bottom: 8px;
    }

    input[type="email"],
    input[type="password"]
    {
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
  </style>
</head>
<body>
  <h1>Login</h1>
  <form action="/gerenciador2/access?action=AutenticarUsuario" method="post">
    
    <label for="email">email</label>
    <input type="email" id="email" name="email" required>

    <label for="senha">senha</label>
    <input type="password" id="senha" name="senha">

    <input type="submit" value="Entrar">
  </form>
</body>
</html>
