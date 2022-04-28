package fp.farmaceutico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FactoriaMedicamentos {

	
	
	
	
	
	
	
	public static List<Medicamento> leeFichero(String nombreFichero){
		List<Medicamento> res = new ArrayList<Medicamento>();
		List<String> aux= new ArrayList<String>();
		try {
			aux= Files.readAllLines(Paths.get(nombreFichero));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int cont= 0; 
		for ( String e:aux) {
			if (cont>0) {
				Medicamento p = parseaLinea(e); 
				res.add(p);
				
				 
			}
			cont++;
		}
		
		
		return res; 
		
	}
	
	private static Medicamento parseaLinea(String cadena){
		String[] medicamento= cadena.split(",");
		String nombreMedicamiento= medicamento[0];
		TipoMedicamento tipoMedicamento= TipoMedicamento.valueOf(medicamento[1].toUpperCase());
		String codigoEnfermedad= medicamento[2];
		String farmaceutica= medicamento[3];
		Double puntuacion= Double.parseDouble(medicamento[4]);
		Integer indiceSomatico =Integer.parseInt(medicamento[5]);
		LocalDate fechaCatalogo = LocalDate.parse(medicamento[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nombreMedicamiento,tipoMedicamento,codigoEnfermedad,farmaceutica,puntuacion,indiceSomatico,fechaCatalogo);
		
		}
}
