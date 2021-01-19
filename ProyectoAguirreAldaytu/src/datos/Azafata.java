package datos;

import java.util.ArrayList;

public class Azafata extends Tripulacion {
	private int altura,peso;
	
	
	public Azafata(String nombre, String apellido, int edad, String dni, String residencia, int anyosExperiencia,
			int vuelosRealizados, String nacionalidad, int tipoTripulacion,int altura,int peso) {
		super(nombre, apellido, edad, dni, anyosExperiencia, vuelosRealizados, nacionalidad, tipoTripulacion);
		this.altura = altura;
		this.peso = peso;
	}

	//Getters y setters
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}


	
}
