package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import java.text.SimpleDateFormat;

import Vista.Vista;
import persistencia.Curso;
import Modelo.Modelo;

public class Controlador implements ActionListener{
	//Objetos && Variables
	Vista vista = new Vista();
	
	//Constructor
		public Controlador() {
		}
	
	//Constructor
	public Controlador(Vista v) {
		this.vista = v;
		
		this.vista.btnAnadirAlumno.addActionListener(this);
	}
	
	
	
	//Controlador de eventos
	@Override
	public void actionPerformed(ActionEvent e) {

		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador();
		
		SessionFactory sessionFactory = null;

		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    sessionFactory = configuration.buildSessionFactory();
		
        //Rellenar combobox
        //controlador.rellenarComboBoxCursos(sessionFactory);
        
        if(e.getSource() == vista.btnAnadirAlumno) {
			try {
				
				String nif = vista.txtNIFUSU.getText();
				String nombreCompleto = vista.txtNombreCompletoUSU.getText();
				
				boolean seleccionado;
				if(vista.checkBoxSeleccionado.isSelected()) {
					 seleccionado = true;
				} else {
					 seleccionado = false;
				}
				
				int telefono = Integer.parseInt(vista.txtTelefonoUSU.getText()); 
				
				String correo = vista.txtCorreoUSU.getText();
		
				//Fecha Nacimiento
				
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		        Date fechaNacimientoUSU = format.parse(vista.txtFechaNacimientoUSU.getText());
		        java.sql.Date fechaNacimiento = new java.sql.Date(fechaNacimientoUSU.getTime());
				
		        int codigoPostal = Integer.parseInt(vista.txtCodigoPostalUSU.getText());
				String nombreCurso = vista.comboBoxNombreCursoUSU.getSelectedItem().toString();
		        
				modelo.crearAlumno(sessionFactory, nif, nombreCompleto, seleccionado, telefono, correo, fechaNacimiento, codigoPostal, nombreCurso);

				System.out.println("ALUMNO CREADOasdasd");
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();
				
			}
		} 
	}
	
	/*public void  rellenarComboBoxCursos (SessionFactory sessionFactory) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Curso");
		ArrayList<Curso> listaCursos = (ArrayList<Curso>) query.list();
		
		for(Curso curso: listaCursos) {
			vista.comboBoxNombreCursoUSU.addItem(curso.getNombreCurso().toString());
		};
 	   	
    }*/
}