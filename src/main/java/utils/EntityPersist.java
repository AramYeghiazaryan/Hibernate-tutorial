package utils;

import org.hibernate.Session;

public class EntityPersist<T> {

    public void persist(T entity) {
        Session session = SessionFactorySingleton.getSessionInstance().getCurrentSession();
        session.save(entity);
    }

}
