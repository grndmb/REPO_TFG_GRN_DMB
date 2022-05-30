package persistencia;
// Generated 17 may. 2022 10:17:02 by Hibernate Tools 5.4.32.Final

import java.util.Date;

/**
 * Convenio generated by hbm2java
 */
public class Convenio implements java.io.Serializable {

	private Integer id;
	private Empresa empresa;
	private String idConvenio;
	private String tipoConvenio;
	private Date fechaAnexo;

	public Convenio() {
	}

	public Convenio(Empresa empresa, String idConvenio, String tipoConvenio, Date fechaAnexo) {
		this.empresa = empresa;
		this.idConvenio = idConvenio;
		this.tipoConvenio = tipoConvenio;
		this.fechaAnexo = fechaAnexo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getIdConvenio() {
		return this.idConvenio;
	}

	public void setIdConvenio(String idConvenio) {
		this.idConvenio = idConvenio;
	}

	public String getTipoConvenio() {
		return this.tipoConvenio;
	}

	public void setTipoConvenio(String tipoConvenio) {
		this.tipoConvenio = tipoConvenio;
	}

	public Date getFechaAnexo() {
		return this.fechaAnexo;
	}

	public void setFechaAnexo(Date fechaAnexo) {
		this.fechaAnexo = fechaAnexo;
	}

	@Override
	public String toString() {
		return "  " + tipoConvenio + "                          " + fechaAnexo + "                                " + idConvenio;
	}

	
	public String toStringAnexar() {
	return tipoConvenio+"              "+idConvenio+"          "+empresa.getNombreEmpresa();
	}
}
