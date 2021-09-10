import java.util.*;

public class Calendar implements Entity {
	
	private static ArrayList<ArrayList<Session>> sessionList = new ArrayList<ArrayList<Session>>();
	private static ArrayList<Movie> inTheaters = new ArrayList<Movie>();
	private static ArrayList<Session> a = new ArrayList<Session>();
	private static ArrayList<Session> b = (ArrayList<Session>) a.clone();
	private static ArrayList<Session> c = (ArrayList<Session>) a.clone();
	private static ArrayList<Session> d = (ArrayList<Session>) a.clone();
	
	public Calendar() {
		sessionList.add(a);
		sessionList.add(b);
		sessionList.add(c);
		sessionList.add(d);
   }
	@Override // adicionar sessão
	public void register() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Session> auxRoom;
		
		System.out.println("---------Adicionar sessão---------");
		
		for (int i = 0; i < inTheaters.size(); i++) {
			System.out.println(i + " - " + inTheaters.get(i).getName());
		}
		
		System.out.println("Digite o número correspondente ao filme desejado: ");
		int filmChoice = Integer.parseInt(sc.nextLine());
		
		Movie m = getMovie(filmChoice);
		
		CinemaRoom.showRooms();
		
		System.out.println("Digite a letra correspondente à sala desejada [A/B/C/D]: ");
		char roomChoice = Character.toUpperCase(sc.nextLine().charAt(0));
		if (roomChoice > 'D' && roomChoice < 'A') {
			System.out.println("Essa sala não existe!");
			this.register();
			return;
		}
		
		System.out.println("Digite o dia, mês e ano da sessão (dd MM yyyy): ");
		
		String[] dateInfo = sc.nextLine().split(" ");
		if (dateInfo.length > 3) {
			System.out.println("Informação inválida");
			this.register();
			return;
		}
		int[] dateInfoInt = new int[3];
		for (int i = 0; i < 3; i++) {
			dateInfoInt[i] = Integer.parseInt(dateInfo[i]);
		}
		
		System.out.println("Digite o horário da sessão (hh:mm): ");
		String[] timeInfo = sc.nextLine().split(":");
		if (timeInfo.length > 2) {
			System.out.println("Informação inválida");
			this.register();
			return;
		}
		int[] timeInfoInt = new int[2];
		for (int i = 0; i < 2; i++) {
			timeInfoInt[i] = Integer.parseInt(timeInfo[i]);
		}
		
		GregorianCalendar gcal = new GregorianCalendar(dateInfoInt[2], dateInfoInt[1], dateInfoInt[0], timeInfoInt[0], timeInfoInt[1]);
		GregorianCalendar gcalCopy = (GregorianCalendar) gcal.clone();
		gcalCopy.add(GregorianCalendar.MINUTE, m.getDuration());
		
		// Linhas: salas | Colunas: sessões
		
		auxRoom = getRoomList(roomChoice);
		System.out.println((int)(roomChoice) - 65);
		
		for (int  i = 0; i < auxRoom.size(); i++) {
			
			Session auxSession = auxRoom.get(i);
			GregorianCalendar auxDate = auxSession.getDate();
			GregorianCalendar auxDateCopy = (GregorianCalendar) auxDate.clone();
			
			auxDateCopy.add(GregorianCalendar.MINUTE, auxSession.getMovie().getDuration());

			if (gcalCopy.compareTo(auxDate) < 0 || gcal.compareTo(auxDateCopy) > 0 ){
				
			}
			else {
				System.out.println("Data não disponível");
				return;
			}
		}
		
		try {
			Session s = new Session (m, roomChoice, gcal);
			auxRoom.add(s);
			System.out.println("Sessão cadastrada com sucesso!");
		} catch (Exception e) {
			System.out.println("Não foi possível cadastrar a sessão");
			return;
		}
		
		
	}

	@Override // atualizar sessão
	public void update() {
		delete();
		register();
	}

	@Override // visualizar calendário
	public void view() {
		// TODO Auto-generated method stub
		for (int i = 0; i < sessionList.size(); i++) {
			for (int j = 0; j < sessionList.get(i).size(); j++) {
				System.out.println(sessionList.get(i).get(j));
				System.out.println("-------------------------------------------------------------------");
			}
		}
	}
	
	// visualizar sessão
	public void view(Session s) {
		System.out.println(s);
	}
	
	// visualizar filmes em cartaz
	public static void viewMovies() {
		for (Movie m : inTheaters) {
			m.view();
			System.out.println("-------------------------------------------------------------------");
		}
	}

	@Override // remover sessão
	public void delete() {
		
		Scanner sc = new Scanner(System.in);
		
		view();
		System.out.println("Digite a sala da sessão desejada: ");
		char room = sc.nextLine().charAt(0);
		
		System.out.println("Digite o número correspondente à sessão desejada"
				+ "\n (os números começam em zero e reiniciam a partir de cada sala): ");
		int index = Integer.parseInt(sc.nextLine());
		
		ArrayList<Session> roomList = getRoomList(room);
		roomList.remove(index);
	}

	
	// Sessões
	public static ArrayList<Session> getRoomList(char room) {
		return sessionList.get((int)(room) - 65);
	}
	
	public static Session getSession(char room, int index) {
		ArrayList<Session> roomList = getRoomList(room);	
		return roomList.get(index);
	}
	
	
	// Filmes
	public static void addMovie(Movie m) {
		inTheaters.add(m);
	}
	
	public static void removeMovie(Movie m) {
		inTheaters.remove(m);
	}
	
	public static Movie getMovie(int index) {
		return inTheaters.get(index);
	}
	
	public static Movie getMovie(String name) {
		for (int i = 0; i < inTheaters.size(); i++) {
			if (name == inTheaters.get(i).getName()) {
				return inTheaters.get(i);
			}
		}
		System.out.println("Filme não encontrado!");
		return null;
	}
	
	public static int getMovieIndex(Movie m) {
		return inTheaters.indexOf(m);
	}
}
