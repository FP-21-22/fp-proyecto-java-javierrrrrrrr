package fp.vacunas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FactoriaVacunaciones {
	
	
	public static List<Vacunacion> leefichero(String nombreFichero){
		List<Vacunacion> res =new ArrayList<Vacunacion>();
		List<String> aux = new ArrayList<String>();
		try {
			
			aux = Files.readAllLines(Paths.get(nombreFichero));
		}catch (IOException e) {
		e.printStackTrace();
		}
		int cont=0;
		for (String e: aux) {
			if (cont> 0 ) {
			Vacunacion p= parseaLinea(e);
			res.add(p);
			
 
			}
			cont ++;
		}
		

		return res;
		
		
	}
	
	
	
	private static Vacunacion parseaLinea(String cadena) {
		String[] vacunacion= cadena.split(";");
		LocalDate fecha=LocalDate.parse(vacunacion[0],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String comunidad= vacunacion[1];
		Integer pfizer= Integer.parseInt(vacunacion[2]);
		Integer moderna= Integer.parseInt(vacunacion[3]);
		Integer astrazeneca= Integer.parseInt(vacunacion[4]);
		Integer janssen= Integer.parseInt(vacunacion[5]);
		Integer numeroDePersonas= Integer.parseInt(vacunacion[6]);
		return Vacunacion.of(fecha,comunidad,pfizer,moderna,astrazeneca, janssen,numeroDePersonas);
	}
	
	
	
	
	
	
	
	
	
	
	

}
