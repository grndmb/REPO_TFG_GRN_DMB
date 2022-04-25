package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Vista.Vista;
import Modelo.Modelo;

public class Controlador implements ActionListener{
	//Objetos && Variables
	Vista vista = new Vista();
	
	//Constructor
	public Controlador(Vista v) {
		this.vista = v;
	}

	//Controlador de eventos
	@Override
	public void actionPerformed(ActionEvent e) {

		Modelo modelo = new Modelo();
		
    	SessionFactory sessionFactory = null;

    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
		
	}
}