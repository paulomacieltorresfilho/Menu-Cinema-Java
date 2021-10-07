package controller;

import java.util.ArrayList;

import model.Snack;

public class SnackController{

	public static ArrayList<Snack> snackList = new ArrayList<Snack>();
	
	public static void addRandomData() {
		for (int i = 0; i < 10; i++) {
			snackList.add(new Snack(
					String.format("lanche-%d", i),
					i*i + 2.50,
					i * 50
					));	
		}
	}

	public static Snack createSnack(String name, double price, int stockQuantity) {
		return new Snack(name, price, stockQuantity);
	}

	public static String[] getSnackInfo(int id) {
		Snack s = SnackController.getSnack(id);
		String[] sInfo = {
			s.getName(),
			Double.toString(s.getPrice()),
			Integer.toString(s.getStockQuantity())
		};
		return sInfo;
	}
	
	public static void register(Snack s) {
		snackList.add(s);
	}

	public static void update(int id, Snack s) {
		snackList.remove(id);
		snackList.add(id, s);
	}
	
	public static void remove(Snack s) {
		snackList.remove(s);
	}
	
	public static void remove(int id) {
		snackList.remove(id);
	}
	
	public static ArrayList<Snack> getSnackList() {
		return snackList;
	}
	
	public static Snack getSnack(int index) {
		return snackList.get(index);
	}
	
	public static int getListSize() {
		return snackList.size();
	}
	
}
