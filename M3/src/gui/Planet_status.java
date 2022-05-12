package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Planet_status extends JPanel {
	JPanel content, content_left, content_right, name_exit, resources, ships, defenses, tech_levels;
	
	public Planet_status (JFrame window){
		this.setPreferredSize(new Dimension(window.getWidth(),window.getHeight()));
		this.setBackground(Color.gray);
		this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		
		JLabel test = new JLabel("ASDFGHJKL");
		test.setBackground(Color.pink);
		test.setOpaque(true);
		test.setPreferredSize(new Dimension(100,50));
		test.setVisible(true);
		this.add(test, FlowLayout.LEFT);
		
		this.setVisible(true);
	}

}
