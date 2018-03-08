package fr.eni.clinique.bll;

public class ClientsUtilSingleton {
	private static ClientsUtil instance;
	
	private ClientsUtilSingleton(){}
	public static ClientsUtil getinstance(){
		if(instance == null){
			instance = new ClientsUtilImpl();
		}
		return instance;
	}
}
