package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import Controller.SnackController;
import Model.Snack;

public class SnackScreen 
extends ScreenBase
implements ActionListener, ListSelectionListener {
	
	String[] snacksName = new String[1000];
	private SnackController snackData;
	ArrayList<Snack> snacks;
	
	
	public SnackScreen(SnackController snackData) {
		super();
		this.snackData = snackData;
		snacks = snackData.getSnacks();
		snacksName = snackData.view();
		
		menu.setTitle("Lanches");
		title.setText("Lista de Lanches");
		
		list.setListData(snacksName);
		
		btAdd.addActionListener(this);
		btAtt.addActionListener(this);
		list.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting()&& src == list) {
			new SnackScreenDetails(snackData, list.getSelectedIndex());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == btAdd) {
			Snack s = new Snack(null, 0, 0);
			int pos = snacks.size();
			snacks.add(pos, s);
			snackData.update(snacks);
			
			new SnackScreenDetails(snackData, pos);
		}
		if(src == btAtt) {
			snacksName = new String[1000];
			snacksName = snackData.view();
			list.setListData(snacksName);
		}
	}
}