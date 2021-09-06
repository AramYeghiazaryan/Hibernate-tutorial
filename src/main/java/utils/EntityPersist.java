package utils;

import org.hibernate.Session;

import java.util.List;

public class EntityPersist<T> {

    private final static TransactionUtils transaction = new TransactionUtils();

    public void persist(List<T> entities) {
        Session session = SessionFactorySingleton.getSessionInstance().getCurrentSession();
        transaction.doWithTransaction(session, () -> {
            entities.forEach(session::save);
            return true;
        });
    }

}
