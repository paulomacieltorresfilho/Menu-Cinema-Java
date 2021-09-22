package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import Controller.SnackController;
import Model.Snack;

public class SnackScreen 
extends ScreenBase
implements ActionListener, ListSelectionListener {
	private JButton btBuy = new JButton("comprar");
	
	String[] snacksName = new String[1000];
	private static SnackController snackData;
	ArrayList<Snack> snacks;
	
	
	public SnackScreen(SnackController snackData) {
		super();
		SnackScreen.snackData = snackData;
		snacks = snackData.getSnacks();
		snacksName = snackData.view();
		
		menu.setTitle("Lanches");
		title.setText("Lista de Lanches");
		
		list.setListData(snacksName);
		
		btAdd.setBounds(30,177,100,30);
		btBuy.setBounds(140,177,100,30);
		btAtt.setBounds(250,177,100,30);
		menu.add(btBuy);
		
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