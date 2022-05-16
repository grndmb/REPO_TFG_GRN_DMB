package Controlador;

import java.awt.Color;
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
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Vista.Vista;
import persistencia.Alumno;
import persistencia.Curso;
import persistencia.Empresa;
import persistencia.Poblacion;
import Modelo.Modelo;

public class Controlador implements ActionListener{
	//Objetos && Variables
	Vista vista = new Vista();

	//Constructor
	public Controlador(Vista v) {
		this.vista = v;
		
		//Botones Panel Inicio
			this.vista.btnInicio.addActionListener(this);
		
		//Botones Menu
			this.vista.btnPanelAlumnos.addActionListener(this);
			this.vista.btnPanelEmpresas.addActionListener(this);
			
		//BOTONES PANEL LISTA ALUMNOS
			this.vista.btnPanelAddAlumno.addActionListener(this);
			this.vista.comboBoxListaCursoAlumno.addActionListener(this);
			
		//BOTONES PANEL NUEVO Y ACTUALIZAR ALUMNOS
			this.vista.btnAnadirAlumno.addActionListener(this);
			this.vista.comboBoxPoblacionUSUAlumno.addActionListener(this);
			this.vista.btnNuevaPoblacionAlumno.addActionListener(this);
			this.vista.btnNuevoCursoAlumno.addActionListener(this);
			this.vista.btnPanelModificarAlumno.addActionListener(this);
			this.vista.btnModificarAlumno.addActionListener(this);
			this.vista.btnEliminarAlumno.addActionListener(this);
			
		//Botones Panel Nueva Poblacion
			this.vista.btnAnadirPoblacion.addActionListener(this);
			
		//Botones Panel Nuevo Curso
			this.vista.btnAnadirCurso.addActionListener(this);
			
			
		//BOTONES PANEL LISTA EMPRESAS
			this.vista.btnPanelConvenio.addActionListener(this);
			this.vista.btnPanelModificarEmpresa.addActionListener(this);
			this.vista.btnEliminarEmpresa.addActionListener(this);
			this.vista.btnAnadirEmpresa.addActionListener(this);
			
		//Botones Panel Nueva Empresa
			this.vista.btnAnadirEmpresa.addActionListener(this);
			this.vista.comboBoxPoblacionUSUEmpresa.addActionListener(this);
			this.vista.btnNuevaPoblacionEmpresa.addActionListener(this);
			
		//VISTAS
			this.vista.panelConvenios.setVisible(false);;
			this.vista.panelPrincipal.setVisible(true);
			this.vista.panelListaAlumno.setVisible(false);
			this.vista.panelMenu.setVisible(false);
			this.vista.panelNuevoActualizarAlumno.setVisible(false);
			this.vista.panelNuevaPoblacion.setVisible(false);
			this.vista.panelNuevoCurso.setVisible(false);
			this.vista.panelNuevaEmpresa.setVisible(false);
			this.vista.panelListaEmpresas.setVisible(false);
	}
	
	
	
