package died.guia06;

import died.guia06.excepciones.ExcepcionCreditosRequeridos;
import died.guia06.excepciones.ExcepcionCuposCubierto;

public class App {

	public static void main(String[] args)  {

		Alumno a1 = new Alumno();
		Alumno a2 = new Alumno();
		Alumno a3 = new Alumno();
		Curso c1 = new Curso();
		Curso c2 = new Curso();
		a1.setNombre("Pepito");
		a1.setNroLibreta(24063);
		a2.setNombre("Antonia");
		a2.setNroLibreta(24233);
		a3.setNombre("Zoe");
		a3.setNroLibreta(21433);


		c2.setNombre("literatura");
		c2.setId(1);
		c2.setCreditos(32);

		a1.setAprobados(c2);
		a2.setAprobados(c2);
		a3.setAprobados(c2);

		c1.setNombre("Matematica");
		c1.setId(4);
		c1.setCreditosRequeridos(2);
		c1.setCupo(2);
		try {
			c1.inscribir(a1);
			c1.inscribir(a2);
			c1.inscribir(a3);

		} catch (ExcepcionCreditosRequeridos e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
		}catch (ExcepcionCuposCubierto e1){
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		} finally {
			System.out.println("Entro al finally");
		}

		c1.imprimirInscriptos();


	}
}
