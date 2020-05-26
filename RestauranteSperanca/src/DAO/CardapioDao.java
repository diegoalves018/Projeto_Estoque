package DAO;

import java.util.*;
import java.sql.*;

public class CardapioDao {

	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estoque?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String Cardapio = "root";
    private static final String SENHA = "admin";
   
    public static Connection getConnection(){
    	Connection con=null;
        try{
            Class.forName(DRIVER);
                con=DriverManager.getConnection(URL, Cardapio, SENHA);
        }catch(Exception ex){System.out.println(ex);}
		return con;
	}
    
	public static int save(Cardapio c){
		int status=0;
		try{
			Connection con=CardapioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into cardapio(nome_prato,descricao,disponivel,preco) values (?,?,?,?)");
			ps.setString(1,c.getNome_prato());
			ps.setString(2,c.getDescricao());
			ps.setString(3,c.getDisponivel());
			ps.setString(4,c.getPreco());
					
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int update(Cardapio c){
		int status=0;
		try{
			Connection con=CardapioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update cardapio set nome_prato=?,descricao=?,disponivel=?,preco=? where id=?");
			ps.setString(1,c.getNome_prato());
			ps.setString(2,c.getDescricao());
			ps.setString(3,c.getDisponivel());
			ps.setString(4,c.getPreco());
			ps.setInt(5,c.getId());
			
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=CardapioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from cardapio where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static Cardapio getCardapioId(int id){
		Cardapio c=new Cardapio();
		
		try{
			Connection con=CardapioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from cardapio where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				c.setId(rs.getInt(1));
				c.setNome_prato(rs.getString(2));
				c.setDescricao(rs.getString(3));
				c.setDisponivel(rs.getString(4));
				c.setPreco(rs.getString(5));
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return c;
	}
	
	public static List<Cardapio> getTodoCardapio(){
		List<Cardapio> list=new ArrayList<Cardapio>();
		
		try{
			Connection con=CardapioDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from cardapio");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Cardapio c=new Cardapio();
				c.setId(rs.getInt(1));
				c.setNome_prato(rs.getString(2));
				c.setDescricao(rs.getString(3));
				c.setDisponivel(rs.getString(4));
				c.setPreco(rs.getString(5));
				list.add(c);
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return list;
	}
}
