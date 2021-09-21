package Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Session extends CinemaRoom {
	
	private GregorianCalendar date;
	private ArrayList<String> ticketIdList = new ArrayList<String>();
	private int purchasedTickets;
	private Movie movie;

	//constructor
	public Session(char room, boolean room3d, double ticketPrice, Movie movie,
				   GregorianCalendar gcal) {
		
		super(room, room3d, ticketPrice);
		
		this.date = gcal;
		this.movie = movie;
		this.purchasedTickets = 0;
	}

	//gets and sets
	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public ArrayList<String> getTicketIdList() {
		return ticketIdList;
	}

	public void setTicketIdList(ArrayList<String> ticketIdList) {
		this.ticketIdList = ticketIdList;
	}

	public int getPurchasedTickets() {
		return purchasedTickets;
	}

	public void setPurchasedTickets(int purchasedTickets) {
		this.purchasedTickets = purchasedTickets;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
