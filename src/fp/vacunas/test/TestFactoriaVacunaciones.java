package fp.vacunas.test;
import java.util.List;

import fp.vacunas.*;
public class TestFactoriaVacunaciones {


	public static void main(String[] args) {
		String ruta = "data/ccaa_vacunas_3.csv";
		List<Vacunacion> lista=FactoriaVacunaciones.leefichero(ruta);
		for (Vacunacion e : lista) {
			System.out.println(e);
			
		}
	}
	
} 
