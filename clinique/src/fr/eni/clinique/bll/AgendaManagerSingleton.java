package fr.eni.clinique.bll;


public class AgendaManagerSingleton {
	private static AgendaManager instance;

	private AgendaManagerSingleton() {
	}

	public static AgendaManager getinstance() {
		if (instance == null) {
			instance = new AgendaManagerImpl();
		}
		return instance;
	}
}
