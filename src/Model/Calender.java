package Model;

import java.util.ArrayList;

public class Calender {
	private static ArrayList<ArrayList<Session>> sessionList = new ArrayList<ArrayList<Session>>();
	private static ArrayList<Movie> inTheaters = new ArrayList<Movie>();
	
	//constructor
	public void Calendar() {
		ArrayList<Session> a = new ArrayList<Session>();
		ArrayList<Session> b = new ArrayList<Session>();
		ArrayList<Session> c = new ArrayList<Session>();
		ArrayList<Session> d = new ArrayList<Session>();
		
		sessionList.add(a);
		sessionList.add(b);
		sessionList.add(c);
		sessionList.add(d);
   }
	
	//gets and sets
	public ArrayList<ArrayList<Session>> getSessionList() {
		return sessionList;
	}
	public void setSessionList(ArrayList<ArrayList<Session>> sessionList) {
		Calender.sessionList = sessionList;
	}
	public ArrayList<Movie> getInTheaters() {
		return inTheaters;
	}
	public void setInTheaters(ArrayList<Movie> inTheaters) {
		Calender.inTheaters = inTheaters;
	}
}