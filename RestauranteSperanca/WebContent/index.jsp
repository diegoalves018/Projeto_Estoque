<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Restaurante Sperença</title>
    <style>
      #boxes {
        content: "";
        display: table;
        clear: both;
      }
      div {
        float: left;
        height: 270px;
        width: 35%;
        padding: 0 10px;
      }
      #column1 {
        background-color: #FB5000;
      }
      #column2 {
        background-color: #3DEF1E;
      } 
      #column3 {
        background-color: #f497f1;
      h2 {
        color: #000000;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <main id="boxes">
      <div id="column1">
       <h2>Novo Cadastro</h2>
<form action="SalvarServlet" method="post">
<table>
<tr><td>Nome:</td><td><input type="text" name="name" required="required"/></td></tr>
<tr><td>Senha:</td><td><input type="password" name="password" required="required"/></td></tr>
<tr><td>E-mail:</td><td><input type="email" name="email" required="required"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Cadastrar" /></td></tr>
</table>
</form>

<br/>
<a href="VerServlet">Lista de Cadastrados</a>
</div>
      <div id="column2">
        <h2>Login</h2>
	<form action="autenticacao" method="post">
<table>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Senha:</td><td><input type="password" name="password"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Entrar"/></td></tr>
</table>
	</form>
	</div>
	<div id="column3">
       <h2>Menu Sperança</h2>
       <a href="VerServletCardapio2">Cardápio Sperança</a>
</div>

    </main>
  </body>
</html>