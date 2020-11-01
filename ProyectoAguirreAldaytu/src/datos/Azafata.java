package datos;

import java.util.ArrayList;

public class Azafata {
	ArrayList<String> idiomas; //Idiomas en los que se expresa la azafata
	
	//Getters y setters
	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	@Override
	public String toString() {
		return "Azafata [idiomas=" + idiomas + "]";
	}
	
	
	

}
