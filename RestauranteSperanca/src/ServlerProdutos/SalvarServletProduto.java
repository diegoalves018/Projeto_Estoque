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

@WebServlet("/SalvarServletProduto")
public class SalvarServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String nome_produto=request.getParameter("nome_produto");
		String descricao=request.getParameter("descricao");
		String estoque_minimo=request.getParameter("estoque_minimo");
		String estoque_maximo=request.getParameter("estoque_maximo");
		
		Produto p=new Produto();
		p.setNome_produto(nome_produto);
		p.setDescricao(descricao);
		p.setEstoque_minimo(estoque_minimo);
		p.setEstoque_maximo(estoque_maximo);
		
		
		int status=ProdutoDao.save(p);
		if(status>0){
			out.print("<p>Cadastro do produto efetuado com sucesso!</p>");
			request.getRequestDispatcher("welcome.jsp").include(request, response);
		}else{
			out.println("Erro! Não foi possível salvar os dados do produto!");
		}
		
		out.close();
	}

}

