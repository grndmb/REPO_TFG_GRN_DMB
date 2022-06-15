package Controlador;
import java.awt.Checkbox;
//IMPORTS
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import java.text.SimpleDateFormat;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


import Vista.Vista;
import net.bytebuddy.asm.Advice.This;
import persistencia.Alumno;
import persistencia.Anexar;
import persistencia.Convenio;
import persistencia.DatosEfa;
import persistencia.Empresa;
import persistencia.Practica;
import Modelo.Modelo;

public class Controlador implements ActionListener{
	//Objetos && Variabless
	Vista vista = new Vista();
	//Constructor
	public Controlador(Vista v) {
		this.vista = v;
		
		//Botones Panel Inicio
			this.vista.btnInicio.addActionListener(this);
		
		//Botones Menu
			this.vista.btnPanelAlumnos.addActionListener(this);
			this.vista.btnPanelEmpresas.addActionListener(this);
			this.vista.btnPanelPeriodos.addActionListener(this);
			this.vista.btnPanelPracticas.addActionListener(this);
			this.vista.btnPanelInstrucciones.addActionListener(this);
			
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
			this.vista.btnAnadirPoblacionAlumno.addActionListener(this);
			this.vista.btnAnadirPoblacionEmpresa.addActionListener(this);
			
		//Botones Panel Nuevo Curso
			this.vista.btnAnadirCurso.addActionListener(this);
			
			
		//BOTONES PANEL LISTA EMPRESAS
			this.vista.btnPanelConvenio.addActionListener(this);
			this.vista.btnPanelModificarEmpresa.addActionListener(this);
			this.vista.btnEliminarEmpresa.addActionListener(this);
			this.vista.btnAnadirEmpresa.addActionListener(this);
			this.vista.btnBuscarListaEmpresas.addActionListener(this);
			this.vista.btnPanelAddEmpresa.addActionListener(this);
			
		//Botones Panel Nueva Actualiazar Empresa
			this.vista.btnAnadirEmpresa.addActionListener(this);
			this.vista.btnModificarEmpresa.addActionListener(this);
			this.vista.comboBoxPoblacionUSUEmpresa.addActionListener(this);
			this.vista.btnNuevaPoblacionEmpresa.addActionListener(this);
		
		//Botones panel Convenios
			this.vista.comboBoxListaCursoConvenio.addActionListener(this);
			this.vista.btnActualizarConvenio.addActionListener(this);
			this.vista.comboBoxTipoConvenioPanelConvenio.addActionListener(this);
			this.vista.btnPanelCrearNuevoConvenio.addActionListener(this);
			this.vista.btnCrearConvenio.addActionListener(this);
			
		//Botones del panel Periodos
			this.vista.btnCrearPeriodo.addActionListener(this);
			this.vista.btnEliminarPeriodo.addActionListener(this);
			
		//Botones del panel Practicas
			this.vista.btnAsignarPeriodoPracticas.addActionListener(this);
			this.vista.btnAsignarEmpresaPracticas.addActionListener(this);
			this.vista.btnEliminarAnexarPracticas.addActionListener(this);
			this.vista.btnPanelDocumentos.addActionListener(this);
			
		//Botones del panel Documentos
			this.vista.btnGuardarDocumentos.addActionListener(this);
			this.vista.btnAtrasDocumentos.addActionListener(this);
			
		//VISTAS
			this.vista.panelInstrucciones.setVisible(false);
			this.vista.panelConvenios.setVisible(false);
			this.vista.panelPrincipal.setVisible(true);
			this.vista.panelListaAlumno.setVisible(false);
			this.vista.panelMenu.setVisible(false);
			this.vista.panelNuevoActualizarAlumno.setVisible(false);
			this.vista.panelNuevaPoblacion.setVisible(false);
			this.vista.panelNuevoCurso.setVisible(false);
			this.vista.panelNuevaActualizarEmpresa.setVisible(false);
			this.vista.panelListaEmpresas.setVisible(false);
			this.vista.panelPeriodos.setVisible(false);
			this.vista.panelPracticas.setVisible(false);
			this.vista.panelCrearNuevoConvenio.setVisible(false);
			this.vista.panelDocumentos.setVisible(false);

	}
	
	
	
	//Controlador de eventos
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {

		Modelo modelo = new Modelo();
		
		//ARRAYLIST JLIST Alumnos 
		ArrayList <Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		//ARRAYLIST JLIST Empresas
		ArrayList <Empresa> listaEmpresas = new ArrayList<Empresa>();
		
		//ARRAYLIST JLIST CONVENIOS
		ArrayList<Convenio> listaConvenios = new ArrayList<Convenio>();
		
		//ARRAYLIST PERIODO
		ArrayList<Practica> listaPeriodos = new ArrayList<Practica>();
		
		//ARRAYLIST ANEXARS
		ArrayList <Anexar> listaAnexarsPracticas = new ArrayList<Anexar>();
		
		SessionFactory sessionFactory = null;

		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    sessionFactory = configuration.buildSessionFactory();
        
	    //Control de las acciones de los botones
	    
	        //Acciones del botón de INICIAR
		    if(e.getSource() == vista.btnInicio) {
		    	
				//Mostrar panel menu
		    	vista.panelMenu.setVisible(true);
		    	
		    	//Situar el lbl de EFA MORATALAZ
		    	vista.labelTitulo.setVisible(true);
		    	vista.labelTitulo.setBounds(342, 10, 1183, 112);
		    	vista.labelTitulo.setText("EFA MORATALAZ");
		    	//vista.labelTitulo.setOpaque(true);
		    	//vista.labelTitulo.setForeground(new Color(53, 100, 54));
		    	
				vista.btnInicio.setVisible(false);
				vista.lblLogoInicio.setVisible(false);
				//MOSTRAR LOGO
				vista.lblLogo.setVisible(true);
				//MOSTRAR EL PANEL DE INSTRUCCIONES
				vista.panelInstrucciones.setVisible(true);
				
				//CAMBIOS DE COLORES DE FONDO BOTONES DEL MENï¿½
	    		vista.btnPanelInstrucciones.setBackground(new Color(211, 211, 211));
	    		vista.btnPanelAlumnos.setBackground(Color.WHITE);
	    		vista.btnPanelEmpresas.setBackground(Color.WHITE);
	    		vista.btnPanelPeriodos.setBackground(Color.WHITE);
	    		vista.btnPanelPracticas.setBackground(Color.WHITE);
				
		    }
		    if(e.getSource() == vista.btnPanelInstrucciones) {
		    	//CAMBIOS DE COLORES DE FONDO BOTONES DEL MENï¿½
		    	vista.btnPanelInstrucciones.setBackground(new Color(211, 211, 211));
	    		vista.btnPanelAlumnos.setBackground(Color.WHITE);
	    		vista.btnPanelEmpresas.setBackground(Color.WHITE);
	    		vista.btnPanelPeriodos.setBackground(Color.WHITE);
	    		vista.btnPanelPracticas.setBackground(Color.WHITE);
	    		
	    		//PANELES 
		    	this.vista.panelInstrucciones.setVisible(true);
		    	this.vista.panelConvenios.setVisible(false);
				this.vista.panelNuevoActualizarAlumno.setVisible(false);
				this.vista.panelNuevaPoblacion.setVisible(false);
				this.vista.panelNuevoCurso.setVisible(false);
				this.vista.panelNuevaActualizarEmpresa.setVisible(false);
				this.vista.panelListaEmpresas.setVisible(false);
				this.vista.panelPeriodos.setVisible(false);
				this.vista.panelPracticas.setVisible(false);
				this.vista.panelDocumentos.setVisible(false);
				this.vista.panelListaAlumno.setVisible(false);
	    		
		    }
		    /**
		     * ACCIONES DEL PANEL ALUMNOS
		     */
		    if(e.getSource() == vista.btnPanelAlumnos) {
		    	//CAMBIOS DE COLORES DE FONDO BOTONES DEL MENï¿½
		    		vista.btnPanelAlumnos.setBackground(new Color(211, 211, 211));
		    		vista.btnPanelEmpresas.setBackground(Color.WHITE);
		    		vista.btnPanelPeriodos.setBackground(Color.WHITE);
		    		vista.btnPanelPracticas.setBackground(Color.WHITE);
		    		vista.btnPanelInstrucciones.setBackground(Color.WHITE);
		    	//PANELES CONSULTAS
		    	vista.panelListaAlumno.setVisible(true);
		    	
		    	//PANELES 
		    	vista.panelInstrucciones.setVisible(false);
		    	this.vista.panelConvenios.setVisible(false);
				this.vista.panelNuevoActualizarAlumno.setVisible(false);
				this.vista.panelNuevaPoblacion.setVisible(false);
				this.vista.panelNuevoCurso.setVisible(false);
				this.vista.panelNuevaActualizarEmpresa.setVisible(false);
				this.vista.panelListaEmpresas.setVisible(false);
				this.vista.panelPeriodos.setVisible(false);
				this.vista.panelPracticas.setVisible(false);
				this.vista.panelDocumentos.setVisible(false);
				
				vista.comboBoxListaCursoAlumno.removeAllItems();
				modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxListaCursoAlumno);
				
				
				this.resetFormularioNuevoAlumno();
		    }
		    
		    
		    //RELLENA JLIST, EN FUNCIÓN DE LA OPCIÓN EN EL COMBOBOX
		    else if(e.getSource() == vista.comboBoxListaCursoAlumno) {
		   
				try {
					if(vista.comboBoxListaCursoAlumno.getSelectedIndex() != -1) {
						vista.modelAlumnos.removeAllElements();
						listaAlumnos = modelo.listarAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno.getSelectedItem().toString());
						
						for (int i = 0; i < listaAlumnos.size(); i++) {
							vista.modelAlumnos.addElement(listaAlumnos.get(i).toString());
							vista.listAlumnos.setModel(vista.modelAlumnos);
						}
						
						//RELLENA EL JLIST DE LOS ALUMNOS
						this.recargaJLISTAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos, vista.listAlumnos);
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		    	
		    }
		    
