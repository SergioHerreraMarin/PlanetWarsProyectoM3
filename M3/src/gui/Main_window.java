package gui;

import java.awt.*;
import javax.swing.*;



public class Main_window extends JFrame {
Toolkit tk = Toolkit.getDefaultToolkit();
	public Main_window() {
		this.setLayout(new FlowLayout());
		this.setSize(tk.getScreenSize());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main_window MainWindow = new Main_window();
		MainWindow.add(new Planet_status(MainWindow));
	} //main method
} //main class

