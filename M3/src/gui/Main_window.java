package gui;

import java.awt.*;
import javax.swing.*;


public class Main_window extends JFrame {
	
	Toolkit tk = Toolkit.getDefaultToolkit();
	public Main_window() {
		this.setSize(tk.getScreenSize());
<<<<<<< HEAD
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//AÑADIR PANALES: 
		
		this.add(new Planet_status(this,0));
		//this.add(new IG());
		
		
=======
		this.setExtendedState(MAXIMIZED_BOTH);
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
>>>>>>> parent of 4437178 (base de dades nueva versió)
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
<<<<<<< HEAD
		//new Main_window();
=======
		Main_window MainWindow = new Main_window();
		MainWindow.add(new Planet_status(MainWindow));
>>>>>>> parent of 4437178 (base de dades nueva versió)
	} //main method
} //main class
