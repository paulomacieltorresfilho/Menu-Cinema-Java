package model;

public class Seat {
    
    private String position;
    private boolean available;

    public Seat(int row, int column) {
        this.position = String.format("%c%d", (char) column, row);
        this.available = true;
    }

    public void changeAvailability() {
        this.available = !this.available;
    }
    
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
