package PROYECTO;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;

import java.util.Calendar;
import com.toedter.calendar.JDateChooser;

public class IG2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IG frame = new IG();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IG2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, getWidth(), getHeight());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//-----------------LABELS-----------------//
		JLabel LabelLogin = new JLabel();
		LabelLogin.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(LabelLogin);
		
		JLabel LabelChoosePlanet = new JLabel("");
		LabelChoosePlanet.setVisible(false);
		LabelChoosePlanet.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(LabelChoosePlanet);
		
		JLabel LabelCreateAccount = new JLabel("");
		LabelCreateAccount.setVisible(false);
		LabelCreateAccount.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(LabelCreateAccount);
		
		//-----------------X BUTTONS-----------------//
		JButton btnXLogin = new JButton("x");
		btnXLogin.setForeground(Color.WHITE);
		btnXLogin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnXLogin.setBackground(Color.RED);
		btnXLogin.setBounds(screenSize.width - 45, 0, 45, 25);
		LabelLogin.add(btnXLogin);
		btnXLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		JButton btnXChoosePlanet = new JButton("x");
		btnXChoosePlanet.setForeground(Color.WHITE);
		btnXChoosePlanet.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnXChoosePlanet.setBackground(Color.RED);
		btnXChoosePlanet.setBounds(screenSize.width - 45, 0, 45, 25);
		LabelChoosePlanet.add(btnXChoosePlanet);
		btnXChoosePlanet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		JButton btnXCreateAccount = new JButton("x");
		btnXCreateAccount.setForeground(Color.WHITE);
		btnXCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnXCreateAccount.setBackground(Color.RED);
		btnXCreateAccount.setBounds(screenSize.width - 45, 0, 45, 25);
		LabelCreateAccount.add(btnXCreateAccount);
		btnXCreateAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		//-----------------RETURN BUTTONS-----------------//
		JButton btnReturnCreateAccount = new JButton("<-");
		btnReturnCreateAccount.setForeground(Color.WHITE);
		btnReturnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnReturnCreateAccount.setBackground(Color.RED);
		btnReturnCreateAccount.setBounds(0, screenSize.height-70, 45, 25);
		LabelCreateAccount.add(btnReturnCreateAccount);
		btnReturnCreateAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LabelCreateAccount.setVisible(false);
				setSize(screenSize.width, screenSize.height);
				LabelLogin.setVisible(true);
			}
		});
		
		//-----------------COMPONENTS LABELLOGIN-----------------//
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Lato Medium", Font.BOLD, 15));
		passwordField.setBounds(276, 433, 166, 34);
		LabelLogin.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("PLANET WARS");
		lblNewLabel.setFont(new Font("Lato Medium", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(142, 178, 332, 41);
		LabelLogin.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Lato Medium", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(88, 335, 146, 34);
		LabelLogin.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Lato Medium", Font.BOLD, 25));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(88, 437, 170, 34);
		LabelLogin.add(lblNewLabel_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Lato Medium", Font.BOLD, 20));
		formattedTextField.setBounds(276, 335, 166, 34);
		LabelLogin.add(formattedTextField);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an account?");
		lblNewLabel_3.setFont(new Font("Lato Medium", Font.BOLD, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(88, 603, 243, 25);
		LabelLogin.add(lblNewLabel_3);
		
		JButton btncreateaccount = new JButton("CREATE ACCOUNT");
		btncreateaccount.setForeground(Color.BLACK);
		btncreateaccount.setFont(new Font("Lato Medium", Font.BOLD, 12));
		btncreateaccount.setBounds(88, 658, 163, 27);
		LabelLogin.add(btncreateaccount);
		btncreateaccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LabelLogin.setVisible(false);
				setSize(screenSize.width, screenSize.height);
				LabelCreateAccount.setVisible(true);
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setFont(new Font("Lato Medium", Font.BOLD, 20));
		rdbtnNewRadioButton.setBounds(440, 433, 26, 34);
		LabelLogin.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rdbtnNewRadioButton.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else{
					passwordField.setEchoChar('\u25cf');
				}
			}
		});
		
		Button button = new Button("LOGIN");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Lato Medium", Font.BOLD, 25));
		button.setBounds(87, 517, 189, 50);
		LabelLogin.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LabelLogin.setVisible(false);
				LabelChoosePlanet.setVisible(true);
			}
		});
		
		//-----------------COMPONENTS LABELCREATEACCOUNT-----------------//
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Lato Medium", Font.BOLD, 15));
		passwordField_1.setBounds(586, 553, 166, 34);
		LabelCreateAccount.add(passwordField_1);
		
		JLabel lblNewLabel_4 = new JLabel("PLANET WARS");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Lato Medium", Font.BOLD, 40));
		lblNewLabel_4.setBounds(452, 298, 332, 41);
		LabelCreateAccount.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("USERNAME");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Lato Medium", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(398, 455, 146, 34);
		LabelCreateAccount.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("PASSWORD");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Lato Medium", Font.BOLD, 25));
		lblNewLabel_2_1_1.setBounds(398, 553, 170, 34);
		LabelCreateAccount.add(lblNewLabel_2_1_1);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Lato Medium", Font.BOLD, 20));
		formattedTextField_1.setBounds(586, 455, 166, 34);
		LabelCreateAccount.add(formattedTextField_1);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setFont(new Font("Lato Medium", Font.BOLD, 20));
		rdbtnNewRadioButton_1.setBounds(750, 553, 26, 34);
		LabelCreateAccount.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rdbtnNewRadioButton_1.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				}else{
					passwordField_1.setEchoChar('\u25cf');
				}
			}
		});
		
		
		Button button_1 = new Button("LOGIN");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Lato Medium", Font.BOLD, 25));
		button_1.setBounds(398, 764, 189, 50);
		LabelCreateAccount.add(button_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("BIRTH DATE");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Lato Medium", Font.BOLD, 25));
		lblNewLabel_2_1_1_1.setBounds(398, 663, 170, 34);
		LabelCreateAccount.add(lblNewLabel_2_1_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(586, 663, 166, 34);
		LabelCreateAccount.add(dateChooser);

		//-----------------COMPONENTS LABELCHOOSEPLANET-----------------//
		JLabel Planet1Name = new JLabel("PLANET_NAME");
		Planet1Name.setBounds(new Rectangle(135, 93, 572, 67));
		Planet1Name.setBorder(new LineBorder(Color.WHITE));
		Planet1Name.setBackground(Color.LIGHT_GRAY);
		Planet1Name.setForeground(Color.WHITE);
		Planet1Name.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1Name.setBounds(135, 58, 672, 102);
		LabelChoosePlanet.add(Planet1Name);
		
		JLabel Planet1Resources = new JLabel("RESOURCES");
		Planet1Resources.setForeground(Color.WHITE);
		Planet1Resources.setFont(new Font("Lato Medium", Font.BOLD, 25));
		Planet1Resources.setBounds(new Rectangle(135, 160, 672, 57));
		Planet1Resources.setBorder(new LineBorder(Color.WHITE));
		Planet1Resources.setBackground(Color.LIGHT_GRAY);
		Planet1Resources.setBounds(135, 160, 672, 57);
		LabelChoosePlanet.add(Planet1Resources);
		
		JLabel Planet1Metal = new JLabel("METAL");
		Planet1Metal.setForeground(Color.WHITE);
		Planet1Metal.setFont(new Font("Lato Medium", Font.BOLD, 25));
		Planet1Metal.setBounds(new Rectangle(135, 243, 473, 57));
		Planet1Metal.setBorder(new LineBorder(Color.WHITE));
		Planet1Metal.setBackground(Color.LIGHT_GRAY);
		Planet1Metal.setBounds(135, 217, 546, 57);
		LabelChoosePlanet.add(Planet1Metal);
		
		JLabel Planet1Deuterium = new JLabel("DEUTERIUM");
		Planet1Deuterium.setForeground(Color.WHITE);
		Planet1Deuterium.setFont(new Font("Lato Medium", Font.BOLD, 25));
		Planet1Deuterium.setBounds(new Rectangle(135, 302, 473, 57));
		Planet1Deuterium.setBorder(new LineBorder(Color.WHITE));
		Planet1Deuterium.setBackground(Color.LIGHT_GRAY);
		Planet1Deuterium.setBounds(135, 274, 546, 57);
		LabelChoosePlanet.add(Planet1Deuterium);
		
		JLabel Planet1Crystal = new JLabel("CRYSTAL");
		Planet1Crystal.setForeground(Color.WHITE);
		Planet1Crystal.setFont(new Font("Lato Medium", Font.BOLD, 25));
		Planet1Crystal.setBounds(new Rectangle(135, 347, 572, 57));
		Planet1Crystal.setBorder(new LineBorder(Color.WHITE));
		Planet1Crystal.setBackground(Color.LIGHT_GRAY);
		Planet1Crystal.setBounds(135, 331, 546, 57);
		LabelChoosePlanet.add(Planet1Crystal);
		
		JLabel Planet1MetalAmount = new JLabel("1000");
		Planet1MetalAmount.setForeground(Color.WHITE);
		Planet1MetalAmount.setFont(new Font("Lato Medium", Font.BOLD, 25));
		Planet1MetalAmount.setBounds(new Rectangle(609, 243, 98, 57));
		Planet1MetalAmount.setBorder(new LineBorder(Color.WHITE));
		Planet1MetalAmount.setBackground(Color.LIGHT_GRAY);
		Planet1MetalAmount.setBounds(681, 217, 126, 57);
		LabelChoosePlanet.add(Planet1MetalAmount);
		
		JLabel Planet1MetalAmount_1 = new JLabel("1000");
		Planet1MetalAmount_1.setForeground(Color.WHITE);
		Planet1MetalAmount_1.setFont(new Font("Lato Medium", Font.BOLD, 25));
		Planet1MetalAmount_1.setBounds(new Rectangle(609, 228, 98, 33));
		Planet1MetalAmount_1.setBorder(new LineBorder(Color.WHITE));
		Planet1MetalAmount_1.setBackground(Color.LIGHT_GRAY);
		Planet1MetalAmount_1.setBounds(681, 274, 126, 57);
		LabelChoosePlanet.add(Planet1MetalAmount_1);
		
		JLabel Planet1MetalAmount_1_1 = new JLabel("1000");
		Planet1MetalAmount_1_1.setForeground(Color.WHITE);
		Planet1MetalAmount_1_1.setFont(new Font("Lato Medium", Font.BOLD, 25));
		Planet1MetalAmount_1_1.setBounds(new Rectangle(609, 262, 98, 33));
		Planet1MetalAmount_1_1.setBorder(new LineBorder(Color.WHITE));
		Planet1MetalAmount_1_1.setBackground(Color.LIGHT_GRAY);
		Planet1MetalAmount_1_1.setBounds(681, 331, 126, 57);
		LabelChoosePlanet.add(Planet1MetalAmount_1_1);
		
		JLabel Planet1Ships = new JLabel("SHIPS");
		Planet1Ships.setForeground(Color.WHITE);
		Planet1Ships.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1Ships.setBounds(new Rectangle(1138, 58, 672, 57));
		Planet1Ships.setBorder(new LineBorder(Color.WHITE));
		Planet1Ships.setBackground(Color.LIGHT_GRAY);
		Planet1Ships.setBounds(1109, 58, 672, 57);
		LabelChoosePlanet.add(Planet1Ships);
		
		JLabel Planet1ShipsType = new JLabel("TYPE");
		Planet1ShipsType.setForeground(Color.WHITE);
		Planet1ShipsType.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsType.setBounds(new Rectangle(1138, 114, 292, 57));
		Planet1ShipsType.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsType.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsType.setBounds(1109, 114, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsType);
		
		JLabel Planet1ShipsNumber = new JLabel("NUMBER");
		Planet1ShipsNumber.setForeground(Color.WHITE);
		Planet1ShipsNumber.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsNumber.setBounds(new Rectangle(1430, 114, 292, 57));
		Planet1ShipsNumber.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsNumber.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsNumber.setBounds(1401, 114, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsNumber);
		
		JLabel Planet1ShipsAdd = new JLabel("ADD");
		Planet1ShipsAdd.setForeground(Color.WHITE);
		Planet1ShipsAdd.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsAdd.setBounds(new Rectangle(1722, 114, 88, 57));
		Planet1ShipsAdd.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsAdd.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsAdd.setBounds(1693, 114, 88, 57);
		LabelChoosePlanet.add(Planet1ShipsAdd);
		
		JLabel Planet1ShipsLightHunter = new JLabel("LIGHT HUNTER");
		Planet1ShipsLightHunter.setForeground(Color.WHITE);
		Planet1ShipsLightHunter.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsLightHunter.setBounds(new Rectangle(1138, 170, 292, 57));
		Planet1ShipsLightHunter.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsLightHunter.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsLightHunter.setBounds(1109, 170, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsLightHunter);
		
		JLabel Planet1ShipsNumberLightHunter_1 = new JLabel("10");
		Planet1ShipsNumberLightHunter_1.setForeground(Color.WHITE);
		Planet1ShipsNumberLightHunter_1.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsNumberLightHunter_1.setBounds(new Rectangle(1430, 170, 292, 57));
		Planet1ShipsNumberLightHunter_1.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsNumberLightHunter_1.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsNumberLightHunter_1.setBounds(1401, 170, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsNumberLightHunter_1);
		
		JButton Planet1ShipsAddLightHunter = new JButton("+");
		Planet1ShipsAddLightHunter.setForeground(Color.WHITE);
		Planet1ShipsAddLightHunter.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsAddLightHunter.setBounds(new Rectangle(1722, 170, 88, 57));
		Planet1ShipsAddLightHunter.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsAddLightHunter.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsAddLightHunter.setBounds(1693, 170, 88, 57);
		LabelChoosePlanet.add(Planet1ShipsAddLightHunter);
		Planet1ShipsAddLightHunter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel Planet1ShipsHeavyHunter_1 = new JLabel("HEAVY HUNTER");
		Planet1ShipsHeavyHunter_1.setForeground(Color.WHITE);
		Planet1ShipsHeavyHunter_1.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsHeavyHunter_1.setBounds(new Rectangle(1138, 226, 292, 57));
		Planet1ShipsHeavyHunter_1.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsHeavyHunter_1.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsHeavyHunter_1.setBounds(1109, 226, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsHeavyHunter_1);
		
		JLabel Planet1ShipsNumberHeavyHunter_1_1 = new JLabel("10");
		Planet1ShipsNumberHeavyHunter_1_1.setForeground(Color.WHITE);
		Planet1ShipsNumberHeavyHunter_1_1.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsNumberHeavyHunter_1_1.setBounds(new Rectangle(1430, 226, 292, 57));
		Planet1ShipsNumberHeavyHunter_1_1.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsNumberHeavyHunter_1_1.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsNumberHeavyHunter_1_1.setBounds(1401, 226, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsNumberHeavyHunter_1_1);
		
		JButton Planet1ShipsAddHeavyHunter_1 = new JButton("+");
		Planet1ShipsAddHeavyHunter_1.setForeground(Color.WHITE);
		Planet1ShipsAddHeavyHunter_1.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsAddHeavyHunter_1.setBounds(new Rectangle(1722, 226, 88, 57));
		Planet1ShipsAddHeavyHunter_1.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsAddHeavyHunter_1.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsAddHeavyHunter_1.setBounds(1693, 226, 88, 57);
		LabelChoosePlanet.add(Planet1ShipsAddHeavyHunter_1);
		Planet1ShipsAddHeavyHunter_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel Planet1ShipsBattleShip = new JLabel("BATTLE SHIP");
		Planet1ShipsBattleShip.setForeground(Color.WHITE);
		Planet1ShipsBattleShip.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsBattleShip.setBounds(new Rectangle(1138, 282, 292, 57));
		Planet1ShipsBattleShip.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsBattleShip.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsBattleShip.setBounds(1109, 282, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsBattleShip);
		
		JLabel Planet1ShipsNumberBattleShip = new JLabel("10");
		Planet1ShipsNumberBattleShip.setForeground(Color.WHITE);
		Planet1ShipsNumberBattleShip.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsNumberBattleShip.setBounds(new Rectangle(1430, 282, 292, 57));
		Planet1ShipsNumberBattleShip.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsNumberBattleShip.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsNumberBattleShip.setBounds(1401, 282, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsNumberBattleShip);
		
		JButton Planet1ShipsAddBattleShip = new JButton("+");
		Planet1ShipsAddBattleShip.setForeground(Color.WHITE);
		Planet1ShipsAddBattleShip.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsAddBattleShip.setBounds(new Rectangle(1722, 282, 88, 57));
		Planet1ShipsAddBattleShip.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsAddBattleShip.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsAddBattleShip.setBounds(1693, 282, 88, 57);
		LabelChoosePlanet.add(Planet1ShipsAddBattleShip);
		Planet1ShipsAddBattleShip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel Planet1ShipsArmoredShip = new JLabel("ARMORED SHIP");
		Planet1ShipsArmoredShip.setForeground(Color.WHITE);
		Planet1ShipsArmoredShip.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsArmoredShip.setBounds(new Rectangle(1138, 338, 292, 57));
		Planet1ShipsArmoredShip.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsArmoredShip.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsArmoredShip.setBounds(1109, 338, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsArmoredShip);
		
		JLabel Planet1ShipsNumberArmoredShip = new JLabel("10");
		Planet1ShipsNumberArmoredShip.setForeground(Color.WHITE);
		Planet1ShipsNumberArmoredShip.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsNumberArmoredShip.setBounds(new Rectangle(1430, 338, 292, 57));
		Planet1ShipsNumberArmoredShip.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsNumberArmoredShip.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsNumberArmoredShip.setBounds(1401, 338, 292, 57);
		LabelChoosePlanet.add(Planet1ShipsNumberArmoredShip);
		
		JButton Planet1ShipsAddArmoredShip = new JButton("+");
		Planet1ShipsAddArmoredShip.setForeground(Color.WHITE);
		Planet1ShipsAddArmoredShip.setFont(new Font("Lato Medium", Font.BOLD, 30));
		Planet1ShipsAddArmoredShip.setBounds(new Rectangle(1722, 338, 88, 57));
		Planet1ShipsAddArmoredShip.setBorder(new LineBorder(Color.WHITE));
		Planet1ShipsAddArmoredShip.setBackground(Color.LIGHT_GRAY);
		Planet1ShipsAddArmoredShip.setBounds(1693, 338, 88, 57);
		LabelChoosePlanet.add(Planet1ShipsAddArmoredShip);
		Planet1ShipsAddArmoredShip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

		
		//-----------------BACKGROUNDS-----------------//
		ImageIcon LoginBackGround= new ImageIcon("espacio.gif");
		ImageIcon icono= new ImageIcon(LoginBackGround.getImage().getScaledInstance(LabelLogin.getWidth(),LabelLogin.getHeight(),Image.SCALE_DEFAULT));
		LabelLogin. setIcon(icono);
		
		ImageIcon ChoosePlanetBackGround= new ImageIcon("espacio.gif");
		ImageIcon icono2= new ImageIcon(ChoosePlanetBackGround.getImage().getScaledInstance(LabelChoosePlanet.getWidth(),LabelChoosePlanet.getHeight(),Image.SCALE_DEFAULT));
		LabelChoosePlanet. setIcon(icono2);
				
		ImageIcon CreateAccountBackGround= new ImageIcon("espacio.gif");
		ImageIcon icono3= new ImageIcon(CreateAccountBackGround.getImage().getScaledInstance(LabelCreateAccount.getWidth(),LabelCreateAccount.getHeight(),Image.SCALE_DEFAULT));
		LabelCreateAccount. setIcon(icono3);
		
        
	}
}

class LogoPanel extends JPanel {

	  Image logo;

	  public LogoPanel() {
		  logo = Toolkit.getDefaultToolkit().createImage("PlanetWarsLOGO.png");
	  }

	  @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (logo != null) {
	      g.drawImage(logo, WIDTH/2, HEIGHT/2, 200, 200, this);
	      setOpaque(false);
	    }
	  }

}