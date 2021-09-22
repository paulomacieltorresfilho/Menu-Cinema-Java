package Model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

public class Session extends CinemaRoom {
	
	public static ArrayList<Session> sessionList = new ArrayList<Session>();
	
    private Movie movie;
    private GregorianCalendar date;
    private ArrayList<Ticket> ticketList;
    private int purchasedTickets;
    private boolean registered;

    public Session(Movie movie, GregorianCalendar date, char room) {
        super(room);
        this.movie = movie;
        this.date = date;
        this.ticketList = new ArrayList<Ticket>(roomSize);
        this.purchasedTickets = 0;
        this.registered = false;
    }
    //mover funcoes para controller
    	//busca
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
    public static Session getSession(int index) {
    	return sessionList.get(index);
    }
    
    public static Session getSession(GregorianCalendar date) {
    	for (Session s : sessionList) {
    		if (s.getDate().equals(date)) return s;
    	}
    	System.out.println("Essa data n�o possui nenhuma sess�o cadastrada");
    	return null;
    }
       //outros
    public String ticketsInfo() {
    	String text = "";
    	text += String.format("Pre�o do ingresso: %d \n", this.ticketPrice);
        text += String.format("Ingressos dispon�veis: %d", roomSize - this.purchasedTickets);
        return text;
    }
    public boolean isSessionAvailable() {
        ArrayList<Session> roomSessionList = sessionList.stream().filter(i -> this.room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
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
                System.out.println("Esta data n�o est� dispon�vel");
                return false;
            } 
        }
        return true;
    }

    public boolean isSessionAvailable(Movie movie) {
        ArrayList<Session> roomSessionList = sessionList.stream().filter(i -> this.room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
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
                System.out.println("Esta data n�o est� dispon�vel");
                return false;
            } 
        }
        return true;
    }

    public boolean isSessionAvailable(GregorianCalendar date) {
        ArrayList<Session> roomSessionList = sessionList.stream().filter(i -> this.room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
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
                System.out.println("Esta data n�o est� dispon�vel");
                return false;
            } 
        }
        return true;
    }

    public boolean isSessionAvailable(char room) {
        ArrayList<Session> roomSessionList = sessionList.stream().filter(i -> room == i.room).collect(Collectors.toCollection(ArrayList<Session>::new));
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
                System.out.println("Esta data n�o est� dispon�vel");
                return false;
            } 
        }
        return true;
    }
    
    //gets and sets
	public static ArrayList<Session> getSessionList() {
		return sessionList;
	}

	public static void setSessionList(ArrayList<Session> sessionList) {
		Session.sessionList = sessionList;
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

	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public int getPurchasedTickets() {
		return purchasedTickets;
	}

	public void setPurchasedTickets(int purchasedTickets) {
		this.purchasedTickets = purchasedTickets;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	//gets and sets



	
}
