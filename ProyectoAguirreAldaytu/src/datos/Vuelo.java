package datos;

public class Vuelo {
	int idAvion;
	String origen;
	String destino;
	int horaSalida;
	int horaLLegada;
	int numeroPasajeros;
	int maximoPasajeros;
	

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
	@Override
	public String toString() {
		return "Vuelo [idAvion=" + idAvion + ", origen=" + origen + ", destino=" + destino + ", horaSalida="
				+ horaSalida + ", horaLLegada=" + horaLLegada + "]";
	}
	

}
