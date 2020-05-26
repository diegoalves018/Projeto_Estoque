package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDao;
import DAO.Usuario;

@WebServlet("/EditarServlet2")
public class EditarServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/jsp");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		Usuario e=new Usuario();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		
		int status=UsuarioDao.update(e);
		if(status>0){
			response.sendRedirect("VerServlet");
		}else{
			out.println("Erro! Não foi possível atualizar!");
		}
		
		out.close();
	}

}

