package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Planet_status extends JPanel {
	private Image fondo;
	
	public Planet_status (Main_window window, int planetId){
		System.out.println(window.getWidth());
		this.setSize(window.getWidth(),window.getHeight());
		this.setPreferredSize(this.getSize());
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10,10,10,10));
		this.setVisible(true);
		
		JPanel left = new JPanel();
		left.setSize((this.getWidth()/2)-23,this.getHeight());
		left.setPreferredSize(left.getSize());
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		left.setBorder(new EmptyBorder(10,10,10,10));
		left.setOpaque(false);
		this.add(left);
		
		JPanel right = new JPanel();
		right.setSize((this.getWidth()/2)-23,this.getHeight());
		right.setPreferredSize(right.getSize());
		right.setLayout(new FlowLayout(FlowLayout.LEFT));
		right.setOpaque(false);
		JScrollPane scrollFrame = new JScrollPane(right);
		right.setAutoscrolls(true);
		scrollFrame.setPreferredSize(new Dimension((this.getWidth()/2)-23,this.getHeight()));
		scrollFrame.setOpaque(false);
		scrollFrame.getViewport().setOpaque(false);
		this.add(scrollFrame);
		//this.add(right);
		
		JLabel planetName = new JLabel("PLANET NAME");
		planetName.setSize(left.getWidth()-20,60);
		planetName.setPreferredSize(planetName.getSize());
		planetName.setBorder(new LineBorder(Color.white));
		planetName.setFont(new Font("Arial", 1, 60));
		planetName.setForeground(Color.white);
		planetName.setBackground(new Color(51, 102, 0));
		planetName.setOpaque(true);
		
		JButton viewBattleReports = new JButton(" VIEW BATTLE REPORTS ");
		viewBattleReports.setSize(right.getWidth()-15,20);
		viewBattleReports.setPreferredSize(viewBattleReports.getSize());
		viewBattleReports.setBackground(new Color(51, 102, 0));
		viewBattleReports.setForeground(Color.white);
		
		JButton back = new JButton(" BACK ");
		back.setSize(right.getWidth()-15,20);
		back.setPreferredSize(back.getSize());
		back.setBackground(new Color(51, 102, 0));
		back.setForeground(Color.white);
		
		left.add(planetName);
		
		left.add(new Spacer());
		
		left.add(new ResourcesTable(left));
		
		right.add(new ShipTable(right));
		
		right.add(new Spacer());
		
		right.add(new DefenseTable(right));
		
		right.add(new Spacer());
		
		right.add(new TechLevelsTable(right));
		
		right.add(new Spacer());
		
		right.add(viewBattleReports);
		
		right.add(new Spacer());
		
		right.add(back);
		
		/*
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("assets/images/planets/dirt_planet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(500, 500, 1)));
		picLabel.setSize(500,500);
		picLabel.setPreferredSize(picLabel.getSize());
		
		left.add(picLabel);
		*/
		
		this.setVisible(true);
	}

}//clase principal



class ResourcesTable extends JPanel{
	public ResourcesTable(JPanel container) {
		this.setSize(container.getWidth()-20, 200);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		this.setBackground(Color.black);
		container.add(this);
		
		JLabel resourcesTitle = new JLabel(" RESOURCES ");
		resourcesTitle.setSize(this.getWidth(),20);
		resourcesTitle.setPreferredSize(resourcesTitle.getSize());
		resourcesTitle.setBorder(BorderFactory.createLineBorder(Color.white));
		resourcesTitle.setForeground(Color.white);
		resourcesTitle.setBackground(new Color(51, 102, 0));
		resourcesTitle.setOpaque(true);
		this.add(resourcesTitle);
		
		//###
		JPanel resourcesContents = new JPanel();
		resourcesContents.setBackground(Color.black);
		resourcesContents.setSize(this.getWidth()-25,35*3);
		resourcesContents.setPreferredSize(resourcesContents.getSize());
		
		resourcesContents.add(new ResourceRow(resourcesContents,"Deuterium"));
		resourcesContents.add(new ResourceRow(resourcesContents,"Metal"));
		resourcesContents.add(new ResourceRow(resourcesContents,"Crystal"));
		
		this.add(resourcesContents);
		//###
		this.setSize(container.getWidth()-20, resourcesContents.getHeight()+resourcesTitle.getHeight()+15);
		this.setPreferredSize(this.getSize());
	}
}//ResourceTable

