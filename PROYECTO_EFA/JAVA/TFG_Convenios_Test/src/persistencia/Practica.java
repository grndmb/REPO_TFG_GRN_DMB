package persistencia;
// Generated 17 may. 2022 10:17:02 by Hibernate Tools 5.4.32.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Practica generated by hbm2java
 */
public class Practica implements java.io.Serializable {

	private int idPractica;
	private Curso curso;
	private Profesor profesor;
	private String tipoPractica;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean enProceso;
	private Set anexars = new HashSet(0);

	public Practica() {
	}

	public Practica(int idPractica, Curso curso, Profesor profesor, String tipoPractica, Date fechaInicio,
			Date fechaFin, boolean enProceso) {
		this.idPractica = idPractica;
		this.curso = curso;
		this.profesor = profesor;
		this.tipoPractica = tipoPractica;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.enProceso = enProceso;
	}

	public Practica(int idPractica, Curso curso, Profesor profesor, String tipoPractica, Date fechaInicio,
			Date fechaFin, boolean enProceso, Set anexars) {
		this.idPractica = idPractica;
		this.curso = curso;
		this.profesor = profesor;
		this.tipoPractica = tipoPractica;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.enProceso = enProceso;
		this.anexars = anexars;
	}

	public int getIdPractica() {
		return this.idPractica;
	}

	public void setIdPractica(int idPractica) {
		this.idPractica = idPractica;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public String getTipoPractica() {
		return this.tipoPractica;
	}

	public void setTipoPractica(String tipoPractica) {
		this.tipoPractica = tipoPractica;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isEnProceso() {
		return this.enProceso;
	}

	public void setEnProceso(boolean enProceso) {
		this.enProceso = enProceso;
	}

	public Set getAnexars() {
		return this.anexars;
	}

	public void setAnexars(Set anexars) {
		this.anexars = anexars;
	}

	@Override
	public String toString() {
		return "- " + tipoPractica + "   ("+ fechaInicio + " -- " + fechaFin + ") --> *"+curso+"*" ;
	}


	
}
