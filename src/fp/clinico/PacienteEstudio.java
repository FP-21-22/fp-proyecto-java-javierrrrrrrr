package fp.clinico;

import fp.utiles.Checkers;

public record PacienteEstudio(String id,String genero, Double edad,Boolean hipertension,
		Boolean enfermedadCorazon,TipoResidencia tipoResindencia,Double nivelMedioGlucosa) implements Comparable<PacienteEstudio>{

	//Método static of:
	public static PacienteEstudio of(String id,String genero, Double edad,Boolean hipertension,
			Boolean enfermedadCorazon,TipoResidencia tipoResidencia,Double nivelMedioGlucosa) {
		
		
		PacienteEstudio res= new PacienteEstudio(id,genero,edad,hipertension,enfermedadCorazon,tipoResidencia,nivelMedioGlucosa);
		return res;
	}
	
	
	//Restricciones:
	public PacienteEstudio{
		Checkers.check(" La edad tiene que ser mayor o igual que cero y menor o igual que 130", 0<=edad && edad<=130);
		Checkers.check("El nivel medio de glucosa tiene que ser mayor o igual que cero", nivelMedioGlucosa>=0);
		
	}
	
	//Método static parse:
	
	public static PacienteEstudio parse(String texto) {

		String[]  pacienteEstudio= texto.split(";");
		String id= pacienteEstudio[0];
		String genero= pacienteEstudio[1];
		Double edad= Double.parseDouble(pacienteEstudio[2]);
		Boolean hipertension=Boolean.parseBoolean(pacienteEstudio[3]);
		Boolean enfermedadCorazon= Boolean.parseBoolean(pacienteEstudio[4]);
		TipoResidencia tipoResidencia= TipoResidencia.valueOf(pacienteEstudio[5]);
		Double nivelMedioGlucosa=Double.parseDouble(pacienteEstudio[6]);
		
		return new PacienteEstudio(id,genero,edad,hipertension,enfermedadCorazon,tipoResidencia,nivelMedioGlucosa);
	
	}
	
	
	
	//Propiedad Derivada:
	
	public Boolean factorRiesgo() {
		Boolean res=true;
		
		if (hipertension && edad>40) {
			res=true;
			}
		else {
			res=false;
		}
		return res;
	}
	
	//Representación como cadena:
	
//	public String toString() {
//		
//		String res= "id="+id+", edad="+edad;
//		return res;
//	}
	
	//Orden Natural:
	
	@Override
	public int compareTo(PacienteEstudio o) {
		
		int res= this.edad().compareTo(o.edad());
		if ( res== 0) {
			res= this.id().compareTo(o.id());		}
		return res;
		
		
	}
	
	//TEST:
	
	public static void main(String[] args) {
		PacienteEstudio paciente1= PacienteEstudio.of("2431934Ñ", "Male",50., false, false, TipoResidencia.URBANA, 83.78);
		PacienteEstudio paciente2= PacienteEstudio.of("23231934P", "Female",46., false, false, TipoResidencia.RURAL, 83.78);
		System.out.println(paciente1);
		
		//RESTRICCIONES
		//PacienteEstudio pacienteRest1= PacienteEstudio.of("23564763K", "Male", 131., false, false, TipoResidencia.RURAL, 84.54);
		//PacienteEstudio pacienteRest2=PacienteEstudio.of("23575763W", "Male", 65., false, false, TipoResidencia.RURAL, -45.);
		//System.out.println(pacienteRest1);
		//System.out.println(pacienteRest2);
	
		System.out.println("==paciente2==");
		System.out.println(paciente2);
		System.out.println("==toString==");
		System.out.println(paciente1.toString());
		System.out.println("==parse==");
		System.out.println(parse("63063234K;Female;80.;false;false;URBANA;83.84" ));
		System.out.println("==compareTo==");
		System.out.println(paciente1.compareTo(paciente2));
		}

	
}
