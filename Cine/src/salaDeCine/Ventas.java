package salaDeCine;

import java.util.Scanner;

public class Ventas {

	private static double recaudacionTotal = 0;
	private static int metodoPago;
	private static int cuotas;
	private static int cantEntradas;
	
	public double getRecaudacion() {
		return recaudacionTotal;
	}


	public void setRecaudacion(double recaudacion) {
		this.recaudacionTotal = recaudacion;
	}
	
	
	
	public static int getCantEntradas() {
		return cantEntradas;
	}


	public static void setCantEntradas(int cantEntradas) {
		Ventas.cantEntradas = cantEntradas;
	}


	public static double getRecaudacionTotal() {
		return recaudacionTotal;
	}


	public static void setRecaudacionTotal(double recaudacionTotal) {
		Ventas.recaudacionTotal = recaudacionTotal;
	}


	public static int getMetodoPago() {
		return metodoPago;
	}


	public static void setMetodoPago(int metodoPago) {
		Ventas.metodoPago = metodoPago;
	}


	public static int getCuotas() {
		return cuotas;
	}


	public static void setCuotas(int cuotas) {
		Ventas.cuotas = cuotas;
	}


	public static void venderEntradas(SalaDeCine salita) {
		double recaudacion = 0;
		Scanner ingreso = new Scanner(System.in);
		Scanner ingreso2 = new Scanner(System.in);
		Scanner ingreso3 = new Scanner(System.in);
		
		boolean capacidad = verificarCapacidad(salita);
		
		
		
		int lugares[] = new int[cantEntradas]; 
		
		if(capacidad) {
			cuotas = medioDePago();
			recaudacion = verificarEdadYPrecio(salita);
			if(recaudacion>0) {
				gestionarButacas(salita, lugares);
				System.out.println("Asi quedo la sala");
				mostrarButacas(salita);
				venta(salita, recaudacion, lugares);
			}
		}
		
	}

	
	public static int calcularPrecio(int edad) {
		
		int precio;
		
		if(edad<18) {
			precio = 15;
		} else { if (edad<65) {
			precio = 20;
		} else { precio = 18;}
		}
		return precio;	
	}
	
	public static double calcularPrecioConTarjeta(int edad, int cuotas) {
		double interes = 1+0.05*cuotas;
		double precio;
		
		if(edad<18) {
			precio = 15*interes;
		} else {if (edad<65) {
			precio = 20*interes;
		} else { precio = 18*interes;}
		}
		return precio;
	}
	
	public static boolean verificarCapacidad(SalaDeCine salita) {
		Scanner ingreso = new Scanner(System.in);
		boolean capacidad;
		System.out.println("Ingrese la cantidad de entradas que desea comprar");
		do {
		cantEntradas = ingreso.nextInt();
		if(cantEntradas <= salita.getCapacidad()) {
			if(cantEntradas>0) {
			System.out.println("Hay capacidad disponible");
			capacidad = true;
			} else {
				System.out.println("Ha ingresado un numero invalido. Por favor ingrese la cantidad de entradas que desea");
				capacidad = false;
			}
		} else { System.out.println("No hay capacidad suficiente en la sala");
		capacidad = false;
		}
		
		}while(cantEntradas<=0);
		return capacidad;
	}
	
	public static double verificarEdadYPrecio(SalaDeCine salita) {
		Scanner ingresito = new Scanner(System.in);
		double ventas = 0;
		int edad;
		System.out.println("Ingrese la edad de las personas de cada entrada");
		for(int i=0; i<cantEntradas ; i++) {
			do {
			edad = ingresito.nextInt();
			if(edad<0) {
				System.out.println("Edad invalida");
			}
			}while(edad<0);
			if(edad < salita.getPelicula().getEdadMinima()) {
				System.out.println("Esta persona no puede ingresar a la funcion");
				return 0;
			} else { if(metodoPago==1) {
				ventas+=calcularPrecio(edad);
				} else { ventas+=calcularPrecioConTarjeta(edad, cuotas);}
			}
		}
		return ventas;
	}
		
	public static void mostrarButacas(SalaDeCine salita) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(salita.getButacas()[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int ocuparButacas(SalaDeCine salita, int asiento, int []lugares) {
		int contador = 1;
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				if(contador == asiento) {
					if(!salita.getButacas()[i][j].equals("X")) {
					salita.getButacas()[i][j] = "X";
					System.out.println("Butaca seleccionada exitosamente");
					return 1;
				} else { System.out.println("Esta butaca ya se encuentra ocupada");
				}
			}
				contador++;
		}
		}
		return 0;
	}
	
	public static void desocuparButacas(SalaDeCine salita, int asiento) {
		int contador = 1;
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				if(contador == asiento) {
					if(salita.getButacas()[i][j].equals("X")) {
						salita.getButacas()[i][j] = Integer.toString(asiento);
					}
				}
				contador++;
			}
		}	
	}
	
	public static int medioDePago() {
		Scanner ingreso = new Scanner(System.in);
		int cuotas = -1;
		
		do {
			System.out.println("Ingrese medio de pago: 1.Efectivo 2.Credito. Tenga en cuenta que con credito tendra un 5% de interes mensual");
			int metodoPago = ingreso.nextInt();
			switch (metodoPago) {
				case 1:
					cuotas = 0;
					break;
				case 2:
					System.out.println("Ingrese cantidad de cuotas, hay 3, 6 y 12");
					cuotas = ingreso.nextInt();
					break;
				default:
					System.out.println("Ha ingresado una opcion invalida");
					break;
			}
		}while(cuotas==-1);
		return cuotas;
	}
	
	public static void gestionarButacas(SalaDeCine salita, int []lugares) {
		Scanner ingreso = new Scanner(System.in);
		System.out.println("Seleccione las butacas donde desea sentarse");
		int pos = 0;
		mostrarButacas(salita);
		int butaquitas = 0;
		int butacotas = 0;
		do {
			int asiento = ingreso.nextInt();
			if(asiento<=20&&asiento>0) {
			butaquitas+=ocuparButacas(salita, asiento, lugares);
			if(butaquitas!=butacotas) {
				lugares[pos] = asiento;
				pos++;
				butacotas = butaquitas;
			}
			} else {System.out.println("Ha ingresado una butaca incorrecta, por favor reingrese la butaca");}
			
		}while(butaquitas<cantEntradas);
	}
	
	public static double venta(SalaDeCine salita, double recaudacion, int[]lugares) {
		Scanner ingreso = new Scanner(System.in);
		String respuesta;
		if(recaudacion!=0) {
			do {
			System.out.println("¿Desea comprar las entradas?");
			respuesta = ingreso.nextLine();
			}while(!respuesta.equals("si")&&!respuesta.equals("no"));
			if(respuesta.equals("si")){
				salita.setVentas(cantEntradas);
				salita.setCapacidad(salita.getCapacidad()-cantEntradas);
				System.out.println("Entradas compradas exitosamente, precio total de la operacion: "+recaudacion);
				recaudacionTotal+=recaudacion;
				salita.setRecaudacion(recaudacion);;
			}
		}
		for(int i=0; i<cantEntradas; i++) {
		desocuparButacas(salita, lugares[i]);
		}
		return 0;
			
	}
	
	public static void main(String[] args) {
		
	}

}
