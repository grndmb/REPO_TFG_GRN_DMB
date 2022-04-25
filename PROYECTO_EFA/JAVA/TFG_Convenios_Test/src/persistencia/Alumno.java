package persistencia;
// Generated 25 abr. 2022 10:01:27 by Hibernate Tools 5.4.32.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Alumno generated by hbm2java
 */
public class Alumno implements java.io.Serializable {

	private String nif;
	private Curso curso;
	private Poblacion poblacion;
	private String nombreCompleto;
	private boolean seleccionado;
	private int telefono;
	private String correo;
	private Date fechaNacimiento;
	private Set anexars = new HashSet(0);

	public Alumno() {
	}

	public Alumno(String nif, Curso curso, Poblacion poblacion, String nombreCompleto, boolean seleccionado,
			int telefono, String correo, Date fechaNacimiento) {
		this.nif = nif;
		this.curso = curso;
		this.poblacion = poblacion;
		this.nombreCompleto = nombreCompleto;
		this.seleccionado = seleccionado;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Alumno(String nif, Curso curso, Poblacion poblacion, String nombreCompleto, boolean seleccionado,
			int telefono, String correo, Date fechaNacimiento, Set anexars) {
		this.nif = nif;
		this.curso = curso;
		this.poblacion = poblacion;
		this.nombreCompleto = nombreCompleto;
		this.seleccionado = seleccionado;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.anexars = anexars;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Poblacion getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public boolean isSeleccionado() {
		return this.seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set getAnexars() {
		return this.anexars;
	}

	public void setAnexars(Set anexars) {
		this.anexars = anexars;
	}

}
