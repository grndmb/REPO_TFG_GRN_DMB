package persistencia;
// Generated 9 may. 2022 16:28:04 by Hibernate Tools 5.4.32.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Empresa generated by hbm2java
 */
public class Empresa implements java.io.Serializable {

	private String cifEmpresa;
	private Poblacion poblacion;
	private String nombreEmpresa;
	private String direccionEmpresa;
	private String emailEmpresa;
	private Integer telefono1;
	private Integer telefono2;
	private String faxEmpresa;
	private String paginaWeb;
	private String dniGerente;
	private String nombreGerente;
	private String dniPersonaContacto;
	private String personaContacto;
	private Date fechaActualizacion;
	private boolean organismoPublico;
	private String observaciones;
	private Set convenios = new HashSet(0);
	private Set anexars = new HashSet(0);

	public Empresa() {
	}

	public Empresa(String cifEmpresa, Poblacion poblacion, String nombreEmpresa, String direccionEmpresa,
			String emailEmpresa, String dniGerente, String nombreGerente, String dniPersonaContacto,
			String personaContacto, Date fechaActualizacion, boolean organismoPublico) {
		this.cifEmpresa = cifEmpresa;
		this.poblacion = poblacion;
		this.nombreEmpresa = nombreEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.emailEmpresa = emailEmpresa;
		this.dniGerente = dniGerente;
		this.nombreGerente = nombreGerente;
		this.dniPersonaContacto = dniPersonaContacto;
		this.personaContacto = personaContacto;
		this.fechaActualizacion = fechaActualizacion;
		this.organismoPublico = organismoPublico;
	}

	public Empresa(String cifEmpresa, Poblacion poblacion, String nombreEmpresa, String direccionEmpresa,
			String emailEmpresa, Integer telefono1, Integer telefono2, String faxEmpresa, String paginaWeb,
			String dniGerente, String nombreGerente, String dniPersonaContacto, String personaContacto,
			Date fechaActualizacion, boolean organismoPublico, String observaciones, Set convenios, Set anexars) {
		this.cifEmpresa = cifEmpresa;
		this.poblacion = poblacion;
		this.nombreEmpresa = nombreEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.emailEmpresa = emailEmpresa;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.faxEmpresa = faxEmpresa;
		this.paginaWeb = paginaWeb;
		this.dniGerente = dniGerente;
		this.nombreGerente = nombreGerente;
		this.dniPersonaContacto = dniPersonaContacto;
		this.personaContacto = personaContacto;
		this.fechaActualizacion = fechaActualizacion;
		this.organismoPublico = organismoPublico;
		this.observaciones = observaciones;
		this.convenios = convenios;
		this.anexars = anexars;
	}

	public String getCifEmpresa() {
		return this.cifEmpresa;
	}

	public void setCifEmpresa(String cifEmpresa) {
		this.cifEmpresa = cifEmpresa;
	}

	public Poblacion getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccionEmpresa() {
		return this.direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getEmailEmpresa() {
		return this.emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public Integer getTelefono1() {
		return this.telefono1;
	}

	public void setTelefono1(Integer telefono1) {
		this.telefono1 = telefono1;
	}

	public Integer getTelefono2() {
		return this.telefono2;
	}

	public void setTelefono2(Integer telefono2) {
		this.telefono2 = telefono2;
	}

	public String getFaxEmpresa() {
		return this.faxEmpresa;
	}

	public void setFaxEmpresa(String faxEmpresa) {
		this.faxEmpresa = faxEmpresa;
	}

	public String getPaginaWeb() {
		return this.paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getDniGerente() {
		return this.dniGerente;
	}

	public void setDniGerente(String dniGerente) {
		this.dniGerente = dniGerente;
	}

	public String getNombreGerente() {
		return this.nombreGerente;
	}

	public void setNombreGerente(String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}

	public String getDniPersonaContacto() {
		return this.dniPersonaContacto;
	}

	public void setDniPersonaContacto(String dniPersonaContacto) {
		this.dniPersonaContacto = dniPersonaContacto;
	}

	public String getPersonaContacto() {
		return this.personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public boolean isOrganismoPublico() {
		return this.organismoPublico;
	}

	public void setOrganismoPublico(boolean organismoPublico) {
		this.organismoPublico = organismoPublico;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Set getConvenios() {
		return this.convenios;
	}

	public void setConvenios(Set convenios) {
		this.convenios = convenios;
	}

	public Set getAnexars() {
		return this.anexars;
	}

	public void setAnexars(Set anexars) {
		this.anexars = anexars;
	}

}
