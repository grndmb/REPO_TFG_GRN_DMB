package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Vista;

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
		
		
	}
}