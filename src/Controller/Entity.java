package Controller;

public interface Entity {
	public void register(Object e);
	void update(int pos, Object e);
	public String[] view();
	public void delete(int pos);
}
