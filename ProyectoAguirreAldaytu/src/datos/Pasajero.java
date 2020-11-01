package datos;
public class Pasajero extends Persona {
	int numeroBillete;//Numero del boleto del viaje para identificarle
	ClasePasajero clase;//A partir de la enumeracion ClasePasajero, la clase del pasajero

	//Getters y setters
	public int getNumeroBillete() {
		return numeroBillete;
	}

	public void setNumeroBillete(int numeroBillete) {
		this.numeroBillete = numeroBillete;
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
