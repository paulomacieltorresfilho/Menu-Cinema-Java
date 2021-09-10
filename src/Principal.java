import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		//TESTE FILMES
		Movie aux = new Movie(0, "As aventuras de pi", "seila amigo", "terror", 120);
		aux.register();	
		aux = new Movie(1, "Velozes e Calmos", "vin diesel calvo", "nerd", 300);
		aux.register();
		aux = new Movie(2, "TIM, o Filme", "azul azul auzl azul", "AZUL", 666);
		aux.register();
		aux = new Movie(3, "o mi aranh", "piupiu vai teia", "heroina", 20);
		aux.register();
		aux = new Movie(4, "Banana nananana", "nao eh azul mas pode ser", "minion", 1717);
		aux.register();
		
		Calendar.viewMovies();
		
		aux = Calendar.getMovie(1);
		System.out.println("Atualizar filme");
		aux.update();
		
		aux = Calendar.getMovie("o mi aranh");
		System.out.println("Filme deletado");
		aux.delete();
		Calendar.viewMovies();
		
		
		//TESTE SESSÕES E CALENDARIO
		Calendar c = new Calendar();
		
		c.view();
		
		c.register();
		c.register();
		c.register();
		c.update();
		c.delete();
		
		c.view();
		
		Scanner sc = new Scanner(System.in);

		c.view();
		System.out.println("Digite a sala da sessão desejada: ");
		char room = sc.nextLine().charAt(0);
		
		System.out.println("Digite o número correspondente à sessão desejada"
				+ "\n (os números começam em zero e reiniciam a partir de cada sala): ");
		int index = Integer.parseInt(sc.nextLine());
		
		Session s = Calendar.getSession(room, index);
		
		c.view(s);
		
		//TESTE LANCHE
		Snack sn;
		sn = new Snack("balinha", 0.50, 100);
		sn.register();
		sn = new Snack("coca cola", 3.50, 10);
		sn.register();
		sn = new Snack("salgado", 4.00, 5);
		sn.register();
		sn = new Snack("chocolate", 1.50, 7);
		sn.register();
		
		Snack s1 = Snack.getSnack("salgado");
		
		Snack.viewSnacks();
		
		//TESTE INGRESSOS E SESSÃO
		s.view();
		s.register();
		s.register();
		s.view(0);
			
	}

}
