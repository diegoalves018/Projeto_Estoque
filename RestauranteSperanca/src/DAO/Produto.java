package DAO;

public class Produto {
	private int id;
	private String nome_produto,descricao,estoque_minimo,estoque_maximo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEstoque_minimo() {
		return estoque_minimo;
	}
	public void setEstoque_minimo(String estoque_minimo) {
		this.estoque_minimo = estoque_minimo;
	}
	public String getEstoque_maximo() {
		return estoque_maximo;
	}
	public void setEstoque_maximo(String estoque_maximo) {
		this.estoque_maximo = estoque_maximo;
	}
	
}
