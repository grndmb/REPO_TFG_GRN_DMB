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
				boolean valido = false;
				
					do {
						
						//Validar dni
						valido = this.validarDNI();
						
						//Variables
						String nif = vista.txtNIFUSU.getText();
						String nombreCompleto = vista.txtNombreCompletoUSU.getText();
						boolean seleccionado;
					
						//Está o no seleccionado
							if(vista.checkBoxSeleccionado.isSelected()) {
								 seleccionado = true;
							} else {
								 seleccionado = false;
							}
						//Telefono
							int telefono = Integer.parseInt(vista.txtTelefonoUSU.getText()); 
						//Correo
							String correo = vista.txtCorreoUSU.getText();
				
						//Fecha Nacimiento
							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					        Date fechaNacimientoUSU = format.parse(vista.txtFechaNacimientoUSU.getText());
					        java.sql.Date fechaNacimiento = new java.sql.Date(fechaNacimientoUSU.getTime());
						
					    //Codigo postal
					        int codigoPostal = Integer.parseInt(vista.comboBoxCodigoPostalUSU.getSelectedItem().toString());
					        String nombreCurso = vista.comboBoxNombreCursoUSU.getSelectedItem().toString();
				       
					    //INSERT
					        modelo.crearAlumno(sessionFactory, nif, nombreCompleto, seleccionado, telefono, correo, fechaNacimiento, codigoPostal, nombreCurso);
	
						//Reset formulario
					        this.resetFormularioNuevoAlumno();
					
					}while (valido == false);
				
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
		//Método validar DNI
			public boolean validarDNI() {
				Boolean valido = false;
				String dni = vista.txtNIFUSU.getText();
				String letraMayuscula = ""; //Guardaremos la letra introducida en formato mayúscula
					
				// Aquí excluimos cadenas distintas a 9 caracteres que debe tener un dni y también si el último caracter no es una letra
				if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false ) {
					vista.lblErrorNuevoAlumno.setText("ERROR. NIF MAL FORMADO");
					valido = false;
				}

				// Al superar la primera restricción, la letra la pasamos a mayúscula
				letraMayuscula = (dni.substring(8)).toUpperCase();

				// Por último validamos que sólo tengo 8 dígitos entre los 8 primeros caracteres y que la letra introducida es igual a la de la ecuación
				// Llamamos a los métodos privados de la clase soloNumeros() y letraDNI()
				if(soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
					valido = true;
				}else {
					vista.lblErrorNuevoAlumno.setText("ERROR. NIF MAL FORMADO");
					valido = false;
				}
				
				return valido;
			}
			
			private boolean soloNumeros(String dni) {

				int i, j = 0;
				String numero = ""; // Es el número que se comprueba uno a uno por si hay alguna letra entre los 8 primeros dígitos
				String miDNI = ""; // Guardamos en una cadena los números para después calcular la letra
				String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};

				for(i = 0; i < dni.length() - 1; i++) {
					numero = dni.substring(i, i+1);

					for(j = 0; j < unoNueve.length; j++) {
						if(numero.equals(unoNueve[j])) {
							miDNI += unoNueve[j];
						}
					}
				}

				if(miDNI.length() != 8) {
					return false;
				}
				else {
					return true;
				}
			}
			
			private String letraDNI(String dni) {
				
				// pasar miNumero a integer
				int miDNI = Integer.parseInt(dni.substring(0,8));
				int resto = 0;
				String miLetra = "";
				String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

				resto = miDNI % 23;

				miLetra = asignacionLetra[resto];

				return miLetra;
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
					vista.checkBoxSeleccionado.setSelected(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
}