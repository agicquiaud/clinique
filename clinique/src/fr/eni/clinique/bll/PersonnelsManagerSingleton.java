package fr.eni.clinique.bll;

public class PersonnelsManagerSingleton {
	private static PersonnelsManager instance;
	
	private PersonnelsManagerSingleton(){
		
	}
	
	public static PersonnelsManager getInstance(){
		if(instance == null){
			instance = new PersonnelsManagerImpl();	
		}
		return instance;
	}
}
