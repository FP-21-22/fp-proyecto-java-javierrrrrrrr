package fp.vacunas.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.vacunas.FactoriaVacunaciones;
import fp.vacunas.Vacunacion;
import fp.vacunas.Vacunaciones;

public class TestVacunaciones {
	public static void main(String[] args) {
		String ruta = "data/ccaa_vacunas_3.csv";
		List<Vacunacion> lista=FactoriaVacunaciones.leefichero(ruta);
		for (Vacunacion e : lista) {
			System.out.println(e);
			
		}
		
		Vacunaciones vacunacion1= FactoriaVacunaciones.leerfichero3(ruta);
	
		System.out.println("========= Vacunaciones comprendidas entre dos fechas =========");
		List<Vacunacion> v1= vacunacion1.vacunacionesEntreFechas(LocalDate.of(2021, 01, 04), LocalDate.of(2021, 01, 6));
		System.out.println(v1);
		
		System.out.println("========= Existe números de personas con la pauta completa por encima n personas en una comunidad =========");
		boolean v2 = vacunacion1.existeNumPersonasPautaCompletaPorEncimaDe("Canarias", 4000000);
		System.out.println(v2);
		
		System.out.println("========= Día de más vacunaciones en una comunidad =========");
		LocalDate v3= vacunacion1.diaMasVacunacionesEn("Asturias");
		System.out.println(v3);
		
		System.out.println("========= Vacunaciones por fecha =========");
		Map<LocalDate,List<Vacunacion>> v4=vacunacion1.vacunacionesPorFecha();
		System.out.println(v4);
		
		System.out.println("========= Máximo numero total de vacunas por comunidad =========");
		Map<String,Integer> v5= vacunacion1.maximoNumTotalVacunasporComunidad();
		System.out.println(v5);
	
		
	}
}
