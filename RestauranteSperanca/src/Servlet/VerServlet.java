package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Usuario;
import DAO.UsuarioDao;

@WebServlet("/VerServlet")
public class VerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.jsp'>Novo Cadastro</a>");
		out.println("<h1>Lista de Cadastrados</h1>");
		
		List<Usuario> list=UsuarioDao.getTodosCadastros();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Nome</th><th>Senha</th><th>Email</th><th>Editar</th><th>Deletar</th></tr>");
		for(Usuario e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td><a href='EditarServlet?id="+e.getId()+"'>edit</a></td><td><a href='ApagarServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
