package fp.farmaceutico;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListadoMedicamentos {
	//Atributos
	List<Medicamento> lista;
	
	
	//Constructores
	public ListadoMedicamentos(Stream<Medicamento> st){
		lista= st.collect(Collectors.toList());
		
		
	}
	
	//Propiedades Derivadas
	public Boolean existeMedicamentoSegunTipoAnteriorA(  TipoMedicamento tipoMedicamento,LocalDate fecha) {
		Boolean res=lista.stream().
				anyMatch(x->x.getTipoMedicamento().equals(tipoMedicamento) 
						&&
						x.getFechaCatalogo().isBefore(fecha));
		return res;
	}
	
	public Set<String> nombreMedicamentosPuntuacionMayorA(Double puntuacion){
		Set<String> res=lista.stream().
				filter(x->x.getPuntuacion()>puntuacion).
				map(x->x.getNombreMedicamento()).
				collect(Collectors.toSet());
		return res;
		
	}
	
	public String nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento medicamento) {
		String res= lista.stream()
				.filter(x->x.getTipoMedicamento().equals(medicamento)).
				max(Comparator.comparing(Medicamento::getIndiceSomatico)).
				orElseThrow().  //Lanza una excepción si no hay máxmo
				getNombreMedicamento();

		return res;
	}
	public Map<TipoMedicamento,Double> agrupaTipoMedicamentoSegunPuntuacionMedia(){
		
		Map<TipoMedicamento,Double> res= lista.stream().
				sorted(Comparator.comparing(Medicamento::getTipoMedicamento)).
				collect(Collectors.groupingBy(Medicamento::getTipoMedicamento,
						Collectors.averagingDouble(Medicamento::getPuntuacion)));
		return res;
	}
	
	public LocalDate fechaCatalogoMasFrecuente() {

		LocalDate res= lista.stream().
				collect(Collectors.groupingBy(
						Medicamento::getFechaCatalogo,Collectors.counting())).
				entrySet().stream().max(Map.Entry.comparingByValue()).
				map(Map.Entry::getKey).orElse(null);
		return res;
		
		
	}
}

