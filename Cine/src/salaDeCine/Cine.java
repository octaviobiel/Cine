package salaDeCine;

import java.util.Scanner;

public class Cine {
	
	private static SalaDeCine[] funciones = new SalaDeCine[3];
	
	public static SalaDeCine[] getFunciones() {
		return funciones;
	}

	public static void setFunciones(SalaDeCine[] funciones) {
		Cine.funciones = funciones;
	}

	public static void cargarFunciones() {
		Pelicula peli1 = new Pelicula("El bromas", 18);
		Pelicula peli2 = new Pelicula("Esperando a la carroza", 0);
		Pelicula peli3 = new Pelicula("Avengers endgame", 13);

		SalaDeCine sala1 = new SalaDeCine(peli1);
		SalaDeCine sala2 = new SalaDeCine(peli2);
		SalaDeCine sala3 = new SalaDeCine(peli3);
		
		funciones[0] = sala1;
		funciones[1] = sala2;
		funciones[2] = sala3;
	}
	
	public static void main(String[] args) {
		
		CineSistema.sistemaPrincipal(funciones);
	}
}