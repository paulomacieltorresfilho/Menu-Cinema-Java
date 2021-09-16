package model;
import java.util.ArrayList;

public abstract class CinemaRoom {
    
    protected char room;
    protected boolean room3d;
    protected double ticketPrice;
    protected ArrayList<Seat> seatList = new ArrayList<Seat>(20);
    protected static int roomSize = 20;

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

    public void changeRoom(char room) {   
        switch (room) {
            case 'a', 'b':
                this.room3d = false;
                this.ticketPrice = 20.00;
                break;
            case 'c', 'd':
                this.room3d = true;
                this.ticketPrice = 30.00;
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }
        this.room = room;
    }
    
    public char getRoom() {
        return this.room;
    }
    
    public boolean is3d() {
        return this.room3d;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    } 
}
