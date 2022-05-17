import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_Mostrar_Seleccionar_Planeta extends JFrame {
	
	private int width;
	
	private int height;
	
	private String planetaSeleccionado;
    
    public GUI_Mostrar_Seleccionar_Planeta(String[] listadoPlanetas) {
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        this.setTitle("SELECCIONA TU PLANETA");
        Toolkit pantalla=Toolkit.getDefaultToolkit();
        Dimension d=pantalla.getScreenSize();
        width=d.width;
        height=d.height;
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("universoProyecto2.gif")));
        setBackground(new java.awt.Color(40, 1, 41));

        setLayout(null);

        drawGUI(listadoPlanetas);
        
        this.setVisible(true);
        
    }
    
    private void drawGUI(String[] listadoPlanetas) {
		int centerX = width/2;
		int centerY = height/2;
		
        JComboBox<String> seleccionPlanetas = new JComboBox<>(listadoPlanetas);
        seleccionPlanetas.setBounds(centerX-70,centerY-25, 140, 20);
        	        
        JButton jButton = new JButton("OK");
        jButton.setBounds(centerX-45, centerY+50, 90, 20);
        
        JLabel jLabel = new JLabel();
        jLabel.setBounds(centerX-100, centerY+50, 200, 100);
        
        this.add(jButton);
        this.add(seleccionPlanetas);
        this.add(jLabel);
        
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	planetaSeleccionado = seleccionPlanetas.getItemAt(seleccionPlanetas.getSelectedIndex());
            	GUI_Mostrar_Seleccionar_Planeta.super.dispose();
            	GUI_Mostrar_Seleccionar_Planeta a = new GUI_Mostrar_Seleccionar_Planeta(new String[] {planetaSeleccionado}) ;
            }
        });
    }

	public String getPlanetaSeleccionado() {
		return planetaSeleccionado;
	}
}
