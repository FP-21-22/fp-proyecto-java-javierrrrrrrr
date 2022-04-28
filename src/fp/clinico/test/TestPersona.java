package fp.clinico.test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.clinico.Persona;

public class TestPersona {

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
		System.out.println(p1.parse("Juan,García Rodríguez,12755078Z,20/03/1965"));
		System.out.println("==CompareTo==");
		System.out.println(p2.compareTo(p1));
	}  
}
