package fp.farmaceutico.test;
import java.time.LocalDate;

import fp.farmaceutico.*;
public class TestMedicamento {

	public static void main(String[] args) {
		Medicamento m1= new Medicamento("efavirenz",TipoMedicamento.ANATOMICO,"Y212XXA","Actavis Mid Atlantic LLC",90.0,1848,LocalDate.of(2018, 12, 1));
		System.out.println("==m1==");
		System.out.println(m1);
		System.out.println("==Parsea==");
		System.out.println(Medicamento.parseaMedicamento("efavirenz,anatomico,Y212XXA,Actavis Mid Atlantic LLC,90.0,1848,04/12/2019"));
		System.out.println("==tratarEnfermedad==");
		System.out.println(m1.tratarEnfermedad("Y212X0A"));
	}
 
}
