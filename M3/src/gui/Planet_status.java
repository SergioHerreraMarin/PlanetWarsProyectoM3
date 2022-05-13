package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Planet_status extends JPanel {
	
	public Planet_status (Main_window window){
		System.out.println(window);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(new Color((float)0.53, (float)0.0, (float)0.0, (float)0.0));
		this.setSize(window.getWidth(),window.getHeight());
		this.setPreferredSize(this.getSize());
		this.setBorder(new EmptyBorder(10,10,10,10));
		this.setVisible(true);
		
		JPanel left = new JPanel();
		left.setSize((this.getWidth()/2)-23,this.getHeight());
		left.setPreferredSize(left.getSize());
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		left.setBorder(new EmptyBorder(10,10,10,10));
		left.setBackground(new Color((float)0.0, (float)0.0, (float)0.0, (float)0.0));
		this.add(left);
		
		JPanel right = new JPanel();
		right.setSize((this.getWidth()/2)-23,this.getHeight());
		right.setPreferredSize(right.getSize());
		right.setLayout(new FlowLayout(FlowLayout.LEFT));
		right.setBackground(new Color((float)0.0, (float)0.0, (float)0.0, (float)0.0));
		this.add(right);
		
		JLabel planetName = new JLabel("PLANET NAME");
		planetName.setSize(left.getWidth()-20,60);
		planetName.setPreferredSize(planetName.getSize());
		planetName.setBorder(new LineBorder(Color.white));
		planetName.setFont(new Font("Arial", 1, 60));
		planetName.setForeground(Color.white);
		left.add(planetName);
		
		left.add(new ResourcesTable(left));
		
		right.add(new ShipTable(right));
		right.add(new DefenseTable(right));
		right.add(new TechLevelsTable(right));
		
		this.setVisible(true);
	}

}//clase principal



class ResourcesTable extends JPanel{
	public ResourcesTable(JPanel container) {
		this.setSize(container.getWidth()-20, 200);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		this.setBackground(new Color((float)0.0, (float)0.0, (float)0.0, (float)0.0));
		container.add(this);
		
		JLabel resourcesTitle = new JLabel(" Resources");
		resourcesTitle.setSize(this.getWidth()-25,20);
		resourcesTitle.setPreferredSize(resourcesTitle.getSize());
		resourcesTitle.setForeground(Color.white);
		this.add(resourcesTitle);
		
		//###
		JPanel resourcesContents = new JPanel();
		resourcesContents.setBackground(Color.black);
		resourcesContents.setSize(this.getWidth()-25,35*3+25);
		resourcesContents.setPreferredSize(resourcesContents.getSize());
		
		resourcesContents.add(new ResourceRow(resourcesContents,"Deuterium"));
		
		resourcesContents.add(new ResourceRow(resourcesContents,"Metal"));
		
		resourcesContents.add(new ResourceRow(resourcesContents,"Crystal"));
		
		this.add(resourcesContents);
		//###
		
		this.setSize(container.getWidth()-20, resourcesContents.getHeight()+resourcesTitle.getHeight());
		this.setPreferredSize(this.getSize());
	}
}//ResourceTable

class ResourceRow extends JPanel{
	public ResourceRow(JPanel resourcesTable, String resource_name) {
		this.setSize(resourcesTable.getWidth(), 25);
		this.setPreferredSize(this.getSize());
		this.setBackground(new Color((float)0.0, (float)0.0, (float)0.0, (float)0.0));
		
		JLabel resourceName = new JLabel(resource_name);
		resourceName.setSize(this.getWidth()-60, 20);
		resourceName.setPreferredSize(resourceName.getSize());
		resourceName.setForeground(Color.white);
		resourceName.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(resourceName);
		
		JLabel resourceQuantity = new JLabel("0000");
		resourceQuantity.setSize(50, 20);
		resourceQuantity.setPreferredSize(resourceQuantity.getSize());
		resourceQuantity.setForeground(Color.white);
		resourceQuantity.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(resourceQuantity);

		this.setVisible(true);
	}
}//ResourceRow



