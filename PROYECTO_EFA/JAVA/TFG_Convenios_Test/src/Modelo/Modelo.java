package Modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
			
			session.save(alumno);
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
		
	 public static void listar(String ciudad, SessionFactory sessionFactory, int numeroVotos) throws InterruptedException {
	        
		// leer todas las asignaturas
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Curso");
		ArrayList<Curso> listaCursos = (ArrayList<Curso>) query.list();
		
		for(Curso curso: listaCursos) {
			System.out.println(curso);
		}
					
	        
	 }
	 
	 
	 public static void main (String [] args) {
		 
			SessionFactory sessionFactory = null;
			
		 
		//Solo se hace una vez, al iniciar la aplicaci�n
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			
			// Cualquier operacion debe hacerse dentro de una transaccion
			sessionFactory.getCurrentSession().beginTransaction();
		 
		// leer todas las asignaturas
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Curso");
			ArrayList<Curso> listaCursos = (ArrayList<Curso>) query.list();
			
			for(Curso curso: listaCursos) {
				System.out.println(curso.getNombreCurso());
			}
	 }
	
}