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
		this.vista.btnInicio.addActionListener(this);
		
		vista.panelInicio.setVisible(true);
		vista.panelNuevoAlumno.setVisible(false);
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
				this.rellenarComboBoxCodigoPostal(sessionFactory);
			
	    }if(e.getSource() == vista.btnAnadirAlumno) {
			try {
		
				// NIF
					String nif = vista.txtNIFUSU.getText();
					
				// NOMBRE COMPLETO
					String nombreCompleto = vista.txtNombreCompletoUSU.getText();
					
				// Está o no seleccionado
					boolean seleccionado = false;
					if (vista.checkBoxSeleccionado.isSelected()) {
						seleccionado = true;
					} else {
						seleccionado = false;
					}
					
				// Telefono
					int telefono = Integer.parseInt(vista.txtTelefonoUSU.getText());

				// Correo
					String correo = vista.txtCorreoUSU.getText();

				// Fecha Nacimiento
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					Date fechaNacimientoUSU = format.parse(vista.txtFechaNacimientoUSU.getText());
					java.sql.Date fechaNacimiento = new java.sql.Date(fechaNacimientoUSU.getTime());

				// Codigo postal
					int codigoPostal = Integer.parseInt(vista.comboBoxCodigoPostalUSU.getSelectedItem().toString());
				//Curso
					String nombreCurso = vista.comboBoxNombreCursoUSU.getSelectedItem().toString();

					
				// INSERT
				modelo.crearAlumno(sessionFactory, nif, nombreCompleto, seleccionado, telefono, correo, fechaNacimiento,
						codigoPostal, nombreCurso);

				// Reset formulario
				this.resetFormularioNuevoAlumno();
				        	
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();
			}
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
					
						vista.comboBoxNombreCursoUSU.addItem("");
					for(int i=0;i<listaCursos.size();i++) {
						vista.comboBoxNombreCursoUSU.addItem(listaCursos.get(i).getNombreCurso().toString());
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
			public void rellenarComboBoxCodigoPostal (SessionFactory sessionFactory) {
				Session session = null;
				
				try {
					session = sessionFactory.getCurrentSession();
					session.beginTransaction();
					
					Query query = sessionFactory.getCurrentSession().createQuery("FROM Poblacion");
					ArrayList<Poblacion> listaCodigoPostales = (ArrayList<Poblacion>) query.list();
					
						vista.comboBoxCodigoPostalUSU.addItem("");
					for(int i=0;i<listaCodigoPostales.size();i++) {
						vista.comboBoxCodigoPostalUSU.addItem(listaCodigoPostales.get(i).getCodigoPostal());
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
					vista.txtNIFUSU.setText("");
					vista.txtNombreCompletoUSU.setText("");
					vista.txtFechaNacimientoUSU.setText("");
					vista.txtTelefonoUSU.setText("");
					vista.txtCorreoUSU.setText("");
					vista.comboBoxCodigoPostalUSU.setSelectedItem("");
					vista.comboBoxNombreCursoUSU.setSelectedItem("");
					vista.lblErrorNuevoAlumno.setText("");
					vista.checkBoxSeleccionado.setSelected(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
}