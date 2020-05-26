package ServletCardapio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Cardapio;
import DAO.CardapioDao;

@WebServlet("/VerServletCardapio")
public class VerServletCardapio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		out.println("<a href='welcome.jsp'>Voltar</a>");
		out.println("<h1>Menu Sperança</h1>");
		
		List<Cardapio> list=CardapioDao.getTodoCardapio();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Nome</th><th>Descricao</th><th>Preço</th><th>Disponível</th><th>Editar</th><th>Deletar</th></tr>");
		for(Cardapio c:list){
			out.print("<tr><td>"+c.getId()+"</td><td>"+c.getNome_prato()+"</td><td>"+c.getDescricao()+"</td><td>"+c.getDisponivel()+"</td><td>"+c.getPreco()+"</td><td><a href='EditarServletCardapio?id="+c.getId()+"'>edit</a></td><td><a href='ApagarServletCardapio?id="+c.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
