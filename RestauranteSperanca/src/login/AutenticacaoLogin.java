package login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UsuarioDao;


@WebServlet("/autenticacao")
public class AutenticacaoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UsuarioDao dao=new UsuarioDao();
		
		
		if(dao.check(email, password))
		{
			
			HttpSession session=request.getSession();
			session.setAttribute("username",email);
			response.sendRedirect("welcome.jsp");
			
		}else {
			
			response.sendRedirect("index.jsp");
			
		}		
		
	}

}


