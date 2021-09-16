package model;

public interface Entity {
    public void register();
    public void update(int option, Object e);
    public void view();
    public void delete();
}
