package datos;
public class Pasajero extends Persona {
	String idLog;//Identificador para logearse 
	int numeroBillete;//Numero del boleto del viaje para identificarle
	ClasePasajero clase;//A partir de la enumeracion ClasePasajero, la clase del pasajero
	String contrasenia;//Contrasenia del usuario para entrar en la app
	
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
