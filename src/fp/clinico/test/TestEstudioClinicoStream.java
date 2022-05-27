package fp.clinico.test;

import java.util.List;
import java.util.Map;

import fp.clinico.EstudioClinico;
import fp.clinico.EstudioClinicoStream;
import fp.clinico.PacienteEstudio;
import fp.clinico.TipoResidencia;

public class TestEstudioClinicoStream {

	public static void main(String[] args) {
	EstudioClinico pacientes= new EstudioClinicoStream();
	String ruta= "data/estudio_clinico.csv";
	EstudioClinico pacientesStream= pacientes.of(ruta);
	PacienteEstudio p1= PacienteEstudio.of("43822","Male",42.,false,false,TipoResidencia.RURAL,60.6);
	
	System.out.println("========= Numero de Pacientes =========");
	Integer m1=pacientesStream.numeroPacientes();
	System.out.println(m1);
	
	System.out.println("========= Está el paciente p =========");
	Boolean m2= pacientesStream.estaPaciente(p1);
	System.out.println(m2);
	
	System.out.println("========= Pacientes de Residencia Urbana =========");
	Boolean m3 = pacientesStream.todosPacienteSonDelTipo(TipoResidencia.URBANA); 
	System.out.println(m3);
	
	System.out.println("========= Existe Algún Paciente de Residencia Rural =========");
	 Boolean m4= pacientesStream.existeAlgunPacienteDelTipo(TipoResidencia.RURAL); 
	 System.out.println(m4);
	 
	 System.out.println("========= Numero de Pacientes de Factor de Riesgo =========");
	 Integer m5= pacientesStream.numeroPacientesFactorRiesgo(); 
	 System.out.println(m5);
	 
	 System.out.println("========= Edad Media de los Pacientes de Factor de Riesgo =========");
	 Double m6=  pacientesStream.edadMediaPacientesConFactorRiesgo(); 
	 System.out.println(m6);
	 
	 System.out.println("========= Filtra Pacientes por Edad =========");
	List<PacienteEstudio> m7 = pacientesStream.filtraPacientesPorEdad(44.);
	System.out.println(m7);
	
	System.out.println("========= Agrupa Pacientes Mayores de una Edad Por Genero =========");
	Map<String, List<PacienteEstudio>> m8= pacientesStream.agruparPacientesEdadMayorQuePorGenero(80.);
    System.out.println(m8);
	
	System.out.println("========= Número de Pacientes por Genero =========");
	Map<String, Long> m9= pacientesStream.numeroPacientesPorGenero();
	System.out.println(m9);
	  
	System.out.println("========= Edad Media de los Pacientes por Genero =========");
	Map<String, Double>m10 =pacientesStream.edadMediaPacientesPorPorGenero();
	System.out.println(m10);
	
}

}