package fr.eni.clinique.bll;

import fr.eni.clinique.bo.User;

public interface IPersonnels {
	public void add(User p);
	public void archive(User p);
	public void update(User p);
	public void read (User p);
}
