package DAO;

import java.util.*;
import java.sql.*;

public class ProdutoDao {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/estoque?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private static final String Produto = "root";
    private static final String SENHA = "admin";
   
    public static Connection getConnection(){
    	Connection con=null;
        try{
            Class.forName(DRIVER);
                con=DriverManager.getConnection(URL, Produto, SENHA);
        }catch(Exception ex){System.out.println(ex);}
		return con;
	}
    
	public static int save(Produto p){
		int status=0;
		try{
			Connection con=ProdutoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into produto(nome_produto,descricao,estoque_minimo, estoque_maximo) values (?,?,?,?)");
			ps.setString(1,p.getNome_produto());
			ps.setString(2,p.getDescricao());
			ps.setString(3,p.getEstoque_minimo());
			ps.setString(4,p.getEstoque_maximo());
					
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int update(Produto p){
		int status=0;
		try{
			Connection con=ProdutoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update produto set nome_produto=?,descricao=?,estoque_minimo=?,estoque_maximo=? where id=?");
			ps.setString(1,p.getNome_produto());
			ps.setString(2,p.getDescricao());
			ps.setString(3,p.getEstoque_minimo());
			ps.setString(4,p.getEstoque_maximo());
			ps.setInt(5,p.getId());
			
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=ProdutoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from produto where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static Produto getProdutoId(int id){
		Produto p=new Produto();
		
		try{
			Connection con=ProdutoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from produto where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				p.setId(rs.getInt(1));
				p.setNome_produto(rs.getString(2));
				p.setDescricao(rs.getString(3));
				p.setEstoque_minimo(rs.getString(4));
				p.setEstoque_maximo(rs.getString(5));
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return p;
	}
	
	public static List<Produto> getTodosProdutos(){
		List<Produto> list=new ArrayList<Produto>();
		
		try{
			Connection con=ProdutoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from produto");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Produto p=new Produto();
				p.setId(rs.getInt(1));
				p.setNome_produto(rs.getString(2));
				p.setDescricao(rs.getString(3));
				p.setEstoque_minimo(rs.getString(4));
				p.setEstoque_maximo(rs.getString(5));
				list.add(p);
			}
			con.close();
			
		}catch(Exception ex){ex.printStackTrace();}
		
		return list;
	}
}
