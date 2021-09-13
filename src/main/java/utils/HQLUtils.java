package utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.List;

public class HQLUtils {

    public static <T> List<T> getList(Class<T> entityClass, Session session) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(MessageFormat.format("from {0}", entityClass.getName()));
        List<T> results = query.getResultList();
        transaction.commit();
        return results;
    }

}
