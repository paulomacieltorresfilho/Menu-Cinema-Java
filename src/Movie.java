import java.util.Scanner;

public class Movie implements Entity {
	
	private int id;
	private String name;
	private String synopsis;
	private String genre;
	private int duration;


	
	public Movie(int id, String name, String synopsis, String genre, int duration) {
		this.id = id;
		this.name = name;
		this.synopsis = synopsis;
		this.genre = genre;
		this.duration = duration;
	}

	@Override
	public void register() {
		Calendar.addMovie(this);
	}

	@Override
	public void update() {
		Scanner sc = new Scanner(System.in);
		
		this.view();
		
		System.out.println("Digite a primeira letra do atributo que deseja atualizar [N/S/G/D]: ");
		char userChoice = Character.toUpperCase(sc.nextLine().charAt(0));

		switch (userChoice) {
			case 'N':
				System.out.println("Digite o nome do filme: ");
				String s1 = sc.nextLine();
				this.setName(s1);
				break;
			case 'S':
				System.out.println("Digite a sinopse do filme: ");
				String s2 = sc.nextLine();
				this.setSynopsis(s2);
				break;
			case 'G':
				System.out.println("Digite o gênero do filme: ");
				String s3 = sc.nextLine();
				this.setGenre(s3);
				break;
			case 'D':
				System.out.println("Digite a duração (em minutos) do filme: ");
				int s4 = Integer.parseInt(sc.nextLine());
				this.setDuration(s4);
				break;
			default:
				System.out.println("Essa opção não existe!");
		}
	}

	@Override
	public void view() {
		System.out.println(this);
	}

	@Override
	public void delete() {
		Calendar.removeMovie(this);
	}

	@Override
	public String toString() {
		String s = "";
		s += "Nome: " + this.name + "\n";
		s += "Sinopse: " + this.synopsis + "\n";
		s += "Gênero: " + this.genre + "\n";
		s += "Duração: " + this.duration;
		return s;
	}


	//Gets & Sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
