package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public record Persona(String nombre,String apellidos,String dni,
		LocalDate fechaNacimiento) implements Comparable<Persona> {

		

	//Método static of:
	public static Persona of(String nombre,String apellidos,String dni,
			LocalDate fechaNacimiento) {
		
		Persona res= new Persona(nombre,apellidos,dni,fechaNacimiento);
		return res;
	}
	
	//Restricciones:
	public Persona{
		Checkers.check("La fecha de nacimiento debe ser anterior a la fecha actual:" , fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("El dni debe ser una cadena con ocho dígitos y seguidos de una letra", dniValido(dni));
	}
	
	//Otros Métodos:
	public boolean dniValido(String dni) {
	
		boolean res= false;
		
		if (dni.length() ==9 && Character.isDigit(dni.charAt(0)) && Character.isDigit(dni.charAt(1)) && 
				Character.isDigit(dni.charAt(2))&& Character.isDigit(dni.charAt(3)) &&
				Character.isDigit(dni.charAt(4))&& Character.isDigit(dni.charAt(5)) &&
			Character.isDigit(dni.charAt(6))&& Character.isDigit(dni.charAt(7)) && Character.isLetter(dni.charAt(8)) ) {
			res= true;
			
			}
		return res;
		
	}
	

	//Propiedad derivada:
	public Integer edad() {
		
		Integer res=0;
		
		LocalDate hoy= LocalDate.now();
		res= hoy.getYear()-this.fechaNacimiento.getYear();
		
		return res;
				
				
		
	}
	//Método static parse:
	public static Persona parse(String texto){
		//String nombre,String apellidos,String dni
		String[] persona= texto.split(",");
		String nombre= persona[0];
		String apellidos= persona[1];
		String dni= persona[2];
		LocalDate fechaNacimiento=LocalDate.parse(persona[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		return new Persona(nombre,apellidos,dni,LocalDate.of(2003, 12, 2));
		return new Persona(nombre,apellidos,dni, fechaNacimiento);
	}
	
	//Orden Natural
		@Override
		public int compareTo(Persona dni) {
			int res= this.dni().compareTo(dni.dni());
			return res;
		}
		
		
		//TEST:
	public static void main(String[] args) {
		
		Persona p1= new Persona("Paqui", "Rin", "03240026I", LocalDate.of(2000, 12, 1));
		Persona p2= Persona.of("Manuel", "Fernandez", "00203022J", LocalDate.of(2000, 12, 1));
		//RESTRICCIÓN:
//	    Persona pRes= Persona.of("Carlos", "Martínez", " 00433022JIE", LocalDate.of(2024, 12, 1));
//		Persona pRes= Persona.of("Gemma", "García", " 00433022JIE", LocalDate.of(2000, 12, 1));
		
//		System.out.println(pRes);
	
	
		System.out.println("==P1==");
		System.out.println(p1);
		System.out.println(p1.edad());
		System.out.println("==P2==");
		System.out.println(p2);
		System.out.println("==Parse==");
		System.out.println(parse("Juan,García Rodríguez,12755078Z,20/03/1965"));
		System.out.println(p1.fechaNacimiento);
		System.out.println("==CompareTo==");
		System.out.println(p2.compareTo(p1));
	}
	
	
	
}