class ResourceRow extends JPanel{
	public ResourceRow(JPanel container, String resource_name) {
		this.setSize(container.getWidth(), 25);
		this.setPreferredSize(this.getSize());
		this.setBackground(Color.black);
		
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
		title.setBackground(new Color(51, 102, 0));
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(title);
		
		JPanel rowTitles = new JPanel();
		rowTitles.setSize(this.getWidth(), 30);
		rowTitles.setPreferredSize(rowTitles.getSize());
		rowTitles.setOpaque(false);
		rowTitles.setAlignmentX(LEFT_ALIGNMENT);
		
		JLabel shipName = new JLabel("Type",SwingConstants.CENTER);
		shipName.setSize(rowTitles.getWidth()/10*6-25,20);
		shipName.setPreferredSize(shipName.getSize());
		shipName.setForeground(Color.white);
		shipName.setBackground(new Color(51, 102, 0));
		shipName.setOpaque(true);
		shipName.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipName);
		
		JLabel shipQuantity = new JLabel("Quantity",SwingConstants.CENTER);
		shipQuantity.setSize(rowTitles.getWidth()/10*4-25,20);
		shipQuantity.setPreferredSize(shipQuantity.getSize());
		shipQuantity.setForeground(Color.white);
		shipQuantity.setBackground(new Color(51, 102, 0));
		shipQuantity.setOpaque(true);
		shipQuantity.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipQuantity);
		
		JLabel shipAdd = new JLabel("Add",SwingConstants.CENTER);
		shipAdd.setSize(rowTitles.getWidth()/10*1-25,20);
		shipAdd.setPreferredSize(shipAdd.getSize());
		shipAdd.setForeground(Color.white);
		shipAdd.setBackground(new Color(51, 102, 0));
		shipAdd.setOpaque(true);
		shipAdd.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipAdd);
		
		this.add(rowTitles);
		
		this.add(new ShipRow(this));
		this.add(new ShipRow(this));
		this.add(new ShipRow(this));
		this.add(new ShipRow(this));
		
		this.setSize(container.getWidth()-15,35 + title.getHeight() + rowTitles.getHeight()+30*4);
		this.setPreferredSize(this.getSize());
	}
}//class shipTable
class ShipRow extends JPanel{
	public ShipRow(JPanel container) {
		this.setSize(container.getWidth(),30);
		this.setPreferredSize(this.getSize());
		this.setOpaque(false);
		this.setBorder(new LineBorder(Color.white));
		
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
		shipAdd.setBackground(new Color(51, 102, 0));
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
		title.setBackground(new Color(51, 102, 0));
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(title);
		
		JPanel rowTitles = new JPanel();
		rowTitles.setSize(this.getWidth(), 30);
		rowTitles.setPreferredSize(rowTitles.getSize());
		rowTitles.setOpaque(false);
		rowTitles.setAlignmentX(LEFT_ALIGNMENT);
		
		JLabel shipName = new JLabel("Type",SwingConstants.CENTER);
		shipName.setSize(rowTitles.getWidth()/10*6-25,20);
		shipName.setPreferredSize(shipName.getSize());
		shipName.setForeground(Color.white);
		shipName.setBackground(new Color(51, 102, 0));
		shipName.setOpaque(true);
		shipName.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipName);
		
		JLabel shipQuantity = new JLabel("Quantity",SwingConstants.CENTER);
		shipQuantity.setSize(rowTitles.getWidth()/10*4-25,20);
		shipQuantity.setPreferredSize(shipQuantity.getSize());
		shipQuantity.setForeground(Color.white);
		shipQuantity.setBackground(new Color(51, 102, 0));
		shipQuantity.setOpaque(true);
		shipQuantity.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipQuantity);
		
		JLabel shipAdd = new JLabel("Add",SwingConstants.CENTER);
		shipAdd.setSize(rowTitles.getWidth()/10*1-25,20);
		shipAdd.setPreferredSize(shipAdd.getSize());
		shipAdd.setForeground(Color.white);
		shipAdd.setBackground(new Color(51, 102, 0));
		shipAdd.setOpaque(true);
		shipAdd.setBorder(new LineBorder(Color.white));
		rowTitles.add(shipAdd);
		
		this.add(rowTitles);
		
		this.add(new DefenseRow(this));
		this.add(new DefenseRow(this));
		this.add(new DefenseRow(this));
		
		this.setSize(container.getWidth()-15,35 + title.getHeight() + rowTitles.getHeight()+30*4);
		this.setPreferredSize(this.getSize());
	}
}//class defenseTable
class DefenseRow extends JPanel{
	public DefenseRow(JPanel container) {
		this.setSize(container.getWidth(),30);
		this.setPreferredSize(this.getSize());
		this.setBorder(new LineBorder(Color.white));
		this.setOpaque(false);
		
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
		shipAdd.setBackground(new Color(51, 102, 0));
		shipAdd.setBorder(new LineBorder(Color.white));
		this.add(shipAdd);
	}
}// class DefenseRow



