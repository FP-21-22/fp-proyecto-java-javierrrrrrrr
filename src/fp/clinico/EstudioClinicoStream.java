package fp.clinico;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.farmaceutico.Medicamento;

public class EstudioClinicoStream implements EstudioClinico {
	
	private List<PacienteEstudio> lista;
	//List<PacienteEstudio> lista  =new ArrayList<PacienteEstudio> ();
	 
	
	//C1: Construye una lista de la clase PacienteEstudio vacía.
public EstudioClinicoStream() {
	this.lista = new ArrayList<PacienteEstudio>();
	}
	
   //C2: Construye una lista de objetos de la clase PacienteEstudio.
	
	public EstudioClinicoStream(List<PacienteEstudio> lista) {
		
		this.lista = lista;
	}

   //C3: Se encarga de parsear una línea del fichero a un objeto del tipo PacienteEstudio.

	public static PacienteEstudio parseaLinea(String cadena) {
		return PacienteEstudio.parse(cadena);
	}
	//Solo tratamientos secuenciales;
	
	
	@Override
	public Integer numeroPacientes() {
		return (int) lista.stream().count();
		
	}

	@Override
	public void incluyePaciente(PacienteEstudio paciente) {
		lista.add(paciente);

	}

	@Override
	public void incluyePacientes(Collection<PacienteEstudio> pacientes) {
		lista.addAll(pacientes);

	}

	@Override
	public void eliminaPaciente(PacienteEstudio paciente) {
		lista.remove(paciente);

	}

	@Override
	public Boolean estaPaciente(PacienteEstudio paciente) {
		return lista.stream().anyMatch(x->x.equals(paciente));
		
	}

	@Override
	public void borraEstudio() {
		lista.clear();

	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		return new EstudioClinicoStream(this.leeFichero(nombreFichero));
	}

	@Override
	public List<PacienteEstudio> leeFichero(String nombreFichero) {
		
		List<PacienteEstudio> res = new ArrayList<PacienteEstudio>();
		List<String> aux =new ArrayList<String>();
		
		try {
			aux= Files.readAllLines(Paths.get(nombreFichero));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		int cont = 0;
		for (String e: aux) {
			if ( cont>0) {
				PacienteEstudio p= parseaLinea(e);
				res.add(p);
			}
			cont++;
		}
		return res;
		
		
//		Stream<Medicamento> res= null;
//		try {
//			res= Files.lines(Paths.get(nombreFichero)).
//					skip(1).
//					map(x-> Medicamento.parseaMedicamento(x));
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return res;
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		return lista.stream().allMatch(x->x.tipoResindencia().equals(tipo));
		
	}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		
		return lista.stream().anyMatch(x->x.tipoResindencia().equals(tipo));
		
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		
		return (int) lista.stream().filter(x->x.factorRiesgo()==true).count();
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		
		//lista.stream().filter(x-> x.factorRiesgo()).map(x->x.edad()).average().getAsDouble();
		
		return lista.stream().filter(x->x.factorRiesgo()).mapToDouble(PacienteEstudio::edad).average().getAsDouble();
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		List<PacienteEstudio> res= lista.stream().filter(x->x.edad().equals(edad)).toList();
		return res;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		//List<PacienteEstudio> lista1= lista.stream().filter(x->x.edad()>edad).collect(Collectors.toList());
		Map<String, List<PacienteEstudio>> res= lista.stream().
				filter(x->x.edad()>edad).
				sorted(Comparator.comparing(PacienteEstudio::genero)).
				collect(Collectors.groupingBy(PacienteEstudio::genero,Collectors.toList())); 
		return res;  
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		Map<String, Long> res= lista.stream().sorted(Comparator.comparing(PacienteEstudio::genero))
				.collect(Collectors.groupingBy(PacienteEstudio::genero, Collectors.counting()));
				
		return res;
	}

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		Map<String,Double> res= lista.stream().sorted(Comparator.comparing(PacienteEstudio::genero)).
				collect(Collectors.groupingBy(PacienteEstudio::genero,Collectors.averagingDouble(PacienteEstudio::edad)));
		return res;
	}

}
