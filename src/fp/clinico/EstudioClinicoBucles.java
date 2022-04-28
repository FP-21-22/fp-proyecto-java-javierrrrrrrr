package fp.clinico;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EstudioClinicoBucles implements EstudioClinico {
	
	private List<PacienteEstudio> lista;
	//List<PacienteEstudio> lista  =new ArrayList<PacienteEstudio> ();
	 
	
	//C1: Construye una lista de la clase PacienteEstudio vacía.
	public EstudioClinicoBucles() {
	this.lista = new ArrayList<PacienteEstudio>();
	}
	
   //C2: Construye una lista de objetos de la clase PacienteEstudio.
	
	public EstudioClinicoBucles(List<PacienteEstudio> lista) {
		
		this.lista = lista;
	}

   //C3: Se encarga de parsear una línea del fichero a un objeto del tipo PacienteEstudio.

	public static PacienteEstudio parseaLinea(String cadena) {
		return PacienteEstudio.parse(cadena);
	}

	
	@Override
	public Integer numeroPacientes() {
		
		return lista.size();
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
		Boolean res= false;
		for (PacienteEstudio p: lista) {
			if (p.equals(paciente)){
				res= true;
			}
		}
		
		return res;            
	}

	@Override
	public void borraEstudio() {
		lista.clear();
	}

	@Override
	public EstudioClinico of(String nombreFichero) {
		return new EstudioClinicoBucles(this.leeFichero(nombreFichero));
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
	}

	@Override
	public Boolean todosPacienteSonDelTipo(TipoResidencia tipo) {
		Boolean res = true; 
		for (PacienteEstudio p: lista) {
			if (!(p.tipoResindencia().equals(tipo))) {
				res =false; 
		}
		
		}
		return res;
		}

	@Override
	public Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo) {
		boolean res= false;
		for (PacienteEstudio p: lista) {
		if (p.tipoResindencia().equals(tipo)) {
			res= true;
		}
		
		}
		return res;
	}

	@Override
	public Integer numeroPacientesFactorRiesgo() {
		//Map<PacienteEstudio> dicc= new HashMap<PacienteEstudio>();
		List<PacienteEstudio> ls= new ArrayList<PacienteEstudio>();
		for ( PacienteEstudio p: lista) {
			if (p.factorRiesgo()) {
				ls.add(p);
				
			}
		}
		return ls.size();
	}

	@Override
	public Double edadMediaPacientesConFactorRiesgo() {
		Double res = 0.;
		List <Double> edad= new ArrayList<Double>();
		
		Double sum = 0.;
		for (PacienteEstudio p : lista) {
			if (p.factorRiesgo()) {
				
				edad.add(p.edad());
				}	
		}
		for (Double n:edad) {
			sum+=n;
		}
//		for ( Integer i=0; i<edad.size();i++) {
//		sum+= edad.get(i);
//		}	
		res= (double) sum/numeroPacientesFactorRiesgo();
		return res;
	}

	@Override
	public List<PacienteEstudio> filtraPacientesPorEdad(Double edad) {
		List<PacienteEstudio> ls= new ArrayList<PacienteEstudio>();
		for (PacienteEstudio p : lista) {
			if(p.edad().equals(edad)) {
				ls.add(p);
			}
		}
		return ls;
	}

	@Override
	public Map<String, List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad) {
		Map<String,List<PacienteEstudio>> dicc= new HashMap<String,List<PacienteEstudio>>();
		List<PacienteEstudio> lsMasc= new ArrayList<PacienteEstudio>();
		List<PacienteEstudio> lsFem= new ArrayList<PacienteEstudio>();
		Set<String> genero =new HashSet<String>();
		
		
		for (PacienteEstudio p: lista) {
			genero.add(p.genero());
			
			if ( p.edad()>= edad) {
			String clave = p.genero();
					

				
				if (clave.equals("Male")) {
					lsMasc.add(p);
					dicc.put(clave, lsMasc);
				}
				else if(clave.equals("Female")) {
					lsFem.add(p);
					dicc.put(clave, lsFem);
					
				}
			}
			
		}
		
		return dicc;
	}

	@Override
	public Map<String, Long> numeroPacientesPorGenero() {
		Map<String,Long> res= new HashMap<String,Long>();
		List<PacienteEstudio> female= new ArrayList<PacienteEstudio>();
		List<PacienteEstudio> male= new ArrayList<PacienteEstudio>();
		
		for ( PacienteEstudio p : lista) {
			if (p.genero().equals("Male")) {
				male.add(p);
			}
			else if( p.genero().equals("Female")) {
				female.add(p);
			}	
		}
		res.put("female", (long) female.size());
		res.put("male", (long) male.size());
		return res;
		
	}
		

	@Override
	public Map<String, Double> edadMediaPacientesPorPorGenero() {
		Map<String,Double> res= new HashMap<String,Double>();
		Map<String,Integer> cont = new HashMap<String,Integer>();
		Map<String,Double> n = new HashMap<String,Double>();
		Set<String> genero = new HashSet<String>();
		for ( PacienteEstudio p : lista) {
			String clave = p.genero();
			genero.add(clave);
			if (cont.get(clave)==null) {
				cont.put(clave, 1); 
			}
			
			else {
				cont.put(clave, cont.get(clave)+1);
			}
			
			if (n.get(clave)==null) {
				n.put(clave, p.edad());
			}
			else {
				n.put(clave, n.get(clave)+p.edad());
			}
			for (String gen: genero) {
				res.put(gen, n.get(gen)/cont.get(gen));
			}
		}
		return res;
	}

}
