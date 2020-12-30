package datos;
public class Piloto extends Tripulacion implements Asignable{
	TipoPiloto tipo;//De tipo comercial o privado
	
	public Piloto() {
		
	}
	
	public TipoPiloto getTipo() {
		return tipo;
	}
	public void setTipo(TipoPiloto tipo) {
		this.tipo = tipo;
	}

	
	
}
