<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Sperança</title>
</head>
<body>
<h1>Seja Bem-Vindo!</h1>



<%
response.setHeader("Cache-Control","no-cach,no-store,must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("login.jsp"); 
}
%>

<h2>Olá, ${username}!</h2>

<br>
<br>
<a href="Produto.jsp">Cadastrar Produto</a><br>
<a href="VerServletProduto">Lista de Produtos</a><br>
<a href="Cardapio.jsp">Cadastrar prato ao menu</a><br>
<a href="VerServletCardapio">Menu Sperança</a><br>
<br>
<form action="Logout">
<input type="submit" value="Logout">

</form>

</body>
</html>