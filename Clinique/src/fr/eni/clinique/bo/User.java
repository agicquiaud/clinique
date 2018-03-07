package fr.eni.clinique.bo;

public class User {

	private Integer id;
	private String login;
	private String password;
	private String type;
	private Boolean hide;

	public User(Integer id, String login, String password, String type, Boolean hide) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.type = type;
		this.hide = hide;
	}

	public User() {

	}

	public User(Integer id, String login, String password, String type) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.type = type;
	}

	public User(String login, String password, String type, Boolean hide) {
		super();
		this.login = login;
		this.password = password;
		this.type = type;
		this.hide = hide;
	}

	public Boolean getHide() {
		return hide;
	}

	public void setHide(Boolean hide) {
		this.hide = hide;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", type=" + type + "]";
	}

}
