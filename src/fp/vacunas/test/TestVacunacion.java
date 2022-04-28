package fp.vacunas.test;
import java.time.LocalDate;

import fp.vacunas.Vacunacion;

public class TestVacunacion {

	public static void main(String[] args) {
		Vacunacion vacunacion1=Vacunacion.of(LocalDate.of(2022, 2, 1), "Extremadura",12431, 12000, 21000, 20500, 16700);
		Vacunacion vacunacion2=Vacunacion.of(LocalDate.of(2021, 9, 1), "Madrid", 30000, 23111, 39120, 18012, 19032);
		
		LocalDate f= LocalDate.of(2003, 12,2);
		System.out.println(vacunacion1);
		System.out.println("==f==");
		System.out.println(f);
		System.out.println("==compareTo==");
		System.out.println(vacunacion1.compareTo(vacunacion2));
		System.out.println("==parse==");
		System.out.println(Vacunacion.parse("04/12/2022;Andalucía;140295;0;0;0;0"));
	} 

}
