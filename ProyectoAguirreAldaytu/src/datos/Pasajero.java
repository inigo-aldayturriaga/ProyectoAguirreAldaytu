package datos;
public class Pasajero extends Persona {
	int numeroBillete;
	ClasePasajero clase;

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
