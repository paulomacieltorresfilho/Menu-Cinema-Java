package Controller;

import java.util.ArrayList;

import Model.Snack;

public class SnackController implements Entity {
	private ArrayList<Snack> snacks = new ArrayList<Snack>();

	public  SnackController() {
		//Dados aleatorios
		for(int i=0; i < 5; i++) {
			Snack aux = new Snack("Lanche-" + i, i, i);
			checkAvailability(aux);
			this.snacks.add(aux);
		}
		//end
	}
	
	public ArrayList<Snack> getSnacks() {
		return snacks;
	}

    public void checkAvailability(Snack snack) {
    	if (snack.getStockQuantity() <= 0) {
    		snack.setAvailable(false);
    		snack.setStockQuantity(0);
    	} else {
    		snack.setAvailable(true);
    	}
    }
    
    public void sellSnack(int pos, int quantity) {
    	
        int newQuantity = snacks.get(pos).getStockQuantity() - quantity;
        if (newQuantity >= 0) {
        	snacks.get(pos).setStockQuantity(newQuantity);
        	checkAvailability(snacks.get(pos));
        }
    }
    
    
    
	@Override
	public void register(Object e) {
		snacks.add((Snack) e);		
	}

	@Override
	public void update(int option, Object e) {
		// TODO
	}
	public void update(ArrayList<Snack> snacks) {
		this.snacks = snacks;
	}

	@Override
	public String[] view() {
		String[] snacksName = new String[1000];
		for(int i = 0; i < snacks.size(); i++) {
			Snack aux;
			
			aux = snacks.get(i);
			snacksName[i] = aux.getName();
		}
		return snacksName;
		
	}
	@Override
	public void delete(int pos) {
		snacks.remove(pos);
	}
	
}
