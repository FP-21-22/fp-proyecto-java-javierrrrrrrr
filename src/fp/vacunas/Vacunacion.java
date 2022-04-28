package fp.vacunas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public record Vacunacion(LocalDate fecha, String comunidad,Integer pfizer,Integer moderna,
	Integer astrazeneca,Integer janssen,Integer numeroDePersonas) implements Comparable<Vacunacion>{
	
	//Restricciones:
	
	public Vacunacion{
		LocalDate fecha1feb= LocalDate.of(2021, 1, 1);
		Checkers.check("La fecha de debe ser posterior al 01/01/2021", fecha.isAfter(fecha1feb));
	}

	//Propiedad Derivada:
	
	public Integer numeroTotal() {
		Integer res= this.pfizer + this.moderna + this.astrazeneca +this.janssen;
		return res;
	}
	 
	//Método static of:
	
	public static Vacunacion of(LocalDate fecha, String comunidad,Integer pfizer,Integer moderna,
			Integer astrazeneca,Integer janssen,Integer numeroDePersonas) {
		Vacunacion res= new Vacunacion(fecha,comunidad,pfizer,moderna,astrazeneca, janssen,numeroDePersonas);
		return res;
		
	}
	
	
	
	public static String formatearFecha(LocalDate f) {
		
		String res= f.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
		return res;
	}
	

//   Método static parse:
	
	public static Vacunacion parse(String texto) {
//		LocalDate fecha, String comunidad,Integer pfizer,Integer moderna,
//		Integer astrazeneca,Integer janssen,Integer numeroDePersonas
		String[] vacunacion= texto.split(";");
		LocalDate fecha=LocalDate.parse(vacunacion[0],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad= vacunacion[1];
		Integer pfizer= Integer.parseInt(vacunacion[2]);
		Integer moderna= Integer.parseInt(vacunacion[3]);
		Integer astrazeneca= Integer.parseInt(vacunacion[4]);
		Integer janssen= Integer.parseInt(vacunacion[5]);
		Integer numeroDePersonas= Integer.parseInt(vacunacion[6]);
		return Vacunacion.of(fecha,comunidad,pfizer,moderna,astrazeneca, janssen,numeroDePersonas);
	
	
}
	
	//Orden natural:
	
	@Override
	public int compareTo(Vacunacion o) {
		int res= this.comunidad().compareTo(o.comunidad());
		if (res==0) {
			res= this.fecha().compareTo(o.fecha());
		}
		return res;
	}
	
	//TEST:
	
	public static void main(String[] args) {
		Vacunacion vacunacion1=Vacunacion.of(LocalDate.of(2022, 2, 1), "Extremadura",12431, 12000, 21000, 20500, 16700);
		Vacunacion vacunacion2=Vacunacion.of(LocalDate.of(2021, 9, 1), "Madrid", 30000, 23111, 39120, 18012, 19032);
		
		LocalDate f= LocalDate.of(2003, 12,2);
		System.out.println(vacunacion1);
		System.out.println("==f==");
		System.out.println(f);
		System.out.println("==parse==");
		System.out.println(parse("04/12/2022;Andalucía;140295;0;0;0;0"));
		System.out.println("==compareTo==");
		System.out.println(vacunacion1.compareTo(vacunacion2));
		
	}




	
}
