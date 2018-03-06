package fr.eni.clinique.ihm.login;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bll.Personnels;
import fr.eni.clinique.bll.PersonnelsSingleton;
import fr.eni.clinique.bo.User;

public class ControllerPersonnels {
	
	private static Personnels mger;
	private List<User> liste;
	
	public ControllerPersonnels(){
		mger = PersonnelsSingleton.getInstance();
	}
	
	public void addPersonnel(User p){
		mger.add(p);
	}
	
	public void ArchivePersonnel(User p){
		mger.archive(p);
	}
	
	public List<User> getListe(){
		liste = mger.getAll();
		List<User> listereturn = new ArrayList<User>();
		for (User user : liste) {
			if(user.getHide() == 0){
				listereturn.add(user);
			}
		}
		return listereturn;		
	}
	
	public String[] getList(){
		liste = mger.getAll();
		String str;
		String pass = null;
		for (User user : liste) {
			str = user.getLogin();
			for(int i = 0; i<user.getPassword().length(); i++){
				pass = pass + "*";
			}
			str = str + pass;
			str = str + user.getType();
		}
		return null;
	}
	
	public void resetMotDePasse(User p){
		mger.resetMotDePasse(p);
	}
	
	
}
