package fr.eni.clinique.bll;

public class ClientsSingleton {
	private static Clients instance;
	
	private ClientsSingleton(){}
	public static Clients getinstance(){
		if(instance == null){
			instance = new ClientsImpl();
		}
		return instance;
	}
}
