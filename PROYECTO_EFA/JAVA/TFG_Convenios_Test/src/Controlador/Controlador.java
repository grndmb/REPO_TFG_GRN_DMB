package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
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
				String fechaNacimientoUSU = vista.txtFechaNacimientoUSU.getText();
				String formato = "dd/MM/yyyy";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
				Date fechaNacimiento = (Date) simpleDateFormat.parse(fechaNacimientoUSU);
				
				modelo.crearAlumno(sessionFactory, nif, nombreCompleto, seleccionado, telefono, correo, fechaNacimiento);

				System.out.println("ALUMNO CREADOasd");
			} catch (Exception exception) {
				// TODO: handle exception
				exception.printStackTrace();
				
				
			}
		}
        
        
        
	}
}