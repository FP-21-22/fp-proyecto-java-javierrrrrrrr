package fp.clinico.test;

import java.util.List;
import java.util.Map;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoBucles;
import fp.clinico.PacienteEstudio;
import fp.clinico.TipoResidencia;

public class TestEstudioClinicoBucles {

	public static void main(String[] args) {
		
		EstudioClinico pacientes= new EstudioClinicoBucles();
		
		String ruta = "data/estudio_clinico.csv";
		EstudioClinico pacientesbucle = pacientes.of(ruta);
		List<PacienteEstudio> lista= pacientes.leeFichero(ruta);
		PacienteEstudio p1= PacienteEstudio.of("43822","Male",42.,false,false,TipoResidencia.RURAL,60.6);
		
		
		
		System.out.println(lista);

//		for (PacienteEstudio e: lista) {
//			System.out.println(e);
//			b.incluyePacientes(lista);
//			System.out.println(b);
//			}
		
		System.out.println("========= Numero de Pacientes =========");
		Integer m1=pacientesbucle.numeroPacientes();
		System.out.println(m1);
		
		System.out.println("========= Está el paciente p =========");
		Boolean m2= pacientesbucle.estaPaciente(p1);
		System.out.println(m2);
		
		System.out.println("========= Pacientes de Residencia Urbana =========");
		Boolean m3 = pacientesbucle.todosPacienteSonDelTipo(TipoResidencia.URBANA); 
		System.out.println(m3);
		
		System.out.println("========= Existe Algún Paciente de Residencia Rural =========");
		 Boolean m4= pacientesbucle.existeAlgunPacienteDelTipo(TipoResidencia.RURAL); 
		 System.out.println(m4);
		 
		 System.out.println("========= Numero de Pacientes de Factor de Riesgo =========");
		 Integer m5= pacientesbucle.numeroPacientesFactorRiesgo(); 
		 System.out.println(m5);
		 
		 System.out.println("========= Edad Media de los Pacientes de Factor de Riesgo =========");
		 Double m6=  pacientesbucle.edadMediaPacientesConFactorRiesgo(); 
		 System.out.println(m6);
		 
		 System.out.println("========= Filtra Pacientes por Edad =========");
		List<PacienteEstudio> m7 = pacientesbucle.filtraPacientesPorEdad(44.);
		System.out.println(m7);
		
		System.out.println("========= Agrupa Pacientes Mayores de una Edad Por Genero =========");
		Map<String, List<PacienteEstudio>> m8= pacientesbucle.agruparPacientesEdadMayorQuePorGenero(80.);
	    System.out.println(m8);
		
		System.out.println("========= Número de Pacientes por Genero =========");
		Map<String, Long> m9= pacientesbucle.numeroPacientesPorGenero();
		System.out.println(m9);
		  
		System.out.println("========= Edad Media de los Pacientes por Genero =========");
		Map<String, Double>m10 =pacientesbucle.edadMediaPacientesPorPorGenero();
		System.out.println(m10);
		
	
	
	}

}
