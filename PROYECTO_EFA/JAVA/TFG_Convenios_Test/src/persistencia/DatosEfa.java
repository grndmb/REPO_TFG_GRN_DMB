package persistencia;
// Generated 14 jun. 2022 12:36:32 by Hibernate Tools 5.4.21.Final

/**
 * DatosEfa generated by hbm2java
 */
public class DatosEfa implements java.io.Serializable {

	private String nombre;
	private Poblacion poblacion;
	private String direccion;
	private int telefono;
	private int fax;
	private String paginaWeb;
	private String nombreDirector;
	private String dniDirector;

	public DatosEfa() {
	}

	public DatosEfa(String nombre, Poblacion poblacion, String direccion, int telefono, int fax, String paginaWeb,
			String nombreDirector, String dniDirector) {
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fax = fax;
		this.paginaWeb = paginaWeb;
		this.nombreDirector = nombreDirector;
		this.dniDirector = dniDirector;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Poblacion getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getFax() {
		return this.fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getPaginaWeb() {
		return this.paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getNombreDirector() {
		return this.nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public String getDniDirector() {
		return this.dniDirector;
	}

	public void setDniDirector(String dniDirector) {
		this.dniDirector = dniDirector;
	}

}
