package Model;

import java.util.ArrayList;

public abstract class CinemaRoom {
	protected static int roomSize = 20;
	protected char room;
	protected boolean room3D;
	protected double ticketPrice;
	protected ArrayList<Seat> seatList = new ArrayList<Seat>(20);
	
	//constructor
	public CinemaRoom(char room) {
        Seat s;
        int column;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                column = i + 65;
                s = new Seat(j, column);
                seatList.add(s);
            }
        }

        changeRoom(room);
    }
	//talvez colocar em controller
	public void changeRoom(char room) {   
	       switch (room) {
	           case 'a', 'b':
	               this.room3D = false;
	               this.ticketPrice = 20.00;
	               break;
	           case 'c', 'd':
	               this.room3D = true;
	               this.ticketPrice = 30.00;
	               break;
	           default:
	               System.out.println("Op��o inv�lida");
	               return;
	       }
	       this.room = room;
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
