package model;

public class Ticket implements Entity{
	
	private String id;
	private Session session;
	private Seat seat;

	public Ticket(Session session, Seat seat, String id) {
		this.session = session;
		this.seat = seat;
		this.createId();
	}

	@Override
	public void register() {
		session.addTicket(this);
	}
	
	@Override
	public void update(int option, Object e) {
		for (Seat s : session.getSeatList()) {
			if (s.getPosition().equals((String) e)) {
				this.seat.changeAvailability();
				s.changeAvailability();
				this.seat = s;
				this.createId();
			}
		}
	}
	
	@Override
	public void view() {
		System.out.println(String.format("Id: %s", this.id));
		System.out.println(this.session);
	}
	
	@Override
	public void delete() {
		session.removeTicket(this);
	}

	public void createId() {
		this.id = String.format("%c-%s", session.getRoom(), seat.getPosition());
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}