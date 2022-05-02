package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		this.vista.comboBoxPoblacionUSUAlumno.addActionListener(this);
		
		
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
					this.rellenarComboBoxNombreCiudad(sessionFactory,vista.comboBoxPoblacionUSUAlumno);
				
			
			//Acciones del bot�n de A�adir Alumno
		    }if(e.getSource() == vista.comboBoxPoblacionUSUAlumno) {
		    	
				this.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxPoblacionUSUAlumno, vista.comboBoxCodigoPostalUSUAlumno);
		    	
		    }
		    
		    
		    if(e.getSource() == vista.btnAnadirAlumno) {
			
		    	if(this.anadirAlumnoValido() == true) {
		    		//Llamamos al metodo que realiza el insert del nuevo alumno
					this.crearNuevoAlumno(sessionFactory, modelo);
		    	}
		    	
				
			//Acciones del bot�n que lleva al panel de Nueva empresa	
			}if(e.getSource() == vista.btnNuevaEmpresa) {
				vista.panelNuevoAlumno.setVisible(false);
				vista.panelNuevaEmpresa.setVisible(true);
				//Rellenar combobox Codigo Postal
					this.rellenarComboBoxNombreCiudad(sessionFactory,vista.comboBoxPoblacionUSUEmpresa);
			
				//Rellena el label con la fecha actualizacion =  fecha actual
					String fechaActualizacion = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
					vista.lblFechaActualizacionUSUEmpresa.setText(fechaActualizacion);
					
			        
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
			@SuppressWarnings("deprecation")
			public void rellenarComboBoxNombreCiudad (SessionFactory sessionFactory, JComboBox comboPoblacionNombre) {
				Session session = null;
				
				try {
					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					/**
					 * Consulta para obtener los nombres de las poblaciones
					 */
					
					
					
					Query query = sessionFactory.getCurrentSession().createQuery("FROM Poblacion ORDER BY Nombre ASC");
					query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
					ArrayList<Poblacion> listaNombresPoblacion = (ArrayList<Poblacion>) query.list();
					
						comboPoblacionNombre.addItem("");
						
					for(int i=0;i<listaNombresPoblacion.size();i++) {
						comboPoblacionNombre.addItem(listaNombresPoblacion.get(i).getNombre());
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
			
			public void rellenarComboBoxCodigoPostal (SessionFactory sessionFactory,JComboBox comboPoblacionNombre, JComboBox comboPoblacionCP) {
				
				Session session = null; 
				
				try {
					
					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					comboPoblacionCP.removeAllItems();
					
					/**
					 * Consulta para obtener los codigos postales de la ciudad seleccionada en el combobox anterior.
					 */
					Query query = sessionFactory.getCurrentSession().createQuery("FROM Poblacion WHERE nombre = :nombre");
					query.setParameter("nombre", comboPoblacionNombre.getSelectedItem().toString());
					ArrayList<Poblacion> listaCodigoPostales = (ArrayList<Poblacion>) query.list();
					
					for(int i=0;i<listaCodigoPostales.size();i++) {
						comboPoblacionCP.addItem(listaCodigoPostales.get(i).getCodigoPostal());
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

				// CODIGO POSTAL
					int codigoPostal = Integer.parseInt(vista.comboBoxCodigoPostalUSUAlumno.getSelectedItem().toString());
					
				// CURSO
					String nombreCurso = vista.comboBoxNombreCursoUSUAlumno.getSelectedItem().toString();

					
				// INSERT
				modelo.crearAlumno(sessionFactory, nif, nombreCompleto, telefono, correo, fechaNacimiento,
						codigoPostal, nombreCurso);

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
				        
				        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				        Date fechaActualizacionEmpresa = format.parse(vista.lblFechaActualizacionUSUEmpresa.getText());
				        java.sql.Date fecha = new java.sql.Date(fechaActualizacionEmpresa.getTime());
					        
						
				        
					// INSERT
						modelo.crearEmpresas(sessionFactory, cifEmpresa, nombreEmpresa, direccionEmpresa, telefono1, telefono2, emailEmpresa, faxEmpresa, paginaWebEmpresa, nombreGerenteEmpresa, dniGerenteEmpresa, personaContactoEmpresa, cargoPersonaContactoEmpresa, fecha, organismoPublico, observacionesEmpresa, poblacion);
				
					// RESET FORMULARIO NUEVA EMPRESA
						this.resetFormularioNuevaEmpresa();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		//Metodo para validar que todo los campos del alumno est�n rellenos
			public boolean anadirAlumnoValido() {
				boolean valido = true;

				try {
					
					if(
						vista.txtNIFUSUAlumno.getText().equals("")
						&& vista.txtNombreCompletoUSUAlumno.getText().equals("")
						&& vista.dateChooserFechaNacimientoUSUAlumno != null
						&& vista.txtTelefonoUSUAlumno.getText().equals("")
						&& vista.txtCorreoUSUAlumno.getText().equals("")
						&& vista.comboBoxPoblacionUSUAlumno.getSelectedItem().equals("")
						&& vista.comboBoxCodigoPostalUSUAlumno.getSelectedItem().equals("")
						&& vista.comboBoxNombreCursoUSUAlumno.getSelectedItem().equals("")
							) {
						valido = false;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return valido;
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
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
}