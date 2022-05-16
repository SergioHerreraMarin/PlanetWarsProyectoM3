package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Planet_status extends JPanel {
	
	public Planet_status (Main_window window){
		System.out.println(window);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(Color.red);
		this.setSize(window.getWidth(),window.getHeight());
		this.setPreferredSize(this.getSize());
		this.setBorder(new EmptyBorder(10,10,10,10));
		this.setVisible(true);
		
		JPanel left = new JPanel();
		left.setSize((this.getWidth()/2)-23,this.getHeight());
		left.setPreferredSize(left.getSize());
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		left.setBorder(new EmptyBorder(10,10,10,10));
		left.setBackground(Color.green);
		this.add(left);
		
		JPanel right = new JPanel();
		right.setSize((this.getWidth()/2)-23,this.getHeight());
		right.setPreferredSize(right.getSize());
		right.setLayout(new FlowLayout(FlowLayout.LEFT));
		right.setBackground(Color.pink);
		this.add(right);
		
		JLabel planetName = new JLabel("Planet name");
		planetName.setBorder(new LineBorder(Color.white));
		planetName.setFont(new Font("Arial", 1, 60));
		planetName.setForeground(Color.white);
		left.add(planetName);
		
		JPanel resourcesTable = new JPanel();
		resourcesTable.setSize(left.getWidth()-60, 200);
		resourcesTable.setPreferredSize(resourcesTable.getSize());
		resourcesTable.setBackground(Color.blue);
		left.add(resourcesTable);
		
		JLabel resourcesTitle = new JLabel(" Resources");
		resourcesTitle.setSize(resourcesTable.getWidth(),30);
		resourcesTitle.setPreferredSize(resourcesTitle.getSize());
		resourcesTitle.setBackground(Color.orange);
		resourcesTitle.setOpaque(true);
		resourcesTable.add(resourcesTitle);
		
		//###
		JPanel resourcesContents = new JPanel();
		resourcesContents.setSize(resourcesTable.getWidth(),35*3);
		resourcesContents.setPreferredSize(resourcesContents.getSize());
		
		resourcesContents.add(new ResourceRow(resourcesContents,"Deuterium"));
		
		resourcesContents.add(new ResourceRow(resourcesContents,"Metal"));
		
		resourcesContents.add(new ResourceRow(resourcesContents,"Crystal"));
		
		resourcesTable.add(resourcesContents);
		
		resourcesTable.setSize(left.getWidth(), resourcesContents.getHeight()+resourcesTitle.getHeight());
		resourcesTable.setPreferredSize(resourcesTable.getSize());
		
		this.setVisible(true);
	}

}//clase principal

class ResourceRow extends JPanel{
	public ResourceRow(JPanel resourcesTable, String resource_name) {
		this.setSize(resourcesTable.getWidth(), 25);
		this.setPreferredSize(this.getSize());
		this.setBackground(Color.magenta);
		
		JLabel resourceName = new JLabel(resource_name);
		resourceName.setSize(this.getWidth()-60, 25);
		resourceName.setPreferredSize(resourceName.getSize());
		resourceName.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(resourceName);
		
		JLabel resourceQuantity = new JLabel("0000");
		resourceQuantity.setSize(50, 25);
		resourceQuantity.setPreferredSize(resourceQuantity.getSize());
		resourceQuantity.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(resourceQuantity);

		this.setVisible(true);
	}
}
