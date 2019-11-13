package salaDeCine;

public class Administrador {
	private String user;
	private String pass;
	public Administrador(String usuario, String contrasenia) {
		user = usuario;
		pass = contrasenia;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
