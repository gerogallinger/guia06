package died.guia06;

import java.util.*;

import died.guia06.excepciones.ExcepcionCreditosRequeridos;
import died.guia06.excepciones.ExcepcionCuposCubierto;
import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso  {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}

	public void setInscriptos(Alumno a){
		this.inscriptos.add(a);
	}

	public List<Alumno> getInscriptos(){
		return inscriptos;
	}

	public Registro getLog() {
		return log;
	}

	public void setLog(Registro log) {
		this.log = log;
	}

	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) throws ExcepcionCreditosRequeridos, ExcepcionCuposCubierto {
		//log.registrar(this, "inscribir ",a.toString());

		if(a.obtenerCreditoAlumno()> creditosRequeridos){
			if(cupo>0){
				if(a.getCursando().size()<3 ){
					a.setCursando(this);
					this.inscriptos.add(a);
					this.cupo = this.cupo -1;
					return true;
				}
			}else{
				if(cupo ==0){
					ExcepcionCuposCubierto e2 = new ExcepcionCuposCubierto("Cupos del curso cubierto");
					throw e2;
				}
			}
		}else {
			ExcepcionCreditosRequeridos e1 = new ExcepcionCreditosRequeridos("Creditos Requeridos insuficientes");
			throw e1;
		}


		return false;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		List<Alumno> imprInscr = inscriptos;

 		System.out.println("Lista de inscriptos sin orden: ");
		mostrarCreditosSinOrden(imprInscr);
		System.out.println("Lista de inscriptos ordenado alfabeticamente: ");
		mostrarAlfabeticamente(imprInscr);
		System.out.println("Lista de inscriptos ordenado por libreta : ");
		mostrarLibretaUniversitaria(imprInscr);
		System.out.println("Lista de inscriptos ordenado por creditos: ");
		mostrarCreditosObtenidos(imprInscr);


		//log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
	}
	public void mostrarAlfabeticamente(List<Alumno> imprInscr){
		Collections.sort(imprInscr, new comparaAlumnosAlfabeticamente());
		for(int i = 0; i<imprInscr.size();i++){
			System.out.println(imprInscr.get(i).getNombre());
			//System.out.println(imprInscr.get(i).getNroLibreta());
		}
	}
	public void mostrarLibretaUniversitaria(List<Alumno> insc){
		Collections.sort(insc, new comparaAlumnosLibreta());
		for(int i = 0; i<insc.size();i++){
			System.out.println(insc.get(i).getNombre());
			//System.out.println(imprInscr.get(i).getNroLibreta());
		}
	}
	public void mostrarCreditosObtenidos(List<Alumno> insc){
		Collections.sort(insc, new comparaAlumnosCreditos());
		for(int i = 0; i<insc.size();i++){
			System.out.println(insc.get(i).getNombre());
			//System.out.println(imprInscr.get(i).getNroLibreta());
		}
	}
	public void mostrarCreditosSinOrden(List<Alumno> insc){
		for(int i = 0; i<insc.size();i++){
			System.out.println(insc.get(i).getNombre());
			//System.out.println(imprInscr.get(i).getNroLibreta());
		}
	}


	public int compare(Alumno a, Alumno b) {
		return a.getNombre().compareTo(b.getNombre());
	}
}
