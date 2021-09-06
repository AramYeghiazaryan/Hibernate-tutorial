package utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.Supplier;

public class TransactionUtils {

    <T> T doWithTransaction(Session currentSession, Supplier<T> supplier) {
        Transaction transaction = currentSession.beginTransaction();
        T returnValue = supplier.get();
        transaction.commit();
        return returnValue;
    }

}
