package ServletCardapio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CardapioDao;
import DAO.Cardapio;

@WebServlet("/EditarServlet2Cardapio")
public class EditarServlet2Cardapio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String nome_prato=request.getParameter("nome_prato");
		String descricao=request.getParameter("descricao");
		String disponivel=request.getParameter("disponivel");
		String preco=request.getParameter("preco");
		
		Cardapio c=new Cardapio();
		c.setId(id);
		c.setNome_prato(nome_prato);
		c.setDescricao(descricao);
		c.setDisponivel(disponivel);
		c.setPreco(preco);
		
		int status=CardapioDao.update(c);
		if(status>0){
			response.sendRedirect("VerServletCardapio");
		}else{
			out.println("Erro! Não foi possível atualizar o cardápio!");
		}
		
		out.close();
	}

}

