package Modelo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.Query;
import org.hibernate.type.CurrencyType;

import persistencia.Alumno;
import persistencia.Curso;
import persistencia.Empresa;
import persistencia.Poblacion;



public class Modelo {
	

	/**
	 * Metodo para crear e insertar un nuevo Curso
	 * @param sessionFactory
	 * @param nombreCurso
	 * @param nombreAbrev
	 * @param clave
	 * @param horasFCT
	 * @param esPublico
	 * @throws HibernateException
	 */
	public void crearCurso (SessionFactory sessionFactory, String nombreCurso, String nombreAbrev, String clave, int horasFCT, boolean esPublico) throws HibernateException {
		
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Curso curso = new Curso();
			curso.setNombreCurso(nombreCurso);
			curso.setNombreAbrev(nombreAbrev);
			curso.setClave(clave);
			curso.setHorasFct(horasFCT);
			curso.setEsPublico(esPublico);
			
			session.saveOrUpdate(curso);
			System.out.println(curso);
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
	 * Metodo para crear e insertar un nuevo Alumno
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
	public void crearAlumno (SessionFactory sessionFactory, String nif, String nombreCompleto, boolean seleccionado, int telefono, String correo, Date fechaNacimiento, int codigoPostal, String nombreCurso) throws HibernateException {
	
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Alumno alumno = new Alumno();
			alumno.setNif(nif);
			alumno.setNombreCompleto(nombreCompleto);
			alumno.setSeleccionado(seleccionado);
			alumno.setTelefono(telefono);
			alumno.setCorreo(correo);
			alumno.setFechaNacimiento(fechaNacimiento);
			
			Query queryPoblacion = session.createQuery("FROM Poblacion WHERE codigoPostal = :codigoPostal");
			queryPoblacion.setParameter("codigoPostal", codigoPostal);
			Poblacion poblacion = (Poblacion) queryPoblacion.getSingleResult();
			
			alumno.setPoblacion(poblacion);
			
			
			Query queryCurso = session.createQuery("FROM Curso WHERE nombreCurso = :nombreCurso");
			queryCurso.setParameter("nombreCurso", nombreCurso);
			Curso curso = (Curso) queryCurso.getSingleResult();
			
			alumno.setCurso(curso);
			
		
			
			session.saveOrUpdate(alumno);
			System.out.println(alumno);
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
	 * Metodo Prueba para consultas
	 * @param ciudad
	 * @param sessionFactory
	 * @param numeroVotos
	 * @throws InterruptedException
	 */
	 public static void listar(String ciudad, SessionFactory sessionFactory, int numeroVotos) throws InterruptedException {
	        
		// leer todas las asignaturas
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Curso");
		ArrayList<Curso> listaCursos = (ArrayList<Curso>) query.list();
		
		for(Curso curso: listaCursos) {
			System.out.println(curso);
		}
					
	        
	 }
	 
	 public void crearEmpresas (SessionFactory sessionFactory, String cifEmpresa, String nombreEmpresa, String direccionEmpresa, int telefono1, int telefono2, 
			 String emailEmpresa, String faxEmpresa, String paginaWeb, String nombreGerente, String dniGerente, 
			 String personaContacto, String cargoContacto, String fechaActualizacion, boolean organismoPublico,String observaciones, int codigoPostal) throws HibernateException{
		 
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
				empresa.setCargoContacto(cargoContacto);
				
				//Fecha Nacimiento
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		        Date fechaActualizAUX = format.parse(fechaActualizacion);
		        java.sql.Date fechaActualizacion1 = new java.sql.Date(fechaActualizAUX.getTime());
				
				empresa.setFechaActualizacion(fechaActualizacion1);
				empresa.setOrganismoPublico(organismoPublico);
				empresa.setObservaciones(observaciones);
				
				Query queryPoblacion = session.createQuery("FROM Poblacion WHERE codigoPostal = :codigoPostal");
				queryPoblacion.setParameter("codigoPostal", codigoPostal);
				Poblacion poblacion = (Poblacion) queryPoblacion.getSingleResult();
				
				empresa.setPoblacion(poblacion);
				
				
				session.saveOrUpdate(empresa);
				System.out.println(empresa);
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
	 
	 public static void main (String [] args) throws ParseException {
		 
			SessionFactory sessionFactory = null;
			
		 
		//Solo se hace una vez, al iniciar la aplicaciï¿½n
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
					
			Modelo helper = new Modelo();	
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaNacimientoUSU = format.parse("22/12/2002");
	        java.sql.Date fechaNacimiento = new java.sql.Date(fechaNacimientoUSU.getTime());
			
			//helper.crearAlumno(sessionFactory, "12345678L", "Guillermo Romero", false, 1243567586, "guillermo@gmail.com", fechaNacimiento, 13230, "2º CFGM Carrocería");
			helper.crearEmpresas(sessionFactory, "1231-FIG", "INDRA", "Ronda de Toleado", 987654321, 123456789, "indra@minsait.com", "123213", "indra.com", "Angel Sevilla", "987654321", "Carlos", "Jefe SF", "12/01/2022", false, "Trabajo DAM", 13230);
	
	 
	 
	 
	 
	 
	 }
}