package fp.clinico;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstudioClinicoAmpliacionStream extends EstudioClinicoStream implements EstudioClinicoAmpliacion {

	//Atributos
	//protected List<PacienteEstudio> pacientes;
	// Constructores
		public EstudioClinicoAmpliacionStream() {
			super();
		}
		
		public EstudioClinicoAmpliacionStream(List<PacienteEstudio> lista) {
			super(lista);
		}
		
		public EstudioClinicoAmpliacionStream(Stream<PacienteEstudio> st) {
			super(st);
		}
	
	//Métodos derivados
	
	@Override
	public Map<TipoResidencia, Integer> agruparNumeroPacientesPorTipoResidencia() {
		return super.lista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::tipoResindencia, 
						Collectors.collectingAndThen(Collectors.counting(),x-> x.intValue())));
		
	}

	@Override
	public Map<TipoResidencia, Double> agruparNivelMedioGlucosaMedioPorTipoResidencia() {
		
		return super.lista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::tipoResindencia,
						Collectors.averagingDouble(PacienteEstudio::nivelMedioGlucosa)
						));
	}

	@Override
	public Map<TipoResidencia, PacienteEstudio> agruparNivelMedioGlucosaMaximoPorTipoResidencia() {
		// TODO Auto-generated method stub
		return super.lista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::tipoResindencia,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(PacienteEstudio::nivelMedioGlucosa)),x->x.get())
				));
	}

	@Override
	public Map<String, List<PacienteEstudio>> agrupaPacientesPorGenero() {
		
		
		return super.lista.stream().
				collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.toList())
				);
	}

	@Override
	public Map<String, Set<PacienteEstudio>> agrupaPacientesPorGeneroEnConjunto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, SortedSet<PacienteEstudio>> agrupaPacientesPorGeneroEnConjuntoOrdenado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, PacienteEstudio> pacienteEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Double>> listaEdadesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> edadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generoEdadMaximaPacientesPorGenero() {
		// TODO Auto-generated method stub
		return null;
	}

}
