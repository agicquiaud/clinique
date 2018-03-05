package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.User;

public class AppliTestDAL {

	public static void main(String[] args) {

		// D�claration et instanciation de la DAO
		UserDAO userDAO = DAOFactory.getUserDAO();

		// Instanciation du jeu d'essai
		User u1 = new User("Edmond", "Bosapin", "adm");
		User u2 = new User("M�lanie", "Malalanich", "vet");
		User u3 = new User("Elisabeth", "Abondieu", "sec");

		System.out.println("Ajout des Utilisateurs... ");
		// TODO...
		try {
			userDAO.insert(u1);
			System.out.println("Utilisateur ajout�  : " + u1.toString());
			userDAO.insert(u2);
			System.out.println("Utilisateur ajout�  : " + u2.toString());
			userDAO.insert(u3);
			System.out.println("Utilisateur ajout�  : " + u3.toString());

			// S�lection de l'utilisateur par id
			// TODO...
			User u = userDAO.selectById(u2.getId());
			System.out.println("S�lection de l'utilisateur par id  : " + u.toString());

			// S�lection de tous les utilisateurs
			// TODO...
			List<User> users = userDAO.selectAll();
			System.out.println("S�lection de tous les utilisateurs  : " + users.toString());

			// Modification d'un utilisateur
			// TODO...
			System.out.println("Modification d'un utilisateur  : ");
			System.out.println("Utilisateur avant modification : " + u1.toString());
			u1.setLogin("Benoit");
			u1.setPassword("DeCajoux");
			u1.setType("adm");
			userDAO.update(u1);
			System.out.println("Utilisateur apr�s modification  : " + u1.toString());

			// Suppression d'un utilisateur
			// TODO...
			System.out.println("Suppression de l'utilisateur  : " + u1.toString());
			userDAO.delete(u1.getId());
			users = userDAO.selectAll();
			// System.out.println("Liste des utilisateur apr�s suppression : " +
			// users.toString() );
			System.out.println("Liste des utilisateurs apr�s suppression : ");
			StringBuffer sb = new StringBuffer();
			for (User user : users) {
				sb.append("Utilisateur [id=");
				sb.append(user.getId());
				sb.append(", type=");
				sb.append(user.getType()).append("]\n");
			}
			System.out.println(sb.toString());
			System.out.println("---------------------------------------------------------------");

		} catch (DALException e) {
			e.printStackTrace();
		}

	}

}
