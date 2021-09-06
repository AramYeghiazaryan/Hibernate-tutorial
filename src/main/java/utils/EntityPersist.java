package utils;

import org.hibernate.Session;

public class EntityPersist<T> {

    private final static TransactionUtils transaction = new TransactionUtils();

    public void persist(T entity) {
        Session session = SessionFactorySingleton.getSessionInstance().getCurrentSession();
        transaction.doWithTransaction(session, () -> session.save(entity));
    }

}
