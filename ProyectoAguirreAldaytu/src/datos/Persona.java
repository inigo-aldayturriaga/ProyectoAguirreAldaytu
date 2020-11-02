package datos;

public abstract class Persona {

	String nombre;//Nombre de la persona
	String apellido;//Primer apellido de la persona
	int edad;//Edad de la persona
	String dni;//DNI con la letra incluida
	String residencia;//Lugar donde vive
	String contrasenia;//Contrasenia del usuario para entrar en la app
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getResidencia() {
		return residencia;
	}
	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni
				+ ", residencia=" + residencia + "]";
	}
	

}
