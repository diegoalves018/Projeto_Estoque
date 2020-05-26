package DAO;

import java.util.*;
import java.sql.*;

public class UsuarioDao {

	private static final String sql="select *from usuario where email=? and password=?";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estoque?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String USUARIO = "root";
    private static final String SENHA = "admin";
   
    public static Connection getConnection(){
    	Connection con=null;
        try{
            Class.forName(DRIVER);
                con=DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(Exception ex){System.out.println(ex);}
		return con;
	}
    
    public boolean check(String email, String password) {
		Connection con=null;
	    try{
		Class.forName("com.mysql.jdbc.Driver");
  	
    	 con= DriverManager.getConnection( URL, USUARIO, SENHA );
    	 PreparedStatement ps=con.prepareStatement(sql);
    	 ps.setString(1,email);
    	 ps.setString(2,password);
    	 ResultSet rs=ps.executeQuery();
    	 if(rs.next()) {
    		 return true;
    	 }
    	   	 
    }catch(Exception ex){System.out.println(ex);}
		
		return false;
	}
    
    
	public static int save(Usuario e){
		int status=0;
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into usuario(name,password,email) values (?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
					
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int update(Usuario e){
		int status=0;
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update usuario set name=?,password=?,email=? where id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setInt(4,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from usuario where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static Usuario getCadastradosId(int id){
		Usuario e=new Usuario();
		
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from usuario where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	
	public static List<Usuario> getTodosCadastros(){
		List<Usuario> list=new ArrayList<Usuario>();
		
		try{
			Connection con=UsuarioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from usuario");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Usuario e=new Usuario();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				list.add(e);
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return list;
	}
	
}