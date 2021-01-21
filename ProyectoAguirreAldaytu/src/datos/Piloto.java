package datos;
public class Piloto extends Tripulacion{
	TipoPiloto tipo;//De tipo comercial o privado
	
	
	
	public Piloto(String nombre, String apellido, int edad, String dni, int anyosExperiencia,
			int vuelosRealizados, String nacionalidad,TipoPiloto tipo) {
		super(nombre, apellido, edad, dni, anyosExperiencia, vuelosRealizados, nacionalidad);
		this.tipo = tipo;
	}
	

	public Piloto() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return " Piloto ["+nombre+" "+apellido+" "+"anyosExperiencia=" + anyosExperiencia +", vuelosRealizados=" + vuelosRealizados+" , nacionalidad=" + nacionalidad+"]";
	}


	public TipoPiloto getTipo() {
		return tipo;
	}
	public void setTipo(TipoPiloto tipo) {
		this.tipo = tipo;
	}
	

	
	
}
