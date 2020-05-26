package ServlerProdutos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Produto;
import DAO.ProdutoDao;

@WebServlet("/VerServletProduto")
public class VerServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		out.println("<a href='welcome.jsp'>Voltar</a>");
		out.println("<h1>Lista de Produtos</h1>");
		
		List<Produto> list=ProdutoDao.getTodosProdutos();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Nome</th><th>Descricao</th><th>Estoque Minimo</th><th>Estoque Maximo</th><th>Editar</th><th>Deletar</th></tr>");
		for(Produto p:list){
			out.print("<tr><td>"+p.getId()+"</td><td>"+p.getNome_produto()+"</td><td>"+p.getDescricao()+"</td><td>"+p.getEstoque_minimo()+"</td><td>"+p.getEstoque_maximo()+"</td><td><a href='EditarServletProduto?id="+p.getId()+"'>edit</a></td><td><a href='ApagarServletProduto?id="+p.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}
