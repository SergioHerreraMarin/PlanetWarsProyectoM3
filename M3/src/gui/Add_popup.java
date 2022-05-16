package gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Add_popup extends JFrame{
	public Add_popup(String unit){
		this.setSize(500,500);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(new FlowLayout());
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		JLabel spacer = new JLabel();
		spacer.setSize(this.getWidth()-25,100);
		spacer.setPreferredSize(spacer.getSize());
		this.add(spacer);
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		JLabel title = new JLabel("How many "+unit+"s do you wanna add?",SwingConstants.CENTER);
		title.setSize(this.getWidth()-25,50);
		title.setPreferredSize(title.getSize());
		title.setForeground(Color.white);
		this.add(title);
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		JPanel tfContainer = new JPanel();
		tfContainer.setSize(this.getWidth()-25,40);
		tfContainer.setPreferredSize(tfContainer.getSize());
		tfContainer.setOpaque(false);
		this.add(tfContainer);
		
		JTextField quantityInput = new JTextField();
		quantityInput.setSize(170,30);
		quantityInput.setPreferredSize(quantityInput.getSize());
		tfContainer.add(quantityInput);
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		JPanel buttons = new JPanel();
		buttons.setSize(this.getWidth()-25,40);
		buttons.setPreferredSize(buttons.getSize());
		buttons.setOpaque(false);
		this.add(buttons);
		
		JButton add = new JButton("ADD");
		add.setSize(80,30);
		add.setPreferredSize(add.getSize());
		buttons.add(add);
		
		JButton cancel = new JButton("CANCEL");
		cancel.setSize(80,30);
		cancel.setPreferredSize(add.getSize());
		buttons.add(cancel);
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		JPanel costs = new JPanel();
		costs.setSize(this.getWidth(),200);
		costs.setPreferredSize(costs.getSize());
		costs.setOpaque(false);
		this.add(costs);
		
		JLabel metalTag = new JLabel("METAL",SwingConstants.RIGHT);
		metalTag.setSize(costs.getWidth()/2-25, 20);
		metalTag.setPreferredSize(metalTag.getSize());
		metalTag.setForeground(Color.white);
		costs.add(metalTag);
		
		JLabel metalCost = new JLabel("0000 / 0000",SwingConstants.LEFT);
		metalCost.setSize(costs.getWidth()/2-25, 20);
		metalCost.setPreferredSize(metalCost.getSize());
		metalCost.setForeground(Color.white);
		costs.add(metalCost);
		
		JLabel deuteriumTag = new JLabel("DEUTERIUM",SwingConstants.RIGHT);
		deuteriumTag.setSize(costs.getWidth()/2-25, 20);
		deuteriumTag.setPreferredSize(deuteriumTag.getSize());
		deuteriumTag.setForeground(Color.white);
		costs.add(deuteriumTag);
		
		JLabel deuteriumCost = new JLabel("0000 / 0000",SwingConstants.LEFT);
		deuteriumCost.setSize(costs.getWidth()/2-25, 20);
		deuteriumCost.setPreferredSize(deuteriumCost.getSize());
		deuteriumCost.setForeground(Color.white);
		costs.add(deuteriumCost);
		
		JLabel crystalTag = new JLabel("CRYSTAL",SwingConstants.RIGHT);
		crystalTag.setSize(costs.getWidth()/2-25, 20);
		crystalTag.setPreferredSize(crystalTag.getSize());
		crystalTag.setForeground(Color.white);
		costs.add(crystalTag);
		
		JLabel crystalCost = new JLabel("0000 / 0000",SwingConstants.LEFT);
		crystalCost.setSize(costs.getWidth()/2-25, 20);
		crystalCost.setPreferredSize(crystalCost.getSize());
		crystalCost.setForeground(Color.white);
		costs.add(crystalCost);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Add_popup("Light hunter");
	}
}

