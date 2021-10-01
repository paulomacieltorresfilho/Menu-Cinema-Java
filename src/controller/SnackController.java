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
	
	public static void register(Snack s) {
		snackList.add(s);
	}
	
	public static void remove(Snack s) {
		snackList.remove(s);
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
