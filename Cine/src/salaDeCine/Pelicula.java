package salaDeCine;

public class Pelicula{

	private String nombre;
	private int edadMinima;
	
	public Pelicula(String nom, int edad) {
		this.nombre = nom;
		this.edadMinima = edad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public static void main(String[] args) {
		

	}

}
