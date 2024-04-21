package co.edu.unbosque.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySQLDB<T> {

	private Class<T> clase;

	public MySQLDB(Class<T> clase) {
		this.clase = clase;
	}

	private SessionFactory crearSessionFactory() {
		return new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(clase)
				.buildSessionFactory();
	}

	public void ejecutarTransaccion(SessionMapper sm) throws Exception {
		try (SessionFactory miFactory = crearSessionFactory();
			 Session miSession = miFactory.openSession();) {
			miSession.beginTransaction();
			sm.mapSession(miSession);
			miSession.getTransaction().commit();
		}
	}

	public List<T> ejecutarConsulta(String consulta) throws Exception {
		try (SessionFactory miFactory = crearSessionFactory();
			 Session miSession = miFactory.openSession();) {
			return miSession.createQuery(consulta, clase).getResultList();
		}
	}

}
