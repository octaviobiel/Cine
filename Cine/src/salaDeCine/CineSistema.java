package salaDeCine;

import java.util.Scanner;

public class CineSistema {

	public static int ingreso() {
		Scanner ingreso = new Scanner(System.in);
		System.out.println("Bienvenido al sistema de ventas de Cinemita S.A. ingrese un numero para entrar al sistema como: ");
		System.out.println("1.Usuario 2.Administrador 3.Salir del sistema");
		return ingreso.nextInt();
	}
	
	public static String operacionUsuario(SalaDeCine sala1, SalaDeCine sala2, SalaDeCine sala3) {
		Scanner ingresoC = new Scanner(System.in);
		Scanner ingresoC2 = new Scanner(System.in);
		String respuesta;
		System.out.println("¿Que pelicula desea ver? 1.El bromas(+18) 2.Esperando a la carroza(ATP) 3.Avengers endgame(+13)");
		System.out.println("Butacas disponibles: Sala1: "+sala1.getCapacidad()+" Sala2: "+sala2.getCapacidad()+" Sala3: "+sala3.getCapacidad());
		int pelicula = ingresoC.nextInt();
		switch (pelicula) {
			case 1:
				Ventas.venderEntradas(sala1);
				break;
			case 2:
				Ventas.venderEntradas(sala2);
				break;
			case 3:
				Ventas.venderEntradas(sala3);
				break;
			default:
				System.out.println("Ha ingresado un numero invalido");
				break;
		}
		do {
		System.out.println("¿Desea seguir comprando? Opciones:  si  no");
		respuesta = ingresoC2.nextLine();
		}while(!respuesta.equals("si")&&!respuesta.equals("no"));
		return respuesta;
	}
	
	public static void operacionAdmin() {
		int opcion;
		Scanner ingresoU = new Scanner(System.in);
		Scanner ingresoP = new Scanner(System.in);
		Scanner ingresoN = new Scanner(System.in);
		System.out.println("Ha ingresado a la consola de administrador. Ingrese su usuario y contraseña");
		String usuario = ingresoU.nextLine();
		String pass = ingresoP.nextLine();
		if(Administradores.getMapita().get(usuario).getPass().equals(pass)) {
			System.out.println("Bienvenido "+usuario+" ¿Que desea hacer?");
			do {
				
			System.out.println("1.Ver recaudacion total 2.Ver recaudacion por pelicula 3.Preguntarle a Javier el miercoles que onda 4.Salir");
			opcion = ingresoN.nextInt();
			switch(opcion) {
				case 1:
					System.out.println("Recaudacion total "+Ventas.getRecaudacionTotal());
					break;
				case 2:
					for(int i=0; i<3; i++) {
						System.out.println(Cine.getFunciones()[i].getPelicula().getNombre()+" - $"+Cine.getFunciones()[i].getRecaudacion());
					}
					break;
				case 3:
					System.out.println("Por favor Javier orientame");
					break;
				case 4:
					System.out.println("Ha salido de la consola de administrador exitosamente");
					break;
				default:
					System.out.println("Ha ingresado un numero incorrecto");
			}	
			} while(opcion!=4);
		}
	}
	
	public static void sistemaPrincipal(SalaDeCine[] funciones) {
		
		double recaudacion = 0;
		String respuesta;
		
		Cine.cargarFunciones();
		
		int operacion = ingreso();
		
		while(operacion!=3) {
			if(operacion==1) {
				do {
					
				respuesta = operacionUsuario(funciones[0], funciones[1], funciones[2]);
		
				}while(funciones[0].getCapacidad()+funciones[1].getCapacidad()+funciones[2].getCapacidad()!=0 && respuesta.equals("si"));
			} else { 
				
				operacionAdmin();	
				
			}
		operacion=ingreso();
		}
		System.out.println("Gracias por utilizar el sistema de Cinemita S.A.");
	}
		
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
