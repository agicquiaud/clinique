package fr.eni.clinique.ihm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.UIManager;



public class WindowAnimal {
	
	private JFrame frmGestionAnimal;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private ControllerAnimaux selectAnimal;
	
	
	public WindowAnimal(){
		
		frmGestionAnimal = new JFrame();
		frmGestionAnimal.setForeground(new Color(240, 255, 255));
		frmGestionAnimal.setBounds(100, 100, 540, 375);
		frmGestionAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionAnimal.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		frmGestionAnimal.setTitle("Gestion Animal");
		frmGestionAnimal.getContentPane().setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 84, 67, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 0, 35, 35, 35, 0, 50, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmGestionAnimal.getContentPane().setLayout(gridBagLayout);
		frmGestionAnimal.setVisible(true);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.gridwidth = 5;
		gbc_desktopPane.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		frmGestionAnimal.getContentPane().add(desktopPane, gbc_desktopPane);
		
		JButton btnAnnuler = new JButton("");
		btnAnnuler.setForeground(new Color(255, 255, 255));
		btnAnnuler.setBackground(new Color(255, 255, 255));
		btnAnnuler.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/checked32.png"));
		btnAnnuler.setBounds(329, 11, 58, 44);
		desktopPane.add(btnAnnuler);
		
		JButton btnValider_1 = new JButton("");
		btnValider_1.setForeground(new Color(255, 255, 255));
		btnValider_1.setBackground(new Color(255, 255, 255));
		btnValider_1.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/cancel.png"));
		btnValider_1.setBounds(423, 11, 58, 44);
		desktopPane.add(btnValider_1);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(UIManager.getColor("Button.background"));
		desktopPane_1.setBorder(null);
		GridBagConstraints gbc_desktopPane_1 = new GridBagConstraints();
		gbc_desktopPane_1.gridheight = 2;
		gbc_desktopPane_1.gridwidth = 5;
		gbc_desktopPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPane_1.fill = GridBagConstraints.BOTH;
		gbc_desktopPane_1.gridx = 0;
		gbc_desktopPane_1.gridy = 1;
		frmGestionAnimal.getContentPane().add(desktopPane_1, gbc_desktopPane_1);
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblClient.setBounds(22, 11, 46, 14);
		desktopPane_1.add(lblClient);
		
		JLabel lblNewLabel_3 = new JLabel("Albert Kader");
		lblNewLabel_3.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(43, 32, 265, 14);
		desktopPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		frmGestionAnimal.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.gridwidth = 2;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 3;
		frmGestionAnimal.getContentPane().add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 4;
		frmGestionAnimal.getContentPane().add(lblNom, gbc_lblNom);
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.gridwidth = 2;
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 4;
		frmGestionAnimal.getContentPane().add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		String [] Genre = {"Mâle", "Femelle"};
		JComboBox comboBox_2 = new JComboBox(Genre);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		comboBox_2.setBackground(new Color(255, 255, 255));
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 4;
		frmGestionAnimal.getContentPane().add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 0;
		gbc_lblCouleur.gridy = 5;
		frmGestionAnimal.getContentPane().add(lblCouleur, gbc_lblCouleur);
		
		textField_11 = new JTextField();
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.gridwidth = 2;
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 5;
		frmGestionAnimal.getContentPane().add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Esp\u00E8ce");
		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		frmGestionAnimal.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		String [] Espece = {"Chat", "Chien", "Serpent", "Souris", "Lapin"};
		JComboBox comboBox = new JComboBox(Espece);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		comboBox.setBackground(new Color(255, 255, 255));
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		frmGestionAnimal.getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Race");
		lblNewLabel_2.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 6;
		frmGestionAnimal.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		String [] race = selectAnimal.getRace(comboBox.getSelectedItem().toString());
		JComboBox comboBox_1 = new JComboBox(race);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		comboBox_1.setBackground(new Color(255, 255, 255));
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 6;
		frmGestionAnimal.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblTatouage = new JLabel("Tatouage");
		lblTatouage.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblTatouage = new GridBagConstraints();
		gbc_lblTatouage.insets = new Insets(0, 0, 0, 5);
		gbc_lblTatouage.gridx = 0;
		gbc_lblTatouage.gridy = 7;
		frmGestionAnimal.getContentPane().add(lblTatouage, gbc_lblTatouage);
		
		textField_12 = new JTextField();
		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
		gbc_textField_12.gridwidth = 2;
		gbc_textField_12.insets = new Insets(0, 0, 0, 5);
		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_12.gridx = 1;
		gbc_textField_12.gridy = 7;
		frmGestionAnimal.getContentPane().add(textField_12, gbc_textField_12);
		textField_12.setColumns(10);
	}
}
