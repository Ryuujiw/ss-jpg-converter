package main;

import javax.swing.SwingUtilities;

import ui.UIMainInit;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new UIMainInit();
			}
		}); //initiates the UI. 	
	}

}
