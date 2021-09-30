package Controller;

public interface Entity {
	
	public void register(Object e);
	void update(int option, Object e);
	public String[] view();
	public void delete(int pos);
	
}
