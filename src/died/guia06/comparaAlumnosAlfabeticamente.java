package died.guia06;

import died.guia06.Alumno;

import java.util.Comparator;

public class comparaAlumnosAlfabeticamente implements Comparator<Alumno> {


    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
