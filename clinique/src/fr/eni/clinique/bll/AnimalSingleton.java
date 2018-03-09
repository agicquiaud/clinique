package fr.eni.clinique.bll;

public class AnimalSingleton {
	private static Animal instance;
	private AnimalSingleton(){}
	public static Animal getinstance(){
		if(instance == null){
			instance = new AnimalImpl();
		}
		return instance;
	}
}
