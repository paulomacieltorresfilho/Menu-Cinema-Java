package components;

public class Lanche {
	private String id;
	private String name;
	private double price;
	private int qtdsEmEstoque;
	
	public Lanche(String identificacao, String nome, double preco
			, int quantidade) {
		id = identificacao;
		name = nome;
		price = preco;
		qtdsEmEstoque = quantidade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQtdsEmEstoque() {
		return qtdsEmEstoque;
	}
	public void setQtdsEmEstoque(int qtdsEmEstoque) {
		this.qtdsEmEstoque = qtdsEmEstoque;
	}
	
	
}
