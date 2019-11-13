package salaDeCine;

public class SalaDeCine {
	
	private int numeroDeSala;
	private Pelicula pelicula;
	private int capacidad = 20;
	private int ventas;
	private String[][] butacas = {{"1","2","3","4","5"},{"6","7","8","9","10"},{"11","12","13","14","15"},{"16","17","18","19","20"}};
	private double recaudacion;
	
	public SalaDeCine(Pelicula peli) {
		this.pelicula = peli;
	}

	public String[][] getButacas() {
		return butacas;
	}

	public void setButacas(String[][] butacas) {
		this.butacas = butacas;
	}

	
	public double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}

	
	
	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula peli) {
		this.pelicula = peli;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public static void main(String[] args) {
		

	}

}