class ShipTable extends JPanel{
	public ShipTable(JPanel container) {
		this.setSize(container.getWidth()-20, 200);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		this.setBackground(Color.black);
		
		JLabel title = new JLabel("SHIPS",SwingConstants.CENTER);
		title.setSize(this.getWidth(),20);
		title.setPreferredSize(title.getSize());
		title.setForeground(Color.white);
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(title);
		
		JPanel rowTitles = new JPanel();
		rowTitles.setSize(this.getWidth(), 30);
		rowTitles.setPreferredSize(rowTitles.getSize());
		rowTitles.setAlignmentX(LEFT_ALIGNMENT);
		
		JLabel shipName = new JLabel("Type",SwingConstants.CENTER);
		shipName.setSize(rowTitles.getWidth()/10*6-25,20);
		shipName.setPreferredSize(shipName.getSize());
		shipName.setForeground(Color.white);
		shipName.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipName);
		
		JLabel shipQuantity = new JLabel("Quantity",SwingConstants.CENTER);
		shipQuantity.setSize(rowTitles.getWidth()/10*4-25,20);
		shipQuantity.setPreferredSize(shipQuantity.getSize());
		shipQuantity.setForeground(Color.white);
		shipQuantity.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipQuantity);
		
		JLabel shipAdd = new JLabel("Add",SwingConstants.CENTER);
		shipAdd.setSize(rowTitles.getWidth()/10*1-25,20);
		shipAdd.setPreferredSize(shipAdd.getSize());
		shipAdd.setForeground(Color.white);
		shipAdd.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipAdd);
		
		this.add(rowTitles);
		
		this.add(new ShipRow(this));
		this.add(new ShipRow(this));
		this.add(new ShipRow(this));
		this.add(new ShipRow(this));
		
		this.setSize(container.getWidth()-20,35 + title.getHeight() + rowTitles.getHeight()+30*4);
		this.setPreferredSize(this.getSize());
	}
}//class shipTable
class ShipRow extends JPanel{
	public ShipRow(JPanel container) {
		this.setSize(container.getWidth(),30);
		this.setPreferredSize(this.getSize());
		this.setBorder(new LineBorder(Color.white));
		this.setBackground(Color.cyan);
		
		JLabel shipName = new JLabel("Type",SwingConstants.CENTER);
		shipName.setSize(this.getWidth()/10*6-25,20);
		shipName.setPreferredSize(shipName.getSize());
		shipName.setForeground(Color.white);
		shipName.setBorder(new LineBorder(Color.white));
		this.add(shipName);
		
		JLabel shipQuantity = new JLabel("Quantity",SwingConstants.CENTER);
		shipQuantity.setSize(this.getWidth()/10*4-25,20);
		shipQuantity.setPreferredSize(shipQuantity.getSize());
		shipQuantity.setForeground(Color.white);
		shipQuantity.setBorder(new LineBorder(Color.white));
		this.add(shipQuantity);
		
		JButton shipAdd = new JButton(" + ");
		shipAdd.setSize(this.getWidth()/10*1-25,20);
		shipAdd.setPreferredSize(shipAdd.getSize());
		shipAdd.setForeground(Color.white);
		shipAdd.setBorder(new LineBorder(Color.white));
		this.add(shipAdd);
	}
}// class ShipRow



class DefenseTable extends JPanel{
	public DefenseTable(JPanel container) {
		this.setSize(container.getWidth()-20, 200);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		this.setBackground(Color.black);
		
		JLabel title = new JLabel("DEFENSES",SwingConstants.CENTER);
		title.setSize(this.getWidth(),20);
		title.setPreferredSize(title.getSize());
		title.setForeground(Color.white);
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(title);
		
		JPanel rowTitles = new JPanel();
		rowTitles.setSize(this.getWidth(), 30);
		rowTitles.setPreferredSize(rowTitles.getSize());
		rowTitles.setAlignmentX(LEFT_ALIGNMENT);
		
		JLabel shipName = new JLabel("Type",SwingConstants.CENTER);
		shipName.setSize(rowTitles.getWidth()/10*6-25,20);
		shipName.setPreferredSize(shipName.getSize());
		shipName.setForeground(Color.white);
		shipName.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipName);
		
