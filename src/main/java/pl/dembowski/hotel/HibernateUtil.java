package pl.dembowski.hotel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static final String DATA_SOURCE = "psqlManager";
	private static HibernateUtil instance;
	private EntityManagerFactory entityManagerFactory;

	private HibernateUtil() {
	}

	public synchronized static HibernateUtil getManager() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}

	private EntityManagerFactory createEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(DATA_SOURCE);
		}
		return entityManagerFactory;
	}

	public EntityManager createEntityManager() {
		return this.createEntityManagerFactory().createEntityManager();
	}

	public void closeEntityManagerFactory() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}
}
