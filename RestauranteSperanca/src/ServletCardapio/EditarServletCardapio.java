package ServletCardapio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cardapio;
import DAO.CardapioDao;

@WebServlet("/EditarServletCardapio")
public class EditarServletCardapio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Atualizar o Cardápio</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Cardapio c=CardapioDao.getCardapioId(id);
		
		out.print("<form action='EditarServlet2Cardapio' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+c.getId()+"'/></td></tr>");
		out.print("<tr><td>Nome:</td><td><input type='text' name='nome_prato' value='"+c.getNome_prato()+"'/></td></tr>");
		out.print("<tr><td>Disponível:</td><td><select name=\"disponivel\">\r\n" + 
				"<option value=\"Sim\">Sim</option>\r\n" + 
				"<option value=\"Não\">Não</option>\r\n" + 
				"</select></td></tr>'"+c.getDisponivel()+"'/></td></tr>");
		out.print("<tr><td>Preço:</td><td><input type='number'  step='0.01' min='0' max='9999999.99' name='preco' value='"+c.getPreco()+"'/></td></tr>");
		out.print("<tr><td>Decrição:</td><td><textarea name=\"descricao\">"+c.getDescricao()+"</textarea></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Editar &amp; Salvar'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.println("<a href='welcome.jsp'>Voltar</a>");
		out.close();
	}
}
