package fp.clinico.test;
import fp.clinico.PacienteEstudio;
import fp.clinico.TipoResidencia;

public class TestPacienteEstudio {
	public static void main(String[] args) {
		PacienteEstudio paciente1= PacienteEstudio.of("2431934Ñ", "Male",50., false, false, TipoResidencia.URBANA, 83.78);
		PacienteEstudio paciente2= PacienteEstudio.of("23231934P", "Female",46., false, false, TipoResidencia.RURAL, 82.78);
		System.out.println(paciente1);
		
	
		//RESTRICCIONES
		//PacienteEstudio pacienteRest1= PacienteEstudio.of("23564763K", "Male", 131., false, false, TipoResidencia.RURAL, 84.54);
		//PacienteEstudio pacienteRest2=PacienteEstudio.of("23575763W", "Male", 65., false, false, TipoResidencia.RURAL, -45.);
		//System.out.println(pacienteRest1);
		//System.out.println(pacienteRest2);
		
		System.out.println("==paciente2==");
		System.out.println(paciente2);
		System.out.println("==toString==");
		//System.out.println(paciente1.toString());
		System.out.println("==parse==");
		System.out.println(paciente2.parse("63063234K;Female;80.;false;false;URBANA;83.84"));
		System.out.println("==compareTo==");
		System.out.println(paciente1.compareTo(paciente2));
		}


}
