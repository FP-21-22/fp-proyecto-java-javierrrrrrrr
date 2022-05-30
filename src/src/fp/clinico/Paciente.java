package fp.clinico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Paciente(Persona persona,String codigoIngreso,
		LocalDateTime fechaHoraIngreso) {

	
	
	//Restricciones:
	
	public Paciente{
	    LocalDateTime hoy = LocalDateTime.now();
		Checkers.check("La fecha y hora de ingreso debe ser anterior o igual a la fecha actual", fechaHoraIngreso.isBefore(hoy) || fechaHoraIngreso.equals(hoy));
		
	}
	
	//Métodos static of: 
	  
	public static Paciente of(String nombre,String apellidos,String dni,LocalDate fechaNacimiento,String codigoIngreso,LocalDateTime fechaHoraIngreso) {
			Persona persona=new Persona(nombre,apellidos,dni,fechaNacimiento);
			Paciente res = new Paciente(persona,codigoIngreso,fechaHoraIngreso);
			return res;
}
	
	
	public static Paciente of(Persona persona,String codigoIngreso,
		LocalDateTime fechaHoraIngreso) {
		
		
		Paciente res= new Paciente(persona,codigoIngreso,fechaHoraIngreso);
		return res;
	
	}
	



	//Propiedades derivadas:
	
	public LocalDate fechaIngreso(){
		LocalDate res= this.fechaHoraIngreso.toLocalDate();
		return res;
	}
	
	public String horaIngreso(){
		String res= this.fechaHoraIngreso.format(DateTimeFormatter.ofPattern("hh:mm"));
		return res;
	}
	
	//TEST:
	
	public static void main(String[] args) {
		Persona pers1= new Persona("Paqui", "Nieto", "00203022J", LocalDate.of(2000, 12, 1));
		LocalDateTime fecha= LocalDateTime.of(2239, 11, 4, 3, 40);
		System.out.println("==fecha==");
		System.out.println(fecha);
		//RESTRICCIÓN:
		//Paciente persRes= Paciente.of(pers1, "23325476H", LocalDateTime.of(2023, 12, 11,4,23));
		//System.out.println(persRes);
		
		
		Paciente pa1= Paciente.of(Persona.of("Paqui", "Nieto", "00203022J", LocalDate.of(2000, 12, 1)), "2233Ds", LocalDateTime.of(2004, 11, 4, 3, 40));
		Paciente pa2= new Paciente(pers1, "2233Ds", LocalDateTime.of(2004, 11, 4, 3, 40));
//	 	
		Paciente pa3= Paciente.of("Manuel", "Hernández", "23045460I", LocalDate.of(2001, 10, 4),"8539J" , LocalDateTime.of(2020, 11, 4, 3, 40) );
		System.out.println("==pa1==");
		System.out.println(pa1);
		System.out.println("==pa2==");
		System.out.println(pa2);
		System.out.println("==pa3==");
		System.out.println(pa3);
//		
		
		
	}
}
