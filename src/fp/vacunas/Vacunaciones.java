package fp.vacunas;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vacunaciones {
	
	List<Vacunacion> vacunas;
	
	
	public Vacunaciones(Stream<Vacunacion> st) {
		vacunas=st.collect(Collectors.toList());
	}
		
		
		
	public void anyadeVacunacion(Vacunacion vacunacion) {
		vacunas.add(vacunacion);
		
		
	}
	
	public List<Vacunacion>  vacunacionesEntreFechas(LocalDate fecha1,LocalDate fecha2){
		List<Vacunacion> res= vacunas.stream().
				filter(x->x.fecha().isAfter(fecha1) && x.fecha().isBefore(fecha2)).
				toList();
		return res; 
	}
	
	public boolean existeNumPersonasPautaCompletaPorEncimaDe(String comunidad,Integer n) {
		boolean res= vacunas.stream().
				anyMatch(x->x.comunidad().equals(comunidad) && x.numeroDePersonas()>n);
		return res;
		
	}
	
	public LocalDate diaMasVacunacionesEn(String comunidad) {
		LocalDate res= vacunas.stream().
				filter(x->x.comunidad().equals(comunidad)).
				max(Comparator.comparing(Vacunacion::numeroDePersonas)).
				map(Vacunacion::fecha).get();
		
		return res;
		
	}
	
	public Map<LocalDate,List<Vacunacion>> vacunacionesPorFecha(){
		Map<LocalDate,List<Vacunacion>> res= vacunas.stream().
				sorted(Comparator.comparing(Vacunacion::fecha)).limit(10).
				collect(Collectors.groupingBy(
						Vacunacion::fecha,
						Collectors.toList()
						));
		return res;
	}
	public Map<String,Integer> maximoNumTotalVacunasporComunidad(){

		Map<String,Integer> res= vacunas.stream().collect(Collectors.groupingBy(Vacunacion::comunidad,
				Collectors.collectingAndThen(
						Collectors.maxBy(
								Comparator.comparing(Vacunacion::numeroTotal))
						,x->x.get().numeroDePersonas() )));
		
	return res;
	}
	
}

