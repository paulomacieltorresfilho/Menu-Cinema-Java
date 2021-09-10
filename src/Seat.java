
public class Seat {
	
	private String position;
	private boolean available;
	
	public Seat(int row, int column) {
		this.position = String.valueOf((char)column) + String.valueOf(row);
		this.available = true;
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

	public void changeAvailability() {
		this.available = !this.available;
	}
	
}
