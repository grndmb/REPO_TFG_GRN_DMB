package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import java.text.SimpleDateFormat;

import Vista.Vista;
import persistencia.Curso;
import persistencia.Poblacion;
import Modelo.Modelo;

public class Controlador implements ActionListener{
	//Objetos && Variables
	Vista vista = new Vista();

	//Constructor
	public Controlador(Vista v) {
		this.vista = v;
		
		this.vista.btnInicio.addActionListener(this);
		this.vista.btnAnadirAlumno.addActionListener(this);
		this.vista.btnNuevaEmpresa.addActionListener(this);
		this.vista.btnAnadirEmpresa.addActionListener(this);
		
		vista.panelInicio.setVisible(true);
		vista.panelNuevoAlumno.setVisible(false);
		vista.panelNuevaEmpresa.setVisible(false);
	}
	
	
	
	//Controlador de eventos
	@Override
	public void actionPerformed(ActionEvent e) {

		Modelo modelo = new Modelo();
		
		SessionFactory sessionFactory = null;

		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    sessionFactory = configuration.buildSessionFactory();
        
	    //Control de las acciones de los botones
	    
	        //Acciones del bot�n de INICIAR
		    if(e.getSource() == vista.btnInicio) {
		    	vista.panelInicio.setVisible(false);
				vista.panelNuevoAlumno.setVisible(true);
				
				//Rellenar combobox Curso y Codigo Postal
					this.rellenarComboBoxCursos(sessionFactory);
					this.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxPoblacionUSUAlumno);
			
			//Acciones del bot�n de A�adir Alumno
		    }if(e.getSource() == vista.btnAnadirAlumno) {
			
		    	//Llamamos al metodo que realiza el insert del nuevo alumno
				this.crearNuevoAlumno(sessionFactory, modelo);
				
			//Acciones del bot�n que lleva al panel de Nueva empresa	
			}if(e.getSource() == vista.btnNuevaEmpresa) {
				vista.panelNuevoAlumno.setVisible(false);
				vista.panelNuevaEmpresa.setVisible(true);
				//Rellenar combobox Codigo Postal
					this.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxPoblacionUSUEmpresa);
			
