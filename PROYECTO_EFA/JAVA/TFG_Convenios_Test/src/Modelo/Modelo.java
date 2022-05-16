package Modelo;

import java.util.Date;
import java.util.Iterator;
import java.awt.Color;
import java.math.BigInteger;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.Query;
import org.hibernate.type.CurrencyType;

import persistencia.Alumno;
import persistencia.Convenio;
import persistencia.Curso;
import persistencia.Empresa;
import persistencia.Poblacion;



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
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
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

	public void rellenarComboBoxCursos (SessionFactory sessionFactory, JComboBox<String> comboBox) {
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Curso");
			ArrayList<Curso> listaCursos = (ArrayList<Curso>) query.list();
			
				comboBox.addItem("");
			for(int i=0;i<listaCursos.size();i++) {
				comboBox.addItem(listaCursos.get(i).getNombreCurso().toString());
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
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
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

	
	 public void rellenarComboBoxNombreCiudad (SessionFactory sessionFactory, JComboBox comboPoblacionNombre) {
			Session session = null;
			
			try {
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				/**
				 * Consulta para obtener los nombres de las poblaciones
				 */	
				Query query = sessionFactory.getCurrentSession().createQuery("FROM Poblacion GROUP BY Nombre ORDER BY Nombre ASC");
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
	
	 
	 public void rellenarComboBoxCodigoPostal (SessionFactory sessionFactory,JComboBox comboPoblacionNombre, JComboBox comboPoblacionCP) {
			
			Session session = null; 
			
			try {
				
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				comboPoblacionCP.removeAllItems();
				
				/**
				 * Consulta para obtener los codigos postales de la ciudad seleccionada en el combobox anterior.
				 */
				Query query = sessionFactory.getCurrentSession().createQuery("FROM Poblacion WHERE nombre = :nombre");
				query.setParameter("nombre", comboPoblacionNombre.getSelectedItem().toString());
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
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Alumno alumno = new Alumno();
			alumno.setNif(nif);
			alumno.setNombreCompleto(nombreCompleto);
			alumno.setTelefono(telefono);
			alumno.setCorreo(correo);
			alumno.setFechaNacimiento(fechaNacimiento);
			
			Query poblacionQuery = sessionFactory.getCurrentSession().createQuery("FROM Poblacion WHERE codigoPostal =:codigoPostal");
			poblacionQuery.setParameter("codigoPostal", codigoPostal);
			Poblacion pb = (Poblacion) poblacionQuery.getSingleResult();
	
			alumno.setPoblacion(pb);
			
			
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
		
	
	
	 public ArrayList<Alumno> listarAlumnos (SessionFactory sessionFactory, String nombreCurso) throws InterruptedException {
	        
		 Session session = null;
		 
		 ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
			try {
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
		 
				Query cursoQuery = sessionFactory.getCurrentSession().createQuery("FROM Curso WHERE nombreCurso =:nombreCurso");
				cursoQuery.setParameter("nombreCurso", nombreCurso);
				Curso curso = (Curso) cursoQuery.getSingleResult();

				
				Query alumnoQuery = sessionFactory.getCurrentSession().createQuery("FROM Alumno WHERE curso =:curso");
				//Query alumnoQuery = sessionFactory.getCurrentSession().createQuery("FROM Alumno WHERE curso LIKE '=:curso%'");
				alumnoQuery.setParameter("curso", curso);
				
				listaAlumnos = (ArrayList<Alumno>) alumnoQuery.list();
				
		
						
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
			
			Query poblacionQuery = sessionFactory.getCurrentSession().createQuery("FROM Poblacion WHERE codigoPostal =:codigoPostal");
			poblacionQuery.setParameter("codigoPostal", codigoPostal);
			Poblacion pb = (Poblacion) poblacionQuery.getSingleResult();
	
			alumno.setPoblacion(pb);
			
			
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
	 
	 
	 public void eliminarAlumno (SessionFactory sessionFactory, String nif) throws HibernateException {
		 
		 Session session = null;
		 
		 try {
			 session = sessionFactory.getCurrentSession();
			 session.beginTransaction();
			 
			 Query query = session.createQuery("FROM Alumno WHERE nif = :nif");
			 query.setParameter("nif", nif);
			 Alumno alumno = (Alumno) query.getSingleResult();
			 
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
			 String personaContacto, String dniPersonaContacto, Date fechaActualizacion, boolean organismoPublico,String observaciones, String poblacion) throws HibernateException{
		 
		 Session session = null;
			
			try {
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
				
				Query poblacionQuery = sessionFactory.getCurrentSession().createQuery("FROM Poblacion WHERE nombre =:nombre");
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
	 	
	 
	 public ArrayList<Empresa> listaEmpresas (SessionFactory sessionFactory) {
		
		 
		 
		 
		 
		 
		 return null; 
	 }
	 /**
	  * Metodo para crear e insertar un convenio con una empresa (Puede ser "FCT" o "PFE")
	  * @param sessionFactory
	  * @param cifEmpresa
	  * @param nombreCurso
	  * @param tipoConvenio
	  * @throws HibernateException
	  */
	 public void crearConvenio (SessionFactory sessionFactory, String cifEmpresa, String nombreCurso, String tipoConvenio, Date fechaAnexo) throws HibernateException {
		 
		 Session session = null;

		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				//MOR/PRIV/C014/22
				//MOR/C014/22
				
				String test;
				String idConvenio = "";
				
				
				BigInteger auxConveniosQuery;
	    		Query queryCantidadConvenio = session.createSQLQuery("SELECT COUNT(*) AS NUMERO_REGISTROS_CONVENIO FROM CONVENIO WHERE TIPO_CONVENIO = :tipoConvenio");
	    		queryCantidadConvenio.setParameter("tipoConvenio", tipoConvenio);
	    		auxConveniosQuery = (BigInteger) queryCantidadConvenio.getSingleResult();
	    		System.out.println(auxConveniosQuery);
	    		
	    		//Convertir Big Integer a Int
	    		String auxConvenios1 = String.valueOf(auxConveniosQuery);
	    		int auxConvenios = Integer.parseInt(auxConvenios1);
				
	    		
				Query query = sessionFactory.getCurrentSession().createQuery("FROM Curso WHERE nombreCurso =:nombreCurso");
				query.setParameter("nombreCurso", nombreCurso);
				Curso curso = (Curso) query.getSingleResult();
				
				if(curso.isEsPublico() == true) {
					test = "MOR/C";
					auxConvenios = auxConvenios + 1;
					idConvenio = test+  auxConvenios + "/22";

				}else {
					test = "MOR/PRIV/C";
					auxConvenios = auxConvenios + 1;
					idConvenio = test +  auxConvenios + "/22";
		    		
				}
				
				
				
				//CREAR CONVENIO
				Convenio convenio = new Convenio();
				convenio.setIdConvenio(idConvenio);
				
				Query empresaQuery = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
				empresaQuery.setParameter("cifEmpresa", cifEmpresa);
				Empresa empresa = (Empresa) empresaQuery.getSingleResult();
				
				convenio.setEmpresa(empresa);
				convenio.setFechaAnexo(fechaAnexo);
				convenio.setTipoConvenio(tipoConvenio);
	    		
				session.saveOrUpdate(convenio);
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
	 
	 
	 public void verConvenio (SessionFactory sessionFactory, String cifEmpresa) throws HibernateException {
		 
		 Session session = null;

		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query empresaQuery = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
				empresaQuery.setParameter("cifEmpresa", cifEmpresa);
				Empresa empresa = (Empresa) empresaQuery.getSingleResult();
				
				Query convenioQuery = sessionFactory.getCurrentSession().createQuery("FROM Convenio WHERE empresa = :empresa");
				convenioQuery.setParameter("empresa", empresa);
				
				ArrayList <Convenio> listaConvenio = (ArrayList<Convenio>) convenioQuery.list();
				
				for (int i = 0; i < listaConvenio.size(); i++) {
					System.out.println(listaConvenio.get(i).getIdConvenio() + " -> " + listaConvenio.get(i).getTipoConvenio());

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
	 
	 public static void main (String [] args) throws ParseException, InterruptedException {
		 
			SessionFactory sessionFactory = null;
			
		 
		//Solo se hace una vez, al iniciar la aplicaci�n
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
					
			Modelo helper = new Modelo();	
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaNacimientoUSU = (Date) format.parse("22/12/2002");
	        java.sql.Date fecha = new java.sql.Date(fechaNacimientoUSU.getTime());
			
	        
	      //helper.crearAlumno(sessionFactory, "12345678L", "Guillermo Romero", false, 1243567586, "guillermo@gmail.com", fechaNacimiento, 13230, "2� CFGM Carrocer�a");
         //helper.crearEmpresas(sessionFactory, "4331-PAT", "Agroviti", "Carretera de Solana", 123456789, 987654321, "agroviti@roncero.com", "987654", "agroviti.roncero.com", "Pedro Roncero", "45321758K", "Jose", "Responsable Oficina", fecha, false, "Trabajo Carroceria", 13230);
         //helper.crearEmpresas(sessionFactory, "1231-FIG", "INDRA", "Ronda de Toleado", 987654321, 123456789, "indra@minsait.com", "123213", "indra.com", "Angel Sevilla", "98754321M", "Carlos", "Jefe SF", fecha, true, "Trabajo DAM", 13230);
	     /*helper.crearConvenio(sessionFactory, "1231-FIG", "2º CFGS Desarrollo de Aplicaciones Multiplataforma", "FCT", fechaNacimientoUSU);
         helper.crearConvenio(sessionFactory, "4331-PAT", "2º CFGM Carrocería", "PFE", fechaNacimientoUSU);
         helper.crearConvenio(sessionFactory, "4331-PAT", "2º CFGM Carrocería", "FCT", fechaNacimientoUSU);
	     helper.crearConvenio(sessionFactory, "1231-FIG", "2º CFGS Desarrollo de Aplicaciones Multiplataforma", "FCT", fechaNacimientoUSU);
         helper.crearConvenio(sessionFactory, "4331-PAT", "2º CFGM Carrocería", "PFE", fechaNacimientoUSU);
         helper.crearConvenio(sessionFactory, "4331-PAT", "2º CFGM Carrocería", "FCT", fechaNacimientoUSU);
	      */
	        
	        helper.verConvenio(sessionFactory, "4331-PAT");
			//ArrayList <Alumno> listaAlumnos = null;
			//helper.listarAlumnos(sessionFactory);
	 
	 
	 
	 
	 }

}
