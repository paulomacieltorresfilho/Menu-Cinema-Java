package model;

import java.util.*;


public class Calendar {
    
    public static ArrayList<Session> sessionList = new ArrayList<Session>();
    
    public static void addSession(Session s) {
        sessionList.add(s);
        System.out.println("Sessão cadastrada com sucesso!");
    }
    
    public static void removeSession(Session s) {
        sessionList.remove(s);
    }
    
    public static Session getSession(int index) {
        return sessionList.get(index);
    }
    
    public static Session getSession(GregorianCalendar date) {
        for (Session s : sessionList) {
            if (s.getDate().equals(date)) return s;
        }
        System.out.println("Essa data não possui nenhuma sessão cadastrada");
        return null;
    }
}
