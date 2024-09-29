package tareaDAMficherosObjetos;

public class Persona {
	
	String nombre;
	int edad;
	String ciudad;
	
	public Persona(String nombre, int edad, String ciudad) {
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		
	}
	
	public static String getPersona(String nombre, int edad, String ciudad) {
		String persona;
		persona = "Mi nombre es " + nombre + " tengo " +  edad + " años y nací en " + ciudad ;
		return persona;
	}
	
	
}
