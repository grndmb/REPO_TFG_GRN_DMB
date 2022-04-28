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
		
		this.vista.btnAnadirAlumno.addActionListener(this);
		this.vista.btnNuevaEmpresa.addActionListener(this);
		this.vista.btnInicio.addActionListener(this);
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
        
        
	    if(e.getSource() == vista.btnInicio) {
	    	vista.panelInicio.setVisible(false);
			vista.panelNuevoAlumno.setVisible(true);
			
			//Rellenar combobox Curso y Codigo Postal
				this.rellenarComboBoxCursos(sessionFactory);
				this.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxCodigoPostalUSUAlumno);
			
	    }if(e.getSource() == vista.btnAnadirAlumno) {
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
				        	
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			
		}if(e.getSource() == vista.btnNuevaEmpresa) {
			vista.panelNuevoAlumno.setVisible(false);
			vista.panelNuevaEmpresa.setVisible(true);
			//Rellenar combobox Curso y Codigo Postal
				this.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxCodigoPostalUSUEmpresa);
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