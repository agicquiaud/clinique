package fr.eni.clinique.bll;

public class PersonnelsSingleton {
	private static Personnels instance;
	
	private PersonnelsSingleton(){
		
	}
	
	public static Personnels getInstance(){
		if(instance == null){
			instance = new PersonnelsImpl();	
		}
		return instance;
	}
}
