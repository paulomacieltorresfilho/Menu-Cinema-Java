package components;

public class Ingresso {
	private String id;
	private double price;
	
	public Ingresso(String identificacao, double preco) {
		id = identificacao;
		price = preco;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
