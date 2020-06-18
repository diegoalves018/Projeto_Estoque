<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=ISO-8859-1">
<title>Cadastrar Produtos</title>
</head>
<body>
<form action="SalvarServletCardapio" method="post">

<table>
<tr><td>Nome do Prato:</td><td><input type="text" name="nome_prato"/></td></tr>
<tr><td>Disponível:</td><td><select name="disponivel">
<option value="Sim">Sim</option>
<option value="Não">Não</option>
</select></td></tr>
<tr><td>Preço:</td><td><input type="number" name="preco"/></td></tr>
<tr><td>Descrição:</td><td><textarea name="descricao"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Salvar"/></td></tr>
</table>
<a href='welcome.jsp'>Voltar</a>
</form>
</body>
</html>