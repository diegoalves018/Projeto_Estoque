package ServlerProdutos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Produto;
import DAO.ProdutoDao;

@WebServlet("/EditarServletProduto")
public class EditarServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		out.println("<h1>Atualizar Produto</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Produto p=ProdutoDao.getProdutoId(id);
		
		out.print("<form action='EditarServlet2Produto' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+p.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='nome_produto' value='"+p.getNome_produto()+"'/></td></tr>");
		out.print("<tr><td>Estoque Minimo:</td><td><input type='number' name='estoque_minimo' value='"+p.getEstoque_minimo()+"'/></td></tr>");
		out.print("<tr><td>Estoque Maximo:</td><td><input type='number' name='estoque_maximo' value='"+p.getEstoque_maximo()+"'/></td></tr>");
		out.print("<tr><td>Decrição:</td><td><textarea name=\"descricao\">"+p.getDescricao()+"</textarea></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Editar &amp; Salvar'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.println("<a href='welcome.jsp'>Página de Login</a>");
		out.close();
	}
}
