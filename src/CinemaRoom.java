import java.util.ArrayList;

public abstract class CinemaRoom {

	protected char room;
	protected boolean room3D;
	protected double ticketPrice;
	protected ArrayList<Seat> seatList = new ArrayList<Seat>(20);
	
	private static int roomSize = 20;
	
	public CinemaRoom(char room) throws Exception {
		int column;
		Seat s;
		
		for (int j = 0; j < roomSize/5; j++) {
			for (int i = 0; i < roomSize/4; i++) {
				column = j + 65;
				s = new Seat(i, column);		
				seatList.add(s);			
			}
		}
		
		changeRoom(Character.toUpperCase(room));
	}
	
	public static void showRooms() {
		System.out.println("SALA A");
		System.out.println("Formato de exibição: 2D");
		System.out.println("Preço: R$15.00");
		System.out.println("-------------------------------");
		System.out.println("SALA B");
		System.out.println("Formato de exibição: 2D");
		System.out.println("Preço: R$15.00");
		System.out.println("-------------------------------");
		System.out.println("SALA C");
		System.out.println("Formato de exibição: 3D");
		System.out.println("Preço: R$20.00");
		System.out.println("-------------------------------");
		System.out.println("SALA D");
		System.out.println("Formato de exibição: 3D");
		System.out.println("Preço: R$20.00");
	}

	public void changeRoom(char room) throws Exception {
		Character.toUpperCase(room);
		
		switch (room) {
		case 'A': 
			this.room3D = false;
			this.ticketPrice = 15;
			break;
		case 'B':
			this.room3D = false;
			this.ticketPrice = 15;
			break;
		case 'C':
			this.room3D = true;
			this.ticketPrice = 20;
			break;
		case 'D':
			this.room3D = true;
			this.ticketPrice = 20;
			break;
		default:
			System.out.println("Essa sala não existe!");
			throw new Exception();
		}
		this.room = room;
	}
	
	
	public char getRoom() {
		return room;
	}
	public Seat getSeat(int index) {
		return seatList.get(index);
	}
	
	public Seat getSeat(String position) throws Exception {
		for (int i = 0; i < roomSize; i++) {
			if (position == seatList.get(i).getPosition()) {
				return seatList.get(i);
			}
		}
		System.out.println("Assento não encontrado!");
		throw new Exception();
	}

	public boolean isRoom3D() {
		return room3D;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}
	
}

