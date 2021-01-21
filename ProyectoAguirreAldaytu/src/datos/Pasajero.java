package datos;
public class Pasajero extends Persona {
	int numeroBillete;//Numero del boleto del viaje para identificarle
	ClasePasajero clase;//A partir de la enumeracion ClasePasajero, la clase del pasajero
	String contrasenia;//Contrasenia del usuario para entrar en la app
	

	public Pasajero(String nombre, String apellido, int edad, String dni,int numeroBillete,ClasePasajero clase,String contrasenia) {
		super(nombre, apellido, edad, dni);
		this.numeroBillete = numeroBillete;
		this.clase = clase;
		this.contrasenia = contrasenia;
		
	}
	
	public Pasajero(String nombre,String contrasenia) {
		super(nombre);
		this.contrasenia = contrasenia;
	}
		
	
	public Pasajero() {
		// TODO Auto-generated constructor stub
	}

	//Getters y setters
	public int getNumeroBillete() {
		return numeroBillete;
	}

	public void setNumeroBillete(int numeroBillete) {
		this.numeroBillete = numeroBillete;
	}
	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public ClasePasajero getClase() {
		return clase;
	}

	public void setClase(ClasePasajero clase) {
		this.clase = clase;
	}
	
	
	@Override
	public String toString() {
		return "Pasajero [numeroBillete=" + numeroBillete + "]";
	}
	
	
	

}
