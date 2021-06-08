package died.guia06;


import died.guia06.Alumno;

import java.util.Comparator;

public class comparaAlumnosLibreta implements Comparator<Alumno> {
    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.getNroLibreta().compareTo(o2.getNroLibreta());
    }

}




