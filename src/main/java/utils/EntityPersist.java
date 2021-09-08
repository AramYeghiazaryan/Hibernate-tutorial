package utils;

import org.hibernate.Session;

import java.util.List;

public class EntityPersist<T> {

    private final static TransactionUtils transaction = new TransactionUtils();

    public void persist(T... entities) {
        final Session session = SessionFactorySingleton.getSessionInstance().getCurrentSession();
        transaction.doWithTransaction(session, () -> {
            List.of(entities).forEach(session::save);
            return true;
        });
    }

    public T getById(Class<T> clazz, Long id) {
        final Session session = SessionFactorySingleton.getSessionInstance().getCurrentSession();
        return transaction.doWithTransaction(session, () -> session.get(clazz, id));
    }

}
