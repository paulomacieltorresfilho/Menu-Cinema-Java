package Model;

import java.util.ArrayList;

public abstract class CinemaRoom {
	protected char room;
	protected boolean room3D;
	protected double ticketPrice;
	protected ArrayList<Seat> seatList = new ArrayList<Seat>(20);
	
	
	private static int roomSize = 20;
	
	//constructor
	public CinemaRoom(char room, boolean room3D, double ticketPrice) {
		this.room = room;
		this.room3D = room3D;
		this.ticketPrice = ticketPrice;
		
		int column;
		Seat s;
		for (int j = 0; j < roomSize/5; j++) {
			for (int i = 0; i < roomSize/4; i++) {
				column = j + 65;
				s = new Seat(i, column);		
				this.seatList.add(s);			
			}
		}
	}
	
	//gets and sets
	public char getRoom() {
		return room;
	}

	public void setRoom(char room) {
		this.room = room;
	}

	public boolean isRoom3D() {
		return room3D;
	}

	public void setRoom3D(boolean room3d) {
		room3D = room3d;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public ArrayList<Seat> getSeatList() {
		return seatList;
	}

	public void setSeatList(ArrayList<Seat> seatList) {
		this.seatList = seatList;
	}
	
}
