package fr.eni.clinique.ihm.view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JTextField;

import javax.swing.border.Border;

import fr.eni.clinique.ihm.controller.ControllerLogin;
import fr.eni.clinique.ihm.graphic.ImagePanel;
import fr.eni.clinique.ihm.graphic.RoundButton;
import fr.eni.clinique.ihm.graphic.RoundJPasswordField;
import fr.eni.clinique.ihm.graphic.RoundJTextField;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

public class WindowLogin {

	private JFrame frame;
	private static JTextField textField = new RoundJTextField(15);
	private JLabel lblConnexion;
	private ControllerLogin controller;
	private JPasswordField textField_1 = new RoundJPasswordField(15);
	private JDesktopPane desktopPane = new JDesktopPane();
	private ImagePanel imgBack = new ImagePanel(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/login-color.jpg").getImage());


	/**
	 * Create the application.
	 * 
	 */

	
	public WindowLogin() {
		controller = new ControllerLogin();
		 
		//liste panneau------------------------------------
		frame = new JFrame();
		frame.setTitle("Connexion");
		frame.setBounds(100, 100, 315, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.gridheight = 2;
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		frame.getContentPane().add(desktopPane, gbc_desktopPane);
		
		JLabel lblTre = new JLabel("");
		lblTre.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/verrou.png"));
		lblTre.setBounds(77, 263, 24, 33);
		desktopPane.add(lblTre);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/human-login.png"));
		lblNewLabel_1.setBounds(77, 214, 24, 33);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/logo-redi-login-sf.png"));
		lblNewLabel.setBounds(84, 23, 141, 142);
		desktopPane.add(lblNewLabel);
		
		textField.setToolTipText("");
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		textField.setBounds(67, 203, 171, 49); 
		textField.setMargin(new Insets(8,45, 0, 0));
		desktopPane.add(textField);
		textField.setColumns(10);

		textField_1.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		textField_1.setBounds(67, 252, 171, 49);
		textField_1.setMargin(new Insets(8,45, 0, 0));
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnValider = new JButton("connexion");
		btnValider.setBorder(new RoundButton(25));
		btnValider.setBounds(62, 344, 180, 29);
		btnValider.setForeground(null);
		btnValider.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		btnValider.setOpaque(false);
		btnValider.setFocusPainted(true);
		btnValider.setBackground(new Color(66, 208, 231));
		btnValider.setBorderPainted(true);
		desktopPane.add(btnValider);

		desktopPane.add(imgBack);
		
//------------------------------------------------------------------------		
		
		btnValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(controller.verif(textField.getText(), textField_1.getPassword())){
					frame.setVisible(false);
				}else{
					lblConnexion.setText("Identifiant incorrect.");
				}
				
			}
		});
	}

	public static String getNom(){
		return textField.getText();
	}

}