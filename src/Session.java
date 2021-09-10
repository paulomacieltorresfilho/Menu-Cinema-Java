import java.time.LocalTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Date;

public class Session 
	extends CinemaRoom
	implements Entity {

	private GregorianCalendar date;
	private ArrayList<String> ticketIdList = new ArrayList<String>();
	private int purchasedTickets;
	private Movie movie;
	
	public Session(Movie movie, char room, GregorianCalendar gcal) throws Exception {
		super(room);
		this.date = gcal;
		this.movie = movie;
		this.purchasedTickets = 0;
	}
	
	public String createTicketId(Seat s) {
		return String.format("%c-%s", this.getRoom(), s.getPosition());
	}
	
	public Seat indexToSeat(int id) {
		String seatPosition = this.ticketIdList.get(id).split("-")[1];
		try {
			Seat s = getSeat(seatPosition);
			return s;
		} catch (Exception e) {
			System.out.println("O ingresso não existe");
			return null;
		}
	}

	@Override // cadastrar ingresso
	public void register() {
		
		Scanner sc = new Scanner (System.in);
		
		view();
		
		System.out.println("Digite o número correspondente ao assento que deseja comprar: ");
		int option = Integer.parseInt(sc.nextLine());
		
		Seat s = this.seatList.get(option);
		
		String ticketId = createTicketId(s);
		ticketIdList.add(ticketId);
		s.changeAvailability();
		
	}
	
	@Override // atualizar ingresso
	public void update() {
		delete();
		register();
	}
	
	@Override // ver ingressos disponiveis
	public void view() {
		Seat s;
		for (int i = 0; i < this.seatList.size(); i++) {
			s = this.seatList.get(i);
			if (s.isAvailable()) {
				System.out.println(i + "- " + s.getPosition());
			}
		}
		
	}
	
	
	public void view(int index) { // ver ingresso
		
		String ticketId = this.ticketIdList.get(index);
		Seat s = indexToSeat(index);
		String position = s.getPosition();
		
		System.out.println("Assento: " + position);
		System.out.println(this);
		
		
	}
	
	@Override // cancelar ingresso
	public void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o ingresso que deseja cancelar: ");
		int option = Integer.parseInt(sc.nextLine());
		
		Seat s = indexToSeat(option);
		s.changeAvailability();
		
		this.ticketIdList.remove(option);
	}
	
	
	@Override
	public String toString() {
		String text = "";
		text += "Filme: " + this.movie.getName() + "\n";
		text += "Dia: " + this.date.get(GregorianCalendar.DATE) + "/" + this.date.get(GregorianCalendar.MONTH) + "/" + this.date.get(GregorianCalendar.YEAR) + "\n";
		text += "Horário: " + String.format("%2d:%2d", this.date.get(GregorianCalendar.HOUR_OF_DAY), this.date.get(GregorianCalendar.MINUTE)) + "\n";
		text += "Sala: " + this.getRoom() + "\n";
		text += "Ingressos disponíveis: " + (20 - this.purchasedTickets) + "\n";
		text += "Preço: " + this.ticketPrice;
		return text;
	}
	
	// Get & Set
	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
