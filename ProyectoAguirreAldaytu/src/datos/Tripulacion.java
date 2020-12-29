package datos;

import java.util.ArrayList;

public abstract class Tripulacion extends Persona {
	int anyosExperiencia;//Años que lleva volando cada tripulante
	int vuelosRealizados;//Numero de vuelos realizados por cada tripulante
	ArrayList<String> idiomas; //Idiomas en los que se expresa el tripulante
	String nacionaldidad;
	


	public Tripulacion() {
		
	}
	
	
	public String getNacionaldidad() {
		return nacionaldidad;
	}

	public void setNacionaldidad(String nacionaldidad) {
		this.nacionaldidad = nacionaldidad;
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
	public ArrayList<String> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}
	
}