		JLabel shipQuantity = new JLabel("Quantity",SwingConstants.CENTER);
		shipQuantity.setSize(rowTitles.getWidth()/10*4-25,20);
		shipQuantity.setPreferredSize(shipQuantity.getSize());
		shipQuantity.setForeground(Color.white);
		shipQuantity.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipQuantity);
		
		JLabel shipAdd = new JLabel("Add",SwingConstants.CENTER);
		shipAdd.setSize(rowTitles.getWidth()/10*1-25,20);
		shipAdd.setPreferredSize(shipAdd.getSize());
		shipAdd.setForeground(Color.white);
		shipAdd.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipAdd);
		
		this.add(rowTitles);
		
		this.add(new DefenseRow(this));
		this.add(new DefenseRow(this));
		this.add(new DefenseRow(this));
		this.add(new DefenseRow(this));
		
		this.setSize(container.getWidth()-20,35 + title.getHeight() + rowTitles.getHeight()+30*4);
		this.setPreferredSize(this.getSize());
	}
}//class defenseTable
class DefenseRow extends JPanel{
	public DefenseRow(JPanel container) {
		this.setSize(container.getWidth(),30);
		this.setPreferredSize(this.getSize());
		this.setBorder(new LineBorder(Color.white));
		this.setBackground(Color.cyan);
		
		JLabel shipName = new JLabel("Type",SwingConstants.CENTER);
		shipName.setSize(this.getWidth()/10*6-25,20);
		shipName.setPreferredSize(shipName.getSize());
		shipName.setForeground(Color.white);
		shipName.setBorder(new LineBorder(Color.white));
		this.add(shipName);
		
		JLabel shipQuantity = new JLabel("Quantity",SwingConstants.CENTER);
		shipQuantity.setSize(this.getWidth()/10*4-25,20);
		shipQuantity.setPreferredSize(shipQuantity.getSize());
		shipQuantity.setForeground(Color.white);
		shipQuantity.setBorder(new LineBorder(Color.white));
		this.add(shipQuantity);
		
		JButton shipAdd = new JButton(" + ");
		shipAdd.setSize(this.getWidth()/10*1-25,20);
		shipAdd.setPreferredSize(shipAdd.getSize());
		shipAdd.setForeground(Color.white);
		shipAdd.setBorder(new LineBorder(Color.white));
		this.add(shipAdd);
	}
}// class DefenseRow



class TechLevelsTable extends JPanel{
	public TechLevelsTable(JPanel container) {
		this.setSize(container.getWidth()-20, 200);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.green, 2, true));
		this.setBackground(Color.blue);
		container.add(this);
		
		JLabel resourcesTitle = new JLabel(" TECHNOLOGIES ",SwingConstants.CENTER);
		resourcesTitle.setSize(this.getWidth(),20);
		resourcesTitle.setPreferredSize(resourcesTitle.getSize());
		resourcesTitle.setForeground(Color.white);
		resourcesTitle.setBackground(Color.orange);
		resourcesTitle.setOpaque(true);
		this.add(resourcesTitle);
		
		//###
		JPanel resourcesContents = new JPanel();
		resourcesContents.setBackground(Color.black);
		resourcesContents.setSize(this.getWidth(),35*3);
		resourcesContents.setPreferredSize(resourcesContents.getSize());
		
		resourcesContents.add(new TechLevelRow(resourcesContents,"Attack"));
		
		resourcesContents.add(new TechLevelRow(resourcesContents,"Defense"));
		
		this.add(resourcesContents);
		
		this.setSize(container.getWidth()-20, resourcesContents.getHeight()+resourcesTitle.getHeight());
		this.setPreferredSize(this.getSize());
	}
}//ResourceTable
class TechLevelRow extends JPanel{
	public TechLevelRow(JPanel resourcesTable, String resource_name) {
		this.setSize(resourcesTable.getWidth(), 25);
		this.setPreferredSize(this.getSize());
		this.setBackground(Color.magenta);
		
		JLabel techName = new JLabel(resource_name,SwingConstants.CENTER);
		techName.setSize(this.getWidth()/10*4-25, 25);
		techName.setPreferredSize(techName.getSize());
		techName.setForeground(Color.white);
		techName.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techName);
		
		JLabel techQuantity = new JLabel("0000",SwingConstants.CENTER);
		techQuantity.setSize(this.getWidth()/10*3-25, 25);
		techQuantity.setPreferredSize(techQuantity.getSize());
		techQuantity.setForeground(Color.white);
		techQuantity.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techQuantity);
		
		JButton techUpgrade = new JButton(" Upgrade ");
		techUpgrade.setSize(this.getWidth()/10*3-25, 25);
		techUpgrade.setPreferredSize(techQuantity.getSize());
		this.add(techUpgrade);

		this.setVisible(true);
	}
}//ResourceRow