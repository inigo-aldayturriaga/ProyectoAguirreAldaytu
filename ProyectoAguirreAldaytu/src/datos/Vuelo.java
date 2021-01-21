package datos;


import java.util.ArrayList;
import java.util.Date;

import datos.Pasajero;

public class Vuelo {
	String idAvion;//Identificador del avion
	String origen;//Lugar de origen del vuelo
	String destino;//Lugar de destino del vuelo
	int puerta;//Puerta de embarque
	String observacion;//Si es llamada ultima llamada retraso etc
	Date horaSalida;//Hora de salida del vuelo
	Date horaLlegada;//Hora de llegada del vuelo
	ArrayList<Pasajero> listaPasajeros;//Lista de toda la gente que va en el vuelo
	ArrayList<Tripulacion> listaTripulacion;
	
	
	//Getters y setters
	
	
	public static void aniadirPasajeros(Pasajero p,ArrayList<Pasajero> listaPasajero) {
		listaPasajero.add(p);
		
	}
	

	public ArrayList<Tripulacion> getListaTripulacion() {
		return listaTripulacion;
	}


	public void setListaTripulacion(ArrayList<Tripulacion> listaTripulacion) {
		this.listaTripulacion = listaTripulacion;
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


	public Date getHoraLlegada() {
		return horaLlegada;
	}


	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	public ArrayList<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}


	public void setListaPasajeros(ArrayList<Pasajero> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}
	

	public int getPuerta() {
		return puerta;
	}

	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Vuelo(String idAvion, String origen, String destino, Date horaSalida, Date horaLLegada,
			ArrayList<Pasajero> listaPasajeros,ArrayList<Tripulacion>listaTripulacion, String observacion,int puerta) {
		super();
		this.idAvion = idAvion;
		this.origen = origen;
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLLegada;
		this.listaPasajeros = listaPasajeros;
		this.listaTripulacion = listaTripulacion;
		this.observacion = observacion;
		this.puerta = puerta;
	}

	public Vuelo() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return   idAvion + "," + origen + "," + destino + ",Puerta =" + puerta
				+ ", Observacion =" + observacion + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada
				+ ", listaPasajeros=" + listaPasajeros +", listaTripulacion=" + listaTripulacion+ "]";
	}



	
	
	
}
