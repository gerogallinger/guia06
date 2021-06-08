package died.guia06;

import java.util.Comparator;
import died.guia06.Alumno;

public class comparaAlumnosCreditos implements Comparator<Alumno> {


    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.obtenerCreditoAlumno().compareTo(o2.obtenerCreditoAlumno());

    }
}