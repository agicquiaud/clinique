package fr.eni.clinique.bll;

public class AnimalSingleton {
	private Animal instance;
	private AnimalSingleton(){}
	public Animal getinstance(){
		if(instance == null){
			instance = new AnimalImpl();
		}
		return instance;
	}
}
