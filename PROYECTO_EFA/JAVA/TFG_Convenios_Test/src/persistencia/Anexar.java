package persistencia;
// Generated 17 may. 2022 10:17:02 by Hibernate Tools 5.4.32.Final

/**
 * Anexar generated by hbm2java
 */
public class Anexar implements java.io.Serializable {

	private int idAnexado;
	private Alumno alumno;
	private Empresa empresa;
	private Practica practica;

	public Anexar() {
	}

	public Anexar(int idAnexado, Alumno alumno, Empresa empresa, Practica practica) {
		this.idAnexado = idAnexado;
		this.alumno = alumno;
		this.empresa = empresa;
		this.practica = practica;
	}

	public int getIdAnexado() {
		return this.idAnexado;
	}

	public void setIdAnexado(int idAnexado) {
		this.idAnexado = idAnexado;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Practica getPractica() {
		return this.practica;
	}

	public void setPractica(Practica practica) {
		this.practica = practica;
	}

}
