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

@WebServlet("/SalvarServletCardapio")
public class SalvarServletCardapio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		
		String nome_prato=request.getParameter("nome_prato");
		String descricao=request.getParameter("descricao");
		String disponivel=request.getParameter("disponivel");
		String preco=request.getParameter("preco");
		
		Cardapio c=new Cardapio();
		c.setNome_prato(nome_prato);
		c.setDescricao(descricao);
		c.setDisponivel(disponivel);
		c.setPreco(preco);
		
		
		int status=CardapioDao.save(c);
		if(status>0){
			out.print("<p>Cadastro do prato efetuado com sucesso!</p>");
			request.getRequestDispatcher("welcome.jsp").include(request, response);
		}else{
			out.println("Erro! Não foi possível salvar os dados do prato!");
		}
		
		out.close();
	}

}

