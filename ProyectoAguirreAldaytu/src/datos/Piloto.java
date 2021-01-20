package datos;
public class Piloto extends Tripulacion{
	TipoPiloto tipo;//De tipo comercial o privado
	
	
	
	public Piloto(String nombre, String apellido, int edad, String dni, int anyosExperiencia,
			int vuelosRealizados, String nacionalidad, int tipoTripulacion,TipoPiloto tipo) {
		super(nombre, apellido, edad, dni, anyosExperiencia, vuelosRealizados, nacionalidad, tipoTripulacion);
		this.tipo = tipo;
	}
	
	public TipoPiloto getTipo() {
		return tipo;
	}
	public void setTipo(TipoPiloto tipo) {
		this.tipo = tipo;
	}

	
	
}
