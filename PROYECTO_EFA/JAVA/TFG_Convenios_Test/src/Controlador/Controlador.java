package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.text.SimpleDateFormat;

import Vista.Vista;
import Modelo.Modelo;

public class Controlador implements ActionListener{
	//Objetos && Variables
	Vista vista = new Vista();
	
	//Constructor
	public Controlador(Vista v) {
		this.vista = v;
		
		this.vista.btnAnadirAlumno.addActionListener(this);
	}

	//Controlador de eventos
	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Hola");
		Modelo modelo = new Modelo();
		
    	SessionFactory sessionFactory = null;

    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
		
        if(e.getSource() == vista.btnAnadirAlumno) {
			try {
				
				String nif = vista.txtNIFUSU.getText();
				String nombreCompleto = vista.txtNombreCompletoUSU.getText();
				
				boolean seleccionado;
				if(vista.chbSeleccionado.isSelected()) {
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
				
				
				modelo.crearAlumno(sessionFactory, nif, nombreCompleto, seleccionado, telefono, correo, fechaNacimiento);

				System.out.println("ALUMNO CREADOasd");
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();
				
				
			}
		}
        
        
        
	}
}