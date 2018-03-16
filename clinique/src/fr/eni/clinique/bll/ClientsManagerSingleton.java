package fr.eni.clinique.bll;

public class ClientsManagerSingleton {
	private static ClientsManager instance;
	
	private ClientsManagerSingleton(){}
	public static ClientsManager getinstance(){
		if(instance == null){
			instance = new ClientsManagerImpl();
		}
		return instance;
	}
}
