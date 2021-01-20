package datos;

import java.util.ArrayList;

public abstract class Tripulacion extends Persona {
	int anyosExperiencia;//Años que lleva volando cada tripulante
	int vuelosRealizados;//Numero de vuelos realizados por cada tripulante
	String nacionalidad;
	int tipoTripulacion;//Si es 0 es piloto si es 1 es azafata
	

	
	public Tripulacion(String nombre, String apellido, int edad, String dni) {
		super(nombre, apellido, edad, dni);
		// TODO Auto-generated constructor stub
	}


	public Tripulacion(String nombre, String apellido, int edad, String dni,int anyosExperiencia,int vuelosRealizados,String nacionalidad,int tipoTripulacion) {
		super(nombre, apellido, edad, dni);
		this.anyosExperiencia = anyosExperiencia;
		this.vuelosRealizados = vuelosRealizados;
		this.nacionalidad = nacionalidad;
		this.tipoTripulacion = tipoTripulacion;
	}


	public int getTipoTripulacion() {
		return tipoTripulacion;
	}


	public void setTipoTripulacion(int tipoTripulacion) {
		this.tipoTripulacion = tipoTripulacion;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionaldidad(String nacionaldidad) {
		this.nacionalidad = nacionaldidad;
	}
	public int getAnyosExperiencia() {
		return anyosExperiencia;
	}
	public void setAnyosExperiencia(int anyosExperiencia) {
		this.anyosExperiencia = anyosExperiencia;
	}
	public int getVuelosRealizados() {
		return vuelosRealizados;
	}
	public void setVuelosRealizados(int vuelosRealizados) {
		this.vuelosRealizados = vuelosRealizados;
	}
	
	
}

