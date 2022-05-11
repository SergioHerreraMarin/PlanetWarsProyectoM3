package gui;

import java.awt.*;

import javax.swing.*;

public class Planet_status extends JPanel {
	JPanel content, content_left, content_right, name_exit, resources, ships, defenses, tech_levels;
	
	public Planet_status (JFrame window){
		this.setPreferredSize(new Dimension(window.getWidth()-10, window.getHeight()-10));
		this.setLocation(window.getContentPane().getWidth()-50+this.getWidth()/2, window.getContentPane().getHeight()-50+this.getHeight()/2); //esto no va
		this.setBackground(Color.green);
		
		JLabel top_margin = new JLabel();
		top_margin.setBackground(Color.pink);
		top_margin.setPreferredSize(new Dimension(this.getWidth(),50));
		top_margin.setOpaque(true);
		top_margin.setVisible(true);
		this.add(top_margin);
		
		
		
		this.setVisible(true);
	}

}
