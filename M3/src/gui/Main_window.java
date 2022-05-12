package gui;

import java.awt.*;
import javax.swing.*;



public class Main_window extends JFrame {
Toolkit tk = Toolkit.getDefaultToolkit();
	public Main_window() {
		this.setLayout(new FlowLayout());
		this.setSize(tk.getScreenSize());
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.add(new Planet_status(this));
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main_window();
	} //main method
} //main class

