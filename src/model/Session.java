package model;

import java.util.*;

public class Session extends CinemaRoom {
	
    private Movie movie;
    private GregorianCalendar date;
    private ArrayList<Ticket> ticketList;
    private int purchasedTickets;

    public Session(Movie movie, GregorianCalendar date, String room) {
    	
        super(room.charAt(0)); 
        this.movie = movie;
        this.date = date;
        this.ticketList = new ArrayList<Ticket>(roomSize);
        this.purchasedTickets = 0;
    }
    
    
    public void viewSeats() {
        for (Seat s : seatList) {
            System.out.println(s.getPosition()); 
        }
    }

    public void viewSeats(boolean available) {
        for (Seat s : seatList) {
            if (s.isAvailable() == available) {
                System.out.println(s.getPosition());
            }
        }
    }

    @Override 
    public String toString() {
        String text = "";
        text += String.format("Filme: %s", this.movie.getName());
        text += String.format("Data: %d/%d/%d \n", this.date.get(GregorianCalendar.DATE), this.date.get(GregorianCalendar.MONTH), this.date.get(GregorianCalendar.YEAR));
        text += String.format("Horário: %2d:%2d \n", this.date.get(GregorianCalendar.HOUR_OF_DAY), this.date.get(GregorianCalendar.MINUTE));
        text += String.format("Sala: %c", this.room);
        return text;
    }
    
    public String ticketsInfo() {
    	String text = "";
    	text += String.format("Preço do ingresso: %d \n", this.ticketPrice);
        text += String.format("Ingressos disponíveis: %d", roomSize - this.purchasedTickets);
        return text;
    }
    
    public void addTicket(Ticket t) {
    	if (!this.ticketList.contains(t)) {
	    	this.ticketList.add(t);
	    	this.purchasedTickets = this.ticketList.size();
    	}
    }
    
    public void removeTicket(Ticket t) {
    	this.ticketList.remove(t);
    	this.purchasedTickets = this.ticketList.size();
    }
    
    public Ticket getTicket(String id) {
    	for (Ticket t : this.ticketList) {
    		if (t.getId().equals(id)) return t;
    	}
    	return null;
    }
    
    public Ticket getTicket(int index) {
    	return this.ticketList.get(index);
    }
    
    
    public Movie getMovie() {
        return movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public GregorianCalendar getDate() {
        return date;
    }
    

}