package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

import model.*;

public class SessionController{
	
	private static ArrayList<Session> sessionList = new ArrayList<Session>();
	private static String[] availableRooms = {"a", "b", "c", "d"};
	
	
	public static void addRandomData() {
		// Adicionar dados aleatorios
		for (int i = 10; i > 0; i--) {
			sessionList.add(new Session(
					MovieController.getMovie(i-1),
                    new GregorianCalendar(2021, i, i + 2, i + 10, 0),
                    "a"
					));
		}
	} 
	
	public static Session createSession(String movieName, String room, String date, String time) {
		
		Movie m = MovieController.getMovie(movieName);
		
		String[] dateSplit = date.split("/");
		int day = Integer.parseInt(dateSplit[0]);
		int month = Integer.parseInt(dateSplit[1]);
		int year = Integer.parseInt(dateSplit[2]);

		String[] timeSplit = time.split(":");
		int hour = Integer.parseInt(timeSplit[0]);
		int minute = Integer.parseInt(timeSplit[1]);
		
		GregorianCalendar gc = new GregorianCalendar(year, month, day, hour, minute);
		return new Session(m, gc, room);
	}

	public static String[] getSessionInfo(int i) {
		Session s = SessionController.getSession(i);
		GregorianCalendar gc = s.getDate();
		String[] sInfo = {
			s.getMovie().getName(),
			Character.toString(s.getRoom()).toUpperCase(),
			String.format(
				"%02d/%02d/%d",
				gc.get(GregorianCalendar.DATE),
				gc.get(GregorianCalendar.MONTH),
				gc.get(GregorianCalendar.YEAR)
				),
			String.format(
				"%02d:%02d",
				gc.get(GregorianCalendar.HOUR_OF_DAY),
				gc.get(GregorianCalendar.MINUTE)
			)
		};
		return sInfo;
	}
	
	public static void register(Session s) throws Exception {
		if (isSessionAvailable(s)) sessionList.add(s);
//        else throw new Exception();
	}
	
	public static void update(int id, Session s) throws Exception {
		sessionList.remove(id);
		if (isSessionAvailable(s)) sessionList.add(s);
//        else throw new Exception();
	}
	
	public static void remove(Session s) {
		sessionList.remove(s);
	}
	
	public static void remove(int id) {
		sessionList.remove(id);
	}


	public static void removeAll(Movie m) {
		Session s;
		for (int i = 0; i < SessionController.getListSize(); i++) {
			s = SessionController.getSession(i);
			if (s.getMovie().getName().equals(m.getName())) {
				sessionList.remove(i);
			}
		}
	}
	
	public static Object[][] getSessionObjList() {
		Object[][] sessionObjList = new Object[SessionController.getListSize()][];
		String[] sessionInfo;
		
		for (int i = 0; i < SessionController.getListSize(); i++) {
			sessionInfo = SessionController.getSessionInfo(i);
			Object[] aux = {
				i, 
				sessionInfo[0],
				sessionInfo[1],
				sessionInfo[2],
				sessionInfo[3]
			};
			sessionObjList[i] = aux;
		}
		return sessionObjList;
	}
	
	public static Object[][] getSessionObjList(String movieName) {
		Object[][] sessionObjList = new Object[SessionController.getListSize()][];
		String[] sessionInfo;
		
		for (int i = 0; i < SessionController.getListSize(); i++) {
			sessionInfo = SessionController.getSessionInfo(i);
			if (sessionInfo[0].equals(movieName)) {
				Object[] aux = {
						i, 
						sessionInfo[0],
						sessionInfo[1],
						sessionInfo[2],
						sessionInfo[3]
				};
				sessionObjList[i] = aux;
				
			}
		}
		return sessionObjList;
	}
	
	public static ArrayList<Session> getSessionList() {
		return sessionList;
	}
	
	public static String[] getMovieList() {
		ArrayList<String> movies = new ArrayList<String>();
		for (Session s : sessionList) {
			if (!movies.contains(s.getMovie().getName())) {
				movies.add(s.getMovie().getName());
			}
		}
		Object[] ob = movies.toArray();
		String[] movieObjList = Arrays.copyOf(ob, ob.length, String[].class);
		return movieObjList;
	}
	
	public static Session getSession(int index) {
		return sessionList.get(index);
	}
	
	public static String[] getRooms() {
		return availableRooms;
	}
	
	public static int getListSize() {
		return sessionList.size();
	}

	public static boolean isSessionAvailable(Session s) {
        ArrayList<Session> roomSessionList = SessionController.getSessionList().stream().filter(i -> s.getRoom() == i.getRoom()).collect(Collectors.toCollection(ArrayList<Session>::new));
        GregorianCalendar startOfSession = s.getDate();
        int movieDuration = s.getMovie().getDuration();
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
}
