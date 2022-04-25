package Modelo;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.query.Query;
import org.hibernate.type.CurrencyType;

import persistencia.Alumno;
import persistencia.Curso;

public class Modelo {

public void crearCurso (SessionFactory sessionFactory, String nombreCurso, String nombreAbrev, int clave, int horasFCT, boolean esPublico) throws HibernateException {
		
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

	public void crearAlumno (SessionFactory sessionFactory, String nif, String nombreCompleto, boolean seleccionado, int telefono, String correo, Date fechaNacimiento) throws HibernateException {
	
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
	
	
	public static void main (String [] args) {
		SessionFactory sessionFactory = null;
		Modelo helper = new Modelo();
		
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			
			//CREAR CURSO
			System.out.println("CREAR CURSO");
		//	helper.crearCurso(sessionFactory);
			System.out.println("Curso creado");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	
}