class TechLevelsTable extends JPanel{
	public TechLevelsTable(JPanel container) {
		this.setSize(container.getWidth()-20, 200);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		this.setBackground(Color.black);
		container.add(this);
		
		JLabel title = new JLabel(" RESOURCES ",SwingConstants.CENTER);
		title.setSize(this.getWidth(),20);
		title.setPreferredSize(title.getSize());
		title.setBorder(BorderFactory.createLineBorder(Color.white));
		title.setForeground(Color.white);
		title.setBackground(new Color(51, 102, 0));
		title.setOpaque(true);
		this.add(title);
		
		JPanel rowTitles = new JPanel();
		rowTitles.setSize(this.getWidth()-25, 25);
		rowTitles.setPreferredSize(this.getSize());
		rowTitles.setBackground(Color.black);
		
		JLabel techName = new JLabel("TECHNOLOGY");
		techName.setSize(rowTitles.getWidth()/10*6-5, 20);
		techName.setPreferredSize(techName.getSize());
		techName.setForeground(Color.white);
		techName.setBackground(new Color(51, 102, 0));
		techName.setOpaque(true);
		techName.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techName);
		
		JLabel techLevel = new JLabel("LEVEL");
		techLevel.setSize(rowTitles.getWidth()/10*2-5, 20);
		techLevel.setPreferredSize(techLevel.getSize());
		techLevel.setForeground(Color.white);
		techLevel.setBackground(new Color(51, 102, 0));
		techLevel.setOpaque(true);
		techLevel.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techLevel);
		
		JLabel techUpgrade = new JLabel("UPGRADE");
		techUpgrade.setSize(rowTitles.getWidth()/10*2-5, 20);
		techUpgrade.setPreferredSize(techLevel.getSize());
		techUpgrade.setForeground(Color.white);
		techUpgrade.setBackground(new Color(51, 102, 0));
		techUpgrade.setOpaque(true);
		techUpgrade.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techUpgrade);
		
		//###
		JPanel contents = new JPanel();
		contents.setBackground(Color.black);
		contents.setSize(this.getWidth()-25,35*3);
		contents.setPreferredSize(contents.getSize());
		
		contents.add(new TechLevelRow(contents,"Deuterium"));
		contents.add(new TechLevelRow(contents,"Metal"));
		contents.add(new TechLevelRow(contents,"Crystal"));
		
		this.add(contents);
		//###
		this.setSize(container.getWidth()-15, contents.getHeight()+title.getHeight()+40);
		this.setPreferredSize(this.getSize());
	}
}//ResourceTable

class TechLevelRow extends JPanel{
	public TechLevelRow(JPanel container, String resource_name) {
		this.setSize(container.getWidth(), 30);
		this.setPreferredSize(this.getSize());
		this.setBorder(BorderFactory.createLineBorder(Color.white));
		this.setBackground(Color.black);
		
		JLabel techName = new JLabel(resource_name);
		techName.setSize(this.getWidth()/10*6-5, 20);
		techName.setPreferredSize(techName.getSize());
		techName.setForeground(Color.white);
		techName.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techName);
		
		JLabel techLevel = new JLabel("0000");
		techLevel.setSize(this.getWidth()/10*2-5, 20);
		techLevel.setPreferredSize(techLevel.getSize());
		techLevel.setForeground(Color.white);
		techLevel.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techLevel);
		
		JButton techUpgrade = new JButton(" UPGRADE ");
		techUpgrade.setSize(this.getWidth()/10*2-5, 20);
		techUpgrade.setPreferredSize(techLevel.getSize());
		techUpgrade.setForeground(Color.white);
		techUpgrade.setBackground(new Color(51, 102, 0));
		techUpgrade.setBorder(BorderFactory.createLineBorder(Color.white));
		this.add(techUpgrade);
		

		this.setVisible(true);
	}
}//ResourceRow



class Spacer extends JLabel{
	public Spacer() {
		this.setSize(10,10);
		this.setPreferredSize(this.getSize());
		this.setBackground(Color.darkGray);
		this.setOpaque(true);
		this.setVisible(true);
	}
}