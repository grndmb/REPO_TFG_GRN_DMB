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
	    
	        //Acciones del botón de INICIAR
		    if(e.getSource() == vista.btnInicio) {
		    	vista.panelInicio.setVisible(false);
				vista.panelNuevoAlumno.setVisible(true);
				
				//Rellenar combobox Curso y Codigo Postal
					this.rellenarComboBoxCursos(sessionFactory);
					this.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxCodigoPostalUSUAlumno);
			
			//Acciones del botón de Añadir Alumno
		    }if(e.getSource() == vista.btnAnadirAlumno) {
			
		    	//Llamamos al metodo que realiza el insert del nuevo alumno
				this.crearNuevoAlumno(sessionFactory, modelo);
				
			//Acciones del botón que lleva al panel de Nueva empresa	
			}if(e.getSource() == vista.btnNuevaEmpresa) {
				vista.panelNuevoAlumno.setVisible(false);
				vista.panelNuevaEmpresa.setVisible(true);
				//Rellenar combobox Codigo Postal
					this.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxCodigoPostalUSUEmpresa);
			
			//Acciones del botón de Añadir Empresa
			}if(e.getSource() == vista.btnAnadirEmpresa) {
		    	
				//Llamamos al metodo que realiza el insert de la nueva empresa
				this.crearNuevaEmpresa(sessionFactory, modelo);
				
			}
	}
	
	/*
	 * Métodos del panelNuevoAlumno
	 */
		//Método para rellenar el combobox que lista los cursos
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
			
		//Método para rellenar el combobox que lista los codigos postales
			public void rellenarComboBoxCodigoPostal (SessionFactory sessionFactory, JComboBox combo) {
				Session session = null;
				
				try {
					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					Query query = sessionFactory.getCurrentSession().createQuery("FROM Poblacion");
					ArrayList<Poblacion> listaCodigoPostales = (ArrayList<Poblacion>) query.list();
					
						combo.addItem("");
					for(int i=0;i<listaCodigoPostales.size();i++) {
						combo.addItem(listaCodigoPostales.get(i).getCodigoPostal());
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
					
				// Está o no seleccionado
					boolean seleccionado = false;
					if (vista.checkBoxSeleccionadoUSUAlumno.isSelected()) {
						seleccionado = true;
					} else {
						seleccionado = false;
					}
					
				// Telefono
					int telefono = Integer.parseInt(vista.txtTelefonoUSUAlumno.getText());

				// Correo
					String correo = vista.txtCorreoUSUAlumno.getText();

				// Fecha Nacimiento
					Date fechaNacimientoUSU = vista.dateChooserFechaNacimientoUSUAlumno.getDate();
					java.sql.Date fechaNacimiento = new java.sql.Date(fechaNacimientoUSU.getTime());

				// Codigo postal
					int codigoPostal = Integer.parseInt(vista.comboBoxCodigoPostalUSUAlumno.getSelectedItem().toString());
				//Curso
					String nombreCurso = vista.comboBoxNombreCursoUSUAlumno.getSelectedItem().toString();

					
				// INSERT
				modelo.crearAlumno(sessionFactory, nif, nombreCompleto, seleccionado, telefono, correo, fechaNacimiento,
						codigoPostal, nombreCurso);

				// Reset formulario
				this.resetFormularioNuevoAlumno();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		//Metodo para hacer el insert del nuevo Alumno en la base de datos
			public void crearNuevaEmpresa(SessionFactory sessionFactory, Modelo modelo) {
				
				try {
					
					//CIF
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		//Método para restablecer el formulario de nuevoAlumno
			public void resetFormularioNuevoAlumno() {
				try {
					vista.txtNIFUSUAlumno.setText("");
					vista.txtNombreCompletoUSUAlumno.setText("");
					vista.dateChooserFechaNacimientoUSUAlumno.setDate(null);
					vista.txtTelefonoUSUAlumno.setText("");
					vista.txtCorreoUSUAlumno.setText("");
					vista.comboBoxCodigoPostalUSUAlumno.setSelectedItem("");
					vista.comboBoxNombreCursoUSUAlumno.setSelectedItem("");
					vista.checkBoxSeleccionadoUSUAlumno.setSelected(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
}