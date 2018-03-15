package fr.eni.clinique.ihm.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowAccueilSecretaire {
	
	private JFrame frame;

		public WindowAccueilSecretaire(){
			frame = new JFrame();
			
			frame.setTitle("Accueil Rendez-vous");
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
			desktopPane.setBackground(new Color(245,244,239));
			GridBagConstraints gbc_desktopPane = new GridBagConstraints();
			gbc_desktopPane.fill = GridBagConstraints.BOTH;
			gbc_desktopPane.gridx = 0;
			gbc_desktopPane.gridy = 0;
			frame.getContentPane().add(desktopPane, gbc_desktopPane);
			
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.setBounds(134, 407, 65, 48);
			desktopPane.add(btnNewButton_2);
			btnNewButton_2.setMaximumSize(new Dimension(30, 30));
			btnNewButton_2.setBackground(Color.white);
			btnNewButton_2.setIcon(new ImageIcon("Y:\\RL_AG_LV\\cancel.png"));
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("Y:\\RL_AG_LV\\logo.jpg"));
			lblNewLabel.setBounds(117, 11, 90, 96);
			desktopPane.add(lblNewLabel);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(94, 141, 229)); //gestion rdv
			panel.setBounds(0, 122, 332, 39);
			desktopPane.add(panel);
			
			JLabel lblGestionRendezvous = new JLabel("GESTION RENDEZ-VOUS");
			panel.add(lblGestionRendezvous);
			lblGestionRendezvous.setBackground(Color.CYAN);
			lblGestionRendezvous.setForeground(Color.WHITE);
			lblGestionRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 17));
			
			JPanel panel_1 = new JPanel(); //fond logo
			panel_1.setBackground(new Color(109, 159, 254));
			panel_1.setBounds(0, 0, 332, 123);
			desktopPane.add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(94, 141, 229));
			panel_2.setBounds(0, 400, 332, 63);
			desktopPane.add(panel_2);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("Y:\\RL_AG_LV\\flat-calendar-redi.jpg"));
			btnNewButton.setBounds(31, 202, 117, 123);
			desktopPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon("Y:\\RL_AG_LV\\Client.jpg"));
			btnNewButton_1.setBounds(185, 202, 117, 123);
			desktopPane.add(btnNewButton_1);
			
			JLabel lblPriseDeRendezvous = new JLabel("Prise Rendez-vous");
			lblPriseDeRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
			lblPriseDeRendezvous.setBounds(31, 336, 127, 20);
			desktopPane.add(lblPriseDeRendezvous);
			
			JLabel lblNewLabel_1 = new JLabel("Gestion Clients");
			lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
			lblNewLabel_1.setBounds(195, 339, 117, 14);
			desktopPane.add(lblNewLabel_1);
			
			btnNewButton_1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					WindowClients windowClients = new WindowClients();
				}
			});
			
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					WindowPriseDeRendezVous windowPriseDeRendezVous = new WindowPriseDeRendezVous();
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
