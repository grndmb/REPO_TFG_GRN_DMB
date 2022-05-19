package Modelo;

import java.util.Date;
import java.util.Formatter;
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
			Query poblacionQuery = sessionFactory.getCurrentSession().createQuery("FROM Poblacion WHERE codigoPostal =:codigoPostal");
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
			 String personaContacto, String dniPersonaContacto, Date fechaActualizacion, boolean organismoPublico,String observaciones, String poblacion) throws HibernateException {
		 
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
	 	
	 
	/**
	 * Metodo para listar empresas sin filtro 
	 * @param sessionFactory
	 * @return
	 */
	 public ArrayList<Empresa> listaEmpresas (SessionFactory sessionFactory) {
		
		 Session session = null;
		 
		 ArrayList<Empresa> listaEmpresa = new ArrayList<Empresa>();
		 
			try {
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query queryEmpresa = sessionFactory.getCurrentSession().createQuery("FROM Empresa");
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
				session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query queryEmpresa = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE nombreEmpresa LIKE :nombreEmpresa");
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
			 String personaContacto, String dniPersonaContacto, Date fechaActualizacion, boolean organismoPublico,String observaciones, String poblacion) throws HibernateException {
		 
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
			
			//Consulta poblacion
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
	
	 
	 public void eliminarEmpresa (SessionFactory sessionFactory, String cifEmpresa) throws HibernateException {
		 
		 Session session = null;
		 
		 try {
			 session = sessionFactory.getCurrentSession();
			 session.beginTransaction();
			 
			 Query queryEmpresa = session.createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
			 queryEmpresa.setParameter("cifEmpresa", cifEmpresa);
			 Empresa empresa = (Empresa) queryEmpresa.getSingleResult();
			
			 
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
	 
	 public void crearConvenio (SessionFactory sessionFactory, String cifEmpresa, String nombreCurso, String tipoConvenio, boolean organismoPublico, Date fechaAnexo) throws HibernateException {
		 
		 Session session = null;

		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				String test;
				String idConvenio = "";
	    		
				BigInteger auxConveniosQuery;
	    		Query queryCantidadConvenio = session.createSQLQuery("SELECT COUNT(*) AS NUMERO_REGISTROS_CONVENIO FROM CONVENIO WHERE TIPO_CONVENIO = :tipoConvenio");
	    		queryCantidadConvenio.setParameter("tipoConvenio", tipoConvenio);
	    		auxConveniosQuery = (BigInteger) queryCantidadConvenio.getSingleResult();
	    		
	    		//Convertir Big Integer a Int
	    		String auxConvenios1 = String.valueOf(auxConveniosQuery);
	    		int auxConvenios = Integer.parseInt(auxConvenios1);
				
	    		
				Query queryCurso = sessionFactory.getCurrentSession().createQuery("FROM Curso WHERE nombreCurso =:nombreCurso");
				queryCurso.setParameter("nombreCurso", nombreCurso);
				Curso curso = (Curso) queryCurso.getSingleResult();
				
				
				
				if(curso.isEsPublico() == true) {
					test = "MOR/";
					
					if(organismoPublico == true) {
						auxConvenios = auxConvenios + 1;
				        Formatter obj = new Formatter();
				        String numeroCeros = String.valueOf(obj.format("%03d", auxConvenios));
				        idConvenio = test + "C"+  numeroCeros + "/22";
						
					}else {
						auxConvenios = auxConvenios + 1;
						Formatter obj = new Formatter();
				        String numeroCeros = String.valueOf(obj.format("%03d", auxConvenios));
						idConvenio = test + "A"+  numeroCeros + "/22";
					}
					
					
				}else {
					test = "MOR/PRIV/";
					
					if(organismoPublico == true) {
						auxConvenios = auxConvenios + 1;
						Formatter obj = new Formatter();
				        String numeroCeros = String.valueOf(obj.format("%03d", auxConvenios));
						idConvenio = test + "C"+  numeroCeros + "/22";
					}else {
						auxConvenios = auxConvenios + 1;
						Formatter obj = new Formatter();
				        String numeroCeros = String.valueOf(obj.format("%03d", auxConvenios));
						idConvenio = test + "A"+  numeroCeros + "/22";
					}
					
					
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
					
			 		System.out.println(test);
			 		
			 		
			 		if(auxComprobacionN < 1) {
			 			
						session.save(convenio);
						session.getTransaction().commit();	
			 			
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
					
			 		System.out.println(test);
			 		
			 		
			 		if(auxComprobacionN < 1) {
			 	
						session.save(convenio);
						session.getTransaction().commit();	
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
			
			Query queryConvenio = session.createQuery("FROM Convenio WHERE idConvenio = :id AND empresa = :empresa");
			queryConvenio.setParameter("id", id);
			queryConvenio.setParameter("empresa", empresa);
			Convenio convenio = (Convenio) queryConvenio.getSingleResult();
			
			
			BigInteger auxConveniosQuery;
    		Query queryCantidadConvenio = session.createSQLQuery("SELECT COUNT(*) AS NUMERO_REGISTROS_CONVENIO FROM CONVENIO WHERE TIPO_CONVENIO = :tipoConvenio");
    		queryCantidadConvenio.setParameter("tipoConvenio", tipoConvenio);
    		auxConveniosQuery = (BigInteger) queryCantidadConvenio.getSingleResult();
    		
    		//Convertir Big Integer a Int
    		String auxConvenios1 = String.valueOf(auxConveniosQuery);
    		int auxConvenios = Integer.parseInt(auxConvenios1);
			
			
    		//Actualizar Convenio			
			Query empresaQuery = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
			empresaQuery.setParameter("cifEmpresa", cifEmpresa);
			Empresa empresaActualizar = (Empresa) empresaQuery.getSingleResult();
			
			//NUEVO ID
			String nuevoIdConvenio;
			
			if (!id.contains("PRIV")) {				
				auxConvenios = auxConvenios + 1;
				Formatter obj = new Formatter();
		        String numeroCeros = String.valueOf(obj.format("%03d", auxConvenios));
				
		        nuevoIdConvenio = id.replace(id.substring(5, 8), numeroCeros);

			}else {
				
				auxConvenios = auxConvenios + 1;
				Formatter obj = new Formatter();
		        String numeroCeros = String.valueOf(obj.format("%03d", auxConvenios));
				
		        nuevoIdConvenio = id.replace(id.substring(10, 13), numeroCeros);
				
			}
			
			convenio.setIdConvenio(nuevoIdConvenio);
			convenio.setEmpresa(empresaActualizar);
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
	 
	 public ArrayList<Convenio> listarConvenios (SessionFactory sessionFactory, String cifEmpresa) throws HibernateException {
		 
		 Session session = null;

		 ArrayList<Convenio> listaConvenios = new ArrayList<Convenio>();
		 
		 	try {
		 		session = sessionFactory.getCurrentSession();
				session.beginTransaction();
				
				Query empresaQuery = sessionFactory.getCurrentSession().createQuery("FROM Empresa WHERE cifEmpresa = :cifEmpresa");
				empresaQuery.setParameter("cifEmpresa", cifEmpresa);
				Empresa empresa = (Empresa) empresaQuery.getSingleResult();
				
				Query convenioQuery = sessionFactory.getCurrentSession().createQuery("FROM Convenio WHERE empresa = :empresa");
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
			
	 
	    
	        
	        
	       helper.crearConvenio(sessionFactory, "1231-FIG", "2º CFGS Desarrollo de Aplicaciones Multiplataforma", "PFE", true, fechaNacimientoUSU);
	       helper.crearConvenio(sessionFactory, "4331-PAT", "2º CFGM Carroceria", "PFE", true, fechaNacimientoUSU);
	       helper.crearConvenio(sessionFactory, "6217-KIR", "2º CFGM Sistemas MicroInformaticos y Redes", "FCT", false, fechaNacimientoUSU);
	       helper.crearConvenio(sessionFactory, "2341-KLO", "2º FP Basica Mantenimiento de Vehiculos", "PFE", false, fechaNacimientoUSU);
	       helper.crearConvenio(sessionFactory, "9687-POK", "2º CFGM Carroceria", "FCT", false, fechaNacimientoUSU);

	       //helper.actualizarConvenio(sessionFactory, "MOR/C001/22", "PFE", fechaNacimientoUSU, "1231-FIG");
	       helper.actualizarConvenio(sessionFactory, "MOR/PRIV/A001/22", "FCT", fechaNacimientoUSU, "6217-KIR");
	     

	        
	        
         /*
          * 2º CFGM Carrocería
			2º CFGM Electromecánica
			2º CFGM Sistemas MicroInformáticos y Redes
			2º CFGS Desarrollo de Aplicaciones Multiplataforma
			2º CFGS Técnico Superior en Automoción
			2º FP Básica Informática y Comunicaciones
			2º FP Básica Mantenimiento de Vehículos
          */
	  
	 
	 
	 
	 }

}