package datos;

import java.util.ArrayList;

public abstract class Tripulacion extends Persona {
	int anyosExperiencia;//Años que lleva volando cada tripulante
	int vuelosRealizados;//Numero de vuelos realizados por cada tripulante
	String nacionalidad;//Nacionalidad de la persona
	

	
	public Tripulacion(String nombre, String apellido, int edad, String dni) {
		super(nombre, apellido, edad, dni);
		// TODO Auto-generated constructor stub
	}


	public Tripulacion(String nombre, String apellido, int edad, String dni,int anyosExperiencia,int vuelosRealizados,String nacionalidad) {
		super(nombre, apellido, edad, dni);
		this.anyosExperiencia = anyosExperiencia;
		this.vuelosRealizados = vuelosRealizados;
		this.nacionalidad = nacionalidad;
	}
	



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getNacionalidad() {
		return nacionalidad;
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