		  //BOTON QUE HACE VISIBLE EL PANEL DE AÑADIR ALUMNO
		    if(e.getSource() == vista.btnPanelAddAlumno) {
		    	
		    	vista.panelListaAlumno.setVisible(false);
		    	vista.panelNuevoActualizarAlumno.setVisible(true);
		    	
		    	vista.lblTituloNuevoAlumno.setVisible(true);
		    	vista.btnAnadirAlumno.setVisible(true);
		    	vista.btnModificarAlumno.setVisible(false);
		    	vista.lblTituloModificarAlumno.setVisible(false);
		    	vista.panelPeriodos.setVisible(false);
		    	
				modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxNombreCursoUSUAlumno);					
		    	modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUAlumno);
		    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUAlumno.getSelectedItem().toString(), vista.comboBoxCodigoPostalUSUAlumno);	
		    	
		    	//LIMITO QUE PUEDA ELEGIR SOLO HASTA LA FECHA ACTUAL
				Date fechaAct = Calendar.getInstance().getTime();
				vista.dateChooserFechaNacimientoUSUAlumno.setMaxSelectableDate(fechaAct);
		    }
		    
		   //BOTON QUE ABRE PANEL MODIFICCAR ALUMNOS
		    if(e.getSource() == vista.btnPanelModificarAlumno) {
		    	if(vista.listAlumnos.getSelectedIndex() != -1){
			    	vista.panelListaAlumno.setVisible(false);
			    	vista.panelNuevoActualizarAlumno.setVisible(true);
			    	
			    	vista.lblTituloNuevoAlumno.setVisible(false);
			    	vista.btnAnadirAlumno.setVisible(false);
			    	vista.btnModificarAlumno.setVisible(true);
			    	vista.lblTituloModificarAlumno.setVisible(true);
			    	
					vista.comboBoxNombreCursoUSUAlumno.removeAllItems();
					modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxNombreCursoUSUAlumno);
					
			    			
			    	modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUAlumno);
			    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUAlumno.getSelectedItem().toString(), vista.comboBoxCodigoPostalUSUAlumno);		
			    	
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
				this.recargaJLISTAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos, vista.listAlumnos);
				
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
					ArrayList<Anexar>listaAnexar = modelo.listarAnexarsPracticas(sessionFactory);
					modelo.eliminarAlumno(sessionFactory, listaAlumnos.get(vista.listAlumnos.getSelectedIndex()).getNif(),listaAnexar);
			    	
			    	//RELLENA EL JLIST DE LOS ALUMNOS
					this.recargaJLISTAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos, vista.listAlumnos);
					
					
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
				
					
					this.recargaJLISTAlumnos(sessionFactory, vista.comboBoxListaCursoAlumno, vista.modelAlumnos, vista.listAlumnos);
					
					this.resetFormularioNuevoAlumno();
		    	}
			}
		    
		    //BOTON NUEVA POBLACION EN PANEL ALUMNO
		    if(e.getSource() == vista.btnNuevaPoblacionAlumno) {
				vista.panelNuevoActualizarAlumno.setVisible(false);
				vista.panelNuevaPoblacion.setVisible(true);

				vista.btnAnadirPoblacionEmpresa.setVisible(false);
				vista.btnAnadirPoblacionAlumno.setVisible(true);
		   }
			
		    //BOTON INSERT POBLACION EN PANEL POBLACION DE ALUMNO
		    if(e.getSource() == vista.btnAnadirPoblacionAlumno) {
		    	
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
						modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUAlumno.getSelectedItem().toString(), vista.comboBoxCodigoPostalUSUAlumno);
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
					vista.comboBoxListaCursoAlumno.removeAllItems();
					modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxListaCursoAlumno);
		
		    	}
				
				
			}
		    
			//AL PULSAR EN UNA OPCIï¿½N DEL COMBOBOX DE POBLACIO,CARGA SU CODIGO POSTAL
		    if(e.getSource() == vista.comboBoxPoblacionUSUAlumno) {
		    	if(vista.comboBoxPoblacionUSUAlumno.getSelectedItem() != null) {
		    		modelo.rellenarComboBoxCodigoPostal(sessionFactory,vista.comboBoxPoblacionUSUAlumno.getSelectedItem().toString(), vista.comboBoxCodigoPostalUSUAlumno);
		    	}
		    }
		    
			/**
			 * ACCIONES DEL PANEL EMPRESA
			 */
				//BOTON QUE ABRE EL PANEL DONDE SE LSTAN LAS EMPRESAS
				    if(e.getSource() == vista.btnPanelEmpresas) {
				    	
				    	//DEJAR DE MOSTRAR PANEL DISTINTO AL PANEL EMPRESA
				    	vista.panelInstrucciones.setVisible(false);
				    	vista.panelListaEmpresas.setVisible(true);
				    	vista.panelListaAlumno.setVisible(false);
				    	vista.panelNuevoActualizarAlumno.setVisible(false);
						vista.panelNuevaPoblacion.setVisible(false);
						vista.panelNuevoCurso.setVisible(false);
						vista.panelConvenios.setVisible(false);
						vista.panelNuevaActualizarEmpresa.setVisible(false);
						vista.panelPeriodos.setVisible(false);
						vista.panelPracticas.setVisible(false);
						vista.panelDocumentos.setVisible(false);
						
						//CAMBIOS DE COLORES DE FONDO BOTONES DEL MENï¿½
			    		vista.btnPanelAlumnos.setBackground(Color.WHITE);
			    		vista.btnPanelEmpresas.setBackground(new Color(211, 211, 211));
			    		vista.btnPanelPeriodos.setBackground(Color.WHITE);
			    		vista.btnPanelPracticas.setBackground(Color.WHITE);
			    		vista.btnPanelInstrucciones.setBackground(Color.WHITE);
						
						//RELLENA EL JLIST DEL PANEL LISTAR EMPRESAS			
							listaEmpresas = modelo.listaEmpresas(sessionFactory);
							this.recargaJLISTEmpresas(sessionFactory, vista.modelEmpresas, vista.listEmpresas, listaEmpresas);
						
							
						//RELLEANR EL COMBO BOX DE LAS POBLACIONES
						vista.comboBoxPoblacionUSUEmpresa.removeAllItems();
						modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUEmpresa);
					
						//RELLENA EL CAMPO DE FECHA DE ACTUALIZACION, CON LA FECHA ACTUAL
							String fechaActualizacion = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
							vista.lblFechaActualizacionUSUEmpresa.setText(fechaActualizacion);	
				    }
				    
				//AL PULSAR EN UNA POBLACIï¿½N CARGA SU CODIGO POSTAL
				    if(e.getSource() == vista.comboBoxPoblacionUSUEmpresa) {
				    	if(vista.comboBoxPoblacionUSUEmpresa.getSelectedItem() != null) {
					    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUEmpresa.getSelectedItem().toString(), vista.comboBoxCodigoPostalUSUEmpresa);
				    	}
			
				    }
			    
			    //BOTON BUSCAR DEL PANEL LISTAR EMPRESAS 
			    
				    if(e.getSource() == vista.btnBuscarListaEmpresas) {
			    	//Rellenar List de empresas				
					listaEmpresas = modelo.listaEmpresasFiltro(sessionFactory, vista.txtFiltroListaEmpresa.getText());
					this.recargaJLISTEmpresas(sessionFactory, vista.modelEmpresas, vista.listEmpresas, listaEmpresas);
				    }
		    
		    
			    /**
			     * PANEL CONVENIOS
			     */
			    	//BOTON QUE ABRE EL PANEL DE VER CONVENIOS
				    if(e.getSource() == vista.btnPanelConvenio) {
				    		
				    	if(vista.listEmpresas.getSelectedIndex() != -1) {
				    		vista.panelListaEmpresas.setVisible(false);
					    	vista.panelConvenios.setVisible(true);
					    	vista.btnPanelCrearNuevoConvenio.setVisible(true);
							vista.panelCrearNuevoConvenio.setVisible(false);

					    	
					    	listaEmpresas = modelo.listaEmpresas(sessionFactory);
					    	
					    	//RELLENA JLIST CON LOS CONVENIOS DE LA EMPRESA SELECCIONADA EJN EL PANEL LSITA EMPRESAS		
					    	vista.lblNombreEmpresaConvenios.setText(listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getNombreEmpresa());

					    	vista.comboBoxListaCursoConvenio.removeAllItems();
							modelo.rellenarComboBoxCursos(sessionFactory, vista.comboBoxListaCursoConvenio);
				    	
							listaConvenios = modelo.listarConveniosCIFEmpresa(sessionFactory, listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
							this.recargaJLISTVerConvenio(sessionFactory, vista.modelConvenios, vista.listConvenios, listaConvenios);
							try {

					            File objetofile = new File ("src/AyudaConvenios.txt");
					            Desktop.getDesktop().open(objetofile);

					     }catch (IOException ex) {

					            System.out.println(ex);

					     }
				    	
				    	}
				    	
				    }
				    
				    //BOTON QUE ACTUALIZA LOS CONVENIOS
				    	if(e.getSource() == vista.btnActualizarConvenio) {
				    		if(vista.listConvenios.getSelectedIndex() != -1){
				    			
				    			listaEmpresas = modelo.listaEmpresas(sessionFactory);
						    	
						    	//RELLENA JLIST CON LOS CONVENIOS DE LA EMPRESA SELECCIONADA EJN EL PANEL LISTA EMPRESAS		
						    	listaConvenios = modelo.listarConveniosCIFEmpresa(sessionFactory, listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
						    	
						    	//FECHA DE HOY
						    	java.sql.Date fecha = null;
						    	Date fechaAct = Calendar.getInstance().getTime();
							    fecha = new java.sql.Date(fechaAct.getTime());
				    			
				    			modelo.actualizarConvenio(sessionFactory, listaConvenios.get(vista.listConvenios.getSelectedIndex()).getIdConvenio(), listaConvenios.get(vista.listConvenios.getSelectedIndex()).getTipoConvenio(), 
				    					fecha, listaConvenios.get(vista.listConvenios.getSelectedIndex()).getEmpresa().getCifEmpresa());
				    		
						    	listaConvenios = modelo.listarConveniosCIFEmpresa(sessionFactory, listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
								this.recargaJLISTVerConvenio(sessionFactory, vista.modelConvenios, vista.listConvenios, listaConvenios);
				    		
				    		}
				    		
				    	
				    	}
				    	
				    	if(e.getSource() == vista.btnPanelCrearNuevoConvenio) {
				    		
				    		vista.panelCrearNuevoConvenio.setVisible(true);
				    		vista.btnPanelCrearNuevoConvenio.setVisible(false);

				    	}
				    	
				    	if(e.getSource() == vista.btnCrearConvenio) {
				    		
				    		listaEmpresas = modelo.listaEmpresas(sessionFactory);
					    	listaConvenios = modelo.listarConveniosCIFEmpresa(sessionFactory, listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
					    	
					    	
					    	//FECHA ANEXO
					    	java.sql.Date fecha = null;
					    	
							Date fechaAnexo = Calendar.getInstance().getTime();
							fecha = new java.sql.Date(fechaAnexo.getTime());
						    	
						    //INSERT DEL CONVENIO
					    	modelo.crearConvenio(sessionFactory, listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa(), vista.comboBoxListaCursoConvenio.getSelectedItem().toString(), 
					    			vista.comboBoxTipoConvenioPanelConvenio.getSelectedItem().toString(), listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).isOrganismoPublico(), fecha, vista.lblError2Convenio);
					    				
					    	
					    	//RELLENA JLIST CON LOS CONVENIOS DE LA EMPRESA SELECCIONADA EJN EL PANEL LSITA EMPRESAS
					    	listaEmpresas = modelo.listaEmpresas(sessionFactory);
					    	listaConvenios = modelo.listarConveniosCIFEmpresa(sessionFactory, listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
							this.recargaJLISTVerConvenio(sessionFactory, vista.modelConvenios, vista.listConvenios, listaConvenios);

							
				    		vista.panelCrearNuevoConvenio.setVisible(false);
				    		vista.btnPanelCrearNuevoConvenio.setVisible(true);
				    	}
				    	
				    	
				
				/**
				 * Panel Nueva Actualizar Empresa
				 */
				  //BOTON QUE MUESTRA EL PANEL DE Aï¿½ADIR NUEVA EMPRESA
					if(e.getSource() == vista.btnPanelAddEmpresa){
							this.vista.btnModificarEmpresa.setVisible(false);
					    	this.vista.btnAnadirEmpresa.setVisible(true);
					    	
					    	this.vista.lblTituloModificarEmpresa.setVisible(false);
					    	this.vista.lblTituloNuevoEmpresa.setVisible(true);
							
							this.vista.panelListaEmpresas.setVisible(false);
				    		this.vista.panelNuevaActualizarEmpresa.setVisible(true);
				    		
				    		
				    	vista.lblErroresNuevaEmpresa.setText(" ");
				    	this.resetFormularioNuevaEmpresa();
					}
			
				//BOTON QUE HACE EL INSERT DE LA EMPRESA
				    if(e.getSource() == vista.btnAnadirEmpresa) {
		
				    	if(this.anadirEmpresaValida() == true && this.existeNuevaEmpresa(sessionFactory) == false) {
				    		//Llamamos al metodo que realiza el insert de la nueva empresa
				    		this.crearNuevaEmpresa(sessionFactory, modelo);
				    		this.vista.panelListaEmpresas.setVisible(true);
				    		this.vista.panelNuevaActualizarEmpresa.setVisible(false);
				    		
				    		//Rellenar List de empresas	
							listaEmpresas = modelo.listaEmpresas(sessionFactory);
							this.recargaJLISTEmpresas(sessionFactory,  vista.modelEmpresas, vista.listEmpresas, listaEmpresas);
				    	}
				    }
				 
				 //BOTON QUE ABRE EL PANEL NUEVA ACTUALIZAR EMPRESA
				    if(e.getSource() == vista.btnPanelModificarEmpresa){
				    	if(vista.listEmpresas.getSelectedIndex() != -1){
				    		vista.lblErroresNuevaEmpresa.setText(" ");
				    		
				    		
				    		//Hace visible el panel nueva actualizar la empresa y cambia el titulo por modificar 
				    		this.vista.btnModificarEmpresa.setVisible(true);
					    	this.vista.btnAnadirEmpresa.setVisible(false);
					    	
					    	this.vista.lblTituloModificarEmpresa.setVisible(true);
					    	this.vista.lblTituloNuevoEmpresa.setVisible(false);
					    	
					    	
					    	this.vista.panelNuevaActualizarEmpresa.setVisible(true);
					    	this.vista.panelListaEmpresas.setVisible(false);
					    	
					    	//RECARGA LOS COMBOBOX
					    	vista.comboBoxPoblacionUSUAlumno.removeAllItems();
					    	modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUAlumno);
					    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUAlumno.getSelectedItem().toString(), vista.comboBoxCodigoPostalUSUAlumno);
					    	
					    	//RELLENA LOS CAMPOS DE LA EMPRESA SELECCIONADA
					    	try {
					    		
								listaEmpresas = modelo.listaEmpresas(sessionFactory);
							
								//Seteamos los valores de la empresa seleccionada
								
								Session session = null;
								
								try {
									session = sessionFactory.getCurrentSession();
									session.beginTransaction();
									
									//CIF
									vista.txtCIFEmpresa.setText(listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
									
									Query query = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cifEmpresa =:cifEmpresa");
									query.setParameter("cifEmpresa", listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
									Empresa empresa = (Empresa) query.getSingleResult();
									
									vista.txtNombreEmpresa.setText(empresa.getNombreEmpresa());
									vista.txtDireccionEmpresa.setText(empresa.getDireccionEmpresa());
									vista.comboBoxPoblacionUSUEmpresa.setSelectedItem(empresa.getPoblacion().getNombre());
									vista.comboBoxCodigoPostalUSUEmpresa.setSelectedItem(empresa.getPoblacion().getCodigoPostal());
									vista.txtEmailEmpresa.setText(empresa.getEmailEmpresa());
									
									int tlf1 = empresa.getTelefono1();
									vista.txtTelefono1Empresa.setText(String.valueOf(tlf1));
									
									int tlf2 = empresa.getTelefono2();
									vista.txtTelefono2Empresa.setText(String.valueOf(tlf2));
									
									vista.txtFaxEmpresa.setText(empresa.getFaxEmpresa());
									vista.txtPaginaWebEmpresa.setText(empresa.getPaginaWeb());
									
									boolean organismoPublico = empresa.isOrganismoPublico();
									if (organismoPublico = true) {
										vista.checkBoxOrganismoPublicoUSUEmpresa.setSelected(true);
									} else {
										vista.checkBoxOrganismoPublicoUSUEmpresa.setSelected(false);
									}
									
									vista.txtDNIGerenteEmpresa.setText(empresa.getDniGerente());
									vista.txtNombreGerenteEmpresa.setText(empresa.getNombreGerente());
									vista.txtDNIPersonaContactoEmpresaEmpresa.setText(empresa.getDniPersonaContacto());
									vista.txtPersonaContactoEmpresa.setText(empresa.getPersonaContacto());
									vista.txtObservacionesEmpresa.setText(empresa.getObservaciones());
									
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
					    	
					    	} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
				    }
				    
				//BOTON QUE ACTUALIZA LA EMPRESA
				    if(e.getSource() == vista.btnModificarEmpresa){
				    					    	
				    	if(this.anadirEmpresaValida() == true) {
				    		//Llamamos al metodo que realiza el insert de la nueva empresa
				    		this.actualizarEmpresa(sessionFactory, modelo);
				    		this.vista.panelNuevaActualizarEmpresa.setVisible(false);
					    	this.vista.panelListaEmpresas.setVisible(true);
				    		
					    	//Rellenar List de empresas				
							listaEmpresas = modelo.listaEmpresas(sessionFactory);
							this.recargaJLISTEmpresas(sessionFactory, vista.modelEmpresas, vista.listEmpresas, listaEmpresas);
							
							//RELLENAR EL COMBO BOX DE LAS POBLACIONES
							//RECARGA LOS COMBOBOX
							vista.comboBoxPoblacionUSUEmpresa.removeAllItems();
							modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUEmpresa);
					    	modelo.rellenarComboBoxCodigoPostal(sessionFactory, vista.comboBoxPoblacionUSUEmpresa.getSelectedItem().toString(), vista.comboBoxCodigoPostalUSUEmpresa);
				    	}
				    		
				    }
				    
				    //BOTON QUE HACE EL INSERT DE LA NUEVA POBLACION DEL PANEL EMPRESA
				    if(e.getSource() == vista.btnAnadirPoblacionEmpresa) {
				    	
						if(this.anadirPoblacionValido() == true) {
				    		//Llamamos al metodo que realiza el insert del nueva poblacion
							this.crearNuevaPoblacion(sessionFactory, modelo);
							this.vista.panelNuevaActualizarEmpresa.setVisible(true);
							this.vista.panelNuevaPoblacion.setVisible(false);
							this.vista.panelListaEmpresas.setVisible(false);
							
							//RELLENAR EL COMBO BOX DE LAS POBLACIONES
							modelo.rellenarComboBoxNombreCiudad(sessionFactory, vista.comboBoxPoblacionUSUEmpresa);
					    	
					    	//Rellenar List de empresas				
							listaEmpresas = modelo.listaEmpresas(sessionFactory);
							this.recargaJLISTEmpresas(sessionFactory, vista.modelEmpresas, vista.listEmpresas, listaEmpresas);
						}
					}
			    /**
			     * Panel Nueva Poblacion
			     */
					  //BOTON QUE ABRE EL PANEL DE NUEVA POBLACION
					    if(e.getSource() == vista.btnNuevaPoblacionEmpresa) {
					    	vista.panelNuevaActualizarEmpresa.setVisible(false);
							vista.panelNuevaPoblacion.setVisible(true);
							
							vista.btnAnadirPoblacionEmpresa.setVisible(true);
							vista.btnAnadirPoblacionAlumno.setVisible(false);
						}
						
					 
		    
			  //BOTON QUE ELIMINA LA EMPRESA
			    if(e.getSource() == vista.btnEliminarEmpresa) {
			    	
			    	try {
						listaEmpresas = modelo.listaEmpresas(sessionFactory);
						modelo.eliminarEmpresa(sessionFactory, listaEmpresas.get(vista.listEmpresas.getSelectedIndex()).getCifEmpresa());
				    	
						//Rellenar List de empresas				
						listaEmpresas = modelo.listaEmpresas(sessionFactory);
						this.recargaJLISTEmpresas(sessionFactory, vista.modelEmpresas, vista.listEmpresas, listaEmpresas);
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			    }
		    
		    /**
			 * ACCIONES DEL PANEL PERIODOS
			*/
				//BOTON QUE ABRE EL PANEL DE PERIODOS
					   if(e.getSource() == vista.btnPanelPeriodos) {
						   this.vista.panelPeriodos.setVisible(true);
						   	vista.panelInstrucciones.setVisible(false);
						    vista.panelListaEmpresas.setVisible(false);
					    	vista.panelListaAlumno.setVisible(false);
					    	vista.panelNuevoActualizarAlumno.setVisible(false);
							vista.panelNuevaPoblacion.setVisible(false);
							vista.panelNuevoCurso.setVisible(false);
							vista.panelConvenios.setVisible(false);
							vista.panelNuevaActualizarEmpresa.setVisible(false);
							vista.panelPracticas.setVisible(false);
							vista.panelDocumentos.setVisible(false);
							
							//CAMBIOS DE COLORES DE FONDO BOTONES DEL MENï¿½
				    		vista.btnPanelAlumnos.setBackground(Color.WHITE);
				    		vista.btnPanelEmpresas.setBackground(Color.WHITE);
				    		vista.btnPanelPeriodos.setBackground(new Color(211, 211, 211));
				    		vista.btnPanelPracticas.setBackground(Color.WHITE);
				    		vista.btnPanelInstrucciones.setBackground(Color.WHITE);
							
						   //RELLENA EL COMBO BOX DE CURSOS
						   this.vista.comboBoxListaCursoPeriodo.removeAllItems();
						   modelo.rellenarComboBoxCursos(sessionFactory, this.vista.comboBoxListaCursoPeriodo);
						   
						   //RELLENA EL COMBO BOX DE PROFESOR
						   this.vista.comboBoxListaProfesorPeriodo.removeAllItems();
						   modelo.rellenarComboBoxProfesor(sessionFactory, vista.comboBoxListaProfesorPeriodo);
						   
						 //Rellenar List de periodo			
						   listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
						   for (int i = 0; i < listaPeriodos.size(); i++) {
								listaPeriodos.get(i).getCurso().toString();
							   }
							this.recargaJLISTPeriodos(sessionFactory, vista.modelPeriodos, vista.listPeriodos, listaPeriodos);
					   }
					   
			//  BOTON DE HACER EL INSERT DE PERIODO (PRACTICAS)
				if(e.getSource() == vista.btnCrearPeriodo) {
					//Hace el insert del periodo
					if(this.anadirPeriodoValido() == true) {
						//FECHA INICIO
						Date fechaInicioUSU = vista.dateChooserFechaInicioPeriodo.getDate();
						java.sql.Date fechaInicio = new java.sql.Date(fechaInicioUSU.getTime());
						
						//FECHA FIN
						Date fechaFinUSU = vista.dateChooserFechaFinPeriodo.getDate();
						java.sql.Date fechaFin = new java.sql.Date(fechaFinUSU.getTime());
						
						//INSERT
						modelo.crearPeriodoPracticas(sessionFactory, vista.comboBoxListaTipoPeriodo.getSelectedItem().toString(), fechaInicio, fechaFin, vista.comboBoxListaCursoPeriodo.getSelectedItem().toString(), vista.comboBoxListaProfesorPeriodo.getSelectedItem().toString());
						
						//RESET FORMULARIO
						vista.comboBoxListaCursoPeriodo.setSelectedItem("");
						vista.comboBoxListaTipoPeriodo.setSelectedItem("");
						vista.comboBoxListaProfesorPeriodo.setSelectedItem("");
						vista.dateChooserFechaInicioPeriodo.setDate(null);
						vista.dateChooserFechaFinPeriodo.setDate(null);
						
						//Rellenar List de empresas	
						
						   listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
						   this.recargaJLISTPeriodos(sessionFactory, vista.modelPeriodos, vista.listPeriodos, listaPeriodos);
					}
				}
			
			// BOTON QUE ELIMINA EL PERIODO SELECCIONADO
				//BOTON QUE ELIMINA EL PERIODO
			    if(e.getSource() == vista.btnEliminarPeriodo) {
			    	
			    	try {
						listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
						listaAnexarsPracticas = modelo.listarAnexarsPracticas(sessionFactory);
						modelo.eliminarPeriodoPractica(sessionFactory, listaPeriodos.get(vista.listPeriodos.getSelectedIndex()).getIdPractica(),listaAnexarsPracticas);
				    	
				    	//RELLENA EL JLIST DE LOS PERIODOS
						listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
						this.recargaJLISTPeriodos(sessionFactory, vista.modelPeriodos, vista.listPeriodos, listaPeriodos);
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	
			    }
		    /**
		     * ACCIONES DEL PANEL PRACTICAS
		     */
			//BOTON QUE ABRE EL PANEL DE PRACTICAS
		    if(e.getSource() == vista.btnPanelPracticas) {
		    	vista.panelInstrucciones.setVisible(false);
		    	vista.panelListaEmpresas.setVisible(false);
		    	vista.panelListaAlumno.setVisible(false);
		    	vista.panelNuevoActualizarAlumno.setVisible(false);
				vista.panelNuevaPoblacion.setVisible(false);
				vista.panelNuevoCurso.setVisible(false);
				vista.panelConvenios.setVisible(false);
				vista.panelNuevaActualizarEmpresa.setVisible(false);
				vista.panelPeriodos.setVisible(false);
				vista.panelPracticas.setVisible(true);
				vista.panelDocumentos.setVisible(false);
		    	
				//CAMBIOS DE COLORES DE FONDO BOTONES DEL MENï¿½
	    		vista.btnPanelAlumnos.setBackground(Color.WHITE);
	    		vista.btnPanelEmpresas.setBackground(Color.WHITE);
	    		vista.btnPanelPeriodos.setBackground(Color.WHITE);
	    		vista.btnPanelPracticas.setBackground(new Color(211, 211, 211));
	    		vista.btnPanelInstrucciones.setBackground(Color.WHITE);
		    	
	    		//RELLENAR LIST DE PERIODO			
				   listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
				   for (int i = 0; i < listaPeriodos.size(); i++) {
						listaPeriodos.get(i).getCurso().toString();
					   }
					this.recargaJLISTPeriodos(sessionFactory, vista.modelPeriodosPracticas, vista.listPeriodosPracticas, listaPeriodos);
					
			    //VACï¿½A LOS MODELS DE ALUMNOS, EMPRESAS Y ANEXAR
					vista.modelAlumnosPracticas.removeAllElements();
					vista.modelEmpresasPracticas.removeAllElements();
					vista.modelAnexarPracticas.removeAllElements();
		    }
		   
		   //ASIGNAR PERIODO
		  if(e.getSource() == vista.btnAsignarPeriodoPracticas){
			   
			  //COMPROBAR QUE HAY UN REGISTRO SELECCIOANDO
			  if(vista.listPeriodosPracticas.getSelectedIndex() != -1) {
				  
				  //MOSTRAR LA ZONA DE ALUMNOS Y EMPRESAS
				  vista.lblTituloListaAlumnosPracticas.setVisible(true);
				  vista.listPaneAlumnosPracticas.setVisible(true);
				  vista.lblTituloListaEmpresasPracticas.setVisible(true);
				  vista.listPaneEmpresasPracticas.setVisible(true);
				  vista.btnAsignarEmpresaPracticas.setVisible(true);
				  
				//RELLENAR JLIST DE ALUMNOS SEGï¿½N EL CURSO DEL PERIODO SELECCIONADO
				  listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
				  String curso = listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()).getCurso().getNombreCurso();
				  this.recargaJLISTAlumnosPracticas(sessionFactory, curso, vista.modelAlumnosPracticas, vista.listAlumnosPracticas);
				  
			   //RELLENAR JLIST DE EMPRESAS CON DATOS DEL CONVENIO
				  listaEmpresas = modelo.listaEmpresas(sessionFactory);
					if(vista.listAlumnosPracticas.getFirstVisibleIndex() > -1) {
						this.recargaJLISTConveniosEmpresasPracticas(sessionFactory, vista.modelEmpresasPracticas, vista.listEmpresasPracticas, listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()));
					
				//MOSTRAR PERIODOS
				//MOSTRAR LA ZONA DE LA RELACION ALUMNO - EMPRESA - PERIODO
					 vista.lblTituloListaAnexarPracticas.setVisible(true);
					 vista.listPaneAnexarPracticas.setVisible(true);
					 vista.btnEliminarAnexarPracticas.setVisible(true);
					 vista.btnPanelDocumentos.setVisible(true);
					 
					 listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
					 this.recargaJLISTAnexarPracticas(sessionFactory, vista.modelAnexarPracticas, vista.listAnexarPracticas, listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()));

				}
			}
			  
		   }
		  
		  // MUESTRA LAS RELACIONES ->  ALUMNO - CONVENIO - PERIODO   
		  if(e.getSource() == vista.btnAsignarEmpresaPracticas){
			  
			//COMPROBAR QUE HAY REGISTROS SELECCIOANDOS EN EL JLIST DE ALUMNOS Y EMPRESAS
			  if(vista.listAlumnosPracticas.getSelectedIndex() != -1 && vista.listEmpresasPracticas.getSelectedIndex() != -1) {
				  
				//HACE EL INSERT EN LA TABLA ANEXAR ->  ALUMNO - EMPRESA - PERIODO
				  listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
				  listaConvenios = modelo.listarConveniosTipoConvenio(sessionFactory,listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()).getTipoPractica());
				  
				  String curso = listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()).getCurso().getNombreCurso();
				  try {
					listaAlumnos = modelo.listarAlumnos(sessionFactory, curso);
					listaAnexarsPracticas = modelo.listarAnexarsPracticas(sessionFactory);
				  } catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				  }
				  
				  modelo.crearAnexar(sessionFactory, listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()), listaConvenios.get(vista.listEmpresasPracticas.getSelectedIndex()), listaAlumnos.get(vista.listAlumnosPracticas.getSelectedIndex()), listaAnexarsPracticas);
				
				//RELLENAR JLIST ANEXARS
				  listaAnexarsPracticas = modelo.listarAnexarsPracticas(sessionFactory);
				  listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
				  this.recargaJLISTAnexarPracticas(sessionFactory, vista.modelAnexarPracticas, vista.listAnexarPracticas,listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()));
				  
			  }  
		  }
		//ELIMINAR RELACION ALUMNO - EMPRESA - PERIODO
		  if(e.getSource() == vista.btnEliminarAnexarPracticas){
			  listaAnexarsPracticas = modelo.listarAnexarsPracticas(sessionFactory);
			  modelo.eliminarAnexar(sessionFactory, listaAnexarsPracticas.get(vista.listAnexarPracticas.getSelectedIndex()).getIdAnexado());
		    	
			//RELLENAR JLIST ANEXARS
			  listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
			  listaAnexarsPracticas = modelo.listarAnexarsPracticas(sessionFactory);
			  this.recargaJLISTAnexarPracticas(sessionFactory, vista.modelAnexarPracticas, vista.listAnexarPracticas, listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()));
		  }
	
		  //BOTON QUE ABRE EL PANEL DE DOCUMENTOS
		  if(e.getSource() == vista.btnPanelDocumentos) {
			  if(vista.modelAnexarPracticas.size()>0){
				  vista.panelPracticas.setVisible(false);
				  vista.panelDocumentos.setVisible(true);
				  vista.lblInfoRutaDocumentos.setVisible(false);
				  //INGRESAR TIPO DE DOCUMENTOS FCT/PFE
				  listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
				  
					if (listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()).getTipoPractica().equals("FCT")) {

							vista.lblFCToPFEDocumentos.setText("DOCUMENTOS DE FCT");
							// SI ES FCT SE MUESTRA EL ANEXO 3 Y ANEXO 4 FCT
							vista.btnGuardarDocumentos.setBounds(226, 480, 271, 55);
							vista.checkBoxAnexo4FCT.setVisible(true);
							vista.checkBoxAnexo3.setVisible(true);
							vista.checkBoxAnexo4PFE.setVisible(false);

					} else if (listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()).getTipoPractica().equals("PFE")) {
							vista.lblFCToPFEDocumentos.setText("DOCUMENTOS DE PFE");
							// SI ES PFE, NO SE MUESTRA EL ANEXO 3 ni el ANEXO 4 FCT
							vista.btnGuardarDocumentos.setBounds(226, 430, 271, 55);
							vista.checkBoxAnexo4FCT.setVisible(false);
							vista.checkBoxAnexo3.setVisible(false);
							vista.checkBoxAnexo4PFE.setVisible(true);
					}
			  }
		  }
		/**
		 * ACCIONES PANEL DOCUMENTOS
		*/
		  //BOTON GUARDAR
		  if(e.getSource() == vista.btnGuardarDocumentos) {
			  if(vista.checkBoxAnexo0.isSelected() == true) {
				  DatosEfa datosEfa = modelo.listarDatosEfa(sessionFactory);
				  try {
					  listaAnexarsPracticas = modelo.listarAnexarsPracticas(sessionFactory);
					  listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
					  DatosDocumentos dd = new DatosDocumentos();
					  dd.crearDirectorio();
					  this.seleccionarDocumentos(sessionFactory ,listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()), listaAnexarsPracticas, datosEfa, modelo);
				  } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				  }
		  	}
			  if(vista.checkBoxAnexo1.isSelected() == true) {
				  DatosEfa datosEfa = modelo.listarDatosEfa(sessionFactory);
				  try {
					  listaAnexarsPracticas = modelo.listarAnexarsPracticas(sessionFactory);
					  listaPeriodos = modelo.listarPeriodoPracticas(sessionFactory);
					  DatosDocumentos dd = new DatosDocumentos();
					  dd.crearDirectorio();
					  this.seleccionarDocumentos(sessionFactory ,listaPeriodos.get(vista.listPeriodosPracticas.getSelectedIndex()), listaAnexarsPracticas, datosEfa, modelo);
				  } catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				  }
		  	}
		  }	  
		  
		  //BOTON ATRAS QUE NOS VUELVE AL PANEL DE PRACTICAS
		  if(e.getSource() == vista.btnAtrasDocumentos) {
			  vista.panelPracticas.setVisible(true);
			  vista.panelDocumentos.setVisible(false);
		  }
		  //cerrar session factory
	}
		
	
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
				

			//Metodo para validar que todo los campos del alumno estï¿½n rellenos
				public boolean anadirAlumnoValido() {
					boolean valido = true;
	
					try {
						
						if(
							vista.txtNIFUSUAlumno.getText().equals("")
							|| vista.txtNombreCompletoUSUAlumno.getText().equals("")
							|| vista.dateChooserFechaNacimientoUSUAlumno.getDate() == null
							|| vista.txtTelefonoUSUAlumno.getText().equals("")
							|| vista.txtCorreoUSUAlumno.getText().equals("")
							|| vista.comboBoxPoblacionUSUAlumno.getSelectedItem().equals("")
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
					boolean existe = true;
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
							
							existe = false;
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
					
					return existe;
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
			public void recargaJLISTAlumnos (SessionFactory sessionFactory,JComboBox comboLista, DefaultListModel model, JList list) {
				//Modelo
				Modelo modelo = new Modelo();
				
				//ARRAYLIST JLIST
				ArrayList <Alumno> listaAlumnos = new ArrayList<Alumno>();
				
				try {

					model.removeAllElements();
					
					listaAlumnos = modelo.listarAlumnos(sessionFactory, comboLista.getSelectedItem().toString());
					
					for (int i = 0; i < listaAlumnos.size(); i++) {
							model.addElement(listaAlumnos.get(i).toString());
							list.setModel(model);
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
			
			//Metodo para hacer el insert de la nueva Empresa en la base de datos
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
							int telefono2 = 0;
							if(!vista.txtTelefono2Empresa.getText().equals("")){
								telefono2 = Integer.parseInt(vista.txtTelefono2Empresa.getText());
							}
							
	
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
							
						// DNI CARGO PERSONA DE CNONTACTO
							String dniCargoPersonaContactoEmpresa = vista.txtDNIPersonaContactoEmpresaEmpresa.getText();
							
						// OBSERVACIONES
							String observacionesEmpresa = vista.txtObservacionesEmpresa.getText();
							
						// FECHA ACTUALIZACION DE LOS DATOS  
					    java.sql.Date fecha = null;
					    	
					    Date fechaAct = Calendar.getInstance().getTime();
					    fecha = new java.sql.Date(fechaAct.getTime());
					        
						// INSERT
							modelo.crearEmpresas(sessionFactory, cifEmpresa, nombreEmpresa, direccionEmpresa, telefono1, telefono2, emailEmpresa, faxEmpresa, paginaWebEmpresa, nombreGerenteEmpresa, dniGerenteEmpresa, personaContactoEmpresa, dniCargoPersonaContactoEmpresa, fecha, organismoPublico, observacionesEmpresa, poblacion);
					
						// RESET FORMULARIO NUEVA EMPRESA
							this.resetFormularioNuevaEmpresa();
							
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}	
			//Metodo que recupera los datos de la empresa seleccionada
				public void actualizarEmpresa (SessionFactory sessionFactory, Modelo modelo) {
					try {
						
						// CIF
							String cifEmpresa = vista.txtCIFEmpresa.getText();
							System.out.println(cifEmpresa);
							System.out.println("hola");

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
							modelo.actualizarEmpresa(sessionFactory, cifEmpresa, nombreEmpresa, direccionEmpresa, telefono1, telefono2, emailEmpresa, faxEmpresa, paginaWebEmpresa, nombreGerenteEmpresa, dniGerenteEmpresa, personaContactoEmpresa, dniCargoPersonaContactoEmpresa, fechaActualizacionEmpresa, organismoPublico, observacionesEmpresa, poblacion);
					
						// RESET FORMULARIO NUEVA EMPRESA
							this.resetFormularioNuevaEmpresa();
							
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			//Metodo para validar que todo los campos del alumno estï¿½n rellenos
				public boolean anadirEmpresaValida() {
					boolean valido = true;
	
					try {
						
						if(
							   vista.txtCIFEmpresa.getText().equals("")
							|| vista.txtNombreEmpresa.getText().equals("")
							|| vista.txtDireccionEmpresa.getText().equals("")
							|| vista.comboBoxPoblacionUSUEmpresa.getSelectedItem() == null
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
					boolean existe = false;
					Session session = null; 
					Modelo modelo= new Modelo();
					try {

						String cifEmpresa = vista.txtCIFEmpresa.getText();
						
						//LISTA EMPRESAS
						ArrayList<Empresa>empresas = modelo.listaEmpresas(sessionFactory);
						
						//Comprobamos si existe
						 
						for(int i = 0 ; i < empresas.size() ; i++){
							if(empresas.get(i).getCifEmpresa().equals(cifEmpresa)) {
								vista.lblErroresNuevaEmpresa.setText("ERROR!! LA EMPRESA YA EXISTE");
								vista.lblErroresNuevaEmpresa.setForeground(Color.RED);
								this.resetFormularioNuevaEmpresa();
								
								existe = true;
							}else {
								existe = false;
							}
						}
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return existe;
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

		//Recarga JLIST EMPRESA
			public void recargaJLISTEmpresas (SessionFactory sessionFactory, DefaultListModel model, JList list, ArrayList<Empresa>listaEmpresas) {
				//Modelo
				Modelo modelo = new Modelo();
				
				try {

					model.removeAllElements();
					
					for (int i = 0; i < listaEmpresas.size(); i++) {
						
						model.addElement(listaEmpresas.get(i));
						list.setModel(model);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			//Recarga JLIST del panel Ver convenio
			public void recargaJLISTVerConvenio (SessionFactory sessionFactory, DefaultListModel model, JList list, ArrayList<Convenio>listaConvenios) {
				//Modelo
				Modelo modelo = new Modelo();
				
				try {

					model.removeAllElements();
					
					for (int i = 0; i < listaConvenios.size(); i++) {
						
						model.addElement(listaConvenios.get(i).toString());
						list.setModel(model);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
										String provincia = vista.txtProvinciaUSUPoblacion.getText();
										
								        
									// INSERT
										modelo.crearPoblacion(sessionFactory, codigoPostal, nombrePoblacion, provincia);
									
									// RESET DEL FORMULARIO NUEVA POBLACION
										this.resetFormularioNuevaPoblacion();
								}catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}
						}
					
						//Metodo para validar que todo los campos del alumno estï¿½n rellenos
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
					
						//Metodo para validar que todo los campos del alumno estan rellenos
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
										
										vista.lblErroresNuevoCurso.setText("ERROR!! FALTAN CAMPOS OBLIGATORIOS curso");
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
				
			/**
			 * METODOS DE LOS PERIODOS
			 */
			//METODO QUE RECARGA EL JLIST DE PERIODOS
				public void recargaJLISTPeriodos(SessionFactory sessionFactory, DefaultListModel model, JList list, ArrayList<Practica> listaPeriodos) {
					// Modelo
					Modelo modelo = new Modelo();
	
					try {
	
						model.removeAllElements();
						
						for (int i = 0; i < listaPeriodos.size(); i++) {
	
							model.addElement(listaPeriodos.get(i).toString());
							list.setModel(model);
						}
	
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
				}
				
			//METODO PARA VALIDAR QUE ESTAN RELLENOS TODOS LOS CAMPOS DEL PERIODO 
				public  boolean anadirPeriodoValido() {
					boolean valido = true;
	
					try {
						
						if(
							vista.comboBoxListaCursoPeriodo.getSelectedItem().equals("")
							|| vista.comboBoxListaTipoPeriodo.getSelectedItem().equals("")
							|| "".equals(vista.dateChooserFechaInicioPeriodo.getDate())
							|| "".equals(vista.dateChooserFechaFinPeriodo.getDate())
							|| vista.comboBoxListaProfesorPeriodo.getSelectedItem().equals("")
								) {
							valido = false;  
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return valido;
				}
		/**
		 * METODOS DEL PANEL PRACTICAS
		 */
			//METODO QUE RECARGA EL JLIST DE ALUMNOS SEGUN EL CURSO DEL PERIODO
				public void recargaJLISTAlumnosPracticas (SessionFactory sessionFactory,String nombreCurso, DefaultListModel model, JList list) {
					//Modelo
					Modelo modelo = new Modelo();
					
					//ARRAYLIST JLIST
					ArrayList <Alumno> listaAlumnos = new ArrayList<Alumno>();
					
					try {

						model.removeAllElements();
						
						listaAlumnos = modelo.listarAlumnos(sessionFactory, nombreCurso);
						
						for (int i = 0; i < listaAlumnos.size(); i++) {
								model.addElement(listaAlumnos.get(i).toString());
								list.setModel(model);
						}
						
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				public void recargaJLISTConveniosEmpresasPracticas (SessionFactory sessionFactory, DefaultListModel model, JList list, Practica practica) {
					//Modelo
					Modelo modelo = new Modelo();
					//lista convenios
					ArrayList <Convenio> listaConvenios = modelo.listarConvenios(sessionFactory);
					try {
						model.removeAllElements();
						
						//RELLENA EL JLIST CON LAS EMPRESAS QUE TIENEN CONVENIO Y SEGUN EL TIPO DE PRACTICAS HAYA ELEGIDO EL USUARIO
						for(int i = 0; i < listaConvenios.size(); i++) {
							
								//COMPRUEBA QUE EL TIPO DE CONVENIO COINCIDE CON EL DEL PERIODO
								if(listaConvenios.get(i).getTipoConvenio().equals(practica.getTipoPractica())) {
									//COMPRUEBA SI ES PUBLICO O PRIVADO PARA DARLE UNOS ESPACIOS U OTROS AL TO STRING
									System.out.println(listaConvenios.get(i).getIdConvenio().substring(4,7));
									if(listaConvenios.get(i).getIdConvenio().substring(4,8).equals("PRIV")) {
										model.addElement(listaConvenios.get(i).toStringAnexarPRIV());
										list.setModel(model);
									}else {
										model.addElement(listaConvenios.get(i).toStringAnexarPUBL());
										list.setModel(model);
									}
										
								
							}
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		//METODO QUE RECARGA EL JLIST DE ANEXARS
			public void recargaJLISTAnexarPracticas (SessionFactory sessionFactory, DefaultListModel model, JList list, Practica practica) {
				//Modelo
				Modelo modelo = new Modelo();
				
				//ARRAYLIST JLIST
				ArrayList <Anexar> listaAnexar = new ArrayList<Anexar>();
				
				try {

					model.removeAllElements();
					
					listaAnexar = modelo.listarAnexarsPracticas(sessionFactory);
				
					for (int i = 0; i < listaAnexar.size(); i++) {
						if(listaAnexar.get(i).getPractica().getIdPractica() == practica.getIdPractica()) {
							model.addElement(listaAnexar.get(i).toString());
							list.setModel(model);
						}
							
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
			/**
			 * METODOS DEL PANEL DOCUMENTOS
			 * @throws IOException 
			 */
				//METODO QUE SELECCIONA LOS DOCUMENTOS SEGUN LOS CHECKBOX SELECCIONADOS
				public void seleccionarDocumentos(SessionFactory sessionFactory, Practica practica,ArrayList <Anexar> anexars, DatosEfa datosEfa, Modelo modelo) throws IOException {
					DatosDocumentos datosDocumentos =  new DatosDocumentos();
					
					Convenio convenio = new Convenio();
					ArrayList <Convenio> listaConvenioAnexados = new ArrayList<Convenio>();
					ArrayList <Anexar> listaAnexosAlumnos = new ArrayList<Anexar>();
					
					String tipo = "";
					ArrayList <Anexar> listaAnex = new ArrayList<Anexar>();
						/**
						 * ANEXO 0
						 */
						if(vista.checkBoxAnexo0.isSelected() == true) {
							for(int i = 0 ; i < anexars.size() ; i++) {
								if(anexars.get(i).getPractica().getIdPractica() == practica.getIdPractica()){
									listaAnex.add(anexars.get(i));
									tipo = anexars.get(i).getPractica().getTipoPractica();
								}
							}
							
							//Compruebo si es FCT o PFE
							if(tipo.equals("FCT")) {
								/**
								 * FCT_anexo 0FORM
								 */
								for (int i = 0; i < listaAnex.size(); i++) {
									if(this.existeIdConvenio(listaAnex.get(i).getConvenio(), listaConvenioAnexados) == false) {
										listaConvenioAnexados.add(listaAnex.get(i).getConvenio());	
									}
								}
								for (int i = 0; i < listaConvenioAnexados.size(); i++) {
									datosDocumentos.rellenarPDF_FCTAnexo0(listaConvenioAnexados.get(i).getTipoConvenio()+"_Anexo 0FORM", listaConvenioAnexados.get(i).getTipoConvenio(), listaConvenioAnexados.get(i), datosEfa,listaConvenioAnexados.get(i).getEmpresa().getCifEmpresa());
									vista.lblInfoRutaDocumentos.setVisible(true);
								}
							}else if(tipo.equals("PFE")) {
								/**
								 * PFE_anexo 0FORM
								 */
								for (int i = 0; i < listaAnex.size(); i++) {
									if(this.existeIdConvenio(listaAnex.get(i).getConvenio(), listaConvenioAnexados) == false) {
										listaConvenioAnexados.add(listaAnex.get(i).getConvenio());	
									}
								}
								for (int i = 0; i < listaConvenioAnexados.size(); i++) {
									datosDocumentos.rellenarPDF_PFEAnexo0(listaConvenioAnexados.get(i).getTipoConvenio()+"_Anexo 0FORM", listaConvenioAnexados.get(i).getTipoConvenio(), listaConvenioAnexados.get(i), datosEfa,listaConvenioAnexados.get(i).getEmpresa().getCifEmpresa());
									vista.lblInfoRutaDocumentos.setVisible(true);
								}	
							}
						/**
						* ANEXO 1
						*/	
						}if(vista.checkBoxAnexo1.isSelected() == true) {
							for(int i=0;i<anexars.size();i++) {
								if(anexars.get(i).getPractica().getIdPractica() == practica.getIdPractica()){
									listaAnex.add(anexars.get(i));
									tipo = anexars.get(i).getPractica().getTipoPractica();
								}
							}
							
							//Compruebo si es FCT o PFE
							if(tipo.equals("FCT")) {
								/**
								 * FCT_anexo 1FORM
								 */
								for (int i = 0; i < listaAnex.size(); i++) {
									if(this.existeIdConvenio(listaAnex.get(i).getConvenio(), listaConvenioAnexados) == false) {
										listaConvenioAnexados.add(listaAnex.get(i).getConvenio());	
									}
								}
								for (int i = 0; i < listaConvenioAnexados.size(); i++) {
									listaAnexosAlumnos = modelo.rellenarAnexo1(sessionFactory, listaConvenioAnexados.get(i).getId());
									datosDocumentos.rellenarPDF_FCTAnexo1(listaConvenioAnexados.get(i).getTipoConvenio() + "_Anexo 1FORM", listaConvenioAnexados.get(i).getTipoConvenio(), listaConvenioAnexados.get(i), listaAnexosAlumnos, datosEfa, listaConvenioAnexados.get(i).getEmpresa().getCifEmpresa());
								}
							}else if(tipo.equals("PFE")) {
								/**
								 * PFE_anexo 1FORM
								 */
								for (int i = 0; i < listaAnex.size(); i++) {
									if(this.existeIdConvenio(listaAnex.get(i).getConvenio(), listaConvenioAnexados) == false) {
										listaConvenioAnexados.add(listaAnex.get(i).getConvenio());	
									}
								}
								for (int i = 0; i < listaConvenioAnexados.size(); i++) {
									listaAnexosAlumnos = modelo.rellenarAnexo1(sessionFactory, listaConvenioAnexados.get(i).getId());
									datosDocumentos.rellenarPDF_PFEAnexo1(listaConvenioAnexados.get(i).getTipoConvenio() + "_Anexo 1FORM", listaConvenioAnexados.get(i).getTipoConvenio(), listaConvenioAnexados.get(i), listaAnexosAlumnos, datosEfa, listaConvenioAnexados.get(i) .getEmpresa().getCifEmpresa());
								}
							}
					}
			}	
				
				private boolean existeIdConvenio(Convenio convenio, ArrayList <Convenio> listaConveniosAnexados) {
				   boolean existe = false;

				   for(int i = 0 ; i < listaConveniosAnexados.size() ; i++)   {
				      if(listaConveniosAnexados.get(i).getId() == convenio.getId()) {
				         existe = true;
				      }
				   }

				   return existe;
				}
	}


	