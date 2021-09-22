package Model;

public class Ticket {
	private String id;
	private Session session;
	private Seat seat;

	public Ticket(Session session, Seat seat, String id) {
		this.session = session;
		this.seat = seat;
		this.createId();
	}
	//colocar no controller
	public void createId() {
		this.setId(String.format("%c-%s", session.getRoom(), seat.getPosition()));
	}

	//gets and sets
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