			//Acciones del bot�n de A�adir Empresa
			}if(e.getSource() == vista.btnAnadirEmpresa) {
		    	
				//Llamamos al metodo que realiza el insert de la nueva empresa
				this.crearNuevaEmpresa(sessionFactory, modelo);
				
			}
	}
	
	/*
	 * M�todos del panelNuevoAlumno
	 */
		//M�todo para rellenar el combobox que lista los cursos
			public void rellenarComboBoxCursos (SessionFactory sessionFactory) {
				Session session = null;
				
				try {
					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					Query query = session.createQuery("FROM Curso");
					ArrayList<Curso> listaCursos = (ArrayList<Curso>) query.list();
					
						vista.comboBoxNombreCursoUSUAlumno.addItem("");
					for(int i=0;i<listaCursos.size();i++) {
						vista.comboBoxNombreCursoUSUAlumno.addItem(listaCursos.get(i).getNombreCurso().toString());
					};
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					if(null != session) {
						session.getTransaction().rollback();
					}
				}finally {
					if(null != session) {
						session.close();
					}
				}
				
		 	   	
		    }
			
		//M�todo para rellenar el combobox que lista los codigos postales
			public void rellenarComboBoxCodigoPostal (SessionFactory sessionFactory, JComboBox combo) {
				Session session = null;
				
				try {
					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					Query query = sessionFactory.getCurrentSession().createQuery("FROM Poblacion ORDER BY Nombre ASC");
					ArrayList<Poblacion> listaCodigoPostales = (ArrayList<Poblacion>) query.list();
					
						combo.addItem("");
					for(int i=0;i<listaCodigoPostales.size();i++) {
						combo.addItem(listaCodigoPostales.get(i).getNombre());
					};
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					if(null != session) {
						session.getTransaction().rollback();
					}
				}finally {
					if(null != session) {
						session.close();
					}
				}
				
		    }
		
		//Metodo para hacer el insert del nuevo Alumno en la base de datos
			public void crearNuevoAlumno(SessionFactory sessionFactory, Modelo modelo) {
			
				try {
				// NIF
					String nif = vista.txtNIFUSUAlumno.getText();
					
				// NOMBRE COMPLETO
					String nombreCompleto = vista.txtNombreCompletoUSUAlumno.getText();
					
				// TELEFONO
					int telefono = Integer.parseInt(vista.txtTelefonoUSUAlumno.getText());

				// CORREO
					String correo = vista.txtCorreoUSUAlumno.getText();

				// FECHA NACIMIENTO
					Date fechaNacimientoUSU = vista.dateChooserFechaNacimientoUSUAlumno.getDate();
					java.sql.Date fechaNacimiento = new java.sql.Date(fechaNacimientoUSU.getTime());

				// POBLACION
					String poblacion = vista.comboBoxPoblacionUSUAlumno.getSelectedItem().toString();
					
				// CURSO
					String nombreCurso = vista.comboBoxNombreCursoUSUAlumno.getSelectedItem().toString();

					
				// INSERT
				modelo.crearAlumno(sessionFactory, nif, nombreCompleto, telefono, correo, fechaNacimiento,
						poblacion, nombreCurso);

				// RESET DEL FORMULARIO NUEVO ALUMNO
				this.resetFormularioNuevoAlumno();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		//Metodo para hacer el insert del nuevo Alumno en la base de datos
			public void crearNuevaEmpresa(SessionFactory sessionFactory, Modelo modelo) {
				
				try {
					
					// CIF
						String cifEmpresa = vista.txtCIFEmpresa.getText();
					
					// NOMBRE
						String nombreEmpresa = vista.txtNombreEmpresa.getText();
					
					// DIRECCION
						String direccionEmpresa = vista.txtDireccionEmpresa.getText();
						
					// POBLACION
						String poblacion = vista.comboBoxPoblacionUSUEmpresa.getSelectedItem().toString();
					
					// CORREO
						String emailEmpresa = vista.txtEmailEmpresa.getText();
				
					// TELEFONO 1 Y TELEFONO 2
						int telefono1 = Integer.parseInt(vista.txtTelefono1Empresa.getText());
						int telefono2 = Integer.parseInt(vista.txtTelefono2Empresa.getText());

					// FAX
						String faxEmpresa = vista.txtFaxEmpresa.getText();
					
					// PAGINA WEB
						String paginaWebEmpresa = vista.txtPaginaWebEmpresa.getText();
					
					// ORGANISMO PUBLICO
						boolean organismoPublico = false;
						if (vista.checkBoxOrganismoPublicoUSUEmpresa.isSelected()) {
							organismoPublico = true;
						} else {
							organismoPublico = false;
						}
					
					// DNI GERENTE
						String dniGerenteEmpresa = vista.txtDNIGerenteEmpresa.getText();
						
					// NOMBRE GERENTE
						String nombreGerenteEmpresa = vista.txtNombreGerenteEmpresa.getText();
						
					// PERSONA DE CONTACTO
						String personaContactoEmpresa = vista.txtPersonaContactoEmpresa.getText();
						
					// CARGO PERSONA DE CONTACTO
						String cargoPersonaContactoEmpresa = vista.txtCargoContactoEmpresaEmpresa.getText();
						
					// OBSERVACIONES
						String observacionesEmpresa = vista.txtObservacionesEmpresa.getText();
						
					// FECHA ACTUALIZACION DE LOS DATOS  
						Date fechaActualizacionUSU = vista.dateChooserFechaActualizacionEmpresa.getDate();
						java.sql.Date fechaActualizacion = new java.sql.Date(fechaActualizacionUSU.getTime());
					
						
					// INSERT
						modelo.crearEmpresas(sessionFactory, cifEmpresa, nombreEmpresa, direccionEmpresa, telefono1, telefono2, emailEmpresa, faxEmpresa, paginaWebEmpresa, nombreGerenteEmpresa, dniGerenteEmpresa, personaContactoEmpresa, cargoPersonaContactoEmpresa, fechaActualizacion, organismoPublico, observacionesEmpresa, poblacion);
				
					// RESET FORMULARIO NUEVA EMPRESA
						this.resetFormularioNuevaEmpresa();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		
		//M�todo para restablecer el formulario de nuevoAlumno
			public void resetFormularioNuevoAlumno() {
				try {
					vista.txtNIFUSUAlumno.setText("");
					vista.txtNombreCompletoUSUAlumno.setText("");
					vista.dateChooserFechaNacimientoUSUAlumno.setDate(null);
					vista.txtTelefonoUSUAlumno.setText("");
					vista.txtCorreoUSUAlumno.setText("");
					vista.comboBoxPoblacionUSUAlumno.setSelectedItem("");
					vista.comboBoxNombreCursoUSUAlumno.setSelectedItem("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		//M�todo para restablecer el formulario de nuevoAlumno
			public void resetFormularioNuevaEmpresa() {
				try {
					vista.txtCIFEmpresa.setText("");
					vista.txtNombreEmpresa.setText("");
					vista.txtDireccionEmpresa.setText("");
					vista.comboBoxPoblacionUSUEmpresa.setSelectedItem("");
					vista.txtEmailEmpresa.setText("");
					vista.txtTelefono1Empresa.setText("");
					vista.txtTelefono2Empresa.setText("");
					vista.txtFaxEmpresa.setText("");
					vista.txtPaginaWebEmpresa.setText("");
					vista.checkBoxOrganismoPublicoUSUEmpresa.setSelected(false);
					vista.txtDNIGerenteEmpresa.setText("");
					vista.txtNombreGerenteEmpresa.setText("");
					vista.txtPersonaContactoEmpresa.setText("");
					vista.txtCargoContactoEmpresaEmpresa.setText("");
					vista.txtObservacionesEmpresa.setText("");
					vista.dateChooserFechaActualizacionEmpresa.setDate(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
}