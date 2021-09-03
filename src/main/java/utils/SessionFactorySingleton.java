package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {

    public static SessionFactory getSessionInstance() {
        return SessionFactoryManager.sessionFactory;
    }

    private static class SessionFactoryManager {
        private static final SessionFactory sessionFactory = buildSessionFactoryInstance();

        private static SessionFactory buildSessionFactoryInstance() {
            Configuration configuration = new Configuration();
            return configuration.configure().buildSessionFactory();
        }
    }

}
