package fp.clinico.test;
import java.time.LocalDate;
import java.time.LocalDateTime;

import fp.clinico.Paciente;
import fp.clinico.Persona;


public class TestPaciente {
	public static void main(String[] args) {
		Persona pers1= new Persona("Paqui", "Nieto", "00203022J", LocalDate.of(2000, 12, 1));
		LocalDateTime fecha= LocalDateTime.of(2239, 11, 4, 3, 40);
		System.out.println(fecha);
		//RESTRICCIÓN:
		//Paciente persRes= Paciente.of(pers1, "23325476H", LocalDateTime.of(2023, 12, 11,4,23));
		//System.out.println(persRes);
		
		
		Paciente pa1= Paciente.of(Persona.of("Paqui", "Nieto", "00203022J", LocalDate.of(2000, 12, 1)), "2233Ds", LocalDateTime.of(2004, 11, 4, 3, 40));
		Paciente pa2= new Paciente(pers1, "2233Ds", LocalDateTime.of(2004, 11, 4, 3, 40));
//		
		System.out.println(pa1);
		System.out.println(pa2);
//		
		
		
	}
}
