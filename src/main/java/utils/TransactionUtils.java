package utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.Supplier;

public class TransactionUtils {

    <T> T doWithTransaction(Session currentSession, Supplier<T> supplier) {
        Transaction transaction = getSessionTransaction(currentSession);
        T returnValue = supplier.get();
        transaction.commit();
        return returnValue;
    }

    private static Transaction getSessionTransaction(Session session) {
        return session.getTransaction().isActive() ? session.getTransaction() : session.beginTransaction();
    }

}
