package Modelo;

import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.awt.Color;
import java.math.BigInteger;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Parameter;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.Query;
import org.hibernate.type.CurrencyType;

import java.util.Comparator;



import persistencia.Alumno;
import persistencia.Anexar;
import persistencia.Convenio;
import persistencia.Curso;
import persistencia.DatosEfa;
import persistencia.Empresa;
import persistencia.Poblacion;
import persistencia.Practica;
import persistencia.Profesor;



public class Modelo {
	

	/**
	 * Metodo para crear e insertar un nuevo curso en la base de datos
	 * @param sessionFactory
	 * @param nombreCurso
	 * @param nombreAbrev
	 * @param clave
	 * @param horasFCT
	 * @param esPublico
	 * @throws HibernateException
	 */
	public void crearCurso (SessionFactory sessionFactory, String nombreCurso, String nombreAbrev, String clave, String horasFCT, boolean esPublico) throws HibernateException {
		
		Session session = null;
		
		try {
			
			//Crear sesion e iniciar transaccion
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Creamos un objeto de tipo Curso para hacer el insert
			Curso curso = new Curso();
			curso.setNombreCurso(nombreCurso);
			curso.setNombreAbrev(nombreAbrev);
			curso.setClave(clave);
			curso.setHorasFct(Integer.parseInt(horasFCT));
			curso.setEsPublico(esPublico);
			
			session.saveOrUpdate(curso);
			session.getTransaction().commit();
			
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

	/**
	 * Metodo para rellenar el ComboBox del panel Alumnos
	 * @param sessionFactory
	 * @param comboBox
	 */
	public void rellenarComboBoxCursos (SessionFactory sessionFactory, JComboBox comboBox) {
		Session session = null;
		
		try {
			
			//Crear sesion e iniciar transaccion
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			comboBox.removeAllItems();
			
			//Hacemos una consulta a la tabla de Curso para que devuelva todos los valores de esa tabla y almacenarlos en un arraylist
			Query query = session.createQuery("FROM Curso");
			ArrayList<Curso> listaCursos = (ArrayList<Curso>) query.list();
			
				comboBox.addItem("");
				
			for(int i=0;i<listaCursos.size();i++) {
				comboBox.addItem(listaCursos.get(i).getNombreCurso());
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
	
	
	
	/**
	  * Metodo para crear e insertar una nueva poblacion en la base de datos
	  * @param sessionFactory
	  * @param codigoPostal
	  * @param nombre
	  * @param provincia
	  */
	 public void crearPoblacion (SessionFactory sessionFactory, int codigoPostal, String nombre, String provincia) {
		 
		 Session session = null;
			
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				//Creamos un objeto Poblacion para hacer el insert
				Poblacion poblacion = new Poblacion();
				poblacion.setCodigoPostal(codigoPostal);
				poblacion.setNombre(nombre);
				poblacion.setProvincia(provincia);			
				
				session.saveOrUpdate(poblacion);
				session.getTransaction().commit();
				
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

	/**
	 * Metodo para rellenar el ComboBox de las ciudades de los paneles de Alumnos y Empresas
	 * @param sessionFactory
	 * @param comboPoblacionNombre
	 */
	 public void rellenarComboBoxNombreCiudad (SessionFactory sessionFactory, JComboBox comboPoblacionNombre) {
			Session session = null;
			
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				comboPoblacionNombre.removeAllItems();
				
				//Consulta para obtener los nombres de las poblaciones ordenadas alfabeticamente
				
				Query query = session.createQuery("FROM Poblacion GROUP BY Nombre ORDER BY Nombre ASC");
				ArrayList<Poblacion> listaNombresPoblacion = (ArrayList<Poblacion>) query.list();
				
					comboPoblacionNombre.addItem("");
					
				for(int i=0;i<listaNombresPoblacion.size();i++) {
					comboPoblacionNombre.addItem(listaNombresPoblacion.get(i).getNombre());
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
	
	 
	 /**
	  * Metodo para rellenar el ComboBox del codigo postal de los paneles de Alumnos y Empresas
	  * dependiendo de la eleccion del usuario en el ComboBox de ciudad
	  * @param sessionFactory
	  * @param nombrePoblacion
	  * @param comboPoblacionCP
	  */
	 public void rellenarComboBoxCodigoPostal (SessionFactory sessionFactory,String nombrePoblacion, JComboBox comboPoblacionCP) {
			
			Session session = null; 
			
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				comboPoblacionCP.removeAllItems();
				
				//Consulta para obtener los codigos postales de la ciudad seleccionada en el combobox anterior.
				 
				Query query = session.createQuery("FROM Poblacion WHERE nombre = :nombre");
				query.setParameter("nombre", nombrePoblacion);
				ArrayList<Poblacion> listaCodigoPostales = (ArrayList<Poblacion>) query.list();
				
				for(int i=0 ; i < listaCodigoPostales.size() ; i++) {
					comboPoblacionCP.addItem(listaCodigoPostales.get(i).getCodigoPostal());
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
	 
	 /**
	  * Metodo para rellenar el ComboBox de profesores en panel Perido
	  * @param sessionFactory
	  * @param comboProfesor
	  */
	 public void rellenarComboBoxProfesor (SessionFactory sessionFactory, JComboBox comboProfesor) {
			Session session = null;
			
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				//Consulta para obtener los nombres de las poblaciones
				 
				Query query = session.createQuery("FROM Profesor GROUP BY Nombre ORDER BY Nombre ASC");
				ArrayList<Profesor> listaProfesor = (ArrayList<Profesor>) query.list();
				
					comboProfesor.addItem("");
					
				for(int i=0;i<listaProfesor.size();i++) {
					comboProfesor.addItem(listaProfesor.get(i).getNombre());
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
	 
	/**
	 * Metodo para crear e insertar un nuevo alumno en la base de datos
	 * @param sessionFactory
	 * @param nif
	 * @param nombreCompleto
	 * @param seleccionado
	 * @param telefono
	 * @param correo
	 * @param fechaNacimiento
	 * @param codigoPostal
	 * @param nombreCurso
	 * @throws HibernateException
	 */
	 public void crearAlumno (SessionFactory sessionFactory, String nif, String nombreCompleto, int telefono, String correo, Date fechaNacimiento, int codigoPostal, String nombreCurso) throws HibernateException {
		
		Session session = null;
		
		try {
			
			//Crear sesion e iniciar transaccion
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Creamos un objeto Alumno para hacer el insert
			Alumno alumno = new Alumno();
			alumno.setNif(nif);
			alumno.setNombreCompleto(nombreCompleto);
			alumno.setTelefono(telefono);
			alumno.setCorreo(correo);
			alumno.setFechaNacimiento(fechaNacimiento);
			
			//Consulta para sacar la poblacion del alumno
			Query poblacionQuery = session.createQuery("FROM Poblacion WHERE codigoPostal =:codigoPostal");
			poblacionQuery.setParameter("codigoPostal", codigoPostal);
			Poblacion pb = (Poblacion) poblacionQuery.getSingleResult();
	
			alumno.setPoblacion(pb);
			
			//Consulta para sacar el curso del alumno
			Query queryCurso = session.createQuery("FROM Curso WHERE nombreCurso = :nombreCurso");
			queryCurso.setParameter("nombreCurso", nombreCurso);
			Curso curso = (Curso) queryCurso.getSingleResult();
			
			alumno.setCurso(curso);
			
		
			
			session.saveOrUpdate(alumno);
			session.getTransaction().commit();
			
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
		
	
	 /**
	  * Metodo para listar alumnos dependiendo del curso elegido
	  * @param sessionFactory
	  * @param nombreCurso
	  * @return
	  * @throws InterruptedException
	  */
	
	 public ArrayList<Alumno> listarAlumnos (SessionFactory sessionFactory, String nombreCurso) throws InterruptedException {
	        
		 Session session = null;
		 
		 ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		 
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				//Dependiento de la eleccion del usuario en el combobox de cursos, el jlist listar?? unos valores de alumnos u otros
				if(!nombreCurso.equals("")){
					
					//Consulta para sacar todos los cursos
					Query cursoQuery = session.createQuery("FROM Curso WHERE nombreCurso =:nombreCurso ");
					cursoQuery.setParameter("nombreCurso", nombreCurso);
					Curso curso = (Curso) cursoQuery.getSingleResult();
					
					//Consulta para listar los alumnos dependiendo del curso que el usuario haya elegido, en caso de que haya elegido alguno
					Query alumnoQuery = sessionFactory.getCurrentSession().createQuery("FROM Alumno WHERE curso =:curso ORDER BY nombreCompleto ASC");
					alumnoQuery.setParameter("curso", curso);
					
					listaAlumnos = (ArrayList<Alumno>) alumnoQuery.list();
					
				}else {
					
					//Consulta para sacar todos los alumnos ordenados por orden alfabetico
					Query alumnoQuery2 = sessionFactory.getCurrentSession().createQuery("FROM Alumno ORDER BY nombreCompleto ASC");
					
					listaAlumnos = (ArrayList<Alumno>) alumnoQuery2.list();
				}
		
						
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
			
			return listaAlumnos;	
			
	 }
	
	 
	 /**
	  * Metodo para actualizar un alumno
	  * @param sessionFactory
	  * @param nif
	  * @param nombreCompleto
	  * @param telefono
	  * @param correo
	  * @param fechaNacimiento
	  * @param codigoPostal
	  * @param nombreCurso
	  * @throws HibernateException
	  */
	 public void actualizarAlumno (SessionFactory sessionFactory, String nif, String nombreCompleto, int telefono, String correo, Date fechaNacimiento, int codigoPostal, String nombreCurso) throws HibernateException {
		 
		 Session session=null;

		 try {
			 
			//Crear sesion e iniciar transaccion
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			 
			Query query = session.createQuery("FROM Alumno WHERE nif = :nif");
			query.setParameter("nif", nif);
			Alumno alumno = (Alumno) query.getSingleResult();
			 
			alumno.setNif(nif);
			alumno.setNombreCompleto(nombreCompleto);
			alumno.setTelefono(telefono);
			alumno.setCorreo(correo);
			alumno.setFechaNacimiento(fechaNacimiento);
			
			
			//Consulta poblacion
			Query poblacionQuery = session.createQuery("FROM Poblacion WHERE codigoPostal =:codigoPostal");
			poblacionQuery.setParameter("codigoPostal", codigoPostal);
			Poblacion pb = (Poblacion) poblacionQuery.getSingleResult();
	
			alumno.setPoblacion(pb);
			
			//Consulta curso
			Query queryCurso = session.createQuery("FROM Curso WHERE nombreCurso = :nombreCurso");
			queryCurso.setParameter("nombreCurso", nombreCurso);
			Curso curso = (Curso) queryCurso.getSingleResult();
			
			alumno.setCurso(curso);
			
			
			session.update(alumno);
			session.getTransaction().commit();

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
	 
	 
	 public void eliminarAlumno (SessionFactory sessionFactory, String nif,  ArrayList<Anexar>listaAnexar) throws HibernateException {
		 
		 Session session = null;
		 boolean anexado = false;
		 
		 try {
			 
			//Crear sesion e iniciar transaccion
			 session = sessionFactory.getCurrentSession();
			 session.beginTransaction();
			 
			 for (int i = 0; i < listaAnexar.size(); i++) {
				if(listaAnexar.get(i).getAlumno().getNif().equals(nif)) {
					
					 
					//ELIMINA EL ANEXO
					int idAnexado =  listaAnexar.get(i).getIdAnexado();
					
					//Consulta para recoger el anexo al que el alumno est?? (Foreing Key)
					Query queryAnex = session.createQuery("FROM Anexar WHERE idAnexado = :idAnexado");
					queryAnex.setParameter("idAnexado", idAnexado);
					Anexar anex = (Anexar) queryAnex.getSingleResult();
						 
					session.delete(anex);
					
					anexado = true;
				}
				
			}
			 
			//ELIMINA EL ALUMNO
			Query queryAlumno = session.createQuery("FROM Alumno WHERE nif = :nif");
			queryAlumno.setParameter("nif", nif);
			Alumno alumno = (Alumno) queryAlumno.getSingleResult();
				 
			session.delete(alumno);
			
			session.getTransaction().commit();
			 
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
	 
	 /**
	  * Metodo para crear e insertar una nueva empresa en la base de datos
	  * @param sessionFactory
	  * @param cifEmpresa
	  * @param nombreEmpresa
	  * @param direccionEmpresa
	  * @param telefono1
	  * @param telefono2
	  * @param emailEmpresa
	  * @param faxEmpresa
	  * @param paginaWeb
	  * @param nombreGerente
	  * @param dniGerente
	  * @param personaContacto
	  * @param dniPersonaContacto
	  * @param fechaActualizacion
	  * @param organismoPublico
	  * @param observaciones
	  * @param poblacion
	  * @throws HibernateException
	  */
	 public void crearEmpresas (SessionFactory sessionFactory, String cifEmpresa, String nombreEmpresa, String direccionEmpresa, int telefono1, int telefono2, 
			 String emailEmpresa, String faxEmpresa, String paginaWeb, String nombreGerente, String dniGerente, 
			 String personaContacto, String dniPersonaContacto, Date fechaActualizacion, boolean organismoPublico,String observaciones, String poblacion) throws HibernateException {
		 
		 Session session = null;
			
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Empresa empresa = new Empresa();
				empresa.setCifEmpresa(cifEmpresa);
				empresa.setNombreEmpresa(nombreEmpresa);
				empresa.setDireccionEmpresa(direccionEmpresa);
				empresa.setTelefono1(telefono1);
				empresa.setTelefono2(telefono2);
				empresa.setEmailEmpresa(emailEmpresa);
				empresa.setFaxEmpresa(faxEmpresa);
				empresa.setPaginaWeb(paginaWeb);
				empresa.setNombreGerente(nombreGerente);
				empresa.setDniGerente(dniGerente);
				empresa.setPersonaContacto(personaContacto);
				empresa.setDniPersonaContacto(dniPersonaContacto);
		        empresa.setFechaActualizacion(fechaActualizacion); 
		        
				empresa.setOrganismoPublico(organismoPublico);
				empresa.setObservaciones(observaciones);
				
				//Consulta para recoger la poblacion
				Query poblacionQuery = session.createQuery("FROM Poblacion WHERE nombre =:nombre");
				poblacionQuery.setParameter("nombre", poblacion);
				Poblacion pb = (Poblacion) poblacionQuery.getSingleResult();
		
				empresa.setPoblacion(pb);
				
				
				session.saveOrUpdate(empresa);
				session.getTransaction().commit();
				
				
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
	 	
	 
	/**
	 * Metodo para listar empresas sin filtro 
	 * @param sessionFactory
	 * @return
	 */
	 public ArrayList<Empresa> listaEmpresas (SessionFactory sessionFactory) {
		
		 Session session = null;
		 
		 ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();
		 
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query queryEmpresa = session.createQuery("FROM Empresa ORDER BY nombreEmpresa");
				listaEmpresa = (ArrayList<Empresa>) queryEmpresa.list();
		 
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
		
		 
		 return listaEmpresa; 
	 }
	 
	 
	 /**
	  * Metodo para listar empresas con filtro
	  * @param sessionFactory
	  * @param nombreEmpresa
	  * @return
	  */
	 
	 public ArrayList<Empresa> listaEmpresasFiltro (SessionFactory sessionFactory, String nombreEmpresa) {
		
		 Session session = null;
		 
		 ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();
		 
			try {
				
				//Crear sesion e iniciar transaccion
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				//Consulta para listar las empresas ordenadas por orden alfabetico
				Query queryEmpresa = session.createQuery("FROM Empresa WHERE nombreEmpresa LIKE :nombreEmpresa ORDER BY nombreEmpresa");
				queryEmpresa.setParameter("nombreEmpresa", "%" + nombreEmpresa + "%");
		 
				listaEmpresa = (ArrayList<Empresa>) queryEmpresa.list();
				
				
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
		 
		 return listaEmpresa; 
	 }
	 
	 
	 
	 
	 public void actualizarEmpresa (SessionFactory sessionFactory, String cifEmpresa, String nombreEmpresa, String direccionEmpresa, int telefono1, int telefono2, 
			 String emailEmpresa, String faxEmpresa, String paginaWeb, String nombreGerente, String dniGerente, 
			 String personaContacto, String dniPersonaContacto, Date fechaActualizacion, boolean organismoPublico,String observaciones, int codigoPostal) throws HibernateException {
		 
		 Session session = null;

		 try {
			//Crear sesion e iniciar transaccion
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
			query.setParameter("cifEmpresa", cifEmpresa);
			Empresa empresa = (Empresa) query.getSingleResult();
			
			empresa.setCifEmpresa(cifEmpresa);
			empresa.setNombreEmpresa(nombreEmpresa);
			empresa.setDireccionEmpresa(direccionEmpresa);
			empresa.setTelefono1(telefono1);
			empresa.setTelefono2(telefono2);
			empresa.setEmailEmpresa(emailEmpresa);
			empresa.setFaxEmpresa(faxEmpresa);
			empresa.setPaginaWeb(paginaWeb);
			empresa.setNombreGerente(nombreGerente);
			empresa.setDniGerente(dniGerente);
			empresa.setPersonaContacto(personaContacto);
			empresa.setDniPersonaContacto(dniPersonaContacto);
	        empresa.setFechaActualizacion(fechaActualizacion); 
	        
			empresa.setOrganismoPublico(organismoPublico);
			empresa.setObservaciones(observaciones);
			
			//Consulta poblacion de la empresa
			Query poblacionQuery = sessionFactory.getCurrentSession().createQuery("FROM Poblacion WHERE codigoPostal =:codigoPostal");
			poblacionQuery.setParameter("codigoPostal", codigoPostal);
			Poblacion pb = (Poblacion) poblacionQuery.getSingleResult();
	
			empresa.setPoblacion(pb);
			
			
			session.saveOrUpdate(empresa);
			session.getTransaction().commit();
			
			
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
	
	 
	 public void eliminarEmpresa (SessionFactory sessionFactory, String cifEmpresa) throws HibernateException {
		 
		 Session session = null;
		 
		 try {
			 
			//Crear sesion e iniciar transaccion
			 session = sessionFactory.getCurrentSession();
			 session.beginTransaction();
			 
			 //Consulta para recoger la empresa cuyo id sea el mismo al pasado por parametro
			 Query queryEmpresa = session.createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
			 queryEmpresa.setParameter("cifEmpresa", cifEmpresa);
			 Empresa empresa = (Empresa) queryEmpresa.getSingleResult();
			
			 //Consulta para recoger el convenio al que este asignado la empresa para eliminarlo
			 Query queryConvenio = session.createQuery("FROM Convenio WHERE empresa = :empresa");
			 queryConvenio.setParameter("empresa", empresa);
			 ArrayList <Convenio> listaConvenios = (ArrayList<Convenio>) queryConvenio.list();
			 
			 
			 for (int i = 0; i < listaConvenios.size(); i++) {
				 session.delete(listaConvenios.get(i));
			 }
			
			 session.delete(empresa);
			 session.getTransaction().commit();
			 
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
	 
	
	 /**
	  * Metodo para crear e insertar un convenio con una empresa (Puede ser "FCT" o "PFE")
	  * @param sessionFactory
	  * @param cifEmpresa
	  * @param nombreCurso
	  * @param tipoConvenio
	  * @throws HibernateException
	  */
	 
	 public void crearConvenio (SessionFactory sessionFactory, String cifEmpresa, String nombreCurso, String tipoConvenio, boolean organismoPublico, Date fechaAnexo, JLabel lblError2Convenio) throws HibernateException {
		 
		 Session session = null;

		 	try {
		 		
		 		//Crear sesion e iniciar transaccion
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				
				
				//VARIABLES
				String test;
				String idConvenio = "";
	    		
		
				//QUERY CURSO
				Query queryCurso = session.createQuery("FROM Curso WHERE nombreCurso = :nombreCurso");
				queryCurso.setParameter("nombreCurso", nombreCurso);
				Curso curso = (Curso) queryCurso.getSingleResult();
				
				//QUERY PARA FILTRAR POR TIPO DE CONVENIO
				Query filtrarPorTipoConvenio = session.createQuery("FROM Convenio WHERE tipoConvenio = :tipoConvenio");
				filtrarPorTipoConvenio.setParameter("tipoConvenio", tipoConvenio);
				ArrayList <Convenio> listaConvenios = (ArrayList<Convenio>) filtrarPorTipoConvenio.list();
				
				
				/*
				 * INSERTAR EL PRIMER CONVENIO
				 */
						//Si no hay ningun convenio creado, se crear?? con el numero 1
						if(listaConvenios.isEmpty()) {
							
							//Curso seleccionado es publico
							if(curso.isEsPublico() == true) {
								test = "MOR/";
								
								if(organismoPublico == true) {
									
									//Formateamos para sacar el numero con 3 digitos
									Formatter obj = new Formatter();
							        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", 1));
							        
							        //Tomamos el a??o actual del ordenador
							        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); 
							        String a??o = a??oAux.substring(2);
							        
							        //Formamos el codigo del convenio
									idConvenio = test + "A" +  numeroCompletoConvenio + "/" + a??o;
									
								}else {
									//Formateamos para sacar el numero con 3 digitos
									Formatter obj = new Formatter();
							        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", 1));
									
							        //Tomamos el a??o actual del ordenador
							        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));    
							        String a??o = a??oAux.substring(2);		
							        
							      //Formamos el codigo del convenio
									idConvenio = test + "C" +  numeroCompletoConvenio + "/" + a??o;
								}
								
						//Curso seleccionado es privado
							}else {
								test = "MOR/PRIV/";
							
								if(organismoPublico == true) {
									
									//Formateamos para sacar el numero con 3 digitos
									Formatter obj = new Formatter();
							        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", 1));
									
							      //Tomamos el a??o actual del ordenador
							        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); 
							        String a??o = a??oAux.substring(2);	
							        
							      //Formamos el codigo del convenio
									idConvenio = test + "A" +  numeroCompletoConvenio + "/" + a??o;
									
								}else {
									
									//Formateamos para sacar el numero con 3 digitos
									Formatter obj = new Formatter();
							        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", 1));
									
							        //Tomamos el a??o actual del ordenador
							        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); 							        
							        String a??o = a??oAux.substring(2);	
							        
							        //Formamos el codigo del convenio
									idConvenio = test + "C" +  numeroCompletoConvenio + "/" + a??o;
								}
								
							}
							

							//CREAR CONVENIO
							Convenio convenio = new Convenio();
							convenio.setIdConvenio(idConvenio);
							
							//Consulta para recoger la empresa que ha sido seleccionada a partir del CIF
							Query empresaQuery = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
							empresaQuery.setParameter("cifEmpresa", cifEmpresa);
							Empresa empresa = (Empresa) empresaQuery.getSingleResult();
							
							convenio.setEmpresa(empresa);
							convenio.setFechaAnexo(fechaAnexo);
							convenio.setTipoConvenio(tipoConvenio);
							
							session.save(convenio);
							session.getTransaction().commit();	
							
						} else {
				//----------------------------------------------------------------		
				
				//Diferenciamos entre codigos de convenio publicos y privados
				// para que, a la hora de generar el codigo, se tomen diferentes substrings
				ArrayList<Integer> numeroCodigoConvenio = new ArrayList<>();
				ArrayList<Convenio> listaConveniosPublicos = new ArrayList<Convenio>();
				ArrayList<Convenio> listaConveniosPrivados = new ArrayList<Convenio>();
				
					//Consulta para recoger la lista de convenios, cuyo tipo de convenio sea el pasado por parametro y sea publico
					Query conveniosPublicos = session.createQuery("FROM Convenio WHERE tipoConvenio = :tipoConvenio AND idConvenio NOT LIKE :id");
					conveniosPublicos.setParameter("tipoConvenio", tipoConvenio);
					conveniosPublicos.setParameter("id",  "%" + "PRIV" + "%");
					listaConveniosPublicos = (ArrayList<Convenio>) conveniosPublicos.getResultList();
					
					//Recogemos la lista de convenios publicos y hacemos un substring para sacar los numeros
					for (int i = 0; i < listaConveniosPublicos.size(); i++) {
						numeroCodigoConvenio.add(Integer.parseInt(listaConveniosPublicos.get(i).getIdConvenio().substring(5, 8)));
					}
					
					//Consulta para recoger la lista de convenios, cuyo tipo de convenio sea el pasado por parametro y sea privado
					Query conveniosPrivados = session.createQuery("FROM Convenio WHERE tipoConvenio = :tipoConvenio AND idConvenio LIKE :id");
					conveniosPrivados.setParameter("tipoConvenio", tipoConvenio);
					conveniosPrivados.setParameter("id",  "%" + "PRIV" + "%");
					listaConveniosPrivados = (ArrayList<Convenio>) conveniosPrivados.list();
					
					//Recogemos la lista de convenios privados y hacemos un substring para sacar los numeros
					for (int i = 0; i < listaConveniosPrivados.size(); i++) {
						numeroCodigoConvenio.add(Integer.parseInt(listaConveniosPrivados.get(i).getIdConvenio().substring(10, 13)));
					}	
					
				
				//Ordenamos las dos listas de los codigos de los convenios (publicos y privados) de mayor a menor
				Comparator<Integer> comparador = Collections.reverseOrder();
				Collections.sort(numeroCodigoConvenio, comparador);

				//--------------------------------------------------------------
				
				//El curso seleccionado es publico
				if(curso.isEsPublico() == true) {
					test = "MOR/";
					
					if(organismoPublico == true) {
						
						//Formateamos para sacar el numero con 3 digitos
						Formatter obj = new Formatter();
				        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", numeroCodigoConvenio.get(0) + 1));
						
				        //Tomamos el a??o actual del ordenador
				        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));         
				        String a??o = a??oAux.substring(2);
				        
				        //Formamos el codigo del convenio
						idConvenio = test + "A" +  numeroCompletoConvenio + "/" + a??o;
				
					}else {
						
						//Formateamos para sacar el numero con 3 digitos
						Formatter obj = new Formatter();
				        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", numeroCodigoConvenio.get(0) + 1));
						
				        //Tomamos el a??o actual del ordenador
				        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));   
				        String a??o = a??oAux.substring(2);
				        //Formamos el codigo del convenio
						idConvenio = test + "C" +  numeroCompletoConvenio + "/" + a??o;
					}
					
					
				}else {
					test = "MOR/PRIV/";
				
					if(organismoPublico == true) {
						
						//Formateamos para sacar el numero con 3 digitos
						Formatter obj = new Formatter();
				        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", numeroCodigoConvenio.get(0) + 1));

				        //Tomamos el a??o actual del ordenador
				        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));         
				        String a??o = a??oAux.substring(2);
				        
				        //Formamos el codigo del convenio
						idConvenio = test + "A" +  numeroCompletoConvenio + "/" + a??o;
						
					}else {
						
						//Formateamos para sacar el numero con 3 digitos
						Formatter obj = new Formatter();
				        String numeroCompletoConvenio = String.valueOf(obj.format("%03d", numeroCodigoConvenio.get(0) + 1));
						
				        //Tomamos el a??o actual del ordenador
				        String a??oAux = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); 	        
				        String a??o = a??oAux.substring(2);
				        
				        //Formamos el codigo del convenio
						idConvenio = test + "C" +  numeroCompletoConvenio + "/" + a??o;
					}
					
				}
				
				
				//CREAR CONVENIO
				Convenio convenio = new Convenio();
				convenio.setIdConvenio(idConvenio);
				
				//Consulta para recoger la empresa a la que pertenece el convenio
				Query empresaQuery = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
				empresaQuery.setParameter("cifEmpresa", cifEmpresa);
				Empresa empresa = (Empresa) empresaQuery.getSingleResult();
				
				convenio.setEmpresa(empresa);
				convenio.setFechaAnexo(fechaAnexo);
				convenio.setTipoConvenio(tipoConvenio);
				
				if(test.equals("MOR/PRIV/")) {
					
				
					//COMPROBAR QUE COMO MAXIMO SOLO HAY 2 CONVENIOS PRIVADOS POR EMPRESA
					BigInteger auxComprobacion;
					Query queryComprobacion = session.createSQLQuery("SELECT COUNT(*) FROM CONVENIO WHERE CIF_EMPRESA = :cifEmpresa AND TIPO_CONVENIO = :tipoConvenio AND ID_CONVENIO LIKE :id");
					queryComprobacion.setParameter("cifEmpresa", cifEmpresa);
					queryComprobacion.setParameter("tipoConvenio", tipoConvenio);
					queryComprobacion.setParameter("id",  "%" + "PRIV" + "%");
	
					auxComprobacion = (BigInteger) queryComprobacion.getSingleResult();
					
					
			 		//Convertir Big Integer a Int
			 		String auxComprobacionParset = String.valueOf(auxComprobacion);
			 		int auxComprobacionN = Integer.parseInt(auxComprobacionParset);
								 		
			 		
			 		if(auxComprobacionN < 1) {
			 			
						session.save(convenio);
						session.getTransaction().commit();	
			 			
			 		}else {
			 			
			 			lblError2Convenio.setText("ERROR. SOLO PUEDE TENER 2 CONVENIOS MAXIMOS POR TIPO");
			 			
			 		}
		 		
				}if(test.equals("MOR/")) {
					
					//COMPROBAR QUE COMO MAXIMO SOLO HAY 2 CONVENIOS PUBLICOS POR EMPRESA
					BigInteger auxComprobacion;
					Query queryComprobacion = session.createSQLQuery("SELECT COUNT(*) FROM CONVENIO WHERE CIF_EMPRESA = :cifEmpresa AND TIPO_CONVENIO = :tipoConvenio AND ID_CONVENIO NOT LIKE :id");
					queryComprobacion.setParameter("cifEmpresa", cifEmpresa);
					queryComprobacion.setParameter("tipoConvenio", tipoConvenio);
					queryComprobacion.setParameter("id",  "%" + "PRIV" + "%");
	
					auxComprobacion = (BigInteger) queryComprobacion.getSingleResult();
					
					
			 		//Convertir Big Integer a Int
			 		String auxComprobacionParset = String.valueOf(auxComprobacion);
			 		int auxComprobacionN = Integer.parseInt(auxComprobacionParset);
					
			 		
			 		if(auxComprobacionN < 1) {
			 	
						session.save(convenio);
						session.getTransaction().commit();	
			 		} else {
			 			
			 			lblError2Convenio.setText("ERROR. SOLO PUEDE TENER 2 CONVENIOS MAXIMOs POR TIPO");
			 			
			 		}
					
				}
				
			}
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
	 
	 
	 public void actualizarConvenio (SessionFactory sessionFactory, String id, String tipoConvenio, Date fechaAnexo, String cifEmpresa) throws HibernateException {
		 
		 
		 Session session = null;

		 try {
			//Crear sesion e iniciar transaccion
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query queryEmpresa = session.createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
			queryEmpresa.setParameter("cifEmpresa", cifEmpresa);
			Empresa empresa = (Empresa) queryEmpresa.getSingleResult();
			
			Query queryConvenio = session.createQuery("FROM Convenio WHERE idConvenio = :id AND empresa = :empresa AND tipoConvenio = :tipoConvenio");
			queryConvenio.setParameter("id", id);
			queryConvenio.setParameter("empresa", empresa);
			queryConvenio.setParameter("tipoConvenio", tipoConvenio);
			Convenio convenio = (Convenio) queryConvenio.getSingleResult();
			
			//----------------------------------------------------------------		
			
			ArrayList<Integer> numeroCodigoConvenio = new ArrayList<>();
			ArrayList<Convenio> listaConveniosPublicos = new ArrayList<Convenio>();
			ArrayList<Convenio> listaConveniosPrivados = new ArrayList<Convenio>();
			

			
				Query conveniosPublicos = session.createQuery("FROM Convenio WHERE tipoConvenio = :tipoConvenio AND idConvenio NOT LIKE :id");
				conveniosPublicos.setParameter("tipoConvenio", tipoConvenio);
				conveniosPublicos.setParameter("id",  "%" + "PRIV" + "%");
				listaConveniosPublicos = (ArrayList<Convenio>) conveniosPublicos.getResultList();
				
				for (int i = 0; i < listaConveniosPublicos.size(); i++) {
					numeroCodigoConvenio.add(Integer.parseInt(listaConveniosPublicos.get(i).getIdConvenio().substring(5, 8)));
				}
				
				
				Query conveniosPrivados = session.createQuery("FROM Convenio WHERE tipoConvenio = :tipoConvenio AND idConvenio LIKE :id");
				conveniosPrivados.setParameter("tipoConvenio", tipoConvenio);
				conveniosPrivados.setParameter("id",  "%" + "PRIV" + "%");
				listaConveniosPrivados = (ArrayList<Convenio>) conveniosPrivados.list();
				
				for (int i = 0; i < listaConveniosPrivados.size(); i++) {
					numeroCodigoConvenio.add(Integer.parseInt(listaConveniosPrivados.get(i).getIdConvenio().substring(10, 13)));
				}	
				
			
			
			Comparator<Integer> comparador = Collections.reverseOrder();
			Collections.sort(numeroCodigoConvenio, comparador);
				
			
			//NUEVO ID
			String nuevoIdConvenio;
			
			if (!id.contains("PRIV")) {				

				Formatter obj = new Formatter();
		        String numeroCeros = String.valueOf(obj.format("%03d",numeroCodigoConvenio.get(0) + 1));
				
		        nuevoIdConvenio = id.replace(id.substring(5, 8), numeroCeros);

			}else {
				
				Formatter obj = new Formatter();
		        String numeroCeros = String.valueOf(obj.format("%03d", numeroCodigoConvenio.get(0) + 1));
				
		        nuevoIdConvenio = id.replace(id.substring(10, 13), numeroCeros);
				
			}
			
			
			convenio.setIdConvenio(nuevoIdConvenio);
			convenio.setEmpresa(empresa);
			convenio.setFechaAnexo(fechaAnexo);
			convenio.setTipoConvenio(tipoConvenio);
    		
			session.save(convenio);
			session.getTransaction().commit();	
			
		}  catch (Exception e) {
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
	 
	 /**
	  * Metodo para ver los Convenios de una empresa
	  * @param sessionFactory
	  * @param cifEmpresa
	  * @throws HibernateException
	  */
	 
	 public ArrayList<Convenio> listarConveniosCIFEmpresa (SessionFactory sessionFactory, String cifEmpresa) throws HibernateException {
		 
		 Session session = null;

		 ArrayList<Convenio> listaConvenios = new ArrayList<Convenio>();
		 
		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query empresaQuery = session.createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
				empresaQuery.setParameter("cifEmpresa", cifEmpresa);
				Empresa empresa = (Empresa) empresaQuery.getSingleResult();
				
				Query convenioQuery = session.createQuery("FROM Convenio WHERE empresa = :empresa");
				convenioQuery.setParameter("empresa", empresa);
				
				listaConvenios = (ArrayList<Convenio>) convenioQuery.list();
				
				
				
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
			return listaConvenios;
		 
		 
	 }
	 
	 public ArrayList<Convenio> listarConvenios (SessionFactory sessionFactory) throws HibernateException {
		 
		 Session session = null;

		 ArrayList<Convenio> listaConvenios = new ArrayList<Convenio>();
		 
		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query convenioQuery = session.createQuery("FROM Convenio");
		
				listaConvenios = (ArrayList<Convenio>) convenioQuery.list();
				
				
				
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
			return listaConvenios;
		 
		 
	 }
	 
	public ArrayList<Convenio> listarConveniosTipoConvenio (SessionFactory sessionFactory,String tipoConvenio) throws HibernateException {
		 
		 Session session = null;
	
		 ArrayList<Convenio> listaConvenios = new ArrayList<Convenio>();
		 
		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query convenioQuery = session.createQuery("FROM Convenio WHERE tipoConvenio = :tipoConvenio");
				convenioQuery.setParameter("tipoConvenio", tipoConvenio);
				listaConvenios = (ArrayList<Convenio>) convenioQuery.list();
				
				
				
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
			return listaConvenios;
		 
		 
	}

	 public void crearPeriodoPracticas (SessionFactory sessionFactory, String tipoPractica, Date fechaInicio, Date fechaFin, String nombreCurso, String nombreProfesor) throws HibernateException {
		 
		 Session session = null;

		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Practica practica = new Practica();
				practica.setTipoPractica(tipoPractica);
				practica.setFechaInicio(fechaInicio);
				practica.setFechaFin(fechaFin);
				
				//Query Curso
				Query queryCurso = session.createQuery("FROM Curso WHERE nombreCurso = :nombreCurso");
				queryCurso.setParameter("nombreCurso", nombreCurso);
				Curso curso = (Curso) queryCurso.getSingleResult();
				
				practica.setCurso(curso);
				
				//Query Profesor
				Query queryProfesor = session.createQuery("FROM Profesor WHERE nombre = :nombreProfesor");
				queryProfesor.setParameter("nombreProfesor", nombreProfesor);
				Profesor profesor = (Profesor) queryProfesor.getSingleResult();
					
				practica.setProfesor(profesor);
				
				session.saveOrUpdate(practica);
				session.getTransaction().commit();
				
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

	 // LISTA DE LOS PERIODOS
	public ArrayList<Practica> listarPeriodoPracticas (SessionFactory sessionFactory) throws HibernateException {
		
		 Session session = null;

		 ArrayList<Practica> listaPracticas = new ArrayList<Practica>();
		 
		 try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			 
			Query query = session.createQuery("FROM Practica");
			listaPracticas = (ArrayList<Practica>) query.list();
			
			
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
		 
		 
		 return listaPracticas;
	}
	
	/*
	 * 
	 */
	public void eliminarPeriodoPractica (SessionFactory sessionFactory, int idPractica, ArrayList<Anexar>listaAnexar) throws HibernateException{
		
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//ELIMINAMOS ANEXAR
			for (int i = 0; i < listaAnexar.size(); i++) {
				if(listaAnexar.get(i).getPractica().getIdPractica() == idPractica) {
					
					//ELIMINA EL ANEXO
					int idAnexado =  listaAnexar.get(i).getIdAnexado();
					Query queryAnex = session.createQuery("FROM Anexar WHERE idAnexado = :idAnexado");
					queryAnex.setParameter("idAnexado", idAnexado);
					Anexar anex = (Anexar) queryAnex.getSingleResult();
						 
					session.delete(anex);
				}
				
			}
			
			//ELIMINAMOS EL PERIODO
			Query query = session.createQuery("FROM Practica WHERE idPractica = :idPractica");
			query.setParameter("idPractica", idPractica);
			Practica practica = (Practica) query.getSingleResult();
			
			session.delete(practica);
			session.getTransaction().commit();
			
		}catch (Exception e) {
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
	// CREAR ANEXAR
	public void crearAnexar (SessionFactory sessionFactory, Practica practica, Convenio convenio, Alumno alumno, ArrayList <Anexar> listaAnexar) throws HibernateException {
		 	boolean mismo = false;
		 	try {
		 		sessionFactory.getCurrentSession().beginTransaction();
				
				//COMPRUEBO SI EXISTE EL ALUMNO ANEXADO A MAS DE UNA EMPRESA
					for (int i = 0; i < listaAnexar.size(); i++) {
						if(listaAnexar.get(i).getPractica().getIdPractica() == practica.getIdPractica() && listaAnexar.get(i).getAlumno().getNif().equals(alumno.getNif())) {
							mismo = true;
						}
					}
					
					if(mismo == false) {
						Anexar anexar = new Anexar();
						anexar.setPractica(practica);
						anexar.setConvenio(convenio);
						anexar.setAlumno(alumno);
						
						sessionFactory.getCurrentSession().save(anexar);
						sessionFactory.getCurrentSession().getTransaction().commit();
					}
				
				
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(null != sessionFactory.getCurrentSession()) {
				sessionFactory.getCurrentSession().getTransaction().rollback();
			}
		}finally {
			if(null != sessionFactory.getCurrentSession()) {
				sessionFactory.getCurrentSession().close();
			}
		}
		 		 
	 } 
	 
	// LISTAR ANEXAR
	public ArrayList<Anexar> listarAnexarsPracticas (SessionFactory sessionFactory) throws HibernateException {
		
		 Session session = null;

		 ArrayList<Anexar> listaAnexar = new ArrayList<Anexar>();
		 
		 try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Anexar");
			listaAnexar = (ArrayList<Anexar>) query.list();
			
			
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
		 
		 
		 return listaAnexar;
	}
	
	//ELIMIANR ANEXAR
    public void eliminarAnexar (SessionFactory sessionFactory, int idAnexado) {
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Anexar WHERE idAnexado = :idAnexado");
            query.setParameter("idAnexado", idAnexado);
            Anexar anex = (Anexar) query.getSingleResult();
            
            session.delete(anex);
            session.getTransaction().commit();

        }catch (Exception e) {
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
	
    //LISTAR DATOS EFA
    public DatosEfa listarDatosEfa (SessionFactory sessionFactory) throws HibernateException {
		
		 Session session = null;

		 DatosEfa datosEfa = new DatosEfa();
		 
		 try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM DatosEfa WHERE nombre = :nombre");
			query.setParameter("nombre", "EFA MORATALAZ");
			datosEfa = (DatosEfa) query.getSingleResult();
			
			
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
		 
		 
		 return datosEfa;
	}
    
    public ArrayList<Anexar> rellenarAnexo1 (SessionFactory sessionFactory, int idConvenioAI) {
    	
    	 ArrayList <Anexar> listaAnexos = null;
    	 Session session = null;
    	
    	try {
			
    		session = sessionFactory.getCurrentSession();
			session.beginTransaction();
    		
			Query queryConvenio = sessionFactory.getCurrentSession().createQuery("FROM Convenio WHERE id = :idConvenioAI");
			queryConvenio.setParameter("idConvenioAI", idConvenioAI);
    		Convenio convenio = (Convenio) queryConvenio.getSingleResult();
			
			
			Query queryAnexar = sessionFactory.getCurrentSession().createQuery("FROM Anexar WHERE convenio = :convenio");
			queryAnexar.setParameter("convenio", convenio);
    		listaAnexos = (ArrayList) queryAnexar.list();
    	
    		for (int i = 0; i < listaAnexos.size(); i++) {
				System.out.println(listaAnexos.get(i));
			}
    		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(null != session) {
				session.close();
			}
		}
		return listaAnexos;
    	
    }
}