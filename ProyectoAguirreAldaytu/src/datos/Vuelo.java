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
			ArrayList<Persona> listaPersonas,String observacion,int puerta) {
		super();
		this.idAvion = idAvion;
		this.origen = origen;
		this.destino = destino;
		this.horaSalida = horaSalida;
		this.horaLLegada = horaLLegada;
		this.listaPersonas = listaPersonas;
		this.observacion = observacion;
		this.puerta = puerta;
	}

	@Override
	public String toString() {
		return "Vuelo [idAvion=" + idAvion + ", origen=" + origen + ", destino=" + destino + ", puerta=" + puerta
				+ ", observacion=" + observacion + ", horaSalida=" + horaSalida + ", horaLLegada=" + horaLLegada
				+ ", listaPersonas=" + listaPersonas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((horaLLegada == null) ? 0 : horaLLegada.hashCode());
		result = prime * result + ((horaSalida == null) ? 0 : horaSalida.hashCode());
		result = prime * result + ((idAvion == null) ? 0 : idAvion.hashCode());
		result = prime * result + ((listaPersonas == null) ? 0 : listaPersonas.hashCode());
		result = prime * result + ((observacion == null) ? 0 : observacion.hashCode());
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		result = prime * result + puerta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (horaLLegada == null) {
			if (other.horaLLegada != null)
				return false;
		} else if (!horaLLegada.equals(other.horaLLegada))
			return false;
		if (horaSalida == null) {
			if (other.horaSalida != null)
				return false;
		} else if (!horaSalida.equals(other.horaSalida))
			return false;
		if (idAvion == null) {
			if (other.idAvion != null)
				return false;
		} else if (!idAvion.equals(other.idAvion))
			return false;
		if (listaPersonas == null) {
			if (other.listaPersonas != null)
				return false;
		} else if (!listaPersonas.equals(other.listaPersonas))
			return false;
		if (observacion == null) {
			if (other.observacion != null)
				return false;
		} else if (!observacion.equals(other.observacion))
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		if (puerta != other.puerta)
			return false;
		return true;
	}
	
	
	
}
