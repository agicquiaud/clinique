package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerAnimauxSingleton;
import fr.eni.clinique.ihm.controller.ControllerClients;
import fr.eni.clinique.ihm.controller.ControllerClientsSingleton;

public class WindowClients implements Observer {

	private JFrame frame;
	private DefaultTableModel tableModel;
	private JTable table_1;
	private JTable table_2;
	private ControllerClients controllerclient;
	private ControllerAnimaux controlleranimal;
	private JTextField textFieldSearch;
	private final String[] ENTETES_CLIENT = { "CodeClient", "Prenom", "Nom", "Code Postal", "Ville" };
	private final String[] ENTETES_ANIMAL = { "CodeAnimal", "Nom", "Sexe", "Couleur", "Race", "Espece" };

	public WindowClients() {
		
		controllerclient = ControllerClientsSingleton.getinstance();
		((Observable) controllerclient).addObserver(this);
		controlleranimal = ControllerAnimauxSingleton.getinstance();
		((Observable) controlleranimal).addObserver(this);
		frame = new JFrame();
		frame.setTitle("Gestion Clients");
		frame.setSize(850, 485);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel bckground = new JLabel(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/backgroung.jpg"));
		frame.setContentPane(bckground);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnConnexion = new JMenu("Menu");
		menuBar.add(mnConnexion);
		
		JMenuItem mntmDeconnexion = new JMenuItem("Deconnexion");
		mnConnexion.add(mntmDeconnexion);
		
		JMenuItem mntmRetour = new JMenuItem("Retour");
		mnConnexion.add(mntmRetour);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 23, 66, 135, 0, 0, 53, 70, 83, 104, 69, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0, 0, 232, 38, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblClient = new JLabel("Client :");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 1;
		gbc_lblClient.gridy = 1;
		frame.getContentPane().add(lblClient, gbc_lblClient);

		textFieldSearch = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textFieldSearch, gbc_textField);
		textFieldSearch.setColumns(10);

		JButton btnSearchClient = new JButton("Rechercher");
		GridBagConstraints gbc_btnSearchClient = new GridBagConstraints();
		gbc_btnSearchClient.gridwidth = 2;
		gbc_btnSearchClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchClient.gridx = 3;
		gbc_btnSearchClient.gridy = 1;
		frame.getContentPane().add(btnSearchClient, gbc_btnSearchClient);

		JButton btnAddClient = new JButton("Ajouter");
		GridBagConstraints gbc_btnAddClient = new GridBagConstraints();
		gbc_btnAddClient.fill = GridBagConstraints.VERTICAL;
		gbc_btnAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddClient.gridx = 5;
		gbc_btnAddClient.gridy = 1;
		frame.getContentPane().add(btnAddClient, gbc_btnAddClient);

		JButton btnDeleteClient = new JButton("Supprimer");
		GridBagConstraints gbc_btnDeleteClient = new GridBagConstraints();
		gbc_btnDeleteClient.anchor = GridBagConstraints.WEST;
		gbc_btnDeleteClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteClient.gridx = 6;
		gbc_btnDeleteClient.gridy = 1;
		frame.getContentPane().add(btnDeleteClient, gbc_btnDeleteClient);

		JButton btnEditClient = new JButton("Editer");
		GridBagConstraints gbc_btnEditClient = new GridBagConstraints();
		gbc_btnEditClient.gridwidth = 2;
		gbc_btnEditClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditClient.gridx = 8;
		gbc_btnEditClient.gridy = 1;
		frame.getContentPane().add(btnEditClient, gbc_btnEditClient);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		Object[][] donnee1 = controllerclient.getList();
		table_1 = new JTable();
		tableModel = new DefaultTableModel(donnee1, ENTETES_CLIENT) { // nouveau
																		// model
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_1.setModel(tableModel);
		scrollPane.setViewportView(table_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 6;
		gbc_scrollPane_1.gridy = 3;
		frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		Object[][] donnee2 = new Object[0][0];
		table_2 = new JTable(donnee2, ENTETES_ANIMAL);
		scrollPane_1.setViewportView(table_2);

		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 4;
		frame.getContentPane().add(lblError, gbc_lblError);

		JLabel lblAnimaux = new JLabel("Animal : ");
		GridBagConstraints gbc_lblAnimaux = new GridBagConstraints();
		gbc_lblAnimaux.insets = new Insets(0, 0, 0, 5);
		gbc_lblAnimaux.gridx = 5;
		gbc_lblAnimaux.gridy = 4;
		frame.getContentPane().add(lblAnimaux, gbc_lblAnimaux);

		JButton btnAddAnimal = new JButton("Ajouter");
		btnAddAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAddAnimal = new GridBagConstraints();
		gbc_btnAddAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddAnimal.gridx = 6;
		gbc_btnAddAnimal.gridy = 4;
		frame.getContentPane().add(btnAddAnimal, gbc_btnAddAnimal);

		JButton btnDeleteAnimal = new JButton("Supprimer");
		GridBagConstraints gbc_btnDeleteAnimal = new GridBagConstraints();
		gbc_btnDeleteAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteAnimal.gridx = 7;
		gbc_btnDeleteAnimal.gridy = 4;
		frame.getContentPane().add(btnDeleteAnimal, gbc_btnDeleteAnimal);

		JButton btnEditAnimal = new JButton("Editer");
		GridBagConstraints gbc_btnEditAnimal = new GridBagConstraints();
		gbc_btnEditAnimal.gridwidth = 2;
		gbc_btnEditAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditAnimal.gridx = 8;
		gbc_btnEditAnimal.gridy = 4;
		frame.getContentPane().add(btnEditAnimal, gbc_btnEditAnimal);

		frame.setVisible(true);
		
		//Actions Listeners
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					// fait une maj du tableau avec les nouvelles données
					setUpTableAnimal(controlleranimal.getListByClient(
							table_1.getValueAt(table_1.getSelectedRow(), 0).toString()), ENTETES_ANIMAL);
				} catch (Exception err) {
					setUpTableAnimal(null, ENTETES_ANIMAL);
				}
			}
		});
		
		mntmDeconnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new WindowLogin();
			}
		});
		
		mntmRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new WindowAccueilSecretaire();
			}
		});

		// Boutons Gestion Client

		btnSearchClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				if (textFieldSearch.getText().equals("")) {
					setUpTableClient(controllerclient.getList(), ENTETES_CLIENT);
				} else {
					setUpTableClient(controllerclient.getClient(textFieldSearch.getText()), ENTETES_CLIENT);
				}
			}
		});

		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				new WindowAddClient();
			}
		});

		btnDeleteClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowRemove(
							controllerclient.getClientbyId(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun client selectionné pour le supprimer");
				}

			}
		});

		btnEditClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowEditClient(
							controllerclient.getClientbyId(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun client selectionné pour le modifier");
				}
			}
		});

		// Boutons Gestion Animal

		btnAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowAddAnimal(
							controllerclient.getClientbyId(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun client selectionné pour luil ajouter un animal");
				}
			}
		});

		btnEditAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table_2.getSelectedRow() == -1 && table_2.getSelectedColumn() == -1) {
					lblError.setText("Aucun animal sélectionner !");
				} else {
					lblError.setText("");
					new WindowEditAnimal(
							controlleranimal.getAnimalById(table_2.getValueAt(table_2.getSelectedRow(), 0).toString()));
				}

			}
		});

		btnDeleteAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowRemove(
							controlleranimal.getAnimalById(table_2.getValueAt(table_2.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun animal selectionné pour le modifier");
				}
			}
		});
	}

	void setUpTableClient(Object[][] data, String[] entetes) {
		tableModel = new DefaultTableModel(data, entetes) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_1.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	void setUpTableAnimal(Object[][] data, String[] entetes) {
		tableModel = new DefaultTableModel(data, entetes) { // nouveau model
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_2.setModel(tableModel);
		tableModel.fireTableDataChanged(); // maj tableau
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Clients) {
			setUpTableClient(controllerclient.getList(), ENTETES_CLIENT);
		} else if (arg instanceof Animaux) {
			setUpTableAnimal(
					controlleranimal.getListByClient(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()),
					ENTETES_ANIMAL);
		}
	}
}
