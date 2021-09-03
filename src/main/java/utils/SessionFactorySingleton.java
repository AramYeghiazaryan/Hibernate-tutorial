package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionFactorySingleton {


    public static SessionFactory getSessionInstance() {
        return SessionFactoryManager.sessionFactory;
    }

    private class SessionFactoryManager {
        private static final SessionFactory sessionFactory = buildSessionFactoryInstance();


        private static SessionFactory buildSessionFactoryInstance() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
            EntityManager entityManager = emf.createEntityManager();
            // Get the Hibernate Session from the EntityManager in JPA
            Session session = entityManager.unwrap(org.hibernate.Session.class);
            return session.getSessionFactory();
        }

        public SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }

}
