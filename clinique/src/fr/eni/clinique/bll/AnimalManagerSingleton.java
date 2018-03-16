package fr.eni.clinique.bll;

public class AnimalManagerSingleton {
	private static AnimalManager instance;
	private AnimalManagerSingleton(){}
	public static AnimalManager getinstance(){
		if(instance == null){
			instance = new AnimalManagerImpl();
		}
		return instance;
	}
}
