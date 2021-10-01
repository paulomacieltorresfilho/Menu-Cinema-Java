package model;

public interface Entity {
	public void register();
	public void update(int pos, Object e);
	public void view();
	public void delete();
}
