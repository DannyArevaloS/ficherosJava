package tareaDAMficherosObjetos;

import java.util.*;
import java.io.*;

public class ficherosObjetos {

	public static void main(String[] args) {
	
		// Ejercicio 1 -> Pedir teclado un nombre, una edad y una ciudad y escriba en cada línea del fichero. Si ya hay datos que los añada al final del fichero. (Nombre, Edad, Ciudad de Nacimiento.)
		//menuDeOpciones();
		// Ejercicio 2 -> Mostrar por pantalla el contenido del fichero binario creado.
		// Ejercicio 3 -> Salir del programa
		metodoFicherosBinarios();

	}
	
	public static void menuDeOpciones() {
		String nombreFichero = "ficheroObjecto.dat";
		String nombre;
		int edad;
		String ciudad;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Hola Bienvenido al programa de registro ---------------------------------------------->");
		System.out.println("Dime tú nombre: ");
		nombre = sc.nextLine();
		
		System.out.println("Dime tú edad: ");
		edad = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Dime tú ciudad: ");
		ciudad = sc.nextLine();
		
		String texto = "Hola me llamo " + nombre + " tengo  " + edad + " años y nací en  " + ciudad + ".";
		
		try (FileWriter writer = new FileWriter(nombreFichero)) {

			writer.write(texto);
			
			System.out.println("Texto agregado al archivo : " + nombreFichero);
			System.out.println("Fin del programa que tenga un buen dia  ---------------------------------------------->");
		
			
			
		}catch(IOException e) {
			System.out.println("Error " + e.getMessage());
		}
	}
	
	public static void metodoFicherosBinarios() {
		
		Scanner sc = new Scanner(System.in);                                                                      
        FileOutputStream fileOutputStream = null;
        DataOutputStream dataOutputStream = null;
        String nombre;
        int edad;
        String ciudad;
        String datoDelUsuario;
        String nombreFichero;
        
        System.out.printf("Introduce el nombre del fichero: ");
		nombreFichero = sc.nextLine();

        try {
            fileOutputStream = new FileOutputStream(nombreFichero);
            //dataOutputStream = new DataOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            System.out.printf("Introduce un nombre: ");
            nombre = sc.nextLine();
            
            System.out.printf("Introduce tu Edad: ");
            edad = sc.nextInt();
            sc.nextLine();
            
            System.out.printf("Introduce tú ciudad de nacimiento: ");
            ciudad = sc.nextLine();
            
            //datoDelUsuario = "Hola, mi nombre es " + nombre + " tengo " + edad + " años y nací en " + ciudad + ".";
            Persona persona = new Persona(nombre, edad, ciudad);
            
            System.out.println("@@@DANNY -> datos del objeto Persona: " + persona.getPersona(nombre, edad, ciudad) ); 
            objectOutputStream.writeObject(persona);
            
            
            
            //dataOutputStream.writeUTF(datoDelUsuario);
            
            
            //System.out.println("los datos del objeto Persona son: " + objectOutputStream);
            //System.out.println("datos guardados en el fichero: " + datoDelUsuario);
            System.out.println("@@@DANNY -> termina el programa ");
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fileOutputStream != null) {
                	fileOutputStream.close();
                }
                if (dataOutputStream != null) {
                	dataOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());                                                               
            }
        }
    }
	
}