	//Controlador de eventos
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {

		Modelo modelo = new Modelo();
		
		//ARRAYLIST JLIST
		ArrayList <Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		SessionFactory sessionFactory = null;

		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    sessionFactory = configuration.buildSessionFactory();
        
	    //Control de las acciones de los botones
	    
	        //Acciones del bot�n de INICIAR
		    if(e.getSource() == vista.btnInicio) {
		    	
				//Mostrar panel menu
		    	vista.panelMenu.setVisible(true);
		    	
		    	//Situar el lbl de EFA MORATALAZ
		    	vista.labelTitulo.setBounds(330, 0, 1218, 114);
		    	
				vista.btnInicio.setVisible(false);
			
			//Acciones del bot�n de A�adir Alumno
		    }if(e.getSource() == vista.comboBoxPoblacionUSUAlumno) {
		    	
				modelo.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxPoblacionUSUAlumno, vista.comboBoxCodigoPostalUSUAlumno);
				
		    }
		    
		    
		    /**
		     * ACCIONES DEL PANEL ALUMNOS
		     */
		    if(e.getSource() == vista.btnPanelAlumnos) {
		    	
		    	vista.modelAlumnos.removeAllElements();
		    	
		    	//PANELES CONSULTAS
		    	vista.panelListaAlumno.setVisible(true);
		    	
		    	//PANELES INSERTS
				vista.panelNuevoActualizarAlumno.setVisible(false);
				vista.panelNuevaPoblacion.setVisible(false);
				vista.panelNuevoCurso.setVisible(false);
				vista.panelNuevaEmpresa.setVisible(false);
				
				this.resetFormularioNuevoAlumno();
				vista.comboBoxListaCursoAlumno.removeAllItems();
				modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxListaCursoAlumno);				
				
				
		    }
		    
		    
		    //RELLENA JLIST, EN FUNCIÓN DE LA OPCION EN EL COMBOBOX
		    if(e.getSource() == vista.comboBoxListaCursoAlumno) {
		    	

				try {

					vista.modelAlumnos.removeAllElements();
					
					listaAlumnos = modelo.listarAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno.getSelectedItem().toString());
					
					for (int i = 0; i < listaAlumnos.size(); i++) {
						
						vista.modelAlumnos.addElement(listaAlumnos.get(i).toString());
						vista.listAlumnos.setModel(vista.modelAlumnos);
					}
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    	//RELLENA EL JLIST DE LOS ALUMNOS
				this.recargaJLIST(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos);
		    }
		    
		  //BOTON QUE HACE VISIBLE EL FORMULARIO DE AÑADIR ALUMNO
		    if(e.getSource() == vista.btnPanelAddAlumno) {
		    	
		    	vista.panelListaAlumno.setVisible(false);
		    	vista.panelNuevoActualizarAlumno.setVisible(true);
		    	
		    	vista.lblTituloNuevoAlumno.setVisible(true);
		    	vista.btnAnadirAlumno.setVisible(true);
		    	vista.btnModificarAlumno.setVisible(false);
		    	vista.lblTituloModificarAlumno.setVisible(false);
		    	
		    	vista.comboBoxNombreCursoUSUAlumno.removeAllItems();
		    	vista.comboBoxPoblacionUSUAlumno.removeAllItems();
		    	
		    	modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxNombreCursoUSUAlumno);		
		    	modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUAlumno);
		    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUAlumno, vista.comboBoxCodigoPostalUSUAlumno);
		    	vista.comboBoxListaCursoAlumno.removeAllItems();
		    }
		    
		   //BOTON QUE ABRE PANEL MODIFICAR ALUMNOS
		    if(e.getSource() == vista.btnPanelModificarAlumno) {
		    	if(vista.listAlumnos.getSelectedIndex() != -1){
			    	vista.panelListaAlumno.setVisible(false);
			    	vista.panelNuevoActualizarAlumno.setVisible(true);
			    	
			    	vista.lblTituloNuevoAlumno.setVisible(false);
			    	vista.btnAnadirAlumno.setVisible(false);
			    	vista.btnModificarAlumno.setVisible(true);
			    	vista.lblTituloModificarAlumno.setVisible(true);
			    	
			    	vista.comboBoxNombreCursoUSUAlumno.removeAllItems();
			    	vista.comboBoxPoblacionUSUAlumno.removeAllItems();
			    	
			    	modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxNombreCursoUSUAlumno);				
			    	modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUAlumno);
			    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUAlumno, vista.comboBoxCodigoPostalUSUAlumno);		
			    	
			    	try {
			    		
						listaAlumnos = modelo.listarAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno.getSelectedItem().toString());
					
						//Seteamos los valores del alumno seleccioando
						vista.txtNIFUSUAlumno.setText(listaAlumnos.get(vista.listAlumnos.getSelectedIndex()).getNif());
						
						Session session = null;
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
							
							
							Query query = sessionFactory.getCurrentSession().createQuery("FROM Alumno WHERE nif =:nif");
							query.setParameter("nif", listaAlumnos.get(vista.listAlumnos.getSelectedIndex()).getNif());
							Alumno alumno = (Alumno) query.getSingleResult();
							
							vista.txtNombreCompletoUSUAlumno.setText(alumno.getNombreCompleto());
							
							int tlf = alumno.getTelefono();
							vista.txtTelefonoUSUAlumno.setText(String.valueOf(tlf));
							
							vista.txtCorreoUSUAlumno.setText(alumno.getCorreo());
							vista.dateChooserFechaNacimientoUSUAlumno.setDate(alumno.getFechaNacimiento());
							
							System.out.println(alumno.getTelefono());
							System.out.println(tlf);
							System.out.println(vista.txtTelefonoUSUAlumno.getText());
							
							
							
							vista.comboBoxCodigoPostalUSUAlumno.setSelectedItem(alumno.getPoblacion().getCodigoPostal());
							vista.comboBoxPoblacionUSUAlumno.setSelectedItem(alumno.getPoblacion().getNombre());
							vista.comboBoxNombreCursoUSUAlumno.setSelectedItem(alumno.getCurso().getNombreCurso());
						
							
						} catch (Exception e1) {
							// TODO: handle exception
							e1.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
			    	
			    	} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    }
		    		    
		    // BOTON QUE HACE EL UPDATE DE ALUMNO
		    if(e.getSource() == vista.btnModificarAlumno) {
		    	
		    	
		    	modelo.actualizarAlumno(sessionFactory, vista.txtNIFUSUAlumno.getText(), vista.txtNombreCompletoUSUAlumno.getText(), Integer.parseInt(vista.txtTelefonoUSUAlumno.getText()), 
						vista.txtCorreoUSUAlumno.getText(), vista.dateChooserFechaNacimientoUSUAlumno.getDate(), 
						Integer.parseInt(vista.comboBoxCodigoPostalUSUAlumno.getSelectedItem().toString()), vista.comboBoxNombreCursoUSUAlumno.getSelectedItem().toString());
				
		    	this.resetFormularioNuevoAlumno();
		    	//RELLENA EL JLIST DE LOS ALUMNOS
				this.recargaJLIST(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos);
				
				//Selecciona el curso del alumno, si el mismo se modifica
				vista.comboBoxListaCursoAlumno.setSelectedItem(vista.comboBoxNombreCursoUSUAlumno.getSelectedItem());
				
				//Volvemos al panel Alumno
				vista.panelNuevoActualizarAlumno.setVisible(false);
				vista.panelListaAlumno.setVisible(true);
				
				
		    	
		    }
		   
		   //BOTON QUE ELIMINA EL ALUMNO
		    if(e.getSource() == vista.btnEliminarAlumno) {
		    	
		    	try {
					listaAlumnos = modelo.listarAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno.getSelectedItem().toString());
					modelo.eliminarAlumno(sessionFactory, listaAlumnos.get(vista.listAlumnos.getSelectedIndex()).getNif());
			    	
			    	//RELLENA EL JLIST DE LOS ALUMNOS
					this.recargaJLIST(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos);
					
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    }
		    
		    
		  //BOTON INSERT ALUMNO
		    if(e.getSource() == vista.btnAnadirAlumno) {
			
		    	if(this.anadirAlumnoValido() == true && this.existeNuevoAlumno(sessionFactory) == true) {
		    		//Llamamos al metodo que realiza el insert del nuevo alumno
					this.crearNuevoAlumno(sessionFactory, modelo);
					
					vista.panelNuevoActualizarAlumno.setVisible(false);
					vista.panelListaAlumno.setVisible(true);
					this.recargaJLIST(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos);
					
					
					modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxListaCursoAlumno);
		    	}
			}
		    
		    //BOTON NUEVA POBLACION EN PANEL ALUMNO
		    if(e.getSource() == vista.btnNuevaPoblacionAlumno) {
				vista.panelNuevoActualizarAlumno.setVisible(false);
				vista.panelNuevaPoblacion.setVisible(true);

		   }
			
		    //BOTON INSERT POBLACION EN PANEL POBLACION
		    if(e.getSource() == vista.btnAnadirPoblacion) {
		    	
				if(this.anadirPoblacionValido() == true) {
		    		//Llamamos al metodo que realiza el insert del nueva poblacion
					this.crearNuevaPoblacion(sessionFactory, modelo);
					
					//Volvemos al panel Alumno
					vista.panelNuevaPoblacion.setVisible(false);
					vista.panelNuevoActualizarAlumno.setVisible(true);
					
					//Recargamos el comboBox de poblaciones
					vista.comboBoxPoblacionUSUAlumno.removeAllItems();
					
					
					//sELECCIONAMOS LA POBLACION CREADA
						vista.comboBoxPoblacionUSUAlumno.setSelectedItem(vista.txtNombreUSUPoblacion.getText().toString());
						modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUAlumno);
						modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUAlumno, vista.comboBoxCodigoPostalUSUAlumno);
				}
			}
		   
		    //BOTON NUEVO CURSO EN PANEL ALUMNO
		    if(e.getSource() == vista.btnNuevoCursoAlumno) {	
				vista.panelNuevoActualizarAlumno.setVisible(false);
				vista.panelNuevoCurso.setVisible(true);	
				
			//BOTON INSERT EN PANEL CURSO
			}if(e.getSource() == vista.btnAnadirCurso) {
		    	
				if(this.anadirCursoValido() == true) {
		    		//Llamamos al metodo que realiza el insert del nuevo curso
					this.crearNuevoCurso(sessionFactory, modelo);
					
					//Volvemos al panel Alumno
					vista.panelNuevoCurso.setVisible(false);
					vista.panelNuevoActualizarAlumno.setVisible(true);
					
					//Recargamos el comboBox de cursos
					vista.comboBoxNombreCursoUSUAlumno.removeAllItems();
					modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxNombreCursoUSUAlumno);
					modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxNombreCursoUSUAlumno);
		    	}
				
			}
		    
		    // -------------------------------------------		   
			// -------------------------------------------

		    
			/**
			 * ACCIONES DEL PANEL EMPRESA
			 */
		    if(e.getSource() == vista.btnPanelEmpresas) {
		    	
		    	vista.panelListaEmpresas.setVisible(true);
		    	
		    	vista.panelNuevaEmpresa.setVisible(false);
		    	vista.panelListaAlumno.setVisible(false);
		    	vista.panelNuevoActualizarAlumno.setVisible(false);
				vista.panelNuevaPoblacion.setVisible(false);
				vista.panelNuevoCurso.setVisible(false);
				//Rellenar combobox Codigo Postal
				modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUEmpresa);
			
				//Rellena el label con la fecha actualizacion =  fecha actual
					String fechaActualizacion = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
					vista.lblFechaActualizacionUSUEmpresa.setText(fechaActualizacion);	
					
		    }if(e.getSource() == vista.comboBoxPoblacionUSUEmpresa) {
		    
		    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUEmpresa, vista.comboBoxCodigoPostalUSUEmpresa);
	
		    }
		    
		    if(e.getSource() == vista.btnPanelConvenio) {
		    	
		    	vista.panelListaEmpresas.setVisible(false);
		    	vista.panelConvenios.setVisible(true);
		    	
		    }
		    
		    
		    if(e.getSource() == vista.btnAnadirEmpresa) {
	
		    	if(this.anadirEmpresaValida() == true && this.existeNuevaEmpresa(sessionFactory) == true) {
		    		//Llamamos al metodo que realiza el insert de la nueva empresa
		    		this.crearNuevaEmpresa(sessionFactory, modelo);
		    	}
			}
		    
		  //BOTON ADD --> NUEVA POBLACION EMPRESA
		    if(e.getSource() == vista.btnNuevaPoblacionEmpresa) {
		    	vista.panelNuevaEmpresa.setVisible(false);
				vista.panelNuevaPoblacion.setVisible(true);
			}
			
		    if(e.getSource() == vista.btnAnadirPoblacion) {
		    	
				if(this.anadirPoblacionValido() == true) {
		    		//Llamamos al metodo que realiza el insert del nueva poblacion
					this.crearNuevaPoblacion(sessionFactory, modelo);
				}
			}
		    
		    
		    
		    if(e.getSource() == vista.comboBoxPoblacionUSUEmpresa) {
		    	
		    	modelo.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxPoblacionUSUEmpresa, vista.comboBoxCodigoPostalUSUEmpresa);
		    	
		    }
		    // --------------------------------------------		   
			// --------------------------------------------

		    
		    /**
		     * ACCIONES DEL PANEL PRACTICAS
		     */
		    if(e.getSource() == vista.btnPanelPracticas) {
		    	
		    	
		    }
			   
	}
	
	/*
	 * METODOS DE RELLENO DE COMBOBOX
	 */
		
			
		
		
		
	
	/*
	 * METODOS DEL ALUMNO		
	 */
				
		//METODOS DEL PANEL NUEVO ALUMNO	
		
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
					vista.lblErroresNuevoAlumno.setText("");
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
							|| vista.txtNombreCompletoUSUAlumno.getText().equals("")
							|| "".equals(vista.dateChooserFechaNacimientoUSUAlumno.getDate())
							|| vista.txtTelefonoUSUAlumno.getText().equals("")
							|| vista.txtCorreoUSUAlumno.getText().equals("")
							|| vista.comboBoxPoblacionUSUAlumno.getSelectedItem().equals("")
							|| vista.comboBoxCodigoPostalUSUAlumno.getSelectedItem().equals("")
							|| vista.comboBoxNombreCursoUSUAlumno.getSelectedItem().equals("")
								) {
							valido = false;
							
							vista.lblErroresNuevoAlumno.setText("ERROR!! FALTAN CAMPOS OBLIGATORIOS");
							vista.lblErroresNuevoAlumno.setForeground(Color.RED);
						}else {
							vista.lblErroresNuevoAlumno.setText("ALUMNO CREADO");
							vista.lblErroresNuevoAlumno.setForeground(Color.RED);
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return valido;
				}
			
				
				
				
			//Metodo para validar si el alumno que se desea crear, existe
				public boolean existeNuevoAlumno (SessionFactory sessionFactory) {
					boolean valido = true;
					Session session = null; 
					
					
					
					try {
						
						session = sessionFactory.getCurrentSession();
						session.beginTransaction();
						
						
						//Consulta para obtener los alumnos 
						 
						Query query = sessionFactory.getCurrentSession().createQuery("FROM Alumno WHERE nif = :nif");
						query.setParameter("nif", vista.txtNIFUSUAlumno.getText());
						Alumno al = (Alumno) query.getSingleResult();
						
						if(!al.getNif().equals("")) {
							vista.lblErroresNuevoAlumno.setText("ERROR!! EL ALUMNO YA EXISTE");
							vista.lblErroresNuevoAlumno.setForeground(Color.RED);
							this.resetFormularioNuevoAlumno();
							
							valido = false;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						if(null != session) {
							session.getTransaction().rollback();
						}
					}finally {
						if(null != session) {
							session.close();
						}
					}
					
					return valido;
				}
			
				
			//Metodo para restablecer el formulario de nuevoAlumno
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
	
		//Metodo que recarga el Jlist
			public void recargaJLIST (SessionFactory sessionFactory,JComboBox comboLista, DefaultListModel model) {
				//Modelo
				Modelo modelo = new Modelo();
				
				//ARRAYLIST JLIST
				ArrayList <Alumno> listaAlumnos = new ArrayList<Alumno>();
				
				try {

					model.removeAllElements();
					
					listaAlumnos = modelo.listarAlumnos(sessionFactory, comboLista.getSelectedItem().toString());
					
					for (int i = 0; i < listaAlumnos.size(); i++) {
						
						vista.modelAlumnos.addElement(listaAlumnos.get(i).toString());
						vista.listAlumnos.setModel(vista.modelAlumnos);
					}
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
	/*
	 * METODOS DE LA EMPRESA	
     */
		
		//METODOS DEL PANEL NUEVA EMPRESA
			
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
							
						// DNI CARGO PERSONA DE CONTACTO
							String dniCargoPersonaContactoEmpresa = vista.txtDNIPersonaContactoEmpresaEmpresa.getText();
							
						// OBSERVACIONES
							String observacionesEmpresa = vista.txtObservacionesEmpresa.getText();
							
						// FECHA ACTUALIZACION DE LOS DATOS  
					        
					        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					        Date fechaActualizacionEmpresa = format.parse(vista.lblFechaActualizacionUSUEmpresa.getText());
					        java.sql.Date fecha = new java.sql.Date(fechaActualizacionEmpresa.getTime());
					        
						// INSERT
							modelo.crearEmpresas(sessionFactory, cifEmpresa, nombreEmpresa, direccionEmpresa, telefono1, telefono2, emailEmpresa, faxEmpresa, paginaWebEmpresa, nombreGerenteEmpresa, dniGerenteEmpresa, personaContactoEmpresa, dniCargoPersonaContactoEmpresa, fecha, organismoPublico, observacionesEmpresa, poblacion);
					
						// RESET FORMULARIO NUEVA EMPRESA
							this.resetFormularioNuevaEmpresa();
							
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}	
			
			//Metodo para validar que todo los campos del alumno est�n rellenos
				public boolean anadirEmpresaValida() {
					boolean valido = true;
	
					try {
						
						if(
							   vista.txtCIFEmpresa.getText().equals("")
							|| vista.txtNombreEmpresa.getText().equals("")
							|| vista.txtDireccionEmpresa.getText().equals("")
							|| vista.comboBoxPoblacionUSUEmpresa.getSelectedItem().equals("")
							|| vista.txtEmailEmpresa.getText().equals("")
							|| vista.txtDNIGerenteEmpresa.getText().equals("")
							|| vista.txtNombreGerenteEmpresa.getText().equals("")
							|| vista.txtPersonaContactoEmpresa.getText().equals("")
							|| vista.txtDNIPersonaContactoEmpresaEmpresa.getText().equals("")
								) {
							valido = false;
							
							vista.lblErroresNuevaEmpresa.setText("ERROR!! FALTAN CAMPOS OBLIGATORIOS");
							vista.lblErroresNuevaEmpresa.setForeground(Color.RED);
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return valido;
				}	
				
			//Metodo para validar si la empresa que se desea crear, existe
				public boolean existeNuevaEmpresa (SessionFactory sessionFactory) {
					boolean valido = true;
					Session session = null; 
					
					try {
						
						session = sessionFactory.getCurrentSession();
						session.beginTransaction();
						
						
						//Consulta para obtener las empresas 
						 
						Query query = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cif = :cif");
						query.setParameter("cif", vista.txtCIFEmpresa.getText());
						Empresa em = (Empresa) query.getSingleResult();
						
						if(!em.getCifEmpresa().equals("")) {
							vista.lblErroresNuevaEmpresa.setText("ERROR!! LA EMPRESA YA EXISTE");
							vista.lblErroresNuevaEmpresa.setForeground(Color.RED);
							this.resetFormularioNuevaEmpresa();
							
							valido = false;
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						if(null != session) {
							session.getTransaction().rollback();
						}
					}finally {
						if(null != session) {
							session.close();
						}
					}
					
					return valido;
				}	
				
			//Metodo para restablecer el formulario de nuevaEmpresa
				public void resetFormularioNuevaEmpresa() {
					try {
						vista.txtCIFEmpresa.setText("");
						vista.txtNombreEmpresa.setText("");
						vista.txtDireccionEmpresa.setText("");
						vista.comboBoxPoblacionUSUEmpresa.setSelectedItem("");
						vista.comboBoxCodigoPostalUSUEmpresa.setSelectedItem("");
						vista.txtEmailEmpresa.setText("");
						vista.txtTelefono1Empresa.setText("");
						vista.txtTelefono2Empresa.setText("");
						vista.txtFaxEmpresa.setText("");
						vista.txtPaginaWebEmpresa.setText("");
						vista.checkBoxOrganismoPublicoUSUEmpresa.setSelected(false);
						vista.txtDNIGerenteEmpresa.setText("");
						vista.txtNombreGerenteEmpresa.setText("");
						vista.txtPersonaContactoEmpresa.setText("");
						vista.txtDNIPersonaContactoEmpresaEmpresa.setText("");
						vista.txtObservacionesEmpresa.setText("");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}



				/*
				 * METODOS DE POBLACION			
				 */
					//METODOS DEL PANEL NUEVA POBLACION
						
							//Metodo para hacer el insert de la nueva poblacion en la base de datos
							public void crearNuevaPoblacion(SessionFactory sessionFactory, Modelo modelo) {
								
								try {
									
									// CODIGO POSTAL
										int codigoPostal = Integer.parseInt(vista.txtCodigoPostalUSUPoblacion.getText());
									
									// NOMBRE POBLACION
										String nombrePoblacion = vista.txtNombreUSUPoblacion.getText();
									
									// PROVINCIA
										String provincia = vista.txtClaveUSUCurso.getText();
										
								        
									// INSERT
										modelo.crearPoblacion(sessionFactory, codigoPostal, nombrePoblacion, provincia);
									
									// RESET DEL FORMULARIO NUEVA POBLACION
										this.resetFormularioNuevaPoblacion();
								}catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
						}
					
						//Metodo para validar que todo los campos del alumno est�n rellenos
							public boolean anadirPoblacionValido() {
								boolean valido = true;
				
								try {
									
									if(
										vista.txtCodigoPostalUSUPoblacion.getText().equals("")
										|| vista.txtNombreUSUPoblacion.getText().equals("")
										|| vista.txtProvinciaUSUPoblacion.getText().equals("")
											) {
										valido = false;
										
										vista.lblErroresNuevoCurso.setText("ERROR!! FALTAN CAMPOS OBLIGATORIOS");
										vista.lblErroresNuevoCurso.setForeground(Color.RED);
									}else {
										valido = true;
									}
									
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								return valido;
							}		
						//Metodo para restablecer el formulario de nuevaPoblacion
							public void resetFormularioNuevaPoblacion() {
								try {
									vista.txtCodigoPostalUSUPoblacion.setText("");
									vista.txtNombreUSUPoblacion.setText("");
									vista.txtProvinciaUSUPoblacion.setText("");
									vista.lblErroresNuevaPoblacion.setText("");
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
				
				/*
				 * METODOS DE CURSO			
				 */
					//METODOS DEL PANEL NUEVO CURSO
									
						//Metodo para hacer el insert del nuevo Curso en la base de datos
							public void crearNuevoCurso(SessionFactory sessionFactory, Modelo modelo) {
								
								try {
									
									// NOMBRE CURSO
										String nombreCurso = vista.txtNombreUSUCurso.getText();
									
									// NOMBRE ABREV
										String nombreAbrev = vista.txtNombreAbrevUSUCurso.getText();
									
									// CLAVE
										String clave = vista.txtClaveUSUCurso.getText();
										
									// HORAS FCT
										String horasFCT = vista.txtHorasFCTUSUCurso.getText();
									// ES PUBLICO
										boolean esPublico = false;
										if (vista.checkBoxEsPublicoUSUCurso.isSelected()) {
											esPublico = true;
										} else {
											esPublico = false;
										}
								        
									// INSERT
										modelo.crearCurso(sessionFactory, nombreCurso, nombreAbrev, clave, horasFCT, esPublico);
									
									// RESET DEL FORMULARIO NUEVO CURSO
										this.resetFormularioNuevoCurso();
								}catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
						}
					
						//Metodo para validar que todo los campos del alumno est�n rellenos
							public boolean anadirCursoValido() {
								boolean valido = true;
				
								try {
									
									if(
										vista.txtNombreUSUCurso.getText().equals("")
										|| vista.txtNombreAbrevUSUCurso.getText().equals("")
										|| vista.txtClaveUSUCurso.getText().equals("")
										|| vista.txtHorasFCTUSUCurso.getText().equals("")
											) {
										valido = false;
										
										vista.lblErroresNuevoCurso.setText("ERROR!! FALTAN CAMPOS OBLIGATORIOS");
										vista.lblErroresNuevoCurso.setForeground(Color.RED);
									}
									
								} catch (Exception e) {
									e.printStackTrace();
								}
								
								return valido;
							}		
						//Metodo para restablecer el formulario de nuevoCurso
							public void resetFormularioNuevoCurso() {
								try {
									vista.txtNombreUSUCurso.setText("");
									vista.txtNombreAbrevUSUCurso.setText("");
									vista.txtClaveUSUCurso.setText("");
									vista.txtHorasFCTUSUCurso.setText("");
									vista.checkBoxEsPublicoUSUCurso.setSelected(false);
									vista.lblErroresNuevoCurso.setText("");
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
				


}