package model;

import controller.SessionController;
import java.util.*;
import java.util.stream.Collectors;

public class Session 
    extends CinemaRoom 
    implements Entity {
	
    private Movie movie;
    private GregorianCalendar date;
    private ArrayList<Ticket> ticketList;
    private int purchasedTickets;
    private boolean registered;

    public Session(Movie movie, GregorianCalendar date, char room, boolean room3d, double ticketPrice) {
        super(room);
        this.movie = movie;
        this.date = date;
        this.ticketList = new ArrayList<Ticket>(roomSize);
        this.purchasedTickets = 0;
        this.registered = false;
    }
    
    
    public void register() {
        if (this.isSessionAvailable()) {
            SessionController.register(this);
            this.registered = true;
        }
    }

    @Override
    public void update(int option, Object e) { 
        switch (option) {
            case 0: // Update Movie
                if (this.isSessionAvailable((Movie) e)) this.setMovie((Movie) e);
                break;
            case 1: // Update Date
                if (this.isSessionAvailable((GregorianCalendar) e)) this.setDate((GregorianCalendar) e);
                break;
            case 2: // Update Room
                if (this.isSessionAvailable((char) e)) this.changeRoom((char) e);
                break;
            default:
                System.out.println("Opção inválida");
        }

        if (!this.registered) this.register();
    }
    
    @Override
    public void view() {
        System.out.println(this);
        System.out.println(this.ticketsInfo());
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
    public void delete() {
        SessionController.remove(this);
        this.registered = false;
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
    
    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public boolean isSessionAvailable() {
        ArrayList<Session> roomSessionList = SessionController.getSessionList().stream().filter(i -> this.room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
        GregorianCalendar startOfSession = this.getDate();
        int movieDuration = this.getMovie().getDuration();
        GregorianCalendar endOfSession = (GregorianCalendar) startOfSession.clone();
        endOfSession.add(GregorianCalendar.MINUTE, movieDuration);
        for (Session sessionRoom : roomSessionList) {
            GregorianCalendar startOfSessionRoom = sessionRoom.getDate();
            int movieDurationRoom = sessionRoom.getMovie().getDuration();
            GregorianCalendar endOfSessionRoom = (GregorianCalendar) startOfSessionRoom.clone();
            endOfSessionRoom.add(GregorianCalendar.MINUTE, movieDurationRoom);
            if ( !(startOfSession.compareTo(endOfSessionRoom) > 0 || endOfSession.compareTo(startOfSessionRoom) < 0) ) {
                System.out.println("Esta data não está disponível");
                return false;
            } 
        }
        return true;
    }

    public boolean isSessionAvailable(Movie movie) {
        ArrayList<Session> roomSessionList = SessionController.getSessionList().stream().filter(i -> this.room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
        GregorianCalendar startOfSession = this.getDate();
        int movieDuration = movie.getDuration();
        GregorianCalendar endOfSession = (GregorianCalendar) startOfSession.clone();
        endOfSession.add(GregorianCalendar.MINUTE, movieDuration);
        for (Session sessionRoom : roomSessionList) {
            GregorianCalendar startOfSessionRoom = sessionRoom.getDate();
            int movieDurationRoom = sessionRoom.getMovie().getDuration();
            GregorianCalendar endOfSessionRoom = (GregorianCalendar) startOfSessionRoom.clone();
            endOfSessionRoom.add(GregorianCalendar.MINUTE, movieDurationRoom);
            if ( !(startOfSession.compareTo(endOfSessionRoom) > 0 || endOfSession.compareTo(startOfSessionRoom) < 0) && !(this.equals(sessionRoom))) {
                System.out.println("Esta data não está disponível");
                return false;
            } 
        }
        return true;
    }

    public boolean isSessionAvailable(GregorianCalendar date) {
        ArrayList<Session> roomSessionList = SessionController.getSessionList().stream().filter(i -> this.room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
        GregorianCalendar startOfSession = date;
        int movieDuration = this.getMovie().getDuration();
        GregorianCalendar endOfSession = (GregorianCalendar) startOfSession.clone();
        endOfSession.add(GregorianCalendar.MINUTE, movieDuration);
        for (Session sessionRoom : roomSessionList) {
            GregorianCalendar startOfSessionRoom = sessionRoom.getDate();
            int movieDurationRoom = sessionRoom.getMovie().getDuration();
            GregorianCalendar endOfSessionRoom = (GregorianCalendar) startOfSessionRoom.clone();
            endOfSessionRoom.add(GregorianCalendar.MINUTE, movieDurationRoom);
            if ( !(startOfSession.compareTo(endOfSessionRoom) > 0 || endOfSession.compareTo(startOfSessionRoom) < 0) && !(this.equals(sessionRoom))) {
                System.out.println("Esta data não está disponível");
                return false;
            } 
        }
        return true;
    }

    public boolean isSessionAvailable(char room) {
        ArrayList<Session> roomSessionList = SessionController.getSessionList().stream().filter(i -> room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
        GregorianCalendar startOfSession = this.getDate();
        int movieDuration = this.getMovie().getDuration();
        GregorianCalendar endOfSession = (GregorianCalendar) startOfSession.clone();
        endOfSession.add(GregorianCalendar.MINUTE, movieDuration);
        for (Session sessionRoom : roomSessionList) {
            GregorianCalendar startOfSessionRoom = sessionRoom.getDate();
            int movieDurationRoom = sessionRoom.getMovie().getDuration();
            GregorianCalendar endOfSessionRoom = (GregorianCalendar) startOfSessionRoom.clone();
            endOfSessionRoom.add(GregorianCalendar.MINUTE, movieDurationRoom);
            if ( !(startOfSession.compareTo(endOfSessionRoom) > 0 || endOfSession.compareTo(startOfSessionRoom) < 0)) {
                System.out.println("Esta data não está disponível");
                return false;
            } 
        }
        return true;
    }
}