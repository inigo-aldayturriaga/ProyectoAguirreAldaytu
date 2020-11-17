package datos;

import java.util.ArrayList;

import datos.Pasajero;

public class Vuelo {
	int idAvion;//Identificador del avion
	String origen;//Lugar de origen del vuelo
	String destino;//Lugar de destino del vuelo
	int horaSalida;//Hora de salida del vuelo
	int horaLLegada;//Hora de llegada del vuelo
	int numeroPasajeros;//Cantidad de pasajeros que van en el vuelo
	int maximoPasajeros;//Cantidad maxima de pasajeros de ese vuelo
	ArrayList<Pasajero> pasajeros;//Lista de los pasajeros que van en el vuelo
	
	
	//Getters y setters
	public int getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(int idAvion) {
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
	public int getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}
	public int getHoraLLegada() {
		return horaLLegada;
	}
	public void setHoraLLegada(int horaLLegada) {
		this.horaLLegada = horaLLegada;
	}
	
	public int getNumeroPasajeros() {
		return numeroPasajeros;
	}
	public void setNumeroPasajeros(int numeroPasajeros) {
		this.numeroPasajeros = numeroPasajeros;
	}
	public int getMaximoPasajeros() {
		return maximoPasajeros;
	}
	public void setMaximoPasajeros(int maximoPasajeros) {
		this.maximoPasajeros = maximoPasajeros;
	}
	
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	@Override
	public String toString() {
		return "Vuelo [idAvion=" + idAvion + ", origen=" + origen + ", destino=" + destino + ", horaSalida="
				+ horaSalida + ", horaLLegada=" + horaLLegada + ", numeroPasajeros=" + numeroPasajeros
				+ ", maximoPasajeros=" + maximoPasajeros + ", pasajeros=" + pasajeros + "]";
	}
	

}
