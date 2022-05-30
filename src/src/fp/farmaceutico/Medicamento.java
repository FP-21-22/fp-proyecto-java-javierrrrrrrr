package fp.farmaceutico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import fp.utiles.Checkers;

public class Medicamento {
	//Atributos:
	
	public String nombreMedicamento;
	public TipoMedicamento tipoMedicamento;
	public String  codigoEnfermedad;
	public String farmaceutica;
	public Double puntuacion;
	public Integer indiceSomatico;
	public LocalDate fechaCatalogo;
	
	//Constructores:
	public Medicamento(String nombreMedicamento, TipoMedicamento tipoMedicamento, String codigoEnfermedad,
			String farmaceutica, Double puntuacion, Integer indiceSomatico, LocalDate fechaCatalogo) {
		LocalDate fecha1enero=LocalDate.of(2015, 1, 1);
		Checkers.check(" La puntación tiene que ser mayor estricta que cero", puntuacion>0);
		Checkers.check("El índice somático tiene que ser mayor o igual que 1000", indiceSomatico>= 1000);
		Checkers.check(" La fecha de catálogo tiene que ser posterior al 01/01/2015 ", fechaCatalogo.isAfter(fecha1enero));
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.codigoEnfermedad = codigoEnfermedad;
		this.farmaceutica = farmaceutica;
		this.puntuacion = puntuacion;
		this.indiceSomatico = indiceSomatico;
		this.fechaCatalogo = fechaCatalogo;
	} 
	


 
	//Representación cómo cadena:
	
	@Override
	public String toString() {
		return "Medicamento [nombreMedicamento=" + nombreMedicamento + ", farmaceutica=" + farmaceutica + "]";
	}

	
	//Criterio de igualdad:
	
	@Override
	public int hashCode() {
		return Objects.hash(farmaceutica, nombreMedicamento);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(farmaceutica, other.farmaceutica)
				&& Objects.equals(nombreMedicamento, other.nombreMedicamento);
	}


	//Propiedad derivada:
	
	public Boolean tratarEnfermedad(String codigo) {
		
		Boolean res= false; 
		
		if (codigoEnfermedad== codigo) {
			res= true;
		}
		return res;
		
	}


	//Obtención de getters y setters:
	
	public LocalDate getFechaCatalogo() {
		return fechaCatalogo;
	}

	public void setFechaCatalogo(LocalDate fechaCatalogo) {
		LocalDate fecha1enero=LocalDate.of(2015, 1, 1);
		Checkers.check(" La fecha de catálogo tiene que ser posterior al 01/01/2015 ", fechaCatalogo.isAfter(fecha1enero));
		this.fechaCatalogo = fechaCatalogo;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public String getCodigoEnfermedad() {
		return codigoEnfermedad;
	}

	public String getFarmaceutica() {
		return farmaceutica;
	}

	public Double getPuntuacion() {
		
		return puntuacion;
	}
	
	public Integer getIndiceSomatico() {
		return indiceSomatico;
	}
	
	//Parsea Medicamento:
	public static Medicamento parseaMedicamento(String texto){
		String[] medicamento= texto.split(",");
		String nombreMedicamiento= medicamento[0];
		TipoMedicamento tipoMedicamento= TipoMedicamento.valueOf(medicamento[1].toUpperCase());
		String codigoEnfermedad= medicamento[2];
		String farmaceutica= medicamento[3];
		Double puntuacion= Double.parseDouble(medicamento[4]);
		Integer indiceSomatico =Integer.parseInt(medicamento[5]);
		LocalDate fechaCatalogo = LocalDate.parse(medicamento[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Medicamento(nombreMedicamiento,tipoMedicamento,codigoEnfermedad,farmaceutica,puntuacion,indiceSomatico,fechaCatalogo);
		
		}
	//TEST:
	public static void main(String[] args) {
		Medicamento m1= new Medicamento("efavirenz",TipoMedicamento.ANATOMICO,"Y212XXA","Actavis Mid Atlantic LLC",90.0,1848,LocalDate.of(2018, 12, 1));
		System.out.println("==m1==");
		System.out.println(m1);
		System.out.println("==Parsea==");
		System.out.println(parseaMedicamento("efavirenz,anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019"));
		System.out.println("==tratarEnfermedad==");
		System.out.println(m1.tratarEnfermedad("Y212X0A"));
	}
	}
