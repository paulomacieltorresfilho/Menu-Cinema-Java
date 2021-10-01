package controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import model.*;

public class SessionController{
	
	public static ArrayList<Session> sessionList = new ArrayList<Session>();
	
	public static void addRandomData() {
		// Adicionar dados aleatorios
		for (int i = 10; i > 0; i--) {
			sessionList.add(new Session(
					MovieController.getMovie(i-1),
                    new GregorianCalendar(2021, i, i + 2, i + 10, 0),
                    'a',
                    false,
                    5
					));
		}
	}
	
	
	public static void register(Session s) {
		sessionList.add(s);
	}
	
	public static void remove(Session s) {
		sessionList.remove(s);
	}
	
	public static ArrayList<Session> getSessionList() {
		return sessionList;
	}
	
	public static Session getSession(int index) {
		return sessionList.get(index);
	}
	
	public static int getListSize() {
		return sessionList.size();
	}

}
