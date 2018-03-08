package fr.eni.clinique.bll;

public class LoginManagerSingleton {
	private static LoginManager instance;
	
	private LoginManagerSingleton() {
		
	}
	
	public static LoginManager getInstance() {
		if(instance == null) {
			instance = new LoginManagerImpl();
		}
		return instance;
	}
}
