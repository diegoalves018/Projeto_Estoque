package ServlerProdutos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProdutoDao;
import DAO.Produto;

@WebServlet("/EditarServlet2Produto")
public class EditarServlet2Produto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String nome_produto=request.getParameter("nome_produto");
		String descricao=request.getParameter("descricao");
		String estoque_minimo=request.getParameter("estoque_minimo");
		String estoque_maximo=request.getParameter("estoque_maximo");
		
		Produto p=new Produto();
		p.setId(id);
		p.setNome_produto(nome_produto);
		p.setDescricao(descricao);
		p.setEstoque_minimo(estoque_minimo);
		p.setEstoque_maximo(estoque_maximo);
		
		int status=ProdutoDao.update(p);
		if(status>0){
			response.sendRedirect("VerServletProduto");
		}else{
			out.println("Erro! Não foi possível atualizar!");
		}
		
		out.close();
	}

}

