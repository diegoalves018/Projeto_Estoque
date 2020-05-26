<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=ISO-8859-1">
<title>Cadastrar Produtos</title>
</head>
<body>
<form action="SalvarServletProduto" method="post">

<table>
<tr><td>Nome do Produto:</td><td><input type="text" name="nome_produto"/></td></tr>
<tr><td>Estoque Minimo:</td><td><input type="number" name="estoque_minimo"/></td></tr>
<tr><td>Estoque Maximo:</td><td><input type="number" name="estoque_maximo"/></td></tr>
<tr><td>Descrição:</td><td><textarea name="descricao"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Salvar"/></td></tr>
</table>
</form>
<a href='welcome.jsp'>Voltar</a>

</body>
</html>