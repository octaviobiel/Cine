package salaDeCine;

import java.util.HashMap;

public class Administradores {
	private static HashMap<String,Administrador> mapita;
	static {
		mapita = new HashMap<String,Administrador>();
		mapita.put("octa", new Administrador("octa","lalala"));
		mapita.put("javote", new Administrador("javote","blublu"));
	}
	public static HashMap<String, Administrador> getMapita() {
		return mapita;
	}
	public static void setMapita(HashMap<String, Administrador> mapita) {
		Administradores.mapita = mapita;
	}
	

}
