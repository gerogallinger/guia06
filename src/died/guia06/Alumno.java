package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno (){
		this.cursando = new ArrayList<>();
		this.aprobados = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public int creditosObtenidos() {
		return 1;
	}

	public void aprobar(Curso c) {
		//
	}
	public void setCursando(Curso c){
		this.cursando.add(c);
	}

	public void setAprobados(Curso c){
		this.aprobados.add(c);
	}

	public List<Curso> getAprobados(){
		return aprobados;
	}

	public List<Curso> getCursando(){
		return cursando;
	}

	public void inscripcionAceptada(Curso c) {
		//
	}
	public Integer obtenerCreditoAlumno() {
		Integer sumatoria = 0;
		for(int i = 0; i < aprobados.size(); i++) {
			sumatoria += aprobados.get(i).getCreditos();
		}
		return sumatoria;
	}


}
