package datos;

public abstract class Persona {

	String nombre;//Nombre de la persona
	String apellido;//Primer apellido de la persona
	int edad;//Edad de la persona
	String dni;//DNI con la letra incluida

	
	public Persona(String nombre, String apellido, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
	}
	public Persona() {
		
	}
	public Persona(String nombre) {
		this.nombre = nombre;
	}
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
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni+ "]";
	}
	

}
