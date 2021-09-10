import java.util.ArrayList;
import java.util.Scanner;
public class Snack implements Entity {

	private String name;
	private double price;
	private int stockQuantity;
	private static ArrayList<Snack> snackList = new ArrayList<Snack>();
	
	public Snack(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	public static void viewSnacks() {
		for (Snack s : snackList) {
			System.out.println(s.getName() + " - " + s.getPrice());
		}
	}
	
	@Override // cadastrar lanche
	public void register() {
		snackList.add(this);
	}

	@Override // atualizar lanche
	public void update() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1- Nome");
		System.out.println("2- Preço");
		System.out.println("3- Quantidade em estoque");
		
		System.out.println("Digite o atributo que deseja utilizar: ");
		int opcao = Integer.parseInt(sc.nextLine());
		
		switch (opcao) {
		case 1:
			System.out.println("Digite o nome do produto: ");
			String n = sc.nextLine();
			this.setName(n);
			break;
		case 2:
			System.out.println("Digite o preço do produto: ");
			int p = Integer.parseInt(sc.nextLine());
			this.setPrice(p);
			break;
		case 3: 
			System.out.println("Digite a quantidade em estoque do produto: ");
			int q = Integer.parseInt(sc.nextLine());
			this.setStockQuantity(q);
			break;
		default:
			System.out.println("Opção inválida");
		}
		
	}

	@Override // ver lanche
	public void view() {
		System.out.println(this);

	}

	@Override // remover lanche
	public void delete() {
		snackList.remove(this);

	}
	
	@Override
	public String toString() {
		String text = "";
		text += "Nome: " + this.name + "\n";
		text += "Preço: " + this.price + "\n";
		text += "Quantidade em estoque: " + this.stockQuantity;
		return text;
	}
	
	public void sellSnack(int quantity) {
		if (this.stockQuantity - quantity >= 0) {
			this.stockQuantity -= quantity;
		}
	}
	
	// Get & Set

	public static Snack getSnack(String name) {
		for (Snack s : snackList) {
			if (s.getName() == name) {
				return s;
			}
		}
		return null;
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

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
