package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Usuario;
import DAO.UsuarioDao;

@WebServlet("/SalvarServlet")
public class SalvarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		Usuario e=new Usuario();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		
		
		if(UsuarioDao.existeUsuario(e)) {
			out.print("<p>Email já cadastrado!</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		}else {
		int status=UsuarioDao.save(e);
		    if(status>0){
			out.print("<p>Cadastro efetuado com sucesso!</p>");
			request.getRequestDispatcher("index.jsp").include(request, response);
		   }else {
			out.println("Erro! Não foi possível salvar seus dados!");   
		   }
		}
		out.close();
	}

}

