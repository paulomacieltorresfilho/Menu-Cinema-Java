package Model;

public class Seat {
	private String position;
	private boolean available;

	//constructor
	
	public Seat(int row, int column) {
		this.position = String.valueOf((char)column) + String.valueOf(row);
		this.available = true;
	}

	//gets and sets
	
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
