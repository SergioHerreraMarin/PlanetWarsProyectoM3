package gui;

import java.awt.*;
import javax.swing.*;



public class Main_window extends JFrame {
Toolkit tk = Toolkit.getDefaultToolkit();
	public Main_window() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new Planet_status(this,0));
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main_window();
	} //main method
} //main class
