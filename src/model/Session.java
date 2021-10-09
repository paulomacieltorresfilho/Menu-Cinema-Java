package model;

import java.util.*;

public class Session extends CinemaRoom {
	
    private Movie movie;
    private GregorianCalendar date;
    
    public Session(Movie movie, GregorianCalendar date, String room) {
    	
        super(room); 
        this.movie = movie;
        this.date = date;
    }
  
    public String[] getSeatIdList(boolean available) {
    	ArrayList<String> sArr = new ArrayList<String>();
    	for (Seat seat: seatList) {
    		if (seat.isAvailable()) {
    			sArr.add(seat.getPosition());
    		}
    	}
    	String[] s = new String[sArr.size()];
    	for (int i = 0; i < sArr.size(); i++) {
    		s[i] = sArr.get(i);
    	}
    	return s;
    }
    
    public void changeSeatAvailability(String position) {
    	for (Seat s : getSeatList()) {
    		if (s.getPosition().equals(position)) {
    			s.changeAvailability();
    		}
    	}
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