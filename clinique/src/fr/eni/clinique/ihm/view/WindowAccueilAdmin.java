package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowAccueilAdmin {
	JFrame frame;
	
	
	public WindowAccueilAdmin(){
	frame = new JFrame();
	frame.setTitle("Accueil Gestion Personnel");
	frame.setBounds(100, 100, 348, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{0, 0};
	gridBagLayout.rowHeights = new int[]{0, 0};
	gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
	frame.getContentPane().setLayout(gridBagLayout);
	
	JDesktopPane desktopPane = new JDesktopPane();
	desktopPane.setBackground(Color.WHITE);
	GridBagConstraints gbc_desktopPane = new GridBagConstraints();
	gbc_desktopPane.fill = GridBagConstraints.BOTH;
	gbc_desktopPane.gridx = 0;
	gbc_desktopPane.gridy = 0;
	frame.getContentPane().add(desktopPane, gbc_desktopPane);
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon("Y:\\RL_AG_LV\\logo.jpg"));
	lblNewLabel.setBounds(117, 11, 90, 96);
	desktopPane.add(lblNewLabel);
	
	JPanel panel = new JPanel();
	panel.setBackground(new Color(94, 141, 229));
	panel.setBounds(0, 122, 332, 39);
	desktopPane.add(panel);
	
	JLabel lblGestionRendezvous = new JLabel("Gestion du Personnel");
	panel.add(lblGestionRendezvous);
	lblGestionRendezvous.setBackground(Color.CYAN);
	lblGestionRendezvous.setForeground(Color.WHITE);
	lblGestionRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(109, 159, 254));
	panel_1.setBounds(0, 0, 332, 123);
	desktopPane.add(panel_1);
	
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(94, 141, 229));
	panel_2.setBounds(0, 400, 332, 63);
	desktopPane.add(panel_2);
	
	JButton btnNewButton_2 = new JButton("");
	panel_2.add(btnNewButton_2);
	btnNewButton_2.setMaximumSize(new Dimension(30, 30));
	btnNewButton_2.setBackground(new Color(240, 240, 240));
	btnNewButton_2.setIcon(new ImageIcon("Y:\\RL_AG_LV\\cancel.png"));
	
	JButton btnNewButton = new JButton("");
	btnNewButton.setIcon(new ImageIcon("Y:\\RL_AG_LV\\ico_gp.jpg"));
	btnNewButton.setBounds(92, 193, 140, 139);
	desktopPane.add(btnNewButton);
	
	JLabel lblPriseDeRendezvous = new JLabel("Gestion du Personnel");
	lblPriseDeRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
	lblPriseDeRendezvous.setBounds(92, 342, 150, 20);
	desktopPane.add(lblPriseDeRendezvous);
	
	btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			WindowGestionPersonnels windowGestionPersonnels  = new WindowGestionPersonnels();
		}
	});
	
	btnNewButton_2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			WindowLogin windowClients = new WindowLogin();
		}
	});
}
}
