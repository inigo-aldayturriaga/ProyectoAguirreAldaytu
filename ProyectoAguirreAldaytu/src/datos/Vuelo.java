package datos;


import java.util.ArrayList;
import java.util.Date;

import datos.Pasajero;

public class Vuelo {
	String idAvion;//Identificador del avion
	String origen;//Lugar de origen del vuelo
	String destino;//Lugar de destino del vuelo
	Date horaSalida;//Hora de salida del vuelo
	Date horaLLegada;//Hora de llegada del vuelo
	ArrayList<Persona> listaPersonas;//Lista de toda la gente que va en el vuelo
	
	
	//Getters y setters
	
	public static void añadirPasajeros(Persona p,ArrayList<Persona> listaPersonas) {
		listaPersonas.add(p);
		
	}

	public String getIdAvion() {
		return idAvion;
	}


	public void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Date getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}


	public Date getHoraLLegada() {
		return horaLLegada;
	}


	public void setHoraLLegada(Date horaLLegada) {
		this.horaLLegada = horaLLegada;
	}


	public ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}


	public void setListaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public Vuelo(String idAvion, String origen, String destino, Date horaSalida, Date horaLLegada,
			ArrayList<Persona> listaPersonas) {
		super();
		this.idAvion = idAvion;
		this.origen = origen;
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLLegada = horaLLegada;
		this.listaPersonas = listaPersonas;
	}
	
	
}
