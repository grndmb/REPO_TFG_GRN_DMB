package Modelo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.query.Query;
import org.hibernate.type.CurrencyType;

import persistencia.Curso;

public class Modelo {

public void crearCurso (SessionFactory sessionFactory) throws HibernateException {
		
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("************CURSOS*************");
			System.out.println("************CURSOS*************");
			
			
			Curso curso = new Curso();
			curso.setNombreCurso("Desarrollo de Aplicaciones Multiplataforma");
			curso.setNombreAbrev("DAM");
			curso.setClave(1122334455);
			curso.setHorasFct(400);
			curso.setEsPublico(true);
			
			Curso curso2 = new Curso();
			curso2.setNombreCurso("Desarrollo de Aplicaciones Web");
			curso2.setNombreAbrev("DAW");
			curso2.setClave(1155223344);
			curso2.setHorasFct(350);
			curso2.setEsPublico(true);

			Curso curso3 = new Curso();
			curso3.setNombreCurso("Sistemas Microinformaticos y Redes");
			curso3.setNombreAbrev("SMR");
			curso3.setClave(1335223344);
			curso3.setHorasFct(300);
			curso3.setEsPublico(false);
			
			session.saveOrUpdate(curso);
			System.out.println(curso);
			
			session.saveOrUpdate(curso2);
			System.out.println(curso2);
			
			session.saveOrUpdate(curso3);
			System.out.println(curso3);
			
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
			helper.crearCurso(sessionFactory);
			System.out.println("Curso creado");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	
}