package datos;
public class Piloto extends Persona {
	int anyosExperiencia;//Años que lleva conduciendo aviones el piloto
	int vuelosRealizados;//Numero de vuelos realizados en avion
	TipoPiloto tipo;//De tipo comercial o privado
	
	
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
	
	public TipoPiloto getTipo() {
		return tipo;
	}
	public void setTipo(TipoPiloto tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Piloto [anyosExperiencia=" + anyosExperiencia + ", vuelosRealizados=" + vuelosRealizados + ", tipo="
				+ tipo + "]";
	}
	
	
	

}
