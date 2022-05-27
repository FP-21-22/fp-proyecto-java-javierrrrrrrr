package fp.farmaceutico.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.farmaceutico.FactoriaMedicamentos;
import fp.farmaceutico.ListadoMedicamentos;
import fp.farmaceutico.Medicamento;
import fp.farmaceutico.TipoMedicamento;

public class TestListadoMedicamentos {

	public static void main(String[] args) {
		
		String ruta= "data/medicamentos.csv";
		List<Medicamento> lista= FactoriaMedicamentos.leeFichero(ruta);
		for (Medicamento e: lista) {
			System.out.println(e);
		}
		
		ListadoMedicamentos medicamento1=FactoriaMedicamentos.leeFichero3(ruta);
		
		System.out.println("========= Existe el medicamento segun un tipo y una fecha =========");
		boolean m1= medicamento1.existeMedicamentoSegunTipoAnteriorABoolean(TipoMedicamento.ANATOMICO, LocalDate.of(2010, 12, 21));
		System.out.println(m1);
		
		System.out.println("========= Nombre medicamentos con puntuación mayor a n =========");
		Set<String> m2= medicamento1.nombreMedicamentosPuntuacionMayorA(89.1);
		System.out.println(m2);
		
		System.out.println("========= Nombre del medicamento con mayor indice sómatico según un tipo de medicamento =========");
		String m3= medicamento1.nombreMedicamentoMayorIndiceSomaticoSegunTipoMedicamento(TipoMedicamento.TERAPEUTICO);
		System.out.println(m3);
		
		System.out.println("========= Agrupa los tipos de medicamentos según la puntuacion media =========");
		Map<TipoMedicamento,Double> m4= medicamento1.agrupaTipoMedicamentoSegunPuntuacionMedia();
		System.out.println(m4);
		
		System.out.println("========= Fecha de catálogo más frecuente =========");
		LocalDate m5= medicamento1.fechaCatalogoMasFrecuente();
		System.out.println(m5);
	}

}
