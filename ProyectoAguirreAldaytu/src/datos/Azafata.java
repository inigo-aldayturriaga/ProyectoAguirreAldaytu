package datos;

import java.util.ArrayList;

public class Azafata extends Tripulacion {
	private int altura,peso;
	
	
	public Azafata(String nombre, String apellido, int edad, String dni, int anyosExperiencia,
			int vuelosRealizados, String nacionalidad,int altura,int peso) {
		super(nombre, apellido, edad, dni, anyosExperiencia, vuelosRealizados, nacionalidad);
		this.altura = altura;
		this.peso = peso;
	}

	public Azafata() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Azafata [altura=" + altura + ", peso=" + peso + "]";
	}
	


	
}